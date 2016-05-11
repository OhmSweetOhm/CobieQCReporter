package com.prairiesky.cobie.tool.util;

public enum PhaseOptionValue
{
	CONSTRUCTION("C"), DESIGN("D");
	
	private final String text;
	
	private PhaseOptionValue(String text)
	{
		this.text = text;
	}
	
	public String toString()
	{
		return text;
	}
	
	public boolean matches(String s)
	{
		return text.equalsIgnoreCase(s);
	}
}
