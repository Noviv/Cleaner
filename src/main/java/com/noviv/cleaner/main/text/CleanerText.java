package main.java.com.noviv.cleaner.main.text;

import main.java.com.noviv.cleaner.utils.CleanerType;
import java.io.File;
import java.util.ArrayList;
import main.java.com.noviv.cleaner.cleaners.BruteDirectoryCleaner;
import main.java.com.noviv.cleaner.cleaners.BruteDualCleaner;
import main.java.com.noviv.cleaner.cleaners.BruteFileCleaner;
import main.java.com.noviv.cleaner.cleaners.Cleaner;
import main.java.com.noviv.cleaner.utils.CleanerTextUtils;

public class CleanerText {

    private Cleaner cleaner;
    private CleanerType type;

    public CleanerText(ArrayList<String> exc, CleanerType type_) {
        switch (type_) {
            case FILE:
                cleaner = new BruteFileCleaner(exc, true);
                break;
            case DIRECTORY:
                cleaner = new BruteDirectoryCleaner(exc, true);
                break;
            case FILE_DIRECTORY:
                cleaner = new BruteDualCleaner(exc, true);
                break;
        }
        type = type_;
        init();
    }

    private void init() {
        ArrayList<File> empties = cleaner.getEmpties();
        if (CleanerTextUtils.askPrintEmpties(type.getTypeName())) {
            for (File f : empties) {
                System.out.println(f.getAbsolutePath());
            }
        }

        String fp = null;
        switch (CleanerTextUtils.askAutoDelete(type.getTypeName())) {
            case "q":
                for (File f : empties) {
                    f.delete();
                }
                exit();
                break;
            case "a":
                for (File f : empties) {
                    fp = f.getAbsolutePath();
                    if (f.delete()) {
                        System.out.println("Sucessfully deleted " + fp);
                    } else {
                        System.out.println("Failed to delete " + fp);
                    }
                }
                exit();
                break;
            case "f":
                for (File f : empties) {
                    fp = f.getAbsolutePath();
                    if (!f.delete()) {
                        System.out.println("Failed to delete " + fp);
                    }
                }
                exit();
                break;
            case "n":
                System.out.println("No files deleted.");
                exit();
                break;
        }
    }

    private void exit() {
        System.out.println("\nCleaner completed and sucessfully exited.");
        System.exit(0);
    }
}
