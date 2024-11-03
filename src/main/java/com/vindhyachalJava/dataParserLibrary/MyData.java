package com.vindhyachalJava.dataParserLibrary;
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

