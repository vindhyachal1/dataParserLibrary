package com.dataParserLibrary.dataParserLibrary;

import java.io.*;
import java.nio.file.Files;
import java.util.List;

import com.dataParserLibrary.dataParserLibrary.parser.CsvParser;
import com.dataParserLibrary.dataParserLibrary.parser.JsonParser;
import com.dataParserLibrary.dataParserLibrary.parser.XmlParser;

public class DataParserLibraryApplication {
    public static void main(String[] args) {
        try {
            // JSON Example
            JsonParser<MyData> jsonParser = new JsonParser<>();
            File jsonFile = copyResourceToFile("data.json");
            MyData jsonData = jsonParser.fromJson(jsonFile, MyData.class);
            System.out.println("JSON Data: " + jsonData);

            // XML Example
            XmlParser<MyData> xmlParser = new XmlParser<>();
            File xmlFile = copyResourceToFile("data.xml");
            MyData xmlData = xmlParser.fromXml(xmlFile, MyData.class);
            System.out.println("XML Data: " + xmlData);

            // CSV Example
            CsvParser<MyData> csvParser = new CsvParser<>();
            File csvFile = copyResourceToFile("data.csv");
            try (FileReader csvFileReader = new FileReader(csvFile)) {
                List<MyData> csvDataList = csvParser.fromCsv(csvFileReader, MyData.class);
                System.out.println("CSV Data: " + csvDataList);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static File copyResourceToFile(String resourceName) throws IOException {
        InputStream inputStream = DataParserLibraryApplication.class.getClassLoader().getResourceAsStream(resourceName);
        if (inputStream == null) throw new FileNotFoundException("Resource not found: " + resourceName);

        File tempFile = Files.createTempFile("temp", resourceName).toFile();
        tempFile.deleteOnExit();

        try (FileOutputStream outStream = new FileOutputStream(tempFile)) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outStream.write(buffer, 0, bytesRead);
            }
        }
        return tempFile;
    }
}