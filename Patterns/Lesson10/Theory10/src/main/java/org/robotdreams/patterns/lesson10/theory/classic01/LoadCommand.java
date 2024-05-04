package org.robotdreams.patterns.lesson10.theory.classic01;

import org.robotdreams.patterns.lesson10.theory.auxiliary.ICommandLight;

import java.util.Scanner;

public class LoadCommand implements ICommandLight {
    @Override
    public void execute() {
        System.out.print("Enter name of file to open and press Enter: ");
        Scanner scanner = new Scanner(System.in);
        String filename = scanner.nextLine();
        System.out.printf("Executing %s with File=%s%n", LoadCommand.class.getSimpleName(), filename);
    }
}
