package com.twu.biblioteca;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static com.twu.biblioteca.Library.*;

/**
 * Created by poojag on 3/23/2015.
 */
public class CheckOutCommand implements Command {
    private Library library;
    private final InputStream in;
    private final PrintStream out;

    public CheckOutCommand(Library library, InputStream in, PrintStream out) {

        this.library = library;
        this.in = in;
        this.out = out;
    }

    @Override
    public void execute() throws QuitBibliotecaException {
        out.print(Book.REQUEST_MESSAGE);
        Scanner s = new Scanner(in);
        if (library.checkOut(s.nextLine().trim())) out.println(CHECKOUT_SUCCESS);
        else out.println(CHECKOUT_UN_SUCCESS);

    }
}
