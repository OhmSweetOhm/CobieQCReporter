package org.bimserver.cobie.shared.transform.spreadsheetml.cobietab;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

import nl.fountain.xelem.excel.Row;
import nl.fountain.xelem.excel.Workbook;
import nl.fountain.xelem.excel.Worksheet;

import org.bimserver.cobie.shared.COBieTokenUtility;
import org.bimserver.cobie.shared.COBieTokenUtility.SystemColumnNameLiterals;
import org.bimserver.cobie.shared.utility.COBieStringHandler;
import org.bimserver.cobie.shared.utility.COBieUtility.CobieSheetName;
import org.nibs.cobie.tab.COBIEType;
import org.nibs.cobie.tab.SystemType;

public class SystemTransformer extends SpreadsheetMLTransformer
{

    public SystemTransformer(COBIEType cobie, Workbook workbook, COBieStringHandler cobieStringWriter)
    {
        super(workbook, cobie, cobieStringWriter);
    }

    public SystemTransformer(COBIEType cobie, Workbook workbook)
    {
        super(cobie, workbook);
    }

    @Override
    protected List<String> getColumnNames()
    {
        return COBieTokenUtility.SystemColumnNames;
    }

    @Override
    protected String getWorksheetName()
    {
        return CobieSheetName.System.name();
    }

    @Override
    protected void write()
    {
        COBIEType.Systems systems = getTarget().addNewSystems();
        Worksheet sheet = getWorksheet();
        Map<String, Integer> columnDictionary = getColumnDictionary();

        String systemName = "";
        String systemCreatedBy = "";
        Calendar systemCreatedOn;
        String systemCreatedOnString = "";
        String systemCategory = "";
        String systemComponentNames = "";
        String systemExtSystem = "";
        String systemExtObject = "";
        String systemExtIdentifier = "";
        String systemDescription = "";
        int idxName;
        int idxCreatedBy;
        int idxCreatedOn;
        int idxCategory;
        int idxComponentNames;
        int idxExtSystem;
        int idxExtObject;
        int idxExtIdentifier;
        int idxDescription;
        idxName = columnDictionary.get(SystemColumnNameLiterals.Name.toString());
        idxCreatedBy = columnDictionary.get(SystemColumnNameLiterals.CreatedBy.toString());
        idxCreatedOn = columnDictionary.get(SystemColumnNameLiterals.CreatedOn.toString());
        idxCategory = columnDictionary.get(SystemColumnNameLiterals.Category.toString());
        idxComponentNames = columnDictionary.get(SystemColumnNameLiterals.ComponentNames.toString());
        idxExtSystem = columnDictionary.get(SystemColumnNameLiterals.ExtSystem.toString());
        idxExtObject = columnDictionary.get(SystemColumnNameLiterals.ExtObject.toString());
        idxExtIdentifier = columnDictionary.get(SystemColumnNameLiterals.ExtIdentifier.toString());
        idxDescription = columnDictionary.get(SystemColumnNameLiterals.Description.toString());
        int rowIdx;
        int firstRowIdx = Worksheet.firstRow;
        for (Row rowData : sheet.getRows())
        {
            rowIdx = rowData.getIndex();
            if ((rowIdx > firstRowIdx) && COBieSpreadSheet.isRowPopulated(rowData, 1, 100))
            {
                SystemType tmpSystem = systems.addNewSystem();
                if (idxName > -1)
                {
                    systemName = rowData.getCellAt(idxName).getData$();
                }
                if (idxCreatedBy > -1)
                {
                    systemCreatedBy = rowData.getCellAt(idxCreatedBy).getData$();
                }
                if (idxCreatedOn > -1)
                {
                    systemCreatedOnString = rowData.getCellAt(idxCreatedOn).getData$();
                }
                if (idxCategory > -1)
                {
                    systemCategory = rowData.getCellAt(idxCategory).getData$();
                }
                if (idxComponentNames > -1)
                {
                    systemComponentNames = rowData.getCellAt(idxComponentNames).getData$();
                }
                if (idxExtSystem > -1)
                {
                    systemExtSystem = rowData.getCellAt(idxExtSystem).getData$();
                }
                if (idxExtObject > -1)
                {
                    systemExtObject = rowData.getCellAt(idxExtObject).getData$();
                }
                if (idxExtIdentifier > -1)
                {
                    systemExtIdentifier = rowData.getCellAt(idxExtIdentifier).getData$();
                }
                if (idxDescription > -1)
                {
                    systemDescription = rowData.getCellAt(idxDescription).getData$();
                }
                systemCreatedOn = getCobieStringHandler().calendarFromString(systemCreatedOnString);
                tmpSystem.setName(cobieStringHandler.getCOBieString(systemName));
                tmpSystem.setCreatedBy(cobieStringHandler.getCOBieString(systemCreatedBy));
                tmpSystem.setCreatedOn(systemCreatedOn);
                tmpSystem.setCategory(cobieStringHandler.getCOBieString(systemCategory));
                tmpSystem.setComponentNames(cobieStringHandler.getCOBieString(systemComponentNames));
                tmpSystem.setExtSystem(cobieStringHandler.getCOBieString(systemExtSystem));
                tmpSystem.setExtObject(cobieStringHandler.getCOBieString(systemExtObject));
                tmpSystem.setExtIdentifier(cobieStringHandler.getCOBieString(systemExtIdentifier));
                tmpSystem.setDescription(cobieStringHandler.getCOBieString(systemDescription));
            }
        }
    }

}
