package com.twu.biblioteca;

public interface Command{
static  final String REQUEST_MESSAGE ="Enter the Book Name:";

        public void execute() throws QuitBibliotecaException;

    }
