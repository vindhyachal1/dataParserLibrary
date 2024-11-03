package com.dataParserLibrary.dataParserLibrary.parser;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.*;
import java.util.List;

public class CsvParser<T> {

    // Parse CSV from a FileReader
    public List<T> fromCsv(Reader reader, Class<T> clazz) {
        CsvToBean<T> csvToBean = new CsvToBeanBuilder<T>(reader)
                .withType(clazz)
                .withIgnoreLeadingWhiteSpace(true)
                .build();
        return csvToBean.parse();
    }

    // Parse CSV from an InputStream
    public List<T> fromCsv(InputStream inputStream, Class<T> clazz) throws IOException {
        try (Reader reader = new InputStreamReader(inputStream)) {
            return fromCsv(reader, clazz);
        }
    }

    // Serialize a list of objects to CSV and write to a Writer (e.g., FileWriter)
    public void toCsv(List<T> data, Writer writer) throws CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {
        StatefulBeanToCsv<T> beanToCsv = new StatefulBeanToCsvBuilder<T>(writer).build();
        beanToCsv.write(data);
    }
}