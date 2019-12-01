package lk.ayesh.Controllers;

import lk.ayesh.Models.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerLoginInfoManager {
    private static List<Customer> listOfCustomers = new ArrayList<Customer>();

    public static List<Customer> getListOfCustomers() {
        return listOfCustomers;
    }

    public static void addCustomerFromDatabase(List<Customer> listOfCustomersFromDb) {
        listOfCustomers.clear();
        System.out.println("Customers added to List: ");
        for (Customer c : listOfCustomersFromDb) {
            listOfCustomers.add(c);
            System.out.println(c);
        }
    }

    public static String getCustomerEmail(String username) {
        String emailAddress = null;
        for (Customer c : listOfCustomers) {
            if (username.equals(c.getUsername())) {
                emailAddress = c.getEmailAddress();
            }
        }
        return emailAddress;
    }
}
