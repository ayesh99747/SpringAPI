package lk.ayesh.Models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ManagerTest {

    private Manager manager;

    @BeforeEach
    void initEach() {
        manager = new Manager("asd", "asd", "asd");
    }

    @Test
    void getEmployeeID() {
        assertTrue(manager.getEmployeeID().equals("asd"));
        assertFalse(manager.getEmployeeID().equals("qwe"));
    }

    @Test
    void setEmployeeID() {
        manager.setEmployeeID("test");
        assertTrue(manager.getEmployeeID().equals("test"));
        assertFalse(manager.getEmployeeID().equals("asd"));
    }

    @Test
    void getUsername() {
        assertTrue(manager.getUsername().equals("asd"));
        assertFalse(manager.getUsername().equals("qwe"));
    }

    @Test
    void setUsername() {
        manager.setUsername("test");
        assertTrue(manager.getUsername().equals("test"));
        assertFalse(manager.getUsername().equals("qwe"));
    }

    @Test
    void getPassword() {
        assertTrue(manager.getPassword().equals("asd"));
        assertFalse(manager.getPassword().equals("qwe"));
    }

    @Test
    void setPassword() {
        manager.setPassword("test");
        assertTrue(manager.getPassword().equals("test"));
        assertFalse(manager.getPassword().equals("asd"));
    }
}