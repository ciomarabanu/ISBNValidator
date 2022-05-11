package com.virtualpairprogrammers.isbntools;

import java.util.regex.Pattern;

public class ValidateISBN {
    public boolean checkISBN (String isbn) {
        if (isbn.length() != 10){
            throw new NumberFormatException("ISBN numbers must be 10 digits long");
        }
        
        var result = 0;
        int multiFactor = 10;

        for (int i = 0; i < isbn.length(); i++) {
            if (!Character.isDigit(isbn.charAt(i)))
                throw new NumberFormatException("ISBN can only contain numeric digits");
            result += Character.getNumericValue(isbn.charAt(i)) * multiFactor;
            multiFactor--;
        }
        return result % 11 == 0;
    }
}
