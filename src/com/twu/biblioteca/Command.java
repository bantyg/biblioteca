package com.twu.biblioteca;

public interface Command{
static  final String REQUEST_MESSAGE ="Enter the {ITEM} Name:";

        public void execute() throws QuitBibliotecaException;

    }
