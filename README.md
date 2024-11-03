Data Parsing Library

`dataParsingLibrary` is a lightweight data parsing library designed for Java Spring Boot applications. It provides easy import/export functionalities for JSON, XML, and CSV data formats.

Features

- JSON Parsing: Easily parse JSON files to Java objects and vice versa.
- XML Parsing: Read and write XML files to and from Java objects.
- CSV Parsing: Import and export data in CSV format using Java objects.

 Requirements

- Java 8 or higher
- Spring Boot
- [Jackson Databind](https://github.com/FasterXML/jackson) for JSON support
- [Jackson Dataformat XML](https://github.com/FasterXML/jackson-dataformat-xml) for XML support
- [OpenCSV](http://opencsv.sourceforge.net/) for CSV support

 Installation

1. Add the following dependencies to your `pom.xml` file:

   xml
   <dependencies>
       <!-- Jackson for JSON handling -->
       <dependency>
           <groupId>com.fasterxml.jackson.core</groupId>
           <artifactId>jackson-databind</artifactId>
           <version>2.13.4</version>
       </dependency>

       <!-- Jackson Dataformat XML for XML parsing -->
       <dependency>
           <groupId>com.fasterxml.jackson.dataformat</groupId>
           <artifactId>jackson-dataformat-xml</artifactId>
           <version>2.13.4</version>
       </dependency>

       <!-- OpenCSV for CSV handling -->
       <dependency>
           <groupId>com.opencsv</groupId>
           <artifactId>opencsv</artifactId>
           <version>5.5.2</version>
       </dependency>
   </dependencies>
   

2. Clone or download this repository and place the `dataParsingLibrary` package in your project's `src/main/java` directory.

 Usage

The library provides three main parsers for JSON, XML, and CSV. Each parser has methods for importing (reading) and exporting (writing) data.

# JSON Parsing

To parse JSON data, use the `JsonParser` class. It provides methods to convert JSON files to Java objects and vice versa.

java
import dataParsingLibrary.parsers.JsonParser;

// Create an instance of JsonParser
JsonParser<MyData> jsonParser = new JsonParser<>();

// Read from JSON file
MyData data = jsonParser.fromJson(new File("data.json"), MyData.class);

// Write to JSON file
jsonParser.toJson(data, new File("output.json"));


# XML Parsing

To parse XML data, use the `XmlParser` class. This parser converts XML files to Java objects and vice versa.

java
import dataParsingLibrary.parsers.XmlParser;

// Create an instance of XmlParser
XmlParser<MyData> xmlParser = new XmlParser<>();

// Read from XML file
MyData data = xmlParser.fromXml(new File("data.xml"), MyData.class);

// Write to XML file
xmlParser.toXml(data, new File("output.xml"));


# CSV Parsing

To parse CSV data, use the `CsvParser` class. It reads from and writes to CSV files.

java
import dataParsingLibrary.parsers.CsvParser;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;

// Create an instance of CsvParser
CsvParser<MyData> csvParser = new CsvParser<>();

// Read from CSV file
try (FileReader fileReader = new FileReader("data.csv")) {
    List<MyData> dataList = csvParser.fromCsv(fileReader, MyData.class);
}

// Write to CSV file
try (FileWriter fileWriter = new FileWriter("output.csv")) {
    csvParser.toCsv(dataList, fileWriter);
}


 Example

Here's a full example demonstrating JSON, XML, and CSV parsing using a sample data model (`MyData`).

# Step 1: Define a Data Model

Create a data model class that you want to parse. For example, `MyData.java`:

java
package dataParsingLibrary;

import com.opencsv.bean.CsvBindByName;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class MyData {
    @CsvBindByName
    @JacksonXmlProperty
    private String name;

    @CsvBindByName
    @JacksonXmlProperty
    private int age;

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}


# Step 2: Use Parsers

With your model defined, you can now use each parser.

java
package dataParsingLibrary;

import dataParsingLibrary.parsers.JsonParser;
import dataParsingLibrary.parsers.XmlParser;
import dataParsingLibrary.parsers.CsvParser;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class DataParserExample {
    public static void main(String[] args) throws IOException {
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


 License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

---

This `README.md` file reflects the updated package name `dataParsingLibrary`. Adjust any details as needed for your project specifics.
