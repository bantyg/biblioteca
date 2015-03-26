package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

public class LibraryTest {
    @Test
    public void testBookCanBeCheckOutfromLibrary() throws Exception {
        Library library = Library.initLibrary(LibraryMode.BOOK);
        Item ramayan = new Book("Ramayana", "Valmiki", 2001);
        boolean checkedOut = library.checkOut("Ramayana");
        assertTrue(checkedOut);
    }
    @Test
    public void testCheckoutUnSuccessIfBookIsNotAvailable() throws Exception {
       Library library = Library.initLibrary(LibraryMode.BOOK);
        assertFalse(library.checkOut("mahabharta"));
    }

    @Test
    public void testCheckInShouldReturnTrueForReturningValidBook() throws Exception {
        Library library = Library.initLibrary(LibraryMode.BOOK);
        library.checkOut("Ramayana");
        assertTrue(library.checkIn("Ramayana"));
    }

    @Test
    public void testCheckInShouldReturnFalseForReturningInvalidBook() throws Exception {
        Library library = Library.initLibrary(LibraryMode.BOOK);
        assertFalse(library.checkIn("Ramayana"));
    }
}