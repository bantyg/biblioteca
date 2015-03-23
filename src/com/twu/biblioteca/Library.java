package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private static List<Book> bookList = new ArrayList<Book>();
    static {
        bookList.add(new Book("The Adventures of Sherlock Holmes","Arthur Conan Doyle",1987));
        bookList.add(new Book("Wings of Fire","A. P. J. Abdul Kalam",2004));
        bookList.add(new Book("Ramayana", "Valmiki",2001));
        bookList.add(new Book("Five Point Someone", "Chetan Bhagat",2010));
    }
    public List<Book> getBookList() {
        return bookList;
    }

    @Override
    public String toString() {
        String statement = Book.getHeader() +
                "-------------------------------------------\n";
        Library lib = new Library();
        for (Book book: lib.getBookList())
            statement += book.toString()+"\n";
        return  statement;
    }
}
