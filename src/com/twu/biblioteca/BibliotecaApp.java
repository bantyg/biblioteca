package com.twu.biblioteca;

import java.io.PrintStream;
import java.util.Scanner;

public class BibliotecaApp {

    Library library;
    private final Menu menu;
    private boolean keepRunning;

    public BibliotecaApp() {
        menu = new Menu();
        library = new Library();
        menu.addItem(new MenuItem("List Books", new ListBooksCommand(System.out, library)));
        menu.addItem(new MenuItem("CheckOut", new CheckOutCommand(library,System.in,System.out)));
        menu.addItem(new MenuItem("Return Book", new ReturnCommand(library,System.in,System.out)));
        menu.addItem(new MenuItem("Quit", new QuitCommand()));
        keepRunning = true;
    }

    public static void main(String[] args) {
        BibliotecaApp b = new BibliotecaApp();
        b.run();
    }

    private void run() {
        printWelcomeMessage(System.out);
        while(keepRunning) {
            System.out.println(menu);
            System.out.println("Enter option number:");
            Scanner scan = new Scanner(System.in);
            try {
                optionHandler(scan.nextInt());
            }catch(Exception e){
                System.out.println("OOPS!!! Some unknown error occurred!!\n" + e);
            }
        }
    }

    public void printWelcomeMessage(PrintStream printStream) {
        printStream.println("Welcome to Biblioteca.");
    }

    public void optionHandler(int option) {
        try {
            menu.handleOption(option);
        } catch (QuitBibliotecaException e) {
            System.out.println(e.getMessage());
            keepRunning = false;
        }
        catch (InvalidOptionException e) {
            System.out.println(e.getMessage());
        }
    }
}
