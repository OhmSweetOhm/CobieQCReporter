package org.bimserver.cobie.shared.utility;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;


public class WorkbookCopierOptions
{
	private boolean evaluateHeaderRows = false;
	private boolean evaluatePickLists = false;
	private NullInputCellPolicy nullInputCellPolicy = NullInputCellPolicy.CLEAR_EXISTING_OUTPUT_VALUES;
	private  MissingCellPolicy INPUT_WORKSHEET_MISSING_CELL_POLICY = Row.CREATE_NULL_AS_BLANK;
	private MissingCellPolicy OUTPUT_WORKSHEET_MISSING_CELL_POLICY = Row.RETURN_NULL_AND_BLANK;	
	private List<String> preserveOutputWorksheets = new ArrayList<>();
	
	public MissingCellPolicy getINPUT_WORKSHEET_MISSING_CELL_POLICY()
	{
		return INPUT_WORKSHEET_MISSING_CELL_POLICY;
	}
	public void setINPUT_WORKSHEET_MISSING_CELL_POLICY(MissingCellPolicy iNPUT_WORKSHEET_MISSING_CELL_POLICY)
	{
		INPUT_WORKSHEET_MISSING_CELL_POLICY = iNPUT_WORKSHEET_MISSING_CELL_POLICY;
	}
	public MissingCellPolicy getOUTPUT_WORKSHEET_MISSING_CELL_POLICY()
	{
		return OUTPUT_WORKSHEET_MISSING_CELL_POLICY;
	}
	public void setOUTPUT_WORKSHEET_MISSING_CELL_POLICY(MissingCellPolicy oUTPUT_WORKSHEET_MISSING_CELL_POLICY)
	{
		OUTPUT_WORKSHEET_MISSING_CELL_POLICY = oUTPUT_WORKSHEET_MISSING_CELL_POLICY;
	}
	public boolean isEvaluateHeaderRows()
	{
		return evaluateHeaderRows;
	}
	public void setEvaluateHeaderRows(boolean evaluateHeaderRows)
	{
		this.evaluateHeaderRows = evaluateHeaderRows;
	}
	public boolean isEvaluatePickLists()
	{
		return evaluatePickLists;
	}
	public void setEvaluatePickLists(boolean evaluatePickLists)
	{
		this.evaluatePickLists = evaluatePickLists;
	}
	public NullInputCellPolicy getNullInputCellPolicy()
	{
		return nullInputCellPolicy;
	}
	public void setNullInputCellPolicy(NullInputCellPolicy nullInputCellPolicy)
	{
		this.nullInputCellPolicy = nullInputCellPolicy;
	}
	public List<String> getPreserveOutputWorksheets()
	{
		return preserveOutputWorksheets;
	}
	public void setPreserveOutputWorksheets(List<String> preserveOutputWorksheets)
	{
		this.preserveOutputWorksheets = preserveOutputWorksheets;
	}
}
