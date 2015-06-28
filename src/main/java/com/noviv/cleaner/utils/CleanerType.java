package main.java.com.noviv.cleaner.utils;

public enum CleanerType {

    FILE("Files"),
    DIRECTORY("Directories"),
    FILE_DIRECTORY("Files and Directories");

    private String type;

    CleanerType(String type_) {
        type = type_;
    }

    public String getTypeName() {
        return type;
    }
}
