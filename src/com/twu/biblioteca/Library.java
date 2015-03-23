package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Library {
    static final String CHECKOUT_SUCCESS ="Thank you! Enjoy the book";
    static final String CHECKOUT_UN_SUCCESS ="That book is not available";
    static final String CHECK_IN_SUCCESS = "Thank you for returning the book.";
    static final String CHECK_IN_UN_SUCCESS = "That is not a valid book to return.";
    private  List<Book> checkedOutBooks = new ArrayList<Book>();
    private  List<Book> bookList = new ArrayList<Book>();

    public Library() {
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
        for (Book book: bookList)
            statement += book.toString()+"\n";
        return  statement;
    }

    public boolean checkOut(String bookName) {
        for (Book book : bookList) {
            if(book.isTitleEquals(bookName)){
                bookList.remove(book);
                checkedOutBooks.add(book);
                return  true;
            }
        }
        return false;
    }

    public boolean isCheckedOut(String bookName) {
        for (Book book : checkedOutBooks) {
            if(book.isTitleEquals(bookName)){
                return  true;
            }
        }
        return false;
    }

    public boolean checkIn(String bookName) {
        if(isCheckedOut(bookName)){
            for (Book checkedOutBook : checkedOutBooks) {
                if(checkedOutBook.isTitleEquals(bookName)){
                    checkedOutBooks.remove(checkedOutBook);
                    bookList.add(checkedOutBook);
                    return true;
                }
            }
        }
        return false;
    }
}
