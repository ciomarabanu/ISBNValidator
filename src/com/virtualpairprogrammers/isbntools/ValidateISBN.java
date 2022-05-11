package com.virtualpairprogrammers.isbntools;

public class ValidateISBN {
    private static final int LONG_ISBN_LENGTH = 13;
    private static final int SHORT_ISBN_LENGTH = 10;

    public boolean checkISBN(String isbn) {

        if (isbn.length() == SHORT_ISBN_LENGTH) {
            return checkValidShortISBN(isbn);
        } else if (isbn.length() == LONG_ISBN_LENGTH) {
            return checkValidLongISBN(isbn);
        } else
            throw new NumberFormatException("ISBN numbers must be 10 or 13 digits long");
    }

    private boolean checkValidShortISBN(String isbn) {
        var total = 0;
        int multiFactor = 10;

        for (int i = 0; i < SHORT_ISBN_LENGTH; i++) {
            if (!Character.isDigit(isbn.charAt(i))) {
                if (i == SHORT_ISBN_LENGTH - 1 && isbn.charAt(i) == 'X') {
                    total += 10;
                } else
                    throw new NumberFormatException("ISBN can only contain numeric digits");
            } else {
                total += Character.getNumericValue(isbn.charAt(i)) * multiFactor;
            }
            multiFactor--;
        }

        return total % 11 == 0;
    }

    private static boolean checkValidLongISBN(String isbn) {
        int total = 0;
        for (int i = 0; i < LONG_ISBN_LENGTH; i++) {
            total += i % 2 == 0 ? Character.getNumericValue(isbn.charAt(i))
                : Character.getNumericValue(isbn.charAt(i)) * 3;
        }

        return total % 10 == 0;
    }

}
