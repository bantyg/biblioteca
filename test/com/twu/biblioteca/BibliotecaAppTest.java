package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BibliotecaAppTest {
    List<Item> expectedBookList = new ArrayList<Item>();

    @Before
    public void setUp() throws Exception {
        expectedBookList.add(new Book("The Adventures of Sherlock Holmes","Arthur Conan Doyle",1987));
        expectedBookList.add(new Book("Wings of Fire","A. P. J. Abdul Kalam",2004));
        expectedBookList.add(new Book("Ramayana", "Valmiki",2001));
        expectedBookList.add(new Book("Five Point Someone", "Chetan Bhagat",2010));
    }
//    @Test
//    public void test_library_should_have_list_of_all_4_books() {
//        Library library = Library.initLibrary(LibraryMode.BOOK);
//        List<Item> bookList = library.getBookList();
//        assertEquals(bookList.size(),4);
//    }

//    @Test
//    public void test_library_should_have_name_of_all_4_books() {
//        Library library = Library.initLibrary(LibraryMode.BOOK);
//        List<Item> bookList = library.getBookList();
//
//        assertTrue(bookList.equals(expectedBookList));
//    }

    @Test
    public void test_BibliotecaApp_should_display_welcome_message() {
        BibliotecaApp bibliotecaApp = new BibliotecaApp(LibraryMode.BOOK);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        bibliotecaApp.printWelcomeMessage(printStream);
        String expected = "Welcome to Biblioteca." + System.lineSeparator();
        assertEquals(expected, byteArrayOutputStream.toString());
    }
    @Test
    public void test_Bibleotica_App_displays_list_of_Books_with_details() {
        String expected = "Title - Author - year of publication\n-------------------------------------------\n"+
            "The Adventures of Sherlock Holmes-Arthur Conan Doyle-1987\n"+
            "Wings of Fire-A. P. J. Abdul Kalam-2004\n"+
            "Ramayana-Valmiki-2001\n"+
            "Five Point Someone-Chetan Bhagat-2010\n";
        assertTrue(Library.initLibrary(LibraryMode.BOOK).toString().equals(expected));
    }
}
