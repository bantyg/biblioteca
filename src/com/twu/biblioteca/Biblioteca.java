package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by poojag on 3/21/2015.
 */
public class Biblioteca {
    private List<Book> availableBooks;
    private List<String> menues;

    public Biblioteca() {
        availableBooks =new ArrayList<Book>();
        availableBooks.add(new Book("The Adventures Of Sherlock Hollks ", "sir Arthur Conan", 2001));
        availableBooks.add(new Book("Wings Of Fire ", "A.P.J Abdul Kalam", 2003));
        availableBooks.add(new Book("Ramayna", "Maharishi Valmiki", 2004));
        availableBooks.add(new Book("Five Point Someone", "Chetan Bhagat", 2004));
        menues =new ArrayList<String>();
        menues.add("Book List");
        menues.add("Quit");
    }

    public static String readOption(Biblioteca b) {
        System.out.println("Enter the option:-");
        Scanner scanner =new Scanner(System.in);
        String selectedOption = scanner.nextLine();
        while(!b.isValidOption(selectedOption)){
            System.out.println("Select a valid option! " +selectedOption);
            System.out.println("Enter the option:-");
            selectedOption =scanner.nextLine();
        }
        return selectedOption;
    }

    public List<Book> getAvailableBooks() {
        return availableBooks;
    }

    public List<String> getMenues() {
        return menues;
    }

    public boolean isValidOption(String s) {
     return  menues.contains(s);
    }
}
