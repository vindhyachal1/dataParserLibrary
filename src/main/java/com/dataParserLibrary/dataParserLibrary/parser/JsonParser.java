package com.dataParserLibrary.dataParserLibrary.parser;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class JsonParser<T> {
    private final ObjectMapper objectMapper = new ObjectMapper();

    public T fromJson(File file, Class<T> clazz) throws IOException {
        return objectMapper.readValue(file, clazz);
    }

    public void toJson(T data, File file) throws IOException {
        objectMapper.writeValue(file, data);
    }
}
