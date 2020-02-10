package com.prairiesky.cobie.qc.gui;

public enum COBieGUIStringTable
{
	APPLICATIONNAME("COBie QC Checker"),
	ABOUT_WINDOW_TITLE("About COBie QC Checker"),
	ABOUT_WINDOW_CONTENT("The COBie QC Reporter and COBie Plugin for BIMserver.org are open source programs hosted on GitHub.org. To check the latest version visit the GitHub.org repository.\r\n" + 
			"\r\n" + 
			" \r\n" + 
			"This program was developed for Prairie Sky Consulting. For more information about COBie and other services supporting Better Information Management and Lean Handover practices, visit https://www.prairieskyconsulting.com"),
	BLANK(""),
	EXCEPTION_LABEL("The exception stacktrace was:"),
	FILE_EXTENSION_HTML(".html"),
	FILE_EXTENSION_XLSX(".xlsx"),
	FILE_EXTENSION_XML(".xml"),
	FILEPATH_BLANK_COBIE("etc/xsl_xml/COBieExcelTemplate.xml"),
	FILEPATH_CONFIG_FILE("var/application.properties"),
	FILEPATH_CSS("etc/xsl_xml/SpaceReport.css"),
	FILEPATH_SCHEMATRON_PREPROCESSOR("etc/xsl_xml/iso_svrl_for_xslt2.xsl"),
	FILEPATH_SCHEMATRON_FUNCTION("etc/xsl_xml/COBieRules_Functions.xsl"),
	FILEPATH_SCHEMATRON_RULE("etc/xsl_xml/COBieRules.sch"),
	FILEPATH_SCHEMATRON_SKELETON("etc/xsl_xml/iso_schematron_skeleton_for_saxon.xsl"),
	FILEPATH_SVRL_XSLT("etc/xsl_xml/SVRL_HTML_altLocation.xslt"),
	FILE_FILTER_HTML("*.html"),
	FILE_FILTER_HTML_DESCRIPTION("COBie QC Report (html)"),
	FILE_FILTER_XLSX("*.xlsx"),
	FILE_FILTER_XLSX_DESCRIPTION("COBie spreadsheet (xlsx)"),
	FILE_FILTER_XML("*.xml"),
	FILE_FILTER_XML_DESCRIPTION("XML File for Extended Rules"),
	FILE_NAME_OUTPUT_DEFAULT_SUFFIX("_QCReport"),
	HELP_WINDOW_TITLE("COBie QC Checker Help"),
	HELP_WINDOW_CONTENT("Program documentation is provided in the book 'Construction-Operations Building information exchange (COBie) Quality Control' by Dr. Bill East and Dr. Chris Bogen. Copies are available exclusively at http://www.lulu.com/spotlight/billeast.\r\n" +
			"\r\n" + 
			" \r\n" + 
			"\r\n" + 
			"Requests for new features and issue reporting is accomplished exclusively at https://github.com/OhmSweetOhm/CobieQCReporter/issues.  When posting your suggestion or  issue please provide a descriptive title and reference this specific program version: Version 2.00, 01-Jul-2019"),
	PHASE_MENU_HEADER("Phase"),
	PHASE_MENU_CONSTRUCTION("Construction"),
	PHASE_MENU_DESIGN("Design"),
	REPORT_NAME_DATE_FORMAT("yyyy-MM-dd");
	
	private final String text;
	private COBieGUIStringTable(String text)
	{
		this.text = text;
	}
	
	public String toString()
	{
		return this.text;
	}
}
