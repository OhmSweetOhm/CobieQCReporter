package com.prairiesky.cobie.qc.exception;

public enum CobieQCExceptionStringTable
{
	COBIE_FILE_INVALID("Cobie File Error","Input File Exception","There was an error loading the selected COBie file.  Please check to make sure that it is a valid XLSX COBie formatted Workbook."),
	COBIE_QC_ERROR("Cobie QC Report Error","Cobie QC Report Error","An unexpected error occured while producing the QC Report");
	private final String message,title,header;
	private CobieQCExceptionStringTable(String header, String title, String message)
	{
		this.message = message;
		this.title = title;
		this.header = header;
	}
	
	public String toString()
	{
		return this.message;
	}
	
	public String getHeader()
	{
		return this.header;
	}
	
	public String getTitle()
	{
		return this.title;
	}
	
	public String getMessage()
	{
		return this.toString();
	}
}
