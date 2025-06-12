package com.tracker;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class HabitProcessorTest {

    private HabitProcessor processor;
    private List<Habit> habits;

    @BeforeEach
    void setUp() {
        processor = new HabitProcessor();

        habits = Arrays.asList(
                new Habit("Drink Water", false, "Health"),
                new Habit("Read a Book", true, "Growth"),
                new Habit("Exercise", false, "Fitness")
        );
    }

    @Test
    void testFilterHabits_shouldReturnIncompleteHabits() {
        List<Habit> incompleteHabits = processor
                .filterHabits(habits, habit -> !habit.isCompletedToday());
        assertEquals(2, incompleteHabits.size());
        assertTrue(incompleteHabits.stream().allMatch(habit -> !habit.isCompletedToday())); //Check if all habits in the incompleteHabits list are not completed today
    }

    @Test
    void testMapHabits_shouldReturnIncompleteHabits() {
        List<String> incompleteHabitNames = processor.mapHabits(processor
                .filterHabits(habits, habit -> !habit.isCompletedToday()),Habit::getName);
        assertEquals(Arrays.asList("Drink Water", "Exercise"), incompleteHabitNames);

    }

}
