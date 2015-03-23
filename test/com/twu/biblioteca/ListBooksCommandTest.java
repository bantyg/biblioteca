package com.twu.biblioteca;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class ListBooksCommandTest {
    @Test
    public void shouldListBooksWhenExecuted(){
        Library library = new Library();
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(os);
        ListBooksCommand listBooksCommand = new ListBooksCommand(ps , library);
        listBooksCommand.execute();
        assertEquals(library.toString() + System.lineSeparator(), os.toString());
    }


}
