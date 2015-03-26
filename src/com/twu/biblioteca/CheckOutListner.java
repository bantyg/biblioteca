package com.twu.biblioteca;

import java.io.InputStream;
import java.io.PrintStream;

public interface CheckOutListner {
    public void onCheckOut(InputStream inputStream, PrintStream printStream);
}
