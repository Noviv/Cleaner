package cleaner.utils;

import java.util.Scanner;

public class CleanerTextUtils {

    public static void start(String type) {
        System.out.println("Starting Cleaner(" + type + ")...");
    }

    public static void setDirStatus(int num, double percent) {
        System.out.print("\r" + num + " empty directories found, " + percent + "% complete.");
    }

    public static void setFileStatus(int num, double percent) {
        System.out.print("\r" + num + " empty files found, " + percent + "% complete.");
    }

    public static void finish(String type) {
        System.out.println("\n" + "Cleaner(" + type + ") has finished!\n");
    }

    public static boolean askPrintEmpties(String typePlural) {
        try {
            Scanner s = new Scanner(System.in);
            System.out.print("\nWould you like to see all empty " + typePlural + "? (y/n): ");
            switch (s.next().toLowerCase()) {
                case "y":
                    return true;
                case "n":
                    return false;
                default:
                    System.out.println("Invalid input. Try again.");
                    askPrintEmpties(typePlural);
            }
            s.close();
        } catch (Exception e) {
        }
        System.out.println("System error.");
        System.exit(1);
        return false;
    }

    public static String askAutoDelete(String typePlural) {
        try {
            Scanner s = new Scanner(System.in);
            System.out.print("\nWould you like to remove all empty " + typePlural
                    + "? (n = no, q = yes [no output] a = yes [all output] f = yes [fail output]): ");
            String str = s.next().toLowerCase();
            switch (str) {
                case "n":
                case "q":
                case "a":
                case "f":
                    return str;
                default:
                    System.out.println("Invalid input. Try again.");
                    askAutoDelete(typePlural);
            }
            s.close();
        } catch (Exception e) {
        }
        System.out.println("System error.");
        System.exit(1);
        return "";
    }

    public static double round(double val) {
        return Math.round(100.0 * val) / 100.0;
    }
}
