package org.bimserver.plugins.deserializers;

import org.bimserver.emf.IfcModelInterface;
import org.bimserver.emf.PackageMetaData;

import java.io.InputStream;
import java.nio.file.Path;

public interface Deserializer {
	void init(PackageMetaData packageMetaData);
	IfcModelInterface read(Path file, ByteProgressReporter progressReporter) throws DeserializeException;
	IfcModelInterface read(InputStream inputStream,
                          String fileName,
                          long fileSize,
                          ByteProgressReporter progressReporter) throws DeserializeException;
	IfcModelInterface read(Path file) throws DeserializeException;
	IfcModelInterface read(InputStream inputStream, String fileName, long fileSize) throws DeserializeException;
}