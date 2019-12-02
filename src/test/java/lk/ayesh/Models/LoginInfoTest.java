package lk.ayesh.Models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.MathContext;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LoginInfoTest {

    private LoginInfo loginInfo;

    @BeforeEach
    void initEach() {
        loginInfo = new LoginInfo("def", "asd");
    }

    @Test
    void getUsername() {
        assertTrue(loginInfo.getUsername().equals("def"));
        assertFalse(loginInfo.getUsername().equals("asd"));
    }

    @Test
    void setUsername() {
        loginInfo.setUsername("test");
        assertTrue(loginInfo.getUsername().equals("test"));
        assertFalse(loginInfo.getUsername().equals("asd"));
    }

    @Test
    void getPassword() {
        assertTrue(loginInfo.getPassword().equals("asd"));
        assertFalse(loginInfo.getPassword().equals("qwe"));
    }

    @Test
    void setPassword() {
        loginInfo.setPassword("test");
        assertTrue(loginInfo.getPassword().equals("test"));
        assertFalse(loginInfo.getPassword().equals("asd"));
    }
}