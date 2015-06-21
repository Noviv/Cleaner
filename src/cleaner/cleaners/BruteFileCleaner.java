package cleaner.cleaners;

import java.io.File;
import java.util.ArrayList;
import cleaner.utils.CleanerTextUtils;

public class BruteFileCleaner extends Cleaner {

    public BruteFileCleaner(ArrayList<String> excludedPaths_) {
        total = root.getTotalSpace() - root.getUsableSpace();
        empties = new ArrayList<>();
        excludedPaths = excludedPaths_;
        sum = 0l;
    }

    @Override
    public ArrayList<File> getEmpties() {
        CleanerTextUtils.start("File");
        fire(root);
        CleanerTextUtils.finish("File");
        return empties;
    }

    private void fire(File node) {
        if (excludedPaths.contains(node.getAbsolutePath())) {
            return;
        }
        if (node.listFiles() != null) {
            for (File f : node.listFiles()) {
                if (f.isFile()) {
                    sum += f.length();
                    if (f.length() == 0l) {
                        empties.add(f);
                    }
                } else {
                    fire(f);
                }
            }
        }
        CleanerTextUtils.setFileStatus(empties.size(), CleanerTextUtils.round(100.0 * sum / (float) total));
    }
}
