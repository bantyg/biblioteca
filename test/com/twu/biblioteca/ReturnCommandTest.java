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
        final ReturnCommand returnCommand = new ReturnCommand(in, ps);
        returnCommand.addListner(library);
        returnCommand.execute();
        assertEquals(Library.REQUEST_MESSAGE.replace("{ITEM}",library.getMode())+ Library.CHECK_IN_SUCCESS.replace("{ITEM}",library.getMode())+System.lineSeparator(),os.toString());
    }

    @Test
    public void testReturnCommandShouldGiveSuccessMessageWhenBookIsUnSuccessfullyReturned() throws Exception {
        InputStream in = new ByteArrayInputStream("Ramayana".getBytes());
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(os);
        final ReturnCommand returnCommand = new ReturnCommand(in, ps);
        returnCommand.addListner(Library.initLibrary(LibraryMode.BOOK));
        returnCommand.execute();
        assertEquals(Library.REQUEST_MESSAGE.replace("{ITEM}","book")+ Library.CHECK_IN_UN_SUCCESS.replace("{ITEM}","book")+System.lineSeparator(),os.toString());
    }

}