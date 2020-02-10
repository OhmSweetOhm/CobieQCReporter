package org.bimserver.cobie.shared.utility;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import org.bimserver.cobie.shared.COBieException;

public class StreamUtils 
{	
	public static ByteArrayInputStream getInputStream(ByteArrayOutputStream output) throws COBieException
	{
		return new ByteArrayInputStream(output.toByteArray());
	}
	
//	public static ByteInputStream getInputStream(ByteArrayOutputStream output) throws COBieException
//	{
//		return new ByteInputStream(output.getBytes(), output.size());
//	}
}
