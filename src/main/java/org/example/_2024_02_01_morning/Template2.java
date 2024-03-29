package org.example._2024_02_01_morning;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Template2 {
    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
        UniversityContainer universityContainer
                = objectMapper.readValue(new FileReader("1.yaml"), UniversityContainer.class);
        System.out.println(universityContainer.getUniversity());
    }
}
