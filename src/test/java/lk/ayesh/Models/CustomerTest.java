package lk.ayesh.Models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
    }

    @Test
    void setCustomerName() {
        customer.setCustomerName("test");
        assertTrue(customer.getCustomerName().equals("test"));
    }

    @Test
    void getEmailAddress() {
        assertTrue(customer.getEmailAddress().equals("asd"));
    }

    @Test
    void setEmailAddress() {
        customer.setEmailAddress("test");
        assertTrue(customer.getEmailAddress().equals("test"));
    }

    @Test
    void getDriversLicenseNumber() {
        assertTrue(customer.getDriversLicenseNumber().equals("123"));
    }

    @Test
    void setDriversLicenseNumber() {
        customer.setDriversLicenseNumber("345");
        assertTrue(customer.getDriversLicenseNumber().equals("345"));
    }

    @Test
    void getUsername() {
        assertTrue(customer.getUsername().equals("qwe"));
    }

    @Test
    void setUsername() {
        customer.setUsername("test");
        assertTrue(customer.getUsername().equals("test"));
    }

    @Test
    void getPassword() {
        assertTrue(customer.getPassword().equals("asd"));
    }

    @Test
    void setPassword() {
        customer.setPassword("test");
        assertTrue(customer.getPassword().equals("test"));
    }
}