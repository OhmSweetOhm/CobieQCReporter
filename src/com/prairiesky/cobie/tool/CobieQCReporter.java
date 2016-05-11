package com.prairiesky.cobie.tool;

import java.io.File;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.bimserver.cobie.shared.deserialization.COBieDeserializer;
import org.bimserver.cobie.shared.reporting.COBieQCValidationPhase;
import org.bimserver.cobie.shared.reporting.COBieSchematronCheckerSettings;
import org.bimserver.cobie.shared.serialization.COBieCheckSerializer;
import org.bimserver.cobie.shared.utility.COBieStringHandler;
import org.bimserver.cobie.shared.utility.COBieStringHandlerSettings.EmptyStringMode;
import org.nibs.cobie.tab.COBIEDocument;

import com.prairiesky.cobie.tool.util.CobieQCReportOption;
import com.prairiesky.cobie.tool.util.OptionProvider;
import com.prairiesky.cobie.tool.util.PhaseOptionValue;

public class CobieQCReporter
{
	private final Logger LOG = Logger.getLogger(CobieQCReporter.class.getName());
	private final List<CobieQCReportOption> cobieQCOptions = new ArrayList<>();
	private final String[] arguments;
	private final Options options;
	private Optional<String> inputFilePathArgument = Optional.ofNullable(null);
	private Optional<String> outputFilePathArgument = Optional.ofNullable(null);
	private Optional<String> phaseArgument = Optional.ofNullable(null);
	private Optional<File> inputFile = Optional.ofNullable(null);
	private Optional<File> outputFile = Optional.ofNullable(null);
	private Optional<PhaseOptionValue> phase = Optional.ofNullable(null);
	private COBIEDocument cobieDocument;
	public static void main(String[] args)
	{
		CobieQCReporter reporter = new CobieQCReporter(args);
		try
		{
			reporter.init();
			reporter.runReport();
		}
		catch(CobieQCReportException e)
		{
			reporter.getLOG().severe(e.getMessage());
			reporter.help();
		}
		catch (CobieQCReportArgumentException e)
		{
			reporter.getLOG().severe(e.getMessage());
			reporter.help();
		}
		catch (HelpException e)
		{
			reporter.help();
		}
		System.exit(0);
	}

	public List<CobieQCReportOption> getCobieQCOptions()
	{
		return cobieQCOptions;
	}

	public void init() throws CobieQCReportArgumentException, HelpException
	{
		CommandLineParser parser = new BasicParser();
		CommandLine cmd = null;
		try
		{
			cmd = parser.parse(getOptions(), getArguments());
		}
		catch (ParseException e)
		{
			throw new CobieQCReportArgumentException(e);
		}
		parseArgumentValues(cmd);
		if (cobieQCOptions.contains(CobieQCReportOption.HELP)) { throw new HelpException(); }
		checkForInvalidOptions(cmd);
		checkForRequiredOptions();
		checkPhaseArgumentValue();
		checkFilePaths();
	}

	private void checkPhaseArgumentValue()
			throws CobieQCReportArgumentException
	{
		String phaseValue = getPhaseArgument().orElse(CobieQCReporterStringTable.BLANK.toString());
		for(PhaseOptionValue phase : PhaseOptionValue.values())
		{
			if(phase.matches(phaseValue))
			{
				setPhase(Optional.ofNullable(phase));
			}
		}
		if(!getPhase().isPresent())
		{
			throw new CobieQCReportArgumentException(CobieQCReporterStringTable.FORMATSTRING_ERROR_INVALID_PHASE.format(phaseValue));
		}

	}

	private void checkFilePaths() throws CobieQCReportArgumentException
	{
		checkInputPath();
		checkOutputPath();
	}

	private void checkOutputPath() throws CobieQCReportArgumentException
	{
		try
		{
			setOutputFile(Optional.ofNullable(new File(getOutputFilePathArgument().orElse(CobieQCReporterStringTable.BLANK.toString()))));
			if(getOutputFile().get().exists() && getOutputFile().get().isDirectory())
			{
				throw new CobieQCReportArgumentException(CobieQCReporterStringTable.MESSAGE_ERROR_INVALID_OUTPUT_FILEPATH_DIR);
			}
			if(!getOutputFile().get().getName().endsWith(CobieQCReporterStringTable.FILE_EXTENSION_HTML.toString()))
			{
				setOutputFile(Optional.ofNullable(new File(getOutputFilePathArgument().get() + CobieQCReporterStringTable.FILE_EXTENSION_HTML.toString())));
			}
		}
		catch(Exception e)
		{
			throw new CobieQCReportArgumentException(CobieQCReporterStringTable.MESSAGE_ERROR_INVALID_OUTPUT_FILEPATH, e);
		}
		
	}

	private void checkInputPath() throws CobieQCReportArgumentException
	{
		try
		{
			File file = new File(getInputFilePathArgument().orElse(null));
			if(!file.exists())
			{
				throw new CobieQCReportArgumentException(CobieQCReporterStringTable.MESSAGE_ERROR_INPUT_FILE_NOT_EXIST);
			}
			else
			{
				setInputFile(Optional.ofNullable(file));
			}
		}
		catch(Exception e)
		{
			throw new CobieQCReportArgumentException(CobieQCReporterStringTable.MESSAGE_ERROR_INVALID_INPUT_FILE, e);
		}
		
	}

	private void checkForRequiredOptions()
			throws CobieQCReportArgumentException
	{
		boolean valid = true;
		for(CobieQCReportOption option : CobieQCReportOption.values())
		{
			if(option.isRequired() && !getCobieQCOptions().contains(option))
			{
				valid = false;
			}
		}
		if(!valid)
		{
			throw new CobieQCReportArgumentException(CobieQCReporterStringTable.MESSAGE_ERROR_REQUIRED_ARGS_MISSING);
		}
	}

	public void runReport() throws CobieQCReportException
	{
		cobieFromInputFile();
		executeReportTransforms();
	}

	private void executeReportTransforms() throws CobieQCReportException
	{
		COBieQCValidationPhase validationPhase;
		switch(getPhase().get())
		{
			case CONSTRUCTION:
				validationPhase = COBieQCValidationPhase.Construction;
				break;
			case DESIGN:
				validationPhase = COBieQCValidationPhase.Design;
				break;
			default:
				validationPhase = COBieQCValidationPhase.Design;
				break;
			
		}
		
		 COBieSchematronCheckerSettings settings = 
				 new COBieSchematronCheckerSettings(new File(CobieQCReporterStringTable.FILEPATH_SCHEMATRON_RULE.toString()), 
						 new File(CobieQCReporterStringTable.FILEPATH_SCHEMATRON_PREPROCESSOR.toString()), 
						 new File(CobieQCReporterStringTable.FILEPATH_SVRL_XSLT.toString()),
						 validationPhase);
		 COBieCheckSerializer serializer =
				 new COBieCheckSerializer(settings, null);
		 try
		{
			serializer.transformCOBieSheetXMLData(getCobieDocument(), getOutputFile().get());
		}
		catch (Exception e)
		{
			throw new CobieQCReportException(CobieQCReporterStringTable.MESSAGE_ERROR_QC_REPORT, e);
		}
		
	}

	private void cobieFromInputFile() throws CobieQCReportException
	{
		COBieDeserializer deserializer =
				new COBieDeserializer(new File(CobieQCReporterStringTable.FILEPATH_BLANK_COBIE.toString()), null);
		
		try
		{
			COBieStringHandler handler = new COBieStringHandler();
			handler.getSettings().setEmptyStringMode(EmptyStringMode.ALLOW);
			setCobieDocument(deserializer.toCOBieSheetXMLData(getInputFile().get(), handler));
		}
		catch (Exception e)
		{
			throw new CobieQCReportException(CobieQCReporterStringTable.MESSAGE_ERROR_INVALID_SPREADSHEET);
		}	
	}
	

	private void checkForInvalidOptions(CommandLine cmd)
	{
		if (cmd.getOptions().length != getCobieQCOptions().size())
		{ 
			throw new CobieQCReportArgumentException(CobieQCReporterStringTable.MESSAGE_ERROR_INVALID_OPTION);
		}
	}

	private void parseArgumentValues(CommandLine cmd)
	{
		for (CobieQCReportOption option : CobieQCReportOption.values())
		{
			if (hasOption(option, cmd))
			{
				getCobieQCOptions().add(option);
				switch (option)
				{
					case HELP:
						break;
					case INPUT_FILEPATH:
						inputFilePathArgument = Optional.ofNullable(cmd
								.getOptionValue(option.getOption().getOpt()));
						break;
					case PHASE:
						phaseArgument = Optional.ofNullable(cmd
								.getOptionValue(option.getOption().getOpt()));
						break;
					case OUTPUT_FILEPATH:
						outputFilePathArgument = Optional.ofNullable(cmd
								.getOptionValue(option.getOption().getOpt()));
						break;
					default:
						break;

				}
			}
		}
	}

	public CobieQCReporter(String[] args)
	{
		this.arguments = args;
		this.options = new Options();
		for (CobieQCReportOption option : CobieQCReportOption.values())
		{
			getOptions().addOption(option.getOption());
		}
	}

	protected static boolean hasOption(OptionProvider option, CommandLine cmd)
	{
		String shortName = option.getOption().getOpt();
		String longName = option.getOption().getLongOpt();
		return cmd.hasOption(shortName) || cmd.hasOption(longName);
	}

	public String[] getArguments()
	{
		return arguments;
	}

	public Options getOptions()
	{
		return options;
	}

	public Optional<String> getPhaseArgument()
	{
		return phaseArgument;
	}

	public void setPhaseArgument(Optional<String> phaseArgument)
	{
		this.phaseArgument = phaseArgument;
	}

	public Optional<String> getInputFilePathArgument()
	{
		return inputFilePathArgument;
	}

	public void setInputFilePathArgument(Optional<String> inputFilePathArgument)
	{
		this.inputFilePathArgument = inputFilePathArgument;
	}

	public Optional<String> getOutputFilePathArgument()
	{
		return outputFilePathArgument;
	}

	public void setOutputFilePathArgument(
			Optional<String> outputFilePathArgument)
	{
		this.outputFilePathArgument = outputFilePathArgument;
	}

	public Optional<File> getInputFile()
	{
		return inputFile;
	}

	public void setInputFile(Optional<File> inputFile)
	{
		this.inputFile = inputFile;
	}

	public Optional<File> getOutputFile()
	{
		return outputFile;
	}

	public void setOutputFile(Optional<File> outputFile)
	{
		this.outputFile = outputFile;
	}

	private void help()
	{
		HelpFormatter formatter = new HelpFormatter();
		String header = MessageFormat.format(
				CobieQCReporterStringTable.FORMATSTRING_HELP_REQUIRED_ARGS.toString(),
				CobieQCReportOption.INPUT_FILEPATH.getOption().getLongOpt(),
				CobieQCReportOption.OUTPUT_FILEPATH.getOption().getLongOpt(),
				CobieQCReportOption.PHASE.getOption().getLongOpt());
		formatter.printHelp(CobieQCReporter.class.getSimpleName()
				+ CobieQCReporterStringTable.HELP_OPTIONS_TAG.toString(), header, getOptions(), "");
	}

	public Logger getLOG()
	{
		return LOG;
	}

	public COBIEDocument getCobieDocument()
	{
		return cobieDocument;
	}

	public void setCobieDocument(COBIEDocument cobieDocument)
	{
		this.cobieDocument = cobieDocument;
	}

	public Optional<PhaseOptionValue> getPhase()
	{
		return phase;
	}

	public void setPhase(Optional<PhaseOptionValue> phase)
	{
		this.phase = phase;
	}

}
