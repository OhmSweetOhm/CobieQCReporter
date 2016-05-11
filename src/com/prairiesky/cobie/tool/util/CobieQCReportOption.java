package com.prairiesky.cobie.tool.util;

import org.apache.commons.cli.Option;

public enum CobieQCReportOption implements OptionProvider
{
	HELP("h","Help",false,"Displays the help menu", false),
	INPUT_FILEPATH("i","Input",true,"The filepath of the input file for QC testing.  Must be an XLSX or spreadsheet XML file.", true),
	PHASE("p", "Phase",true, "The construction phase QC ruleset.  Acceptable values are D, C - for Design and Construction Respectively", true),
	OUTPUT_FILEPATH("o","Output", true, "The filepath of the resulting QC report (html).", true);
	
	private final Option option;
	private final boolean required;
	private CobieQCReportOption(String shortName, String longName, boolean takesArgument, String description, boolean required)
	{
		this.option = new Option(shortName, longName, takesArgument, description);
		this.required = required;
	}
	
	@Override
	public Option getOption()
	{
		return option;
	}

	public boolean isRequired()
	{
		return required;
	}

}
