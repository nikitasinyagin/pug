package ru.job4j.tracker;

public class TrackerSingle {
    private static Tracker instance;

    private TrackerSingle() {
    }

    public static Tracker getInstance() {
        if (instance == null) {
            instance = new Tracker();
        }
        return instance;
    }
}
