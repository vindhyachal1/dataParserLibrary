package com.dataParserLibrary.dataParserLibrary.parser;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.io.File;
import java.io.IOException;

public class XmlParser<T> {
    private final XmlMapper xmlMapper = new XmlMapper();

    public T fromXml(File file, Class<T> clazz) throws IOException {
        return xmlMapper.readValue(file, clazz);
    }

    public void toXml(T data, File file) throws IOException {
        xmlMapper.writeValue(file, data);
    }
}
