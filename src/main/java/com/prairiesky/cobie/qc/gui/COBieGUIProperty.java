package com.prairiesky.cobie.qc.gui;

public enum COBieGUIProperty
{
	
	LAST_INPUT_FILE(COBieGUIProperty.FILES_SECTION + "." + "LastInputFile"),
	LAST_OUTPUT_DIRECTORY(COBieGUIProperty.FILES_SECTION + "." + "LastOutputDirectory");
	private final String propertyName;
	public static final String FILES_SECTION = "Files";
	private COBieGUIProperty(String propertyName)
	{
		this.propertyName = propertyName;
	}
	
	public String getPropertyName()
	{
		return this.propertyName;
	}
	
	@Override
	public String toString()
	{
		return getPropertyName();
	}
}
