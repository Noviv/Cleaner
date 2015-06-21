package cleaner.cleaners;

import java.io.File;
import java.util.ArrayList;

public abstract class Cleaner {

    protected final File root = new File("/");
    protected ArrayList<String> excludedPaths;

    protected long total;
    protected long sum;

    protected ArrayList<File> empties;

    public abstract ArrayList<File> getEmpties();

}
