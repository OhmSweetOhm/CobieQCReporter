package org.bimserver.cobie.shared.transform.spreadsheetml.cobietab;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

import nl.fountain.xelem.excel.Row;
import nl.fountain.xelem.excel.Workbook;
import nl.fountain.xelem.excel.Worksheet;

import org.bimserver.cobie.shared.COBieTokenUtility;
import org.bimserver.cobie.shared.COBieTokenUtility.ConnectionColumnNameLiterals;
import org.bimserver.cobie.shared.utility.COBieStringHandler;
import org.bimserver.cobie.shared.utility.COBieUtility;
import org.nibs.cobie.tab.COBIEType;
import org.nibs.cobie.tab.ConnectionType;

public class ConnectionTransformer extends SpreadsheetMLTransformer
{

    public ConnectionTransformer(COBIEType cobie, Workbook workbook, COBieStringHandler cobieStringWriter)
    {
        super(workbook, cobie, cobieStringWriter);
    }

    public ConnectionTransformer(COBIEType cobie, Workbook workbook)
    {
        super(cobie, workbook);
    }

    @Override
    protected List<String> getColumnNames()
    {
        return COBieTokenUtility.ConnectionColumnNames;
    }

    @Override
    protected String getWorksheetName()
    {
        return COBieUtility.CobieSheetName.Connection.name();
    }

    @Override
    protected void write()
    {
        COBIEType.Connections connections = getTarget().addNewConnections();
        Worksheet sheet = getWorksheet();
        Map<String, Integer> columnDictionary = getColumnDictionary();
        String connectionName = "";
        String connectionCreatedBy = "";
        String connectionCreatedOnString = "";
        Calendar connectionCreatedOn;
        String connectionConnectionType = "";
        String connectionSheetName = "";
        String connectionRowName1 = "";
        String connectionRowName2 = "";
        String connectionPortName1 = "";
        String connectionPortName2 = "";
        String connectionExtSystem = "";
        String connectionExtObject = "";
        String connectionExtIdentifier = "";
        String connectionDescription = "";
        String connectionRealizingElement = "";
        int idxName;
        int idxCreatedBy;
        int idxCreatedOn;
        int idxConnectionType;
        int idxSheetName;
        int idxRowName1;
        int idxRowName2;
        int idxRealizingElement;
        int idxPortName1;
        int idxPortName2;
        int idxExtSystem;
        int idxExtObject;
        int idxExtIdentifier;
        int idxDescription;
        idxName = columnDictionary.get(ConnectionColumnNameLiterals.Name.toString());
        idxCreatedBy = columnDictionary.get(ConnectionColumnNameLiterals.CreatedBy.toString());
        idxCreatedOn = columnDictionary.get(ConnectionColumnNameLiterals.CreatedOn.toString());
        idxConnectionType = columnDictionary.get(ConnectionColumnNameLiterals.ConnectionType.toString());
        idxSheetName = columnDictionary.get(ConnectionColumnNameLiterals.SheetName.toString());
        idxRowName1 = columnDictionary.get(ConnectionColumnNameLiterals.RowName1.toString());
        idxRowName2 = columnDictionary.get(ConnectionColumnNameLiterals.RowName2.toString());
        idxRealizingElement = columnDictionary.get(ConnectionColumnNameLiterals.RealizingElement.toString());
        idxPortName1 = columnDictionary.get(ConnectionColumnNameLiterals.PortName1.toString());
        idxPortName2 = columnDictionary.get(ConnectionColumnNameLiterals.PortName2.toString());
        idxExtSystem = columnDictionary.get(ConnectionColumnNameLiterals.ExtSystem.toString());
        idxExtObject = columnDictionary.get(ConnectionColumnNameLiterals.ExtObject.toString());
        idxExtIdentifier = columnDictionary.get(ConnectionColumnNameLiterals.ExtIdentifier.toString());
        idxDescription = columnDictionary.get(ConnectionColumnNameLiterals.Description.toString());
        int rowIdx;
        int firstRowIdx = Worksheet.firstRow;
        for (Row rowData : sheet.getRows())
        {
            rowIdx = rowData.getIndex();
            if ((rowIdx > firstRowIdx) && COBieSpreadSheet.isRowPopulated(rowData, 1, 100))
            {
                ConnectionType tmpConnection = connections.addNewConnection();
                if (idxName > -1)
                {
                    connectionName = rowData.getCellAt(idxName).getData$();
                }
                if (idxCreatedBy > -1)
                {
                    connectionCreatedBy = rowData.getCellAt(idxCreatedBy).getData$();
                }
                if (idxCreatedOn > -1)
                {
                    connectionCreatedOnString = rowData.getCellAt(idxCreatedOn).getData$();
                }
                if (idxConnectionType > -1)
                {
                    connectionConnectionType = rowData.getCellAt(idxConnectionType).getData$();
                }
                if (idxSheetName > -1)
                {
                    connectionSheetName = rowData.getCellAt(idxSheetName).getData$();
                }
                if (idxRowName1 > -1)
                {
                    connectionRowName1 = rowData.getCellAt(idxRowName1).getData$();
                }
                if (idxRowName2 > -1)
                {
                    connectionRowName2 = rowData.getCellAt(idxRowName2).getData$();
                }
                if (idxRealizingElement > -1)
                {
                    connectionRealizingElement = rowData.getCellAt(idxRealizingElement).getData$();
                }
                if (idxPortName1 > -1)
                {
                    connectionPortName1 = rowData.getCellAt(idxPortName1).getData$();
                }
                if (idxPortName2 > -1)
                {
                    connectionPortName2 = rowData.getCellAt(idxPortName2).getData$();
                }
                if (idxExtSystem > -1)
                {
                    connectionExtSystem = rowData.getCellAt(idxExtSystem).getData$();
                }
                if (idxExtObject > -1)
                {
                    connectionExtObject = rowData.getCellAt(idxExtObject).getData$();
                }
                if (idxExtIdentifier > -1)
                {
                    connectionExtIdentifier = rowData.getCellAt(idxExtIdentifier).getData$();
                }
                if (idxDescription > -1)
                {
                    connectionDescription = rowData.getCellAt(idxDescription).getData$();
                }
                connectionCreatedOn = getCobieStringHandler().calendarFromString(connectionCreatedOnString);
                tmpConnection.setName(cobieStringHandler.getCOBieString(connectionName));
                tmpConnection.setCreatedBy(cobieStringHandler.getCOBieString(connectionCreatedBy));
                tmpConnection.setCreatedOn(connectionCreatedOn);
                tmpConnection.setConnectionType(cobieStringHandler.getCOBieString(connectionConnectionType));
                tmpConnection.setSheetName(cobieStringHandler.getCOBieString(connectionSheetName));
                tmpConnection.setRowName1(cobieStringHandler.getCOBieString(connectionRowName1));
                tmpConnection.setRowName2(cobieStringHandler.getCOBieString(connectionRowName2));
                tmpConnection.setRealizingElement(cobieStringHandler.getCOBieString(connectionRealizingElement));
                tmpConnection.setPortName1(cobieStringHandler.getCOBieString(connectionPortName1));
                tmpConnection.setPortName2(cobieStringHandler.getCOBieString(connectionPortName2));
                tmpConnection.setExtSystem(cobieStringHandler.getCOBieString(connectionExtSystem));
                tmpConnection.setExtObject(cobieStringHandler.getCOBieString(connectionExtObject));
                tmpConnection.setExtIdentifier(cobieStringHandler.getCOBieString(connectionExtIdentifier));
                tmpConnection.setDescription(cobieStringHandler.getCOBieString(connectionDescription));
            }
        }
    }

}
