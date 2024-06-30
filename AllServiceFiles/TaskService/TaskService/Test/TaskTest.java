import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TaskTest {

	@Test
	void testTaskCreation() {
		Task task = new Task("12345", "Task1", "This is the sample description of this task");
		assertEquals("12345", task.getTaskId());
		assertEquals("Task1", task.getTaskName());
		assertEquals("This is the sample description of this task", task.getTaskDescription());
	}
	
	@Test
    void testInvalidId() {
        // Null ID
        assertThrows(IllegalArgumentException.class, () -> {
            new Task(null, "Task1", "This is a sample task description");
        });

        // More than 10 chars
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("12345678901", "Task1", "This is a sample task description");
        });

        // Duplicate ID
        new Task("1234567890", "Task1", "This is a sample task description");
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("1234567890", "Another Task", "This is another task description");
        });
    }

    @Test
    void testInvalidName() {
        // Null name
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("1234567891", null, "This is a sample task description");
        });

        // More than 20 chars
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("1234567891", "This is a very long task name that exceeds the limit", "This is a sample task description");
        });

        // Update to null
        Task task = new Task("1234567891", "Task1", "This is a sample task description");
        assertThrows(IllegalArgumentException.class, () -> {
            task.setTaskName(null);
        });

        // Update to more than 20 chars
        assertThrows(IllegalArgumentException.class, () -> {
            task.setTaskName("This is a very long task name that exceeds the limit");
        });
        
        // Valid update
        task.setTaskName("Valid Name");
        assertEquals("Valid Name", task.getTaskName());

        // Edge case: exactly 20 characters
        task.setTaskName("12345678901234567890");
        assertEquals("12345678901234567890", task.getTaskName());
    }

    @Test
    void testInvalidDescription() {
        // Null description
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("1234567892", "Task1", null);
        });

        // More than 50 chars
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("1234567892", "Task1", "This is a very long task description that exceeds the fifty characters limit allowed.");
        });

        // Update to null
        Task task = new Task("1234567892", "Task1", "This is a sample task description");
        assertThrows(IllegalArgumentException.class, () -> {
            task.setTaskDescription(null);
        });

        // Update to more than 50 chars
        assertThrows(IllegalArgumentException.class, () -> {
            task.setTaskDescription("This is a very long task description that exceeds the fifty characters limit allowed.");
        });
        
     // Valid update
        task.setTaskDescription("Valid Description");
        assertEquals("Valid Description", task.getTaskDescription());

        // Edge case: exactly 50 characters
        task.setTaskDescription("12345678901234567890123456789012345678901234567890");
        assertEquals("12345678901234567890123456789012345678901234567890", task.getTaskDescription());
    }

}
