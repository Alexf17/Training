package org.example._2024_02_06;

import org.example._2024_02_01.Person;
import org.example._2024_02_06.Pojo.Client;
import org.example._2024_02_06.Pojo.Manager;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("client.dat");
        try (ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(path))) {
            Client client =
                    new Client(1, "Hanna", "Chili", "45 asdr", "45sdas", "asd@fdsf.com",
                            "7956456456456", StatusManager.WORK, LocalDate.now(), LocalDate.now(),
                            new Manager(1, "Olga", "Pouuhgiu", StatusManager.WORK, LocalDate.now(), LocalDate.now()));
            oos.writeObject(client);
        }
        try (ObjectInputStream ois = new ObjectInputStream(
                Files.newInputStream(path))) {
            Person read = (Person) ois.readObject();
            System.out.printf("Read person: %s", read);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
