package main.java.com.noviv.cleaner.filters;

import java.io.File;
import java.util.ArrayList;

public class FinalizeFilterCheck {

    public static ArrayList<File> finalize(ArrayList<File> checks) {
        ArrayList<File> empties = new ArrayList<>();
        for (File f : checks) {
            if (!isImportant(f)) {
                empties.add(f);
            }
        }
        return empties;
    }

    public static boolean isImportant(File f) {
        return false;
    }
}
