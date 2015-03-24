package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Library {


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
        Book book =getBookFrom(bookName,bookList);
        if (book!=null){
            bookList.remove(book);
            checkedOutBooks.add(book);
            return true;
        }
        return false;
    }

    private Book getBookFrom(String bookName, List<Book> listOfBooks) {
        for (Book book : listOfBooks) {
            if(book.isTitleEquals(bookName)){
                return book;
            }
        }
        return null;
    }

    public boolean checkIn(String bookName) {
        Book book =getBookFrom(bookName,checkedOutBooks);
        if(book!=null){
            checkedOutBooks.remove(book);
            bookList.add(book);
            return  true;
        }
        return false;
    }
}
