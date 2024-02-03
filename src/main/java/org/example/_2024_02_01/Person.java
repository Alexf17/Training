package org.example._2024_02_01;

public class Person {
    private String firstName;
    private String lastName;
    private Adress address;

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address=" + address +
                '}';
    }

    public Person(String firstName, String lastName, Adress address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }

}
