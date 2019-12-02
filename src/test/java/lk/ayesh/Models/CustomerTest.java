package lk.ayesh.Models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CustomerTest {
    private Customer customer;

    @BeforeEach
    void initEach() {
        customer = new Customer("def", "asd", "123", "qwe", "asd");
    }

    @Test
    void getCustomerName() {
        assertTrue(customer.getCustomerName().equals("def"));
        assertFalse(customer.getCustomerName().equals("asd"));
    }

    @Test
    void setCustomerName() {
        customer.setCustomerName("test");
        assertTrue(customer.getCustomerName().equals("test"));
        assertFalse(customer.getCustomerName().equals("asd"));
    }

    @Test
    void getEmailAddress() {
        assertTrue(customer.getEmailAddress().equals("asd"));
        assertFalse(customer.getEmailAddress().equals("qwe"));
    }

    @Test
    void setEmailAddress() {
        customer.setEmailAddress("test");
        assertTrue(customer.getEmailAddress().equals("test"));
        assertFalse(customer.getEmailAddress().equals("asd"));
    }

    @Test
    void getDriversLicenseNumber() {
        assertTrue(customer.getDriversLicenseNumber().equals("123"));
        assertFalse(customer.getDriversLicenseNumber().equals("543"));
        assertFalse(customer.getDriversLicenseNumber().equals("asd"));
    }

    @Test
    void setDriversLicenseNumber() {
        customer.setDriversLicenseNumber("345");
        assertTrue(customer.getDriversLicenseNumber().equals("345"));
        assertFalse(customer.getDriversLicenseNumber().equals("654"));
        assertFalse(customer.getDriversLicenseNumber().equals("asd"));
        /*The drivers license wont be changed since it is invalid and
         hence the previous value is still the drivers license*/
        customer.setDriversLicenseNumber("asd");
        assertFalse(customer.getDriversLicenseNumber().equals("asd"));
        assertTrue(customer.getDriversLicenseNumber().equals("345"));
    }

    @Test
    void getUsername() {
        assertTrue(customer.getUsername().equals("qwe"));
        assertFalse(customer.getUsername().equals("asd"));
    }

    @Test
    void setUsername() {
        customer.setUsername("test");
        assertTrue(customer.getUsername().equals("test"));
        assertFalse(customer.getUsername().equals("asd"));
    }

    @Test
    void getPassword() {
        assertTrue(customer.getPassword().equals("asd"));
        assertFalse(customer.getPassword().equals("qwe"));
    }

    @Test
    void setPassword() {
        customer.setPassword("test");
        assertTrue(customer.getPassword().equals("test"));
        assertFalse(customer.getPassword().equals("asd"));
    }
}