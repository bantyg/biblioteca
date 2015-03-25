package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MovieTest {
    @Test
    public void test_toMoviesareEqual() {
        Movie m = new Movie("Run","jeeva",2004, 4);
        Movie m2 = new Movie("Run","jeeva",2004, 4);
        assertEquals(m,m2);
    }
}