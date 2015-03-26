package com.twu.biblioteca;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class ListCommandTest {
    @Test
    public void shouldListBooksWhenExecuted(){
        Library library = Library.initLibrary(LibraryMode.BOOK);
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(os);
        ListCommand listCommand = new ListCommand(ps);
        listCommand.addListner(library);
        listCommand.execute();
        assertEquals(library.toString() + System.lineSeparator(), os.toString());
    }


}
