package org.bimserver.cobie.shared.utility;

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class CP1252Printwriter extends PrintWriter
{
	public CP1252Printwriter(OutputStream out) throws UnsupportedEncodingException
	{
		super(new PrintWriter(new OutputStreamWriter(out,"Cp1252")), false);

	}
}
