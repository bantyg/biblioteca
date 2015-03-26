package com.twu.biblioteca;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ReturnCommand implements Command{
    private List<CheckInListner> listners;
    private  InputStream in;
    private  PrintStream out;

    public ReturnCommand(InputStream in, PrintStream out) {
        this.in = in;
        this.out = out;
        listners =new ArrayList<CheckInListner>();
    }

    @Override
    public void execute() throws QuitBibliotecaException {
        for (CheckInListner listner : listners) {
            listner.onCheckIn(in,out);
        }
    }

    public void addListner(CheckInListner checkInListner) {
        listners.add(checkInListner);
    }
}
