package com.twu.biblioteca;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static com.twu.biblioteca.Library.*;

/**
 * Created by poojag on 3/23/2015.
 */
public class ReturnCommand implements Command{
    private final Library library;
    private final InputStream in;
    private final PrintStream out;

    public ReturnCommand(Library library, InputStream in, PrintStream out) {
        this.library = library;
        this.in = in;
        this.out = out;
    }

    @Override
    public void execute() throws QuitBibliotecaException {
        out.print(Book.REQUEST_MESSAGE);
        Scanner s = new Scanner(in);
        if (library.checkIn(s.nextLine().trim())) out.println(CHECK_IN_SUCCESS);
        else out.println(CHECK_IN_UN_SUCCESS);
    }
}
