package lk.ayesh.Models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.MathContext;

import static org.junit.jupiter.api.Assertions.assertTrue;

class LoginInfoTest {

    private LoginInfo loginInfo;

    @BeforeEach
    void initEach() {
        MathContext mc = new MathContext(2);
        loginInfo = new LoginInfo("def", "asd");
    }

    @Test
    void getUsername() {
        assertTrue(loginInfo.getUsername().equals("def"));
    }

    @Test
    void setUsername() {
        loginInfo.setUsername("test");
        assertTrue(loginInfo.getUsername().equals("test"));
    }

    @Test
    void getPassword() {
        assertTrue(loginInfo.getPassword().equals("asd"));
    }

    @Test
    void setPassword() {
        loginInfo.setPassword("test");
        assertTrue(loginInfo.getPassword().equals("test"));
    }
}