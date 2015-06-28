package cleaner.cleaners;

import cleaner.filters.CleanerNet;
import cleaner.filters.CleanerUselessFileFilter;
import java.io.File;
import java.util.ArrayList;
import cleaner.utils.CleanerTextUtils;

public class BruteFileCleaner extends Cleaner {
    
    public BruteFileCleaner(ArrayList<String> excludedPaths_, boolean text_) {
        total = root.getTotalSpace() - root.getUsableSpace();
        empties = new ArrayList<>();
        net = new CleanerNet();
        excludedPaths = excludedPaths_;
        sum = 0l;
        text = text_;
        
        net.addFilter(new CleanerUselessFileFilter());
    }
    
    @Override
    public ArrayList<File> getEmpties() {
        if (text) {
            CleanerTextUtils.start("File");
        }
        fire(root);
        if (text) {
            CleanerTextUtils.finish("File");
        }
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
                    if (f.length() == 0l || !net.pass(f)) {
                        empties.add(f);
                    }
                } else {
                    fire(f);
                }
            }
        }
        update();
        if (text) {
            CleanerTextUtils.setFileStatus(empties.size(), getPercent());
        }
    }
}
