package com.virtualpairprogrammers.isbntools;

import org.junit.Test;
import static org.junit.Assert.*;

public class CheckValidISBN {

    @Test
    public void checkValidISBN() {
        ValidateISBN validator = new ValidateISBN();
        boolean result = validator.checkISBN("0140449116");
        assertTrue("first value", result);
        result = validator.checkISBN("1250823943");
        assertTrue("second value", result);

    }

    @Test (expected = NumberFormatException.class)
    public void isbnNumEndingInXAreValid() {
        ValidateISBN validator = new ValidateISBN();
        validator.checkISBN("012000b30X");
        boolean result = validator.checkISBN("012000030X");
        assertTrue(result);

    }

    @Test
    public void checkInvalidISBN() {
        ValidateISBN validator = new ValidateISBN();
        boolean result = validator.checkISBN("0140449117");
        assertFalse(result);

    }

    @Test (expected = NumberFormatException.class)
    public void nineDigitsISBNNotAllowed() {
        ValidateISBN validator = new ValidateISBN();
        validator.checkISBN("123456789");

    }

    @Test (expected = NumberFormatException.class)
    public void onlyDigitsAllowed() {
        ValidateISBN validator = new ValidateISBN();
        validator.checkISBN("helloworld");
    }

    @Test
    public void checkAValid13DigitISBN() {
        ValidateISBN validator = new ValidateISBN();
        boolean result = validator.checkISBN("9780120000302");
        assertTrue(result);
    }


}
