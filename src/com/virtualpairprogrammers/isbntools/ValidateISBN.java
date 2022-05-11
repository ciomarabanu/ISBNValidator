package com.virtualpairprogrammers.isbntools;

import java.util.regex.Pattern;

public class ValidateISBN {
    public boolean checkISBN (String isbn) {

        var validLength = 10;

        if (isbn.length() == 13) {
            return true;
        }

        if (isbn.length() != validLength){
            throw new NumberFormatException("ISBN numbers must be 10 digits long");
        }

        var total = 0;
        int multiFactor = 10;

        for (int i = 0; i < validLength; i++) {
            if (!Character.isDigit(isbn.charAt(i))){
                if (i == 9 && isbn.charAt(i) == 'X') {
                    total += 10;
                } else
                throw new NumberFormatException("ISBN can only contain numeric digits");
            }
            else {
                total += Character.getNumericValue(isbn.charAt(i)) * multiFactor;
            }

            multiFactor--;
        }

        return total % 11 == 0;
    }
}
