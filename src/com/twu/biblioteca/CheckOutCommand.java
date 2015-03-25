package com.twu.biblioteca;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;


public class CheckOutCommand implements Command {
    static final String CHECKOUT_SUCCESS ="Thank you! Enjoy the {ITEM}";
    static final String CHECKOUT_UN_SUCCESS ="That {ITEM} is not available";

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
        out.print(REQUEST_MESSAGE.replace("{ITEM}",library.getMode()));
        Scanner s = new Scanner(in);
        if (library.checkOut(s.nextLine().trim())) out.println(CHECKOUT_SUCCESS.replace("{ITEM}",library.getMode()));
        else out.println(CHECKOUT_UN_SUCCESS.replace("{ITEM}",library.getMode()));

    }
}
