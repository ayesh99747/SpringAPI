package lk.ayesh.Models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InputValidatorTest {

    @Test
    void stringWithNumbers() {
        assertTrue(InputValidator.stringWithNumbers("333"));
        assertFalse(InputValidator.stringWithNumbers("asd"));
        assertFalse(InputValidator.stringWithNumbers("."));
        assertFalse(InputValidator.stringWithNumbers(""));
    }

    @Test
    void stringWithLetters() {
        assertTrue(InputValidator.stringWithLetters("asd"));
        assertFalse(InputValidator.stringWithLetters("33"));
        assertFalse(InputValidator.stringWithLetters("."));
        assertFalse(InputValidator.stringWithLetters(""));
    }

    @Test
    void stringWithNumbersAndLetters() {
        assertTrue(InputValidator.stringWithNumbersAndLetters("asd"));
        assertTrue(InputValidator.stringWithNumbersAndLetters("33"));
        assertTrue(InputValidator.stringWithNumbersAndLetters("asd33"));
        assertFalse(InputValidator.stringWithNumbersAndLetters("."));
        assertFalse(InputValidator.stringWithNumbersAndLetters(""));
    }

    @Test
    void plateNumbers() {
        assertTrue(InputValidator.plateNumbers("asd"));
        assertTrue(InputValidator.plateNumbers("33"));
        assertTrue(InputValidator.plateNumbers("asd33"));
        assertTrue(InputValidator.plateNumbers("asd-33"));
        assertFalse(InputValidator.plateNumbers("."));
        assertFalse(InputValidator.plateNumbers(""));
    }

    @Test
    void integers() {
        assertTrue(InputValidator.integers(33));
        assertTrue(InputValidator.integers(1));
        assertFalse(InputValidator.integers(0));
        assertFalse(InputValidator.integers(-1));
    }

    @Test
    void bigDecimals() {
        assertTrue(InputValidator.bigDecimals(33.0));
        assertTrue(InputValidator.bigDecimals(1.0));
        assertFalse(InputValidator.bigDecimals(0));
    }

    @Test
    void emailAddress() {
        assertTrue(InputValidator.emailAddress("asd"));
        assertTrue(InputValidator.emailAddress("33"));
        assertTrue(InputValidator.emailAddress("asd33"));
        assertTrue(InputValidator.emailAddress("asd@33"));
        assertTrue(InputValidator.emailAddress("asd@gmail.com"));
        assertTrue(InputValidator.emailAddress("."));
        assertFalse(InputValidator.emailAddress("-"));
        assertFalse(InputValidator.emailAddress(""));
    }

    @Test
    void passwords() {
        assertTrue(InputValidator.passwords("asd"));
        assertTrue(InputValidator.passwords("33"));
        assertTrue(InputValidator.passwords("asd33"));
        assertTrue(InputValidator.passwords("."));
        assertFalse(InputValidator.passwords(""));
    }
}