package ru.job4j.tracker;

public class TrackerSingleTwo {
    private static final Tracker INSTANCE = new Tracker();

    private TrackerSingleTwo() {
    }

    public static Tracker getInstance() {
        return INSTANCE;
    }
}

