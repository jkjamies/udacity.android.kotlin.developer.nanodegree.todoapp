package com.example.android.architecture.blueprints.todoapp.statistics

import com.example.android.architecture.blueprints.todoapp.data.Task
import org.junit.Assert.*
import org.junit.Test

class StatisticsUtilsTest {

    // If there's 0 completed tasks and 1 active tasks,
    // then there are 0% completed tasks and 100% active tasks.
    @Test
    fun getActiveAndCompletedStats_notCompleted_returnsHundredZero() {
        val tasks = listOf<Task>(
                Task("title", "description", isCompleted = false)
        )

        val result = getActiveAndCompletedStats(tasks)

        assertEquals(0f, result.completedTasksPercent)
        assertEquals(100f, result.activeTasksPercent)
    }

    // If there's 2 completed tasks and 3 active tasks,
    // then there are 40% completed tasks and 60% active tasks.
    @Test
    fun getActiveAndCompletedStats_notCompleted_returnsFortySixty() {
        val tasks = listOf<Task>(
                Task("title", "description", isCompleted = true),
                Task("title", "description", isCompleted = true),
                Task("title", "description", isCompleted = false),
                Task("title", "description", isCompleted = false),
                Task("title", "description", isCompleted = false)
        )

        val result = getActiveAndCompletedStats(tasks)

        assertEquals(40f, result.completedTasksPercent)
        assertEquals(60f, result.activeTasksPercent)
    }

    // If there's 0 completed tasks and 0 active tasks,
    // then there are 0% completed tasks and 0% active tasks.
    @Test
    fun getActiveAndCompletedStats_notCompleted_returnsZeros() {
        val tasks = listOf<Task>()

        val result = getActiveAndCompletedStats(tasks)

        assertEquals(0f, result.completedTasksPercent)
        assertEquals(0f, result.activeTasksPercent)
    }


    // If tasks are null, then there are 0% completed tasks and 0% active tasks.
    @Test
    fun getActiveAndCompletedStats_error_returnsZeros() {
        val tasks = null

        val result = getActiveAndCompletedStats(tasks)

        assertEquals(0f, result.completedTasksPercent)
        assertEquals(0f, result.activeTasksPercent)
    }
}