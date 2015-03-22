package com.twu.biblioteca;


import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BibliotecaTest {

    @Test
    public void testToShowAvailableBooks() {
        List<Book> expected =new ArrayList<Book>();
        expected.add(new Book("The Adventures Of Sherlock Hollks ","sir Arthur Conan",2001));
        expected.add(new Book("Wings Of Fire ","A.P.J Abdul Kalam",2003));
        expected.add(new Book("Ramayna","Maharishi Valmiki",2004));
        expected.add(new Book("Five Point Someone","Chetan Bhagat",2004));
        Biblioteca b =new Biblioteca();
        List<Book> books = b.getAvailableBooks();
        assertTrue(expected.containsAll(books));
        assertTrue(books.containsAll(expected));
    }

    @Test
    public void getMenuegivesAllMenueList()  {
        Biblioteca b =new Biblioteca();
        List<String> menues = b.getMenues();
        assertTrue(menues.get(0).equals("Book List"));
        assertTrue(menues.get(1).equals("Quit"));
        assertTrue(menues.size()==2);
    }

    @Test
    public void testIsValidOptionShouldGiveTrue() {
        Biblioteca b = new Biblioteca();
        assertTrue(b.isValidOption("Book List"));
        assertFalse(b.isValidOption("Book"));
    }
}
