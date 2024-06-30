import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TaskServiceTest {
	
	// used to test each because of unique Ids
	@BeforeEach
	void setup() {
		Task.clearUsedTaskIds();
	}
	

	@Test
	void testAddTask() {
		TaskService service = new TaskService();
		Task task = new Task("12345", "Task1","This is a description");
		service.addTask(task);
		
		assertEquals(task, service.getTask("12345"));
	}
	
	@Test
	void testDeleteTask() {
		TaskService service = new TaskService();
		Task task = new Task("12345", "Task1", "This is a description");
        service.addTask(task);
        service.deleteTask("12345");
        assertNull(service.getTask("12345"));
	}
	
	@Test
	void testNullDelete() {
		TaskService service = new TaskService();
		assertThrows(IllegalArgumentException.class, () -> {
            service.deleteTask("12345");
        });
	}
	
	@Test
	void testUpdateTaskName(){
		TaskService service = new TaskService();
		Task task = new Task("12345", "Task1", "This is a description");
        service.addTask(task);
        service.updateTaskName("12345", "Updated Task");
        assertEquals("Updated Task", service.getTask("12345").getTaskName());
	}
	
	@Test
	void testUpdateTaskDescription() {
		TaskService service = new TaskService();
		Task task = new Task("12345", "Task1", "This is a description");
		service.addTask(task);
		service.updateTaskDescription("12345", "Updated Description");
		assertEquals("Updated Description", service.getTask("12345").getTaskDescription());
	}
	
	@Test
    void testUpdateNullTaskName() {
		TaskService service = new TaskService();
		assertThrows(IllegalArgumentException.class, () -> {
            service.updateTaskName("12345", "New Name");
        });
    }

    @Test
    void testUpdateNullTaskDescription() {
    	TaskService service = new TaskService();
    	assertThrows(IllegalArgumentException.class, () -> {
            service.updateTaskDescription("12345", "New Description");
        });
    }
	

}
