package com.dataParserLibrary.dataParserLibrary.parser;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class JsonParser<T> {
    private final ObjectMapper objectMapper;

    public JsonParser() {
        this.objectMapper = new ObjectMapper();
    }

    // Parse JSON from a File
    public T fromJson(File file, Class<T> clazz) throws IOException {
        return objectMapper.readValue(file, clazz);
    }

    // Parse JSON from an InputStream
    public T fromJson(InputStream inputStream, Class<T> clazz) throws IOException {
        return objectMapper.readValue(inputStream, clazz);
    }

    // Serialize an object to JSON and write to a File
    public void toJson(T object, File file) throws IOException {
        objectMapper.writeValue(file, object);
    }
}
