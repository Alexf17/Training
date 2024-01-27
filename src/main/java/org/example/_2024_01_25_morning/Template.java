package org.example._2024_01_25_morning;

import lombok.Getter;

import java.io.*;

@Getter
public class Template implements Serializable {
    private final String param1 = "QWE";
    private final int param2 = 55;
    private  transient float param3 = 1.0f;


    @Override
    public String toString() {
        return "Template{" +
                "param1='" + param1 + '\'' +
                ", param2=" + param2 +
                ", param3=" + param3 +
                '}';
    }

    public static void main(String[] args) {
        Template template = new Template();
        System.out.println("***Before serializing***");
        System.out.println("P1: " + template.param1);
        System.out.println("P2: " + template.param2);
        System.out.println("P3: " + template.param3);

        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("temp.ser"))) {
            outputStream.writeObject(template);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class Secondary {
    public static void main(String[] args) {
        Template template;
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("temp.ser"))) {
            template = (Template) inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println("***After serializing***");
        System.out.println("P1: " + template.getParam1());
        System.out.println("P2: " + template.getParam2());
        System.out.println("P3: " + template.getParam3());
    }
}
