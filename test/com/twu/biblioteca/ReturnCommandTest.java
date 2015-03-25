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
        Library library = Library.initLibrary(LibraryMode.BOOK);
        library.checkOut("Ramayana");
        InputStream in = new ByteArrayInputStream("Ramayana".getBytes());
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(os);
        new ReturnCommand(library,in,ps).execute();
        assertEquals(Command.REQUEST_MESSAGE.replace("{ITEM}",library.getMode())+ReturnCommand.CHECK_IN_SUCCESS.replace("{ITEM}",library.getMode())+System.lineSeparator(),os.toString());
    }

    @Test
    public void testReturnCommandShouldGiveSuccessMessageWhenBookIsUnSuccessfullyReturned() throws Exception {
        InputStream in = new ByteArrayInputStream("Ramayana".getBytes());
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(os);
        new ReturnCommand(Library.initLibrary(LibraryMode.BOOK),in,ps).execute();
        assertEquals(Command.REQUEST_MESSAGE.replace("{ITEM}","book")+ReturnCommand.CHECK_IN_UN_SUCCESS.replace("{ITEM}","book")+System.lineSeparator(),os.toString());
    }

}