package main.java.com.noviv.cleaner.main;

import main.java.com.noviv.cleaner.main.text.CleanerText;
import main.java.com.noviv.cleaner.main.gui.CleanerGUI;
import main.java.com.noviv.cleaner.utils.CleanerType;
import java.util.ArrayList;
import java.util.Arrays;

public class CleanerMain {

    public static void main(String[] args) {
        if (args.length == 1 || args.length == 2) {
            ArrayList<String> exc = new ArrayList<>();
            exc.addAll(Arrays.asList(args[0].split(",")));
            if (args.length == 2) {
                switch (args[1]) {
                    case "-b":
                        new CleanerText(exc, CleanerType.FILE_DIRECTORY);
                        break;
                    case "-d":
                        new CleanerText(exc, CleanerType.DIRECTORY);
                        break;
                    case "-f":
                        new CleanerText(exc, CleanerType.FILE);
                        break;
                }
            } else {
                System.out.println("No type parameter found, defaulting to directory cleaning.");
                new CleanerText(exc, CleanerType.DIRECTORY);
            }
        } else if (args.length == 0) {
            new CleanerGUI();
        } else {
            System.out.println("Invalid number of arguments.");
        }
    }
}
