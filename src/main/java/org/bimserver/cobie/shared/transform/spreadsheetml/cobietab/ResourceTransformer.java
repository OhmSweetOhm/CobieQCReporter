package org.bimserver.cobie.shared.transform.spreadsheetml.cobietab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import nl.fountain.xelem.excel.Row;
import nl.fountain.xelem.excel.Workbook;
import nl.fountain.xelem.excel.Worksheet;

import org.bimserver.cobie.shared.utility.COBieStringHandler;
import org.bimserver.cobie.shared.utility.COBieUtility.CobieSheetName;
import org.nibs.cobie.tab.COBIEType;
import org.nibs.cobie.tab.ResourceType;

public class ResourceTransformer extends SpreadsheetMLTransformer
{
    public ResourceTransformer(COBIEType cobie, Workbook workbook, COBieStringHandler cobieStringWriter)
    {
        super(workbook, cobie, cobieStringWriter);
    }

    public static enum ResourceColumnNameLiterals
    {
        Name, CreatedBy, CreatedOn, Category, ExtSystem, ExtObject, ExtIdentifier, Description
    }

    public static ArrayList<String> ResourceColumnNames = new ArrayList<String>(Arrays.asList("Name", "CreatedBy", "CreatedOn", "Category",
            "ExtSystem", "ExtObject", "ExtIdentifier", "Description"));

    public ResourceTransformer(COBIEType cobie, Workbook workbook)
    {
        super(cobie, workbook);
    };

    @Override
    protected List<String> getColumnNames()
    {
        return ResourceColumnNames;
    }

    @Override
    protected String getWorksheetName()
    {
        return CobieSheetName.Resource.name();
    }

    @Override
    protected void write()
    {
        COBIEType.Resources resources = getTarget().addNewResources();
        Worksheet sheet = getWorksheet();
        Map<String, Integer> columnDictionary = getColumnDictionary();
        String resourceName = "";
        String resourceCreatedBy = "";
        String resourceCreatedOnString = "";
        Calendar resourceCreatedOn;
        String resourceCategory = "";
        String resourceExtSystem = "";
        String resourceExtObject = "";
        String resourceExtIdentifier = "";
        String resourceDescription = "";
        int idxName;
        int idxCreatedBy;
        int idxCreatedOn;
        int idxCategory;
        int idxExtSystem;
        int idxExtObject;
        int idxExtIdentifier;
        int idxDescription;
        idxName = columnDictionary.get(ResourceColumnNameLiterals.Name.toString());
        idxCreatedBy = columnDictionary.get(ResourceColumnNameLiterals.CreatedBy.toString());
        idxCreatedOn = columnDictionary.get(ResourceColumnNameLiterals.CreatedOn.toString());
        idxCategory = columnDictionary.get(ResourceColumnNameLiterals.Category.toString());
        idxExtSystem = columnDictionary.get(ResourceColumnNameLiterals.ExtSystem.toString());
        idxExtObject = columnDictionary.get(ResourceColumnNameLiterals.ExtObject.toString());
        idxExtIdentifier = columnDictionary.get(ResourceColumnNameLiterals.ExtIdentifier.toString());
        idxDescription = columnDictionary.get(ResourceColumnNameLiterals.Description.toString());
        int rowIdx;
        int firstRowIdx = Worksheet.firstRow;
        for (Row rowData : sheet.getRows())
        {
            rowIdx = rowData.getIndex();
            if ((rowIdx > firstRowIdx) && COBieSpreadSheet.isRowPopulated(rowData, 1, 100))
            {
                ResourceType tmpResource = resources.addNewResource();
                if (idxName > -1)
                {
                    resourceName = rowData.getCellAt(idxName).getData$();
                }
                if (idxCreatedBy > -1)
                {
                    resourceCreatedBy = rowData.getCellAt(idxCreatedBy).getData$();
                }
                if (idxCreatedOn > -1)
                {
                    resourceCreatedOnString = rowData.getCellAt(idxCreatedOn).getData$();
                }
                if (idxCategory > -1)
                {
                    resourceCategory = rowData.getCellAt(idxCategory).getData$();
                }
                if (idxExtSystem > -1)
                {
                    resourceExtSystem = rowData.getCellAt(idxExtSystem).getData$();
                }
                if (idxExtObject > -1)
                {
                    resourceExtObject = rowData.getCellAt(idxExtObject).getData$();
                }
                if (idxExtIdentifier > -1)
                {
                    resourceExtIdentifier = rowData.getCellAt(idxExtIdentifier).getData$();
                }
                if (idxDescription > -1)
                {
                    resourceDescription = rowData.getCellAt(idxDescription).getData$();
                }
                resourceCreatedOn = getCobieStringHandler().calendarFromString(resourceCreatedOnString);
                tmpResource.setName(cobieStringHandler.getCOBieString(resourceName));
                tmpResource.setCreatedBy(cobieStringHandler.getCOBieString(resourceCreatedBy));
                tmpResource.setCreatedOn(resourceCreatedOn);
                tmpResource.setCategory(cobieStringHandler.getCOBieString(resourceCategory));
                tmpResource.setExtSystem(cobieStringHandler.getCOBieString(resourceExtSystem));
                tmpResource.setExtObject(cobieStringHandler.getCOBieString(resourceExtObject));
                tmpResource.setExtIdentifier(cobieStringHandler.getCOBieString(resourceExtIdentifier));
                tmpResource.setDescription(cobieStringHandler.getCOBieString(resourceDescription));
            }
        }
    }

}
