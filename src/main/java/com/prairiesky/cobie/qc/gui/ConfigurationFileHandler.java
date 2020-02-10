package com.prairiesky.cobie.qc.gui;

import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.builder.FileBasedConfigurationBuilder;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.builder.fluent.Parameters;
import org.apache.commons.configuration2.ex.ConfigurationException;

import java.io.File;
import java.io.IOException;

public class ConfigurationFileHandler {

    public static class Factory {

        public static ConfigurationFileHandler newInstance() throws ConfigurationException, IOException {
            return new ConfigurationFileHandler(false);
        }

        public static ConfigurationFileHandler newInstance(boolean enableAutoSave) throws ConfigurationException,
                                                                                          IOException {
            return new ConfigurationFileHandler(enableAutoSave);
        }
    }

    private final Parameters params = new Parameters();
    private final File configurationFile = new File(COBieGUIStringTable.FILEPATH_CONFIG_FILE.toString());
    private final FileBasedConfigurationBuilder<PropertiesConfiguration> builder;
    //private final FileBasedConfiguration configuration;
    private final Configurations configurations = new Configurations();
    private final PropertiesConfiguration configuration;

    private ConfigurationFileHandler() throws ConfigurationException, IOException {
        this(false);
    }

    private ConfigurationFileHandler(boolean enableAutoSave) throws ConfigurationException, IOException {
        if (!configurationFile.exists()) {
            configurationFile.getParentFile().mkdirs();
            configurationFile.createNewFile();
        }
        this.builder = configurations.propertiesBuilder(configurationFile);
        this.builder.setAutoSave(enableAutoSave);
        this.configuration = this.builder.getConfiguration();
    }

    public File getConfigurationFile() {
        return configurationFile;
    }

    public PropertiesConfiguration getConfiguration() {
        return this.configuration;
    }

    public File getLastFileOpened() throws NullPointerException {
        String filepath = getConfiguration().getString(COBieGUIProperty.LAST_INPUT_FILE.getPropertyName());
        return new File(filepath);
    }

    public File getLastSaveDirectory() throws NullPointerException {
        String filepath = getConfiguration().getString(COBieGUIProperty.LAST_OUTPUT_DIRECTORY.getPropertyName());
        return new File(filepath);
    }

    public void setLastFileOpened(File lastFile) {
        getConfiguration().setProperty(COBieGUIProperty.LAST_INPUT_FILE.getPropertyName(), lastFile.getAbsolutePath());
    }

    public void setLastSaveLocation(File lastSaveDir) {
        getConfiguration().setProperty(COBieGUIProperty.LAST_OUTPUT_DIRECTORY.getPropertyName(),
                                       lastSaveDir.getAbsolutePath());
    }
}
