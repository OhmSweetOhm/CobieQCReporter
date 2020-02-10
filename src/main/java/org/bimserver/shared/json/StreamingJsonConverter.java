package org.bimserver.shared.json;

import com.google.gson.stream.JsonReader;

import java.io.IOException;

public class StreamingJsonConverter {

	public <T> T fromJson(JsonReader jsonReader, Class<T> cl) throws IOException {
		jsonReader.beginObject();
		
		jsonReader.endObject();
		return null;
	}
}
