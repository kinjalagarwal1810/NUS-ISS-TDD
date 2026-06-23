package sg.edu.nus.iss.epat.tdd.workshop;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;

import static org.junit.Assert.*;

public class ToDoListTest {
    private ToDoList toDoList;

    public ToDoListTest() {
        super();
    }

    @Before
    public void setUp() throws Exception {
        toDoList = new ToDoList();
    }

    @After
    public void tearDown() throws Exception {
        toDoList = null;
    }

    @Test
    public void testAddTask() {
        Task task = new Task("Study TDD");

        toDoList.addTask(task);

        assertNotNull(toDoList.getTask("Study TDD"));
        assertEquals("Study TDD", toDoList.getTask("Study TDD").getDescription());
        assertEquals(1, toDoList.getAllTasks().size());
    }

    @Test
    public void testGetStatus() {
        Task task = new Task("Complete workshop");

        toDoList.addTask(task);

        assertFalse(toDoList.getStatus("Complete workshop"));

        toDoList.completeTask("Complete workshop");

        assertTrue(toDoList.getStatus("Complete workshop"));
    }

    @Test
    public void testRemoveTask() {
        Task task = new Task("Delete this task");

        toDoList.addTask(task);

        Task removedTask = toDoList.removeTask("Delete this task");

        assertNotNull(removedTask);
        assertNull(toDoList.getTask("Delete this task"));
        assertEquals(0, toDoList.getAllTasks().size());
    }

    @Test
    public void testGetCompletedTasks() {
        Task task1 = new Task("Task 1");
        Task task2 = new Task("Task 2");

        toDoList.addTask(task1);
        toDoList.addTask(task2);

        toDoList.completeTask("Task 1");

        Collection<Task> completedTasks = toDoList.getCompletedTasks();

        assertEquals(1, completedTasks.size());

        Task completedTask = completedTasks.iterator().next();
        assertEquals("Task 1", completedTask.getDescription());
        assertTrue(completedTask.isComplete());
    }
}