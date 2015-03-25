package com.twu.biblioteca;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class CheckOutCommandTest {
    @Test
    public void testCheckOutShouldGiveSuccessMessageOnSuccessFulCheckOut() throws Exception {
        InputStream in = new ByteArrayInputStream("Ramayana".getBytes());
        ByteArrayOutputStream os =new ByteArrayOutputStream();
        PrintStream ps =new PrintStream(os);
        new CheckOutCommand(Library.initLibrary(LibraryMode.BOOK),in,ps).execute();
        assertEquals(Command.REQUEST_MESSAGE.replace("{ITEM}","book")+CheckOutCommand.CHECKOUT_SUCCESS.replace("{ITEM}","book") + System.lineSeparator(),os.toString());
    }
    @Test
    public void testCheckOutShouldGiveMessageOnUnSuccessFullCheckout() throws Exception {
        InputStream in = new ByteArrayInputStream("mahabharta".getBytes());
        ByteArrayOutputStream os =new ByteArrayOutputStream();
        PrintStream ps =new PrintStream(os);
        new CheckOutCommand(Library.initLibrary(LibraryMode.BOOK),in,ps).execute();
        assertEquals(Command.REQUEST_MESSAGE.replace("{ITEM}","book")+CheckOutCommand.CHECKOUT_UN_SUCCESS.replace("{ITEM}","book") +System.lineSeparator(),os.toString());
    }
}