package main.java.com.noviv.cleaner.filters.file;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import main.java.com.noviv.cleaner.filters.CleanerFilter;

public class CleanerUselessFileFilter extends CleanerFilter {

    public final ArrayList<String> dExt = new ArrayList<String>(Arrays.asList(new String[]{".log", ".bak", ".00?", ".chk", ".tmp"}));

    @Override
    public boolean pass(File f) {
        if (f.getName().contains(".")) {
            String ext = f.getName().substring(f.getName().indexOf("."));
            return !dExt.equals(ext);//passed through the filter
        } else {
            return true;
        }
    }

}
