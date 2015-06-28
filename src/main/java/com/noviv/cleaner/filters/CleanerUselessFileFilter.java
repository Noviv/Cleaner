package main.java.com.noviv.cleaner.filters;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class CleanerUselessFileFilter extends CleanerFilter {

    public final ArrayList<String> dExt = new ArrayList<String>(Arrays.asList(new String[]{".log", ".bak", ".00?", ".chk", ".tmp"}));

    @Override
    public boolean pass(File f) {
        if (f.getName().contains(".")) {
            String ext = f.getName().substring(f.getName().indexOf("."));
            return !dExt.contains(ext);//passed through the filter
        }
        return false;
    }

}
