package com.twu.biblioteca;

import org.junit.Test;
import sun.util.resources.ar.CalendarData_ar;

import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by poojag on 3/21/2015.
 */
public class BookTest {
    @Test
    public void twoBooksAreEqual() {
        Book ramayana = new Book("Ramayan","M V", Calendar.getInstance().get(Calendar.YEAR));
        Book ramayana1 = new Book("Ramayan","M V",Calendar.getInstance().get(Calendar.YEAR));
        assertTrue(ramayana.equals(ramayana1));
    }


}
