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
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import static com.google.common.collect.Lists.newArrayList;

public class PickListConverter extends ExcelConverterBase {

    private static final String ELEMENT_NAME_ROOT = "CobiePicklists";
    private static final String ELEMENT_NAME_PICKLIST_VALUE = "PicklistValue";
    private static final String ELEMENT_NAME_PICKLIST = "Picklist";
    private static final String ELEMENT_NAME_SHEET_PICKLISTS = "SheetPicklists";
    private static final String ATTRIBUTE_NAME_COLUMN_NAME = "ColumnName";
    private static final String ATTRIBUTE_NAME_SHEET_NAME = "SheetName";

    private final Document document;
    private File excelWorkbookFile;

    public PickListConverter(File excelWorkbookFile) throws ParserConfigurationException {
        this.excelWorkbookFile = excelWorkbookFile;
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
        document = docBuilder.newDocument();
        Element rootElement = document.createElement(ELEMENT_NAME_ROOT);
        document.appendChild(rootElement);
    }

    public void render(String output) throws TransformerException, IOException, InvalidFormatException {
        try (InputStream inputStream = new FileInputStream(excelWorkbookFile)) {
            Workbook workbook = WorkbookFactory.create(inputStream);
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
                    pickListRules.add(new PickListRule(getStringValue(sheet.getRow(0).getCell(cellIndex)),
                                                       getStringValue(sheet.getRow(1).getCell(cellIndex)),
                                                       getStringValue(sheet.getRow(2).getCell(cellIndex))));
                }
                for (int rowIndex = 3; rowIndex < sheet.getLastRowNum(); ++rowIndex) {
                    Row row = sheet.getRow(rowIndex);
                    for (int cellIndex = 1; cellIndex < row.getLastCellNum(); ++cellIndex) {
                        if (cellIndex >= maxRule) {
                            break;
                        }
                        if (row.getCell(cellIndex) == null || getStringValue(row.getCell(cellIndex)).isEmpty()) {
                            continue;
                        }
                        addPickListValue(pickListRules.get(cellIndex).getTabName(),
                                         pickListRules.get(cellIndex).getColumnName(),
                                         getStringValue(row.getCell(cellIndex)));

                    }
                }
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new File(output));
            transformer.transform(source, result);
        }
    }

    private static boolean isEmptyCell(Sheet sheet, int rowIndex, int cellIndex) {
        return isEmpty(sheet.getRow(rowIndex).getCell(cellIndex));
    }

    private void addPickListValue(String sheetName, String columnName, String value) {
        Element sheet = getSheetPickList(sheetName);
        Element pickList = getPickList(sheet, columnName);
        if (pickList != null) {
            Element pickListValue = document.createElement(ELEMENT_NAME_PICKLIST_VALUE);
            pickListValue.setTextContent(value);
            pickList.appendChild(pickListValue);
        }
    }

    private Element getPickList(Element sheet, String columnName) {
        NodeList pickLists = sheet.getChildNodes();
        for (int i = 0; i < pickLists.getLength(); i++) {
            Node item = pickLists.item(i);
            boolean isPickListItem = ELEMENT_NAME_PICKLIST.equalsIgnoreCase(pickLists.item(i).getNodeName());
            if (isPickListItem &&
                pickLists.item(i)
                         .getAttributes()
                         .getNamedItem(ATTRIBUTE_NAME_COLUMN_NAME)
                         .getNodeValue()
                         .equalsIgnoreCase(columnName)) {
                return (Element) item;
            }
        }
        Element newPickList = document.createElement(ELEMENT_NAME_PICKLIST);
        newPickList.setAttribute(ATTRIBUTE_NAME_COLUMN_NAME, columnName);
        sheet.appendChild(newPickList);
        return newPickList;
    }

    private Element getSheetPickList(String sheetName) {
        return getOrAddElement(document,
                               ELEMENT_NAME_ROOT,
                               ELEMENT_NAME_SHEET_PICKLISTS,
                               ATTRIBUTE_NAME_SHEET_NAME,
                               sheetName);
    }

}
