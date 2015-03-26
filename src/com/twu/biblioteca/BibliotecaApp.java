package com.twu.biblioteca;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

public class BibliotecaApp {

    Library library;
    private final Menu menu;
    private boolean keepRunning;

    public BibliotecaApp(LibraryMode libraryMode) {
        menu = new Menu();
        library = Library.initLibrary(libraryMode);
        ListCommand listCommand = new ListCommand(System.out);
        listCommand.addListner(library);
        CheckOutCommand checkOutCommand = new CheckOutCommand(System.in, System.out);
        ReturnCommand returnCommand = new ReturnCommand(library, System.in, System.out);
        menu.addItem(new MenuItem("List ", listCommand));
        menu.addItem(new MenuItem("CheckOut", checkOutCommand));
        menu.addItem(new MenuItem("Return ", returnCommand));
        menu.addItem(new MenuItem("Quit", new QuitCommand()));
        keepRunning = true;
    }

    public static void main(String[] args) {
        BibliotecaApp b;
        if(Arrays.asList(args).contains("-m")){
            b = new BibliotecaApp(LibraryMode.MOVIE);
        }else{
        b =new BibliotecaApp(LibraryMode.BOOK);
        }
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
