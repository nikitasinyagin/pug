package ru.job4j.tracker;

import java.util.List;
import java.util.Scanner;

public class ConsoleInput implements Input {

    private Scanner scanner = new Scanner(System.in);

    public String ask(String question) {
        System.out.print(question);
        return scanner.nextLine();
    }

    public int ask(String question, List<Integer> range) {
        System.out.print(question);
        Scanner scanner = new Scanner(System.in);
        return Integer.valueOf(scanner.nextLine());
    }
}
