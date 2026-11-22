package ru.dvmakashova.ui;

import java.util.Scanner;

/** Ввод и вывод в консоль. */
public class ConsoleHelper {

    private final Scanner scanner;

    public ConsoleHelper(Scanner scanner) {
        this.scanner = scanner;
    }

    public boolean hasNextLine() {
        return scanner.hasNextLine();
    }

    public String readLine() {
        return scanner.nextLine();
    }

    public void print(String text) {
        System.out.print(text);
    }

    public void println(String text) {
        System.out.println(text);
    }

    public void printError(String text) {
        System.out.println("Ошибка: " + text);
    }
}
