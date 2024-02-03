package org.example._2024_02_01_morning;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.FileWriter;
import java.io.IOException;

public class Template {
    private String name;
    private int age;

    public Template(String name, int age) {
        this.name = name;
        this.age = age;
    }

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

    public static void main(String[] args) throws IOException {
        Template template = new Template("Hanna", 25);
        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
        FileWriter writer = new FileWriter("out.yaml");
        objectMapper.writeValue(writer,template);
        writer.close();
    }
}
