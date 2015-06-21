package cleaner.main;

import cleaner.utils.CleanerType;
import java.io.File;
import java.util.ArrayList;
import cleaner.cleaners.BruteDirectoryCleaner;
import cleaner.cleaners.BruteDualCleaner;
import cleaner.cleaners.BruteFileCleaner;
import cleaner.cleaners.Cleaner;
import cleaner.utils.CleanerTextUtils;

public class CleanerText {

    private Cleaner cleaner;
    private CleanerType type;

    public CleanerText(ArrayList<String> exc, CleanerType type_) {
        switch (type_) {
            case FILE:
                cleaner = new BruteFileCleaner(exc);
                break;
            case DIRECTORY:
                cleaner = new BruteDirectoryCleaner(exc);
                break;
            case FILE_DIRECTORY:
                cleaner = new BruteDualCleaner(exc);
                break;
        }
        type = type_;
        init();
    }

    private void init() {
        ArrayList<File> empties = cleaner.getEmpties();
        if (CleanerTextUtils.askPrintEmpties(type.getTypeName())) {
            for (File f : empties) {
                System.out.println(f.getAbsolutePath());
            }
        }

        String fp = null;
        switch (CleanerTextUtils.askAutoDelete(type.getTypeName())) {
            case "q":
                for (File f : empties) {
                    f.delete();
                }
                break;
            case "a":
                for (File f : empties) {
                    fp = f.getAbsolutePath();
                    if (f.delete()) {
                        System.out.println("Sucessfully deleted " + fp);
                    } else {
                        System.out.println("Failed to delete " + fp);
                    }
                }
                break;
            case "f":
                for (File f : empties) {
                    fp = f.getAbsolutePath();
                    if (!f.delete()) {
                        System.out.println("Failed to delete " + fp);
                    }
                }
                break;
            case "n":
                System.out.println("\nCleaner completed and sucessfully exited.");
                System.exit(0);
                break;
        }
    }
}
