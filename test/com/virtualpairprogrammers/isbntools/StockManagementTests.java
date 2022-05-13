package com.virtualpairprogrammers.isbntools;
import static org.junit.Assert.*;
import org.junit.Test;

public class StockManagementTests {

    @Test
    public void canGetACorrectLocatorCode() {
        ExternalISBNDataService serviceTest = new ExternalISBNDataService() {
            @Override
            public Book lookup(String isbn) {
                return new Book(isbn, "Of Mice And Men", "J. Steinberg");
            }
        };

        StockManager stockManager = new StockManager();
        stockManager.setService(serviceTest);
        String isbn = "0140177396";
        String locatorCode = stockManager.getLocatorCode(isbn);
        assertEquals("7396J4", locatorCode);
    }

}
