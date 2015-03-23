package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

public class LibraryTest {
    @Test
    public void testBookCanBeCheckOutfromLibrary() throws Exception {
        Library library = new Library();
        Book ramayan = new Book("Ramayana", "Valmiki", 2001);
        boolean checkedOut = library.checkOut("Ramayana");
        assertFalse(library.getBookList().contains(ramayan));
        assertTrue(checkedOut);
    }
    @Test
    public void testCheckdeoutBooksAreListedInCheckOutList() throws Exception {
        Library library = new Library();
        Book ramayan = new Book("Ramayana", "Valmiki", 2001);
        boolean checkedOut = library.checkOut("Ramayana");
        assertTrue(library.isCheckedOut("Ramayana"));
        assertTrue(checkedOut);
    }
    @Test
    public void testIsCheckedOutShouldRetunFalseIfBookHasNotCheckedOut() throws Exception {
        Library library = new Library();
        assertFalse(library.isCheckedOut("Ramayana"));
    }

    @Test
    public void testCheckoutUnSuccessIfBookIsNotAvailable() throws Exception {
        Library library = new Library();
        assertFalse(library.checkOut("mahabharta"));
    }

    @Test
    public void testCheckInShouldReturnTrueForReturningValidBook() throws Exception {
        Library library = new Library();
        library.checkOut("Ramayana");
        assertTrue(library.checkIn("Ramayana"));
    }

    @Test
    public void testCheckInShouldReturnFalseForReturningInvalidBook() throws Exception {
        Library library = new Library();
        assertFalse(library.checkIn("Ramayana"));
    }
}