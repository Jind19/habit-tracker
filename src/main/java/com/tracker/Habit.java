package com.tracker;

public class Habit {

    private final String name;
    private final boolean completedToday;
    private final String category;


    public Habit(String name, boolean completedToday, String category) {
        this.name = name;
        this.completedToday = completedToday;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public boolean isCompletedToday() {
        return completedToday;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "Habit{" +
                "name='" + name + '\'' +
                ", completedToday=" + completedToday +
                ", category='" + category + '\'' +
                '}';
    }
}
