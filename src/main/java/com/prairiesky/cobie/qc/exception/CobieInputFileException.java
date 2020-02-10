package com.prairiesky.cobie.qc.exception;

public class CobieInputFileException extends CobieQCException
{
	private static final long serialVersionUID = 1079946888190294268L;

	public CobieInputFileException(Exception e)
	{
		super(CobieQCExceptionStringTable.COBIE_FILE_INVALID,e);
	}
	
	public CobieInputFileException()
	{
		super(CobieQCExceptionStringTable.COBIE_FILE_INVALID);
	}
}
