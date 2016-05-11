package com.prairiesky.cobie.tool;

public class CobieQCReportArgumentException extends IllegalArgumentException
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 717600268382996946L;

	public CobieQCReportArgumentException(Exception e)
	{
		super(e);
	}
	
	public CobieQCReportArgumentException(CobieQCReporterStringTable message, Exception e)
	{
		super(message.toString(), e);
	}
	
	public CobieQCReportArgumentException(CobieQCReporterStringTable message)
	{
		super(message.toString());
	}
	
	public CobieQCReportArgumentException(String message)
	{
		super(message);
	}
}
