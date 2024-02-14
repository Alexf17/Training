package org.example.TESTING._2024_02_08_morning.dummy;

import java.util.ArrayList;
import java.util.List;

public class AddressBook {
    public List<Customer> customers = new ArrayList<Customer>();

    public void addCustomer(Customer customer) {
        if (customer == null) throw new NullPointerException();
        customers.add(customer);
    }

    public int getNumbersOfCustomers() {
        return customers.size();
    }
}

