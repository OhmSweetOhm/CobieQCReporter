package com.corballis.converter;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static com.google.common.collect.Lists.newArrayList;

public class PickListConverter {

    private final Document document;
    private Workbook workbook;

    public PickListConverter(File excelWorkbookFile) throws ParserConfigurationException, IOException,
                                                            InvalidFormatException {
        workbook = WorkbookFactory.create(excelWorkbookFile);
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
        document = docBuilder.newDocument();
        Element rootElement = document.createElement("CobiePicklists");
        document.appendChild(rootElement);
    }

    public void render(String output) throws TransformerException {
        Sheet sheet = workbook.getSheetAt(0);
        ArrayList<PickListRule> pickListRules = newArrayList();

        if (sheet != null && sheet.getLastRowNum() > 2) {
            int maxRule = sheet.getRow(0).getLastCellNum();
            maxRule = Math.min(maxRule, sheet.getRow(1).getLastCellNum());
            maxRule = Math.min(maxRule, sheet.getRow(2).getLastCellNum());
            for (int cellIndex = 0; cellIndex < maxRule; ++cellIndex) {
                if (isEmptyCell(sheet, 0, cellIndex) &&
                    isEmptyCell(sheet, 1, cellIndex) &&
                    isEmptyCell(sheet, 2, cellIndex)) {
                    maxRule = cellIndex;
                    break;
                }
                if (isEmptyCell(sheet, 0, cellIndex)) {
                    throw new RuntimeException("Missing rule name at column " + (cellIndex + 1));
                }
                if (isEmptyCell(sheet, 1, cellIndex)) {
                    throw new RuntimeException("Missing tab name at column " + (cellIndex + 1));
                }
                if (isEmptyCell(sheet, 2, cellIndex)) {
                    throw new RuntimeException("Missing column name at column " + (cellIndex + 1));
                }
                pickListRules.add(new PickListRule(sheet.getRow(0).getCell(cellIndex).getStringCellValue(),
                                                   sheet.getRow(1).getCell(cellIndex).getStringCellValue(),
                                                   sheet.getRow(2).getCell(cellIndex).getStringCellValue()));
            }
            for (int rowIndex = 3; rowIndex < sheet.getLastRowNum(); ++rowIndex) {
                Row row = sheet.getRow(rowIndex);
                for (int cellIndex = 1; cellIndex < row.getLastCellNum(); ++cellIndex) {
                    if (cellIndex >= maxRule) {
                        break;
                    }
                    if (row.getCell(cellIndex) == null || row.getCell(cellIndex).getStringCellValue().isEmpty()) {
                        continue;
                    }
                    addPickListValue(pickListRules.get(cellIndex).getTabName(),
                                     pickListRules.get(cellIndex).getColumnName(),
                                     row.getCell(cellIndex).getStringCellValue());

                }
            }
        }

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(document);
        StreamResult result = new StreamResult(new File(output));
        transformer.transform(source, result);
    }

    private static boolean isEmptyCell(Sheet sheet, int rowIndex, int cellIndex) {
        return sheet.getRow(rowIndex).getCell(cellIndex) == null ||
               sheet.getRow(rowIndex).getCell(cellIndex).getStringCellValue().isEmpty();
    }

    private void addPickListValue(String sheetName, String columnName, String value) {
        Element sheet = getSheetPickList(sheetName);
        Element pickList = getPickList(sheet, columnName);
        if (pickList != null) {
            Element pickListValue = document.createElement("PicklistValue");
            pickListValue.setTextContent(value);
            pickList.appendChild(pickListValue);
        }
    }

    private Element getPickList(Element sheet, String columnName) {
        NodeList pickLists = sheet.getChildNodes();
        for (int i = 0; i < pickLists.getLength(); i++) {
            Node item = pickLists.item(i);
            boolean isPickListItem = "Picklist".equalsIgnoreCase(pickLists.item(i).getNodeName());
            if (isPickListItem &&
                pickLists.item(i)
                         .getAttributes()
                         .getNamedItem("ColumnName")
                         .getNodeValue()
                         .equalsIgnoreCase(columnName)) {
                return (Element) item;
            }
        }
        Element newPickList = document.createElement("Picklist");
        newPickList.setAttribute("ColumnName", columnName);
        sheet.appendChild(newPickList);
        return newPickList;
    }

    private Element getSheetPickList(String sheetName) {
        Element rootElement = (Element) document.getElementsByTagName("CobiePicklists").item(0);
        NodeList existingSheetPickLists = rootElement.getElementsByTagName("SheetPicklists");

        for (int i = 0; i < existingSheetPickLists.getLength(); i++) {
            Node sheetPickList = existingSheetPickLists.item(i);

            if (sheetPickList.getAttributes().getNamedItem("SheetName").getNodeValue().equalsIgnoreCase(sheetName)) {
                return (Element) sheetPickList;
            }
        }
        Element newSheetPickLists = document.createElement("SheetPicklists");
        newSheetPickLists.setAttribute("SheetName", sheetName);
        document.getDocumentElement().appendChild(newSheetPickLists);
        return newSheetPickLists;
    }

}
