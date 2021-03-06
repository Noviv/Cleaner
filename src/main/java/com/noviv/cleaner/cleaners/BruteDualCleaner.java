package main.java.com.noviv.cleaner.cleaners;

import java.io.File;
import java.util.ArrayList;

public class BruteDualCleaner extends Cleaner {

    private BruteDirectoryCleaner dirCleaner;
    private BruteFileCleaner fileCleaner;

    public BruteDualCleaner(ArrayList<String> excludedPaths_, boolean text) {
        total = root.getTotalSpace() - root.getUsableSpace();
        empties = new ArrayList<>();
        excludedPaths = excludedPaths_;
        sum = 0l;
        dirCleaner = new BruteDirectoryCleaner(excludedPaths_, text);
        fileCleaner = new BruteFileCleaner(excludedPaths_, text);
    }

    @Override
    public ArrayList<File> getEmpties() {
        empties.addAll(dirCleaner.getEmpties());
        empties.addAll(fileCleaner.getEmpties());
        return empties;
    }

}
