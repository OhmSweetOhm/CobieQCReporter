package com.prairiesky.cobie.tool;

import com.prairiesky.cobie.tool.util.CobieQCReportOption;

public enum CobieQCReporterStringTable
{
	BLANK(""),
	FILE_EXTENSION_HTML(".html"),
	FILEPATH_BLANK_COBIE("xsl_xml/COBieExcelTemplate.xml"),
	FILEPATH_CSS("xsl_xml/SpaceReport.css"),
	FILEPATH_SCHEMATRON_PREPROCESSOR("xsl_xml/iso_svrl_for_xslt2.xsl"),
	FILEPATH_SCHEMATRON_FUNCTION("xsl_xml/COBieRules_Functions.xsl"),
	FILEPATH_SCHEMATRON_RULE("xsl_xml/COBieRules.sch"),
	FILEPATH_SCHEMATRON_SKELETON("xsl_xml/iso_schematron_skeleton_for_saxon.xsl"),
	FILEPATH_SVRL_XSLT("xsl_xml/SVRL_HTML_altLocation.xslt"),
	FORMATSTRING_ERROR_INVALID_PHASE("Invalid Phase value, \"%s\""),
	FORMATSTRING_HELP_REQUIRED_ARGS("The --{0}, --{1}, and --{2} arguments are required."),
	HELP_OPTIONS_TAG(" <options>"),
	MESSAGE_ERROR_INVALID_INPUT_FILE("Invalid input filepath"),
	MESSAGE_ERROR_INPUT_FILE_NOT_EXIST("Input file does not exist"),
	MESSAGE_ERROR_INVALID_OPTION("Invalid Option(s). Use the "
						+ CobieQCReportOption.HELP.getOption().getOpt()
						+ " for help"),
	MESSAGE_ERROR_INVALID_OUTPUT_FILEPATH("Invalid output filepath"),
	MESSAGE_ERROR_INVALID_OUTPUT_FILEPATH_DIR("Invalid output filepath: Output filepath should point to a file, not a directory"),
	MESSAGE_ERROR_INVALID_SPREADSHEET("Input stream not a valid spreadsheetml file"),
	MESSAGE_ERROR_QC_REPORT("Error producing QC report"),
	MESSAGE_ERROR_REQUIRED_ARGS_MISSING("Required argument(s) are missing");
	private final String text;
	
	private CobieQCReporterStringTable(String text)
	{
		this.text = text;
	}
	
	public String toString()
	{
		return text;
	}
	
	public String format(Object... args)
	{
		return String.format(text, args);
	}
}
