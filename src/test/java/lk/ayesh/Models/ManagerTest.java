package lk.ayesh.Models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ManagerTest {

    private Manager manager;

    @BeforeEach
    void initEach() {
        manager = new Manager("def", "asd", "asd");
    }

    @Test
    void getEmployeeID() {
        assertTrue(manager.getEmployeeID().equals("def"));
    }

    @Test
    void setEmployeeID() {
        manager.setEmployeeID("test");
        assertTrue(manager.getEmployeeID().equals("test"));
    }

    @Test
    void getUsername() {
        assertTrue(manager.getUsername().equals("asd"));
    }

    @Test
    void setUsername() {
        manager.setUsername("test");
        assertTrue(manager.getUsername().equals("test"));
    }

    @Test
    void getPassword() {
        assertTrue(manager.getPassword().equals("asd"));
    }

    @Test
    void setPassword() {
        manager.setPassword("test");
        assertTrue(manager.getPassword().equals("test"));
    }
}