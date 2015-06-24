package cleaner.main;

import cleaner.main.text.CleanerText;
import cleaner.main.gui.CleanerGUI;
import cleaner.utils.CleanerType;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JOptionPane;

public class CleanerMain {

    public static void main(String[] args) {
        System.exit(1);
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
                System.out.println("No option, defaulting to directory cleaning.");
                new CleanerText(exc, CleanerType.DIRECTORY);
            }
        } else if (args.length == 0) {
            new CleanerGUI();
        } else {
            System.out.println("Invalid number of arguments.");
        }
    }
}
