package lk.ayesh.Models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.MathContext;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
/**
 * This class is the Test class for the LoginInfo class
 * This test class tests all the getter and setter methods
 *
 * @author Ayeshmantha Wijayagunathilaka (ID: 2018072)
 */
class LoginInfoTest {

    private LoginInfo loginInfo;

    //This is executed before every test and a login info object is created
    @BeforeEach
    void initEach() {
        loginInfo = new LoginInfo("test", "test");
    }

    //This tests the get username method
    @Test
    void getUsername() {
        assertTrue(loginInfo.getUsername().equals("test"));
        assertFalse(loginInfo.getUsername().equals("test1"));
    }

    //This tests the set username method
    @Test
    void setUsername() {
        //A username can contain letters and numbers
        loginInfo.setUsername("test");
        assertTrue(loginInfo.getUsername().equals("test"));
        assertFalse(loginInfo.getUsername().equals("test1"));
        loginInfo.setUsername("123");
        assertTrue(loginInfo.getUsername().equals("123"));
        assertFalse(loginInfo.getUsername().equals("test"));
        //A username cannot be empty
        loginInfo.setUsername("");
        assertTrue(loginInfo.getUsername().equals("123"));
        assertFalse(loginInfo.getUsername().equals(""));
    }

    //This tests the get password method
    @Test
    void getPassword() {
        assertTrue(loginInfo.getPassword().equals("test"));
        assertFalse(loginInfo.getPassword().equals("test1"));
    }

    //This tests the set password method
    @Test
    void setPassword() {
        //A password can contain any character
        loginInfo.setPassword("test1");
        assertTrue(loginInfo.getPassword().equals("test1"));
        assertFalse(loginInfo.getPassword().equals("test"));
        loginInfo.setPassword("123");
        assertTrue(loginInfo.getPassword().equals("123"));
        assertFalse(loginInfo.getPassword().equals("test"));
        //A password cannot be null
        loginInfo.setPassword("");
        assertTrue(loginInfo.getPassword().equals("123"));
        assertFalse(loginInfo.getPassword().equals(""));
    }
}