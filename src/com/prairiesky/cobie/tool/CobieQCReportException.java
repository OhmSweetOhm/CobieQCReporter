package com.prairiesky.cobie.tool;

public class CobieQCReportException extends RuntimeException
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3207913845353541883L;

	public CobieQCReportException(Exception e)
	{
		super(e);
	}
	
	public CobieQCReportException(CobieQCReporterStringTable message, Exception e)
	{
		super(message.toString(), e);
	}
	
	public CobieQCReportException(CobieQCReporterStringTable message)
	{
		super(message.toString());
	}
	
}
