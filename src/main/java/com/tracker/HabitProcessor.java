package com.tracker;

import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Processes a list of habits using functional programming constructs.
 */
public class HabitProcessor {

    /**
     * Filters habits based on a given predicate.
     */
    public List<Habit> filterHabits(List<Habit> habits, Predicate<Habit> condition){

        return habits
                .stream() // Convert the list to a Stream
                .filter(condition) // Apply the Predicate<Habit> condition: condition.test(Habit), what returns true will remain.
                .collect(Collectors.toList()); //Collect the result into a new List
    }

    /**
     * Transforms tasks using a provided mapping function.
     */
    public List<String> mapHabits(List<Habit> habits, Function<Habit, String> mapper) {
        return habits
                .stream()
                .map(mapper)
                .collect(Collectors.toList());
    }

    /**
     * Applies an action to each task (side-effect operation).
     */
    public void processHabits(List<Habit> habits, Consumer<Habit> action){
        habits.forEach(action);
    }
}
