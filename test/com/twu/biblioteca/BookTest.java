package com.twu.biblioteca;

import org.junit.Test;

import java.util.Calendar;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by poojag on 3/21/2015.
 */
public class BookTest {
    @Test
    public void twoBooksAreEqual() {
        Item ramayana = new Book("Ramayan","M V", Calendar.getInstance().get(Calendar.YEAR));
        Item ramayana1 = new Book("Ramayan","M V",Calendar.getInstance().get(Calendar.YEAR));
        assertTrue(ramayana.equals(ramayana1));
    }


}
