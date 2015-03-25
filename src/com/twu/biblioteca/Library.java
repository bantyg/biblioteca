package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Library {

    private List<Item> checkedOutItems;
    private List<Item> items;
    private LibraryMode mode;

    private Library(LibraryMode mode) {
        this.mode = mode;
        checkedOutItems = new ArrayList<Item>();
       items = new ArrayList<Item>();
   }

    static Library initLibrary(LibraryMode mode){
     Library l=new Library(mode);
        ;
     if(mode.equals(LibraryMode.BOOK)){
        l.add(new Book("The Adventures of Sherlock Holmes", "Arthur Conan Doyle", 1987));
        l.add(new Book("Wings of Fire", "A. P. J. Abdul Kalam", 2004));
        l.add(new Book("Ramayana", "Valmiki", 2001));
        l.add(new Book("Five Point Someone", "Chetan Bhagat", 2010));}
     if (mode.equals(LibraryMode.MOVIE)){
         l.add(new Movie("Interstelear", "JBC", 2014,4));
         l.add(new Movie("Lagan", "Ashitosh gawarikar", 2001,3));
         l.add(new Movie("Border","J.P Dutta",1997,5));
         l.add(new Movie("PK","Rajkumar Hirani",2014,7));
     }

     return l;
 }
private  void add(Item item){
    items.add(item);
}
    @Override
    public String toString() {
        String statement = "{Header}" +
                "-------------------------------------------\n";
        for (Item item : items) {
            statement = statement.replace("{Header}", item.getHeader());
            statement += item.toString() + "\n";
        }
        return statement;
    }

    public boolean checkOut(String itemName) {
        Item book = getItemFrom(itemName, items);
        if (book != null) {
            items.remove(book);
            checkedOutItems.add(book);
            return true;
        }
        return false;
    }

    private Item getItemFrom(String itemName, List<Item> listOfItems) {
        for (Item book : listOfItems) {
            if (book.isTitleEquals(itemName)) {
                return book;
            }
        }
        return null;
    }

    public boolean checkIn(String itemName) {
        Item book = getItemFrom(itemName, checkedOutItems);
        if (book != null) {
            checkedOutItems.remove(book);
            items.add(book);
            return true;
        }
        return false;
    }

    public String getMode() {
        return mode.name().toLowerCase();
    }
}
