package com.twu.biblioteca;

import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertTrue;

/**
 * Created by poojag on 3/21/2015.
 */
public class BookTest {
    @Test
    public void twoBooksAreEqaul() {
        Book ramayana = new Book("Ramayan","M V", new Date().getYear());
        Book ramayana1 = new Book("Ramayan","M V", new Date().getYear());
        assertTrue(ramayana.equals(ramayana1));
    }


}
