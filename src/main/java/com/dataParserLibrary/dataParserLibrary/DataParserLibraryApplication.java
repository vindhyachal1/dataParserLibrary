package com.dataParserLibrary.dataParserLibrary;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.dataParserLibrary.dataParserLibrary.parser.CsvParser;
import com.dataParserLibrary.dataParserLibrary.parser.JsonParser;
import com.dataParserLibrary.dataParserLibrary.parser.XmlParser;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

@SpringBootApplication
public class DataParserLibraryApplication {
	public static void main(String[] args) throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {
        // JSON Example
        JsonParser<MyData> jsonParser = new JsonParser<>();
        MyData jsonData = jsonParser.fromJson(new File("data.json"), MyData.class);
        jsonParser.toJson(jsonData, new File("output.json"));

        // XML Example
        XmlParser<MyData> xmlParser = new XmlParser<>();
        MyData xmlData = xmlParser.fromXml(new File("data.xml"), MyData.class);
        xmlParser.toXml(xmlData, new File("output.xml"));

        // CSV Example
        CsvParser<MyData> csvParser = new CsvParser<>();
        try (FileReader fileReader = new FileReader("data.csv");
             FileWriter fileWriter = new FileWriter("output.csv")) {
            List<MyData> csvData = csvParser.fromCsv(fileReader, MyData.class);
            csvParser.toCsv(csvData, fileWriter);
        }
    }

}
