package org.bimserver.plugins.schema;

import org.bimserver.plugins.Plugin;
import org.bimserver.plugins.PluginConfiguration;

import java.nio.file.Path;

public interface SchemaPlugin extends Plugin {
	SchemaDefinition getSchemaDefinition(PluginConfiguration pluginConfiguration);
	Path getExpressSchemaFile();
	String getSchemaVersion();
}