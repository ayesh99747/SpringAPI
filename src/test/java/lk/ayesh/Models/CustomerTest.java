package lk.ayesh.Models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
/**
 * This class is the Test class for the Customer class
 * This test class tests all the getter and setter methods
 *
 * @author Ayeshmantha Wijayagunathilaka (ID: 2018072)
 */
class CustomerTest {
    private Customer customer;

    //This is run before each test and it initialises a new customer object
    @BeforeEach
    void initEach() {
        customer = new Customer("test", "test", "123", "test", "test");
    }

    //This tests the get customer name
    @Test
    void getCustomerName() {
        assertTrue(customer.getCustomerName().equals("test"));
        assertFalse(customer.getCustomerName().equals("test1"));
    }

    //This tests the set customer name
    @Test
    void setCustomerName() {
        customer.setCustomerName("test");
        assertTrue(customer.getCustomerName().equals("test"));
        assertFalse(customer.getCustomerName().equals("test1"));
        //The customer name can be only letters
        customer.setCustomerName("test1");
        assertTrue(customer.getCustomerName().equals("test"));
        assertFalse(customer.getCustomerName().equals("test1"));
        //The customer name cannot be empty
        customer.setCustomerName("");
        assertTrue(customer.getCustomerName().equals("test"));
        assertFalse(customer.getCustomerName().equals(""));
    }

    //This tests the get email address
    @Test
    void getEmailAddress() {
        assertTrue(customer.getEmailAddress().equals("test"));
        assertFalse(customer.getEmailAddress().equals("test1"));
    }

    //This tests the set email address
    @Test
    void setEmailAddress() {
        //The email address can contain letters, numbers '@', '.' and '_' only
        customer.setEmailAddress("test1");
        assertTrue(customer.getEmailAddress().equals("test1"));
        assertFalse(customer.getEmailAddress().equals("test"));
        customer.setEmailAddress("test1@gmail.com");
        assertTrue(customer.getEmailAddress().equals("test1@gmail.com"));
        assertFalse(customer.getEmailAddress().equals("test"));
        //An email address cannot be empty
        customer.setEmailAddress("");
        assertTrue(customer.getEmailAddress().equals("test1@gmail.com"));
        assertFalse(customer.getEmailAddress().equals(""));
    }

    //This tests the get drivers license
    @Test
    void getDriversLicenseNumber() {
        assertTrue(customer.getDriversLicenseNumber().equals("123"));
        assertFalse(customer.getDriversLicenseNumber().equals("543"));
        assertFalse(customer.getDriversLicenseNumber().equals("asd"));
    }

    //This tests the set drivers license
    @Test
    void setDriversLicenseNumber() {
        //Drivers license can only contain numbers
        customer.setDriversLicenseNumber("345");
        assertTrue(customer.getDriversLicenseNumber().equals("345"));
        assertFalse(customer.getDriversLicenseNumber().equals("654"));
        assertFalse(customer.getDriversLicenseNumber().equals("asd"));
        /*The drivers license wont be changed since it is invalid and
         hence the previous value is still the drivers license*/
        customer.setDriversLicenseNumber("asd");
        assertFalse(customer.getDriversLicenseNumber().equals("asd"));
        assertTrue(customer.getDriversLicenseNumber().equals("345"));
        //Drivers license cannot be empty
        customer.setDriversLicenseNumber("");
        assertFalse(customer.getDriversLicenseNumber().equals(""));
        assertTrue(customer.getDriversLicenseNumber().equals("345"));
    }

    //This tests the get username
    @Test
    void getUsername() {
        assertTrue(customer.getUsername().equals("test"));
        assertFalse(customer.getUsername().equals("test1"));
    }

    //This tests the set username
    @Test
    void setUsername() {
        //A username can contain letters and numbers
        customer.setUsername("test");
        assertTrue(customer.getUsername().equals("test"));
        assertFalse(customer.getUsername().equals("asd"));
        customer.setUsername("test1");
        assertTrue(customer.getUsername().equals("test1"));
        assertFalse(customer.getUsername().equals("test"));
        customer.setUsername("123");
        assertTrue(customer.getUsername().equals("123"));
        assertFalse(customer.getUsername().equals("test"));
        //A username cannot contain symbols
        customer.setUsername(".");
        assertTrue(customer.getUsername().equals("123"));
        assertFalse(customer.getUsername().equals("."));
        //A username cannot be empty
        customer.setUsername("");
        assertTrue(customer.getUsername().equals("123"));
        assertFalse(customer.getUsername().equals(""));
    }

    //This tests the get password
    @Test
    void getPassword() {
        assertTrue(customer.getPassword().equals("test"));
        assertFalse(customer.getPassword().equals("test1"));
    }

    //This tests the set password
    @Test
    void setPassword() {
        //A password can contain any symbols and letters and numbers
        customer.setPassword("test.123");
        assertTrue(customer.getPassword().equals("test.123"));
        assertFalse(customer.getPassword().equals("test"));
        customer.setPassword("test");
        assertTrue(customer.getPassword().equals("test"));
        assertFalse(customer.getPassword().equals("test1"));
        customer.setPassword("test1");
        assertTrue(customer.getPassword().equals("test1"));
        assertFalse(customer.getPassword().equals("test"));
        //This happens because the password cant be null
        customer.setPassword("");
        assertTrue(customer.getPassword().equals("test1"));
        assertFalse(customer.getPassword().equals(""));
    }
}