package lk.ayesh.Models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
/**
 * This class is the Test class for the InputValidator class
 * This test class tests all validation methods
 *
 * @author Ayeshmantha Wijayagunathilaka (ID: 2018072)
 */
class InputValidatorTest {

    //This tests strings with numbers only
    @Test
    void stringWithNumbers() {
        assertTrue(InputValidator.stringWithNumbers("333"));
        assertFalse(InputValidator.stringWithNumbers("asd"));
        assertFalse(InputValidator.stringWithNumbers("."));
        assertFalse(InputValidator.stringWithNumbers(""));
    }

    //This tests strings with letters only
    @Test
    void stringWithLetters() {
        assertTrue(InputValidator.stringWithLetters("asd"));
        assertFalse(InputValidator.stringWithLetters("33"));
        assertFalse(InputValidator.stringWithLetters("."));
        assertFalse(InputValidator.stringWithLetters(""));
    }

    //This tests strings with numbers and letters only
    @Test
    void stringWithNumbersAndLetters() {
        assertTrue(InputValidator.stringWithNumbersAndLetters("asd"));
        assertTrue(InputValidator.stringWithNumbersAndLetters("33"));
        assertTrue(InputValidator.stringWithNumbersAndLetters("asd33"));
        assertFalse(InputValidator.stringWithNumbersAndLetters("."));
        assertFalse(InputValidator.stringWithNumbersAndLetters(""));
    }

    /*This tests plate numbers only
    * plate numbers can contain letters, numbers and '-' only*/
    @Test
    void plateNumbers() {
        assertTrue(InputValidator.plateNumbers("asd"));
        assertTrue(InputValidator.plateNumbers("33"));
        assertTrue(InputValidator.plateNumbers("asd33"));
        assertTrue(InputValidator.plateNumbers("asd-33"));
        assertFalse(InputValidator.plateNumbers("."));
        assertFalse(InputValidator.plateNumbers(""));
    }

    /*This tests integers only
    * Integers are numbers with a value greater than 0*/
    @Test
    void integers() {
        assertTrue(InputValidator.integers(33));
        assertTrue(InputValidator.integers(1));
        assertFalse(InputValidator.integers(0));
        assertFalse(InputValidator.integers(-1));
    }

    /*This test big decimals only
    * big decimals are big decimal objects with a value greater than 0*/
    @Test
    void bigDecimals() {
        assertTrue(InputValidator.bigDecimals(33.0));
        assertTrue(InputValidator.bigDecimals(1.0));
        assertFalse(InputValidator.bigDecimals(0));
    }

    /*This tests email addresses only
    * email addresses can contain numbers,letter,'@','_' and '.' only*/
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

    /*This tests passwords only
    * Passwords contain any character but must not be null*/
    @Test
    void passwords() {
        assertTrue(InputValidator.passwords("asd"));
        assertTrue(InputValidator.passwords("33"));
        assertTrue(InputValidator.passwords("asd33"));
        assertTrue(InputValidator.passwords("."));
        assertFalse(InputValidator.passwords(""));
    }
}