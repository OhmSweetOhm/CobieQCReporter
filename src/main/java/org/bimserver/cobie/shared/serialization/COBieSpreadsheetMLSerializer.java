package org.bimserver.cobie.shared.serialization;

/******************************************************************************

 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.file.Path;

import org.bimserver.cobie.cobieserializersettings.COBieExportOptionsDocument;
import org.bimserver.cobie.shared.cobietab.COBieTabTransformable;
import org.bimserver.cobie.shared.transform.spreadsheetml.cobietab.COBieSpreadSheet;
import org.bimserver.cobie.shared.utility.CP1252Printwriter;
import org.bimserver.plugins.serializers.SerializerException;
import org.nibs.cobie.tab.COBIEDocument;

import com.prairiesky.transform.cobieifc.settings.SettingsType;

/**
 * @author chrisbogen This class is a sub-class of
 *         COBieSheetXMLDataTransformable and its purpose is to provide standard
 *         COBie SpreadsheetML serialization capabilities.
 */
public class COBieSpreadsheetMLSerializer extends COBieTabXMLSerializer implements
		COBieTabTransformable
{
	protected COBieSpreadSheet cobieSpreadsheet;
	protected COBieExportOptionsDocument exportOptions;
	private final File configurationFile;

	public COBieSpreadsheetMLSerializer(File configurationFile, File exportSettingsFile, SettingsType settings)
	{
		super(settings);
		this.configurationFile = configurationFile;
		try
		{
			exportOptions = COBieExportOptionsDocument.Factory
					.parse(exportSettingsFile);
		}
		catch (Exception ex)
		{
			exportOptions = null;
		}
	}
	
	public COBieSpreadsheetMLSerializer(Path configurationFile, Path exportSettingsFile, SettingsType settings)
	{
		this(configurationFile.toFile(), exportSettingsFile.toFile(), settings);
	}

	private PrintWriter createPrintWriter(OutputStream outputStream)
	{
		try
		{
			return new CP1252Printwriter(outputStream);
		}
		catch (UnsupportedEncodingException e)
		{
			return new org.bimserver.cobie.shared.utility.UTF8PrintWriter(outputStream);
		}
	}

	@Override
	protected void finalize() throws Throwable
	{
		super.finalize();
		cobieSpreadsheet = new COBieSpreadSheet(getConfigurationFile(),
				exportOptions);
	}

	public File getConfigurationFile()
	{
		return configurationFile;
	}

	@Override
	public void transformCOBieSheetXMLData(COBIEDocument cobieDocument,
			File targetSaveFile) throws Exception
	{
		cobieSpreadsheet = new COBieSpreadSheet(getConfigurationFile(),
				exportOptions);
		cobieSpreadsheet.loadCOBie(cobieDocument);
		PrintWriter printWriter = new PrintWriter(new FileOutputStream(
				targetSaveFile));
		cobieSpreadsheet.writeToOutputStream(printWriter);

	}

	@Override
	protected void writeCOBIE(OutputStream outputStream)
			throws SerializerException
	{
	  //  UUID guid = UUID.randomUUID();
	   // File tmpFile = new File(this.getPluginManager().getTempDir(), guid.toString() + ".tmp");
		try
		{
			writeCOBieToSpreadsheet();
			//cobieSpreadsheet.saveToFile(tmpFile);
		    //FileInputStream inputStream = new FileInputStream(tmpFile);
		    //outputStream.write(IOUtils.toByteArray(inputStream));
			cobieSpreadsheet
					.writeToOutputStream(createPrintWriter(outputStream));
		}
		catch (Exception e)
		{
			throw new SerializerException(e);
		}
		

	}

	/**
	 * Transforms the COBie data into SpreadsheetML by writing to a copy of the
	 * default template in lib/COBieExcelTemplate.xml.
	 */
	public void writeCOBieToSpreadsheet()
	{
		cobieSpreadsheet = new COBieSpreadSheet(getConfigurationFile(),
				exportOptions);
		cobieSpreadsheet.loadCOBie(getCOBieDocument());

	}

}
