package com.twu.biblioteca;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class ListCommand implements Command {

    private PrintStream ps;
    private List<ListCommandListner> listners;

    public ListCommand(PrintStream ps) {
        this.ps = ps;
        listners =new ArrayList<ListCommandListner>();
    }

    public void execute() {
        for (ListCommandListner listner : listners) {
            listner.onList(ps);
        }
    }

    public void addListner(ListCommandListner ls) {
        listners.add(ls);
    }
}
