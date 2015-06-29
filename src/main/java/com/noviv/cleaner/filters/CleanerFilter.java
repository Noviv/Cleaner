package main.java.com.noviv.cleaner.filters;

import java.io.File;

public abstract class CleanerFilter {

    public abstract boolean pass(File f);
}
