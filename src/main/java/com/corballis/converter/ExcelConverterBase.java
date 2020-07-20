package com.corballis.converter;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public abstract class ExcelConverterBase {

    private static DataFormatter defaultDataFormatter = new DataFormatter();

    protected ExcelConverterBase() {
    }

    protected static String getStringValue(Cell cell) {
        return defaultDataFormatter.formatCellValue(cell);
    }

    protected static boolean isNotEmpty(Cell cell) {
        return !isEmpty(cell);
    }

    protected static boolean isEmpty(Cell cell) {
        return cell == null || StringUtils.isBlank(getStringValue(cell));
    }

    protected Element getOrAddElement(Document document,
                                      String rootElementName,
                                      String sheetElementName,
                                      String sheetNameAttributeName,
                                      String sheetName) {
        Element rootElement = (Element) document.getElementsByTagName(rootElementName).item(0);
        NodeList existingSheetPickLists = rootElement.getElementsByTagName(sheetElementName);

        for (int i = 0; i < existingSheetPickLists.getLength(); i++) {
            Node sheetPickList = existingSheetPickLists.item(i);

            if (sheetPickList.getAttributes()
                             .getNamedItem(sheetNameAttributeName)
                             .getNodeValue()
                             .equalsIgnoreCase(sheetName)) {
                return (Element) sheetPickList;
            }
        }
        Element newSheetPickLists = document.createElement(sheetElementName);
        newSheetPickLists.setAttribute(sheetNameAttributeName, sheetName);
        document.getDocumentElement().appendChild(newSheetPickLists);
        return newSheetPickLists;
    }

}
