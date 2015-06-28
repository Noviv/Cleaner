package cleaner.filters;

import java.io.File;
import java.util.ArrayList;

public class CleanerNet {

    private ArrayList<CleanerFilter> filters;

    public CleanerNet() {
        filters = new ArrayList<>();
    }

    public void addFilter(CleanerFilter filter) {
        filters.add(filter);
    }

    public boolean pass(File f) {
        for (CleanerFilter filter : filters) {
            if (!filter.pass(f)) {
                return false;
            }
        }
        return true;
    }
}
