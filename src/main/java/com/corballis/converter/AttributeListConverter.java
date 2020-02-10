package com.corballis.converter;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
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

public class AttributeListConverter {

    private static final String HEADER_DESCRIPTION = "Description";
    private static final String HEADER_SHEET = "Sheet";
    private static final String ELEMENT_NAME_ROOT = "AttributeConstraints";
    private static final String ELEMENT_NAME_SHEET_ATTRIBUTE_CONSTRAINTS = "SheetAttributeConstraints";
    private static final String ATTRIBUTE_NAME_SHEET_NAME = "sheetName";
    private static final String ELEMENT_NAME_ATTRIBUTE_CONSTRAINT = "AttributeConstraint";
    private static final String ATTRIBUTE_NAME_DESCRIPTION = "Description";
    private static final String ELEMENT_NAME_SHEET_CONDITIONS = "SheetConditions";
    private static final String ATTRIBUTE_NAME_LOGICAL_OPERATOR = "LogicalOperator";
    private static final String ELEMENT_NAME_CONDITION = "Condition";
    private static final String ELEMENT_NAME_COLUMN_NAME = "ColumnName";
    private static final String ELEMENT_NAME_COLUMN_VALUE = "ColumnValue";
    private static final String ELEMENT_NAME_CONDITION_TYPE = "ConditionType";
    private static final String CONDITION_TYPE_CONTAINS = "contains";
    private static final String CONDITION_TYPE_STARTS_WITH = "startsWith";
    private static final String CONDITION_TYPE_ENDS_WITH = "endsWith";
    private static final String CONDITION_TYPE_EQUALS = "equals";
    private static final String ELEMENT_NAME_ATTRIBUTE_NAME = "AttributeName";
    private static final String ATTRIBUTE_NAME_REQUIRES_VALUE = "requiresValue";

    private final Document document;
    private Workbook workbook;

    public AttributeListConverter(File excelWorkbookFile) throws ParserConfigurationException, IOException,
                                                                 InvalidFormatException {
        workbook = WorkbookFactory.create(excelWorkbookFile);
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
        document = docBuilder.newDocument();
        Element rootElement = document.createElement(ELEMENT_NAME_ROOT);
        document.appendChild(rootElement);
    }

    public void render(String output) throws TransformerException {
        Sheet sheet = workbook.getSheetAt(0);
        boolean firstRow = true;
        Element attributeRule = null;
        for (Row row : sheet) {
            Cell description = row.getCell(0);
            Cell sheetName = row.getCell(1);
            Cell logicalOperator = row.getCell(2);
            Cell columnName = row.getCell(3);
            Cell columnValue = row.getCell(4);
            Cell attributeName = row.getCell(5);
            Cell requiresValue = row.getCell(6);
            boolean isHeaderRow = isNotEmpty(description) && isNotEmpty(sheetName) &&
                                  HEADER_DESCRIPTION.equalsIgnoreCase(description.getStringCellValue()) &&
                                  HEADER_SHEET.equalsIgnoreCase(sheetName.getStringCellValue());
            if (firstRow && isHeaderRow) {
                firstRow = false;
                continue;
            }

            if (isNotEmpty(description)) {
                attributeRule = document.createElement(ELEMENT_NAME_ATTRIBUTE_CONSTRAINT);
                attributeRule.setAttribute(ATTRIBUTE_NAME_DESCRIPTION, description.getStringCellValue());
                Element sheetAttributeConstraints = getSheetAttributeConstraints(sheetName.getStringCellValue());
                sheetAttributeConstraints.appendChild(attributeRule);
            }
            if (attributeRule == null) {
                continue;
            }
            if (isNotEmpty(columnName)) {
                addCondition(attributeRule, columnName.getStringCellValue(), columnValue.getStringCellValue());
            }
            if (isNotEmpty(logicalOperator)) {
                if (isNotEmpty(description)) {
                    setLogicalOperator(attributeRule, logicalOperator.getStringCellValue());
                } else {
                    throw new RuntimeException("Logical operator may be set at the first row of a rule only");
                }
            }
            if (isNotEmpty(attributeName)) {
                addAttribute(attributeRule, attributeName.getStringCellValue(), requiresValue.getBooleanCellValue());
            }
        }

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(document);
        StreamResult result = new StreamResult(new File(output));
        transformer.transform(source, result);
    }

    private static boolean isNotEmpty(Cell cell) {
        return cell != null && !cell.getStringCellValue().isEmpty();
    }

    private Element getSheetAttributeConstraints(String sheetName) {
        Element rootElement = (Element) document.getElementsByTagName(ELEMENT_NAME_ROOT).item(0);
        NodeList existingSheetAttributeConstraints = rootElement.getElementsByTagName(ELEMENT_NAME_SHEET_ATTRIBUTE_CONSTRAINTS);

        for (int i = 0; i < existingSheetAttributeConstraints.getLength(); i++) {
            Node sheetAttributeConstraints = existingSheetAttributeConstraints.item(i);

            if (sheetAttributeConstraints.getAttributes()
                                         .getNamedItem(ATTRIBUTE_NAME_SHEET_NAME)
                                         .getNodeValue()
                                         .equalsIgnoreCase(sheetName)) {
                return (Element) sheetAttributeConstraints;
            }
        }
        Element newSheetAttributeConstraints = document.createElement(ELEMENT_NAME_SHEET_ATTRIBUTE_CONSTRAINTS);
        newSheetAttributeConstraints.setAttribute(ATTRIBUTE_NAME_SHEET_NAME, sheetName);
        document.getDocumentElement().appendChild(newSheetAttributeConstraints);
        return newSheetAttributeConstraints;
    }

    private void addCondition(Element attributeRule, String columnName, String columnValue) {
        Element sheetConditions = getOrCreateSheetConditions(attributeRule);
        boolean startsWith = columnValue.endsWith("*");
        boolean endsWith = columnValue.startsWith("*");
        if (endsWith) {
            columnValue = columnValue.substring(1);
        }
        if (startsWith) {
            columnValue = columnValue.substring(0, columnValue.length() - 1);
        }
        Element condition = document.createElement(ELEMENT_NAME_CONDITION);
        Element columnNameElement = document.createElement(ELEMENT_NAME_COLUMN_NAME);
        columnNameElement.setTextContent(columnName);
        condition.appendChild(columnNameElement);
        Element columnValueElement = document.createElement(ELEMENT_NAME_COLUMN_VALUE);
        columnValueElement.setTextContent(columnValue);
        condition.appendChild(columnValueElement);
        Element conditionTypeElement = document.createElement(ELEMENT_NAME_CONDITION_TYPE);
        String conditionType;
        if (startsWith) {
            if (endsWith) {
                conditionType = CONDITION_TYPE_CONTAINS;
            } else {
                conditionType = CONDITION_TYPE_STARTS_WITH;
            }
        } else {
            if (endsWith) {
                conditionType = CONDITION_TYPE_ENDS_WITH;
            } else {
                conditionType = CONDITION_TYPE_EQUALS;
            }
        }
        conditionTypeElement.setTextContent(conditionType);
        condition.appendChild(conditionTypeElement);
        sheetConditions.appendChild(condition);
    }

    private Element getOrCreateSheetConditions(Element attributeRule) {
        Element sheetConditions = getSheetConditions(attributeRule);
        if (sheetConditions == null) {
            sheetConditions = document.createElement(ELEMENT_NAME_SHEET_CONDITIONS);
            attributeRule.appendChild(sheetConditions);
        }
        return sheetConditions;
    }

    private Element getSheetConditions(Element attributeRule) {
        NodeList sheetConditionsList = attributeRule.getElementsByTagName(ELEMENT_NAME_SHEET_CONDITIONS);
        if (sheetConditionsList.getLength() > 0) {
            return (Element) sheetConditionsList.item(0);
        }
        return null;
    }

    private void setLogicalOperator(Element attributeRule, String logicalOperator) {
        Element sheetConditions = getSheetConditions(attributeRule);
        checkValidLogicalOperator(logicalOperator);
        sheetConditions.setAttribute(ATTRIBUTE_NAME_LOGICAL_OPERATOR, logicalOperator);
    }

    private static void checkValidLogicalOperator(String logicalOperator) {
        if (!"AND".equals(logicalOperator) && !"OR".equals(logicalOperator)) {
            throw new RuntimeException("Invalid logical operator: " + logicalOperator);
        }
    }

    private void addAttribute(Element attributeRule, String attributeName, boolean requiresValue) {
        Element attributeNameElement = document.createElement(ELEMENT_NAME_ATTRIBUTE_NAME);
        attributeNameElement.setAttribute(ATTRIBUTE_NAME_REQUIRES_VALUE, requiresValue ? "true" : "false");
        attributeNameElement.setTextContent(attributeName);
        attributeRule.appendChild(attributeNameElement);
    }

}
