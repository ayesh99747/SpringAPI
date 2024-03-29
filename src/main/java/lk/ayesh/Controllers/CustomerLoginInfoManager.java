package lk.ayesh.Controllers;

import lk.ayesh.Models.Customer;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is the customer login info manager
 *
 * @author Ayeshmantha Wijayagunathilaka (ID: 2018072)
 */

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

}
