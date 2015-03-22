package com.twu.biblioteca;

import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {
        System.out.println("\tWelcome To Biblioteca\n");
        Scanner scanner =new Scanner(System.in);
        Biblioteca b = new Biblioteca();
        System.out.println("\nAll Menus are");
        for (String option:b.getMenues()){
            System.out.println("\t"+option);
        }
        String selectedOption = Biblioteca.readOption(b);
        if(selectedOption.equals("Book List")){
            System.out.println("List Of Book");
            System.out.println("Book Name\t\tAuther\t\tYear\n");
            for(Book book:b.getAvailableBooks()){
                System.out.println(book);
            }
        }
    }

}
