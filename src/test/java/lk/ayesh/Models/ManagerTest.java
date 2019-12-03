package lk.ayesh.Models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
/**
 * This class is the Test class for the Manager class
 * This test class tests all the getter and setter methods
 *
 * @author Ayeshmantha Wijayagunathilaka (ID: 2018072)
 */
class ManagerTest {

    private Manager manager;

    //This is executed before each test and a manager object is initialised
    @BeforeEach
    void initEach() {
        manager = new Manager("test", "test", "test");
    }

    //This tests the get employee id method
    @Test
    void getEmployeeID() {
        assertTrue(manager.getEmployeeID().equals("test"));
        assertFalse(manager.getEmployeeID().equals("test1"));
    }

    //This tests the set employee id method
    @Test
    void setEmployeeID() {
        //An employee id can contain letters and numbers
        manager.setEmployeeID("test");
        assertTrue(manager.getEmployeeID().equals("test"));
        assertFalse(manager.getEmployeeID().equals("test1"));
        manager.setEmployeeID("test12");
        assertTrue(manager.getEmployeeID().equals("test12"));
        assertFalse(manager.getEmployeeID().equals("test"));
        manager.setEmployeeID("123");
        assertTrue(manager.getEmployeeID().equals("123"));
        assertFalse(manager.getEmployeeID().equals("test"));
        //An employeeID cannot be null
        manager.setEmployeeID("");
        assertTrue(manager.getEmployeeID().equals("123"));
        assertFalse(manager.getEmployeeID().equals(""));
    }

    //This tests the get username method
    @Test
    void getUsername() {
        assertTrue(manager.getUsername().equals("test"));
        assertFalse(manager.getUsername().equals("test1"));
    }

    //This tests the set username method
    @Test
    void setUsername() {
        //A username can contain letters and numbers
        manager.setUsername("test1");
        assertTrue(manager.getUsername().equals("test1"));
        assertFalse(manager.getUsername().equals("test"));
        manager.setUsername("123");
        assertTrue(manager.getUsername().equals("123"));
        assertFalse(manager.getUsername().equals("test"));
        //A username cannot be empty
        manager.setUsername("");
        assertTrue(manager.getUsername().equals("123"));
        assertFalse(manager.getUsername().equals(""));
    }

    //This tests the get password method
    @Test
    void getPassword() {
        assertTrue(manager.getPassword().equals("test"));
        assertFalse(manager.getPassword().equals("test1"));
    }

    //This tests the set password method
    @Test
    void setPassword() {
        //A password can contain letters and numbers
        manager.setPassword("test1");
        assertTrue(manager.getPassword().equals("test1"));
        assertFalse(manager.getPassword().equals("test"));
        //A password cannot be null
        manager.setPassword("");
        assertTrue(manager.getPassword().equals("test1"));
        assertFalse(manager.getPassword().equals(""));
    }
}