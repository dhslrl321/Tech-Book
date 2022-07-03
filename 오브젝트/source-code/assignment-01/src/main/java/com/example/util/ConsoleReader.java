package com.example.util;

import java.util.Scanner;

public class ConsoleReader {
    Scanner scanner = new Scanner(System.in);

    public String readLine() {
        return scanner.nextLine();
    }
}
