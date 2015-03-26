package com.twu.biblioteca;

import java.io.InputStream;
import java.io.PrintStream;

public interface CheckInListner {
    void  onCheckIn(InputStream in, PrintStream out);
}
