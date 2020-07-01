package hu.codecool.player.reader;

import java.util.Scanner;

public class ConsoleReader extends Reader {

    private static final Scanner SCANNER = new Scanner(System.in);

    @Override
    public String read(String prompt) {
        System.out.println("INFO " + prompt);
        return SCANNER.nextLine();
    }
}
