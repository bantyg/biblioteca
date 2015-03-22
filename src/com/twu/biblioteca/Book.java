package com.twu.biblioteca;

/**
 * Created by poojag on 3/21/2015.
 */
public class Book {
    private final String name;
    private final String author;
    private final int year;

    public Book(String name, String author, int year) {

        this.name = name;
        this.author = author;
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (year != book.year) return false;
        if (!author.equals(book.author)) return false;
        if (!name.equals(book.name)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + author.hashCode();
        result = 31 * result + year;
        return result;
    }

    @Override
    public String toString() {
        return name+"\t\t"+author+"\t\t"+year;
    }
}
