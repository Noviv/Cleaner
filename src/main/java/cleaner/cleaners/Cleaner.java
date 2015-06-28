package main.java.cleaner.cleaners;

import main.java.cleaner.filters.CleanerNet;
import main.java.cleaner.utils.CleanerTextUtils;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JProgressBar;

public abstract class Cleaner {

    protected File root = new File("/");
    protected ArrayList<String> excludedPaths;
    protected CleanerNet net;
    protected JProgressBar bar;

    protected long total;
    protected long sum;
    protected boolean text;

    protected ArrayList<File> empties;

    public abstract ArrayList<File> getEmpties();

    public final double getPercent() {
        return CleanerTextUtils.round(100.0 * sum / (float) total);
    }

    public final void setJProgressBar(JProgressBar bar_) {
        bar = bar_;
    }

    protected final void update() {
        if (bar != null) {
            bar.setValue((int) getPercent());
            bar.setString(getPercent() + "%");
        }
    }

}
