package com.twu.biblioteca;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class CheckOutCommand implements Command {

    private final InputStream in;
    private final PrintStream out;
    private List<CheckOutListner> listners;
    public CheckOutCommand(InputStream in, PrintStream out) {
        listners =new ArrayList<CheckOutListner>();
        this.in = in;
        this.out = out;
    }

    @Override
    public void execute() throws QuitBibliotecaException {
        for (CheckOutListner listner : listners) {
            listner.onCheckOut(in,out);
        }
    }

    public void addListner(CheckOutListner listner) {
        listners.add(listner);
    }
}
