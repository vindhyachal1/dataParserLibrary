package com.dataParserLibrary.dataParserLibrary.parser;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class XmlParser<T> {
    private final XmlMapper xmlMapper;

    public XmlParser() {
        this.xmlMapper = new XmlMapper();
    }

    // Parse XML from a File
    public T fromXml(File file, Class<T> clazz) throws IOException {
        return xmlMapper.readValue(file, clazz);
    }

    // Parse XML from an InputStream
    public T fromXml(InputStream inputStream, Class<T> clazz) throws IOException {
        return xmlMapper.readValue(inputStream, clazz);
    }

    // Serialize an object to XML and write to a File
    public void toXml(T object, File file) throws IOException {
        xmlMapper.writeValue(file, object);
    }
}