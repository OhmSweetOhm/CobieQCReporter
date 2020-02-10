package com.prairiesky.cobie.qc.exception;

public class CobieQCReportException extends CobieQCException
{
	public CobieQCReportException(Exception e)
	{
		super(CobieQCExceptionStringTable.COBIE_QC_ERROR,e);
	}
	
	public CobieQCReportException()
	{
		super(CobieQCExceptionStringTable.COBIE_QC_ERROR);
	}
}
