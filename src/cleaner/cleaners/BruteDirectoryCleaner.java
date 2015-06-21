package cleaner.cleaners;

import java.io.File;
import java.util.ArrayList;
import cleaner.utils.CleanerTextUtils;

public class BruteDirectoryCleaner extends Cleaner {

    public BruteDirectoryCleaner(ArrayList<String> excludedPaths_) {
        total = root.getTotalSpace() - root.getUsableSpace();
        empties = new ArrayList<>();
        excludedPaths = excludedPaths_;
        sum = 0l;
    }

    @Override
    public ArrayList<File> getEmpties() {
        CleanerTextUtils.start("Directory");
        fire(root);
        CleanerTextUtils.finish("Directory");
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
        CleanerTextUtils.setDirStatus(empties.size(), CleanerTextUtils.round(100.0 * sum / (float) total));
    }
}
