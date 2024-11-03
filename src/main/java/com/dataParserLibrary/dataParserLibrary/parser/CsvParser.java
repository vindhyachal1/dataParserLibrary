package com.dataParserLibrary.dataParserLibrary.parser;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CsvParser<T> {

    public List<T> fromCsv(FileReader fileReader, Class<T> clazz) throws IOException {
        CsvToBean<T> csvToBean = new CsvToBeanBuilder<T>(fileReader)
                .withType(clazz)
                .withIgnoreLeadingWhiteSpace(true)
                .build();
        return csvToBean.parse();
    }

    public void toCsv(List<T> data, FileWriter fileWriter) throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {
        StatefulBeanToCsv<T> beanToCsv = new StatefulBeanToCsvBuilder<T>(fileWriter).build();
        beanToCsv.write(data);
    }
}
