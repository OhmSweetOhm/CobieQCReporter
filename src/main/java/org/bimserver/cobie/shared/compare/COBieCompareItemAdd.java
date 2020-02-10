package org.bimserver.cobie.shared.compare;

import org.bimserver.cobie.shared.cobietab.COBIERowDictionary;
import org.bimserver.cobie.shared.cobietab.COBIESheetCollection;
import org.bimserver.cobie.shared.cobietab.COBIESheetDictionary;

public class COBieCompareItemAdd extends COBieCompareItem
{
    private int rowNumber;

    public COBieCompareItemAdd(COBIESheetDictionary newCOBie, String rowHash, String sheetName)
    {

        super(sheetName, rowHash, newCOBie.get(sheetName).getByRowHash(rowHash).getCOBieRowIdString(), newCOBie.get(sheetName).getByRowHash(rowHash)
                .getCOBieUniqueIds());

        try
        {
            COBIESheetCollection cobie2Sheet = newCOBie.get(sheetName);
            COBIERowDictionary cobieRow = cobie2Sheet.getByRowHash(rowHash);
            setRowNumber(cobieRow.getCobieDocumentRowNumber());
            setCOBieKeyValues(cobieRow.getCOBieUniqueIds());

        } catch (Exception e)
        {

        }
    }

    public int getRowNumber()
    {
        return rowNumber;
    }

    public void setRowNumber(int rowNumber)
    {
        this.rowNumber = rowNumber;
    }

}
