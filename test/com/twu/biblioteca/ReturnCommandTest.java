package com.twu.biblioteca;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class ReturnCommandTest {
    @Test
    public void testReturnCommandShouldGiveSuccessMessageWhenBookIsSuccessfullyReturned() throws Exception {
        Library library = new Library();
        library.checkOut("Ramayana");
        InputStream in = new ByteArrayInputStream("Ramayana".getBytes());
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(os);
        new ReturnCommand(library,in,ps).execute();
        assertEquals(Book.REQUEST_MESSAGE+Library.CHECK_IN_SUCCESS+System.lineSeparator(),os.toString());
    }

    @Test
    public void testReturnCommandShouldGiveSuccessMessageWhenBookIsUnSuccessfullyReturned() throws Exception {
        InputStream in = new ByteArrayInputStream("Ramayana".getBytes());
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(os);
        new ReturnCommand(new Library(),in,ps).execute();
        assertEquals(Book.REQUEST_MESSAGE+Library.CHECK_IN_UN_SUCCESS+System.lineSeparator(),os.toString());
    }

}