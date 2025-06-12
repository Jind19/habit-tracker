package com.tracker;

import java.util.Arrays;
import java.util.List;

public class App {

    public static void main( String[] args ) {

        HabitProcessor processor = new HabitProcessor();

        List<Habit> habits = Arrays.asList(
                new Habit("Drink Water", true, "Health"),
                new Habit("Read a Book", false, "Growth"),
                new Habit("Exercise", true, "Fitness"),
                new Habit("Meditate", false, "Fitness"),
                new Habit("Write Journal", true, "Productivity"),
                new Habit("Sleep by 10 PM", false, "Health")
        );

        // Filter habits using lambda expression
        List<Habit> incompletedHabits = processor
                .filterHabits(habits, habit -> !habit.isCompletedToday());

        // Store incompleted habits using method reference
        List<String> incompletedHabitNames = processor.mapHabits(incompletedHabits,Habit::getName);

        // processor.processHabit(incompletedHabits,  System.out::println);
        processor.processHabits(incompletedHabits,  t -> System.out.println("Don't forget: "+ t.toString()));

        // Printing incompleted habitNames
        System.out.println("Habit Names: " + incompletedHabitNames);
    }
}
