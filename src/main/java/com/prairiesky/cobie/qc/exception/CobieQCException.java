package com.prairiesky.cobie.qc.exception;

public class CobieQCException extends RuntimeException
{
	private static final long serialVersionUID = 8127904963336613012L;
	private final CobieQCExceptionStringTable errorDetails;
	public CobieQCException(CobieQCExceptionStringTable errorMessage)
	{
		super(errorMessage.toString());
		this.errorDetails = errorMessage;
	}
	
	public CobieQCException(CobieQCExceptionStringTable errorMessage, Exception e)
	{
		super(errorMessage.toString(),e);
		this.errorDetails = errorMessage;
	}
	
	public final CobieQCExceptionStringTable getErrorDetails()
	{
		return errorDetails;
	}
}
