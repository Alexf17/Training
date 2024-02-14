package org.example.TESTING.dryKissYagni;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class Employee {
    private String firstName;
    private String lastName;
    
    public String getFullName() {
        return firstName + " " + lastName;
    }
    
    public String getInitials() {
        return firstName.charAt(0) + "." + lastName.charAt(0) + ".";
    }
    
    // Дублирование кода формирования email
    public String getEmail() {
        return firstName.toLowerCase() + "." + lastName.toLowerCase() + "@company.com";
    }
}
@Setter
@Getter
@AllArgsConstructor

class EmployeeI {
    private String firstName;
    private String lastName;

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public String getInitials() {
        return firstName.charAt(0) + "." + lastName.charAt(0) + ".";
    }

    // Дублирование кода формирования email
    public String getEmail() {
        return getFullName().replaceAll(" ",".").toLowerCase()  + "@company.com";
    }
}
class EmployeeITest{

    EmployeeI employee = new EmployeeI("John","Doe");
    String firstName = employee.getFirstName();
    String lastName = employee.getLastName();


    @Test
    void getFullNameTest() {
        Assertions.assertEquals(firstName + " " + lastName, employee.getFullName());
    }
    @Test
    void getInitialsTest() {
        Assertions.assertEquals(firstName.charAt(0) + "." + lastName.charAt(0) + ".", employee.getInitials());
    }
    @Test
    void getEmailTest() {
        Assertions.assertEquals(employee.getFullName().replaceAll(" ",".").toLowerCase() + "@company.com", employee.getEmail());
    }
}