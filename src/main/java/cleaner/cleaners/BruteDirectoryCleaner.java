package main.java.cleaner.cleaners;

import java.io.File;
import java.util.ArrayList;
import main.java.cleaner.utils.CleanerTextUtils;

public class BruteDirectoryCleaner extends Cleaner {

    public BruteDirectoryCleaner(ArrayList<String> excludedPaths_, boolean text_) {
        total = root.getTotalSpace() - root.getUsableSpace();
        empties = new ArrayList<>();
        excludedPaths = excludedPaths_;
        sum = 0l;
        text = text_;
    }

    @Override
    public ArrayList<File> getEmpties() {
        if (text) {
            CleanerTextUtils.start("Directory");
        }
        fire(root);
        if (text) {
            CleanerTextUtils.finish("Directory");
        }
        return empties;
    }

    private void fire(File node) {
        if (excludedPaths.contains(node.getAbsolutePath())) {
            return;
        }
        for (File file : node.listFiles()) {
            if (file.isDirectory()) {
                if (file.listFiles() != null) {
                    if (file.listFiles().length == 0) {
                        empties.add(file);
                    } else {
                        fire(file);
                    }
                }
            } else {
                sum += file.length();
            }
        }
        update();
        if (text) {
            CleanerTextUtils.setDirStatus(empties.size(), getPercent());
        }
    }
}
