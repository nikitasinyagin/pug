package ru.job4j.tracker;

public enum TrackerSingleEnum {
    INSTANCE; // здесь мы указываем перечисления.
    public static Tracker tracker = new Tracker();
    public static Tracker getInstance() {
        return tracker;
    }
}
