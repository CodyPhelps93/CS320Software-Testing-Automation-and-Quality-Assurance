import java.util.HashMap;
import java.util.Map;

public class TaskService {
	private final Map<String, Task> tasks = new HashMap<>();
	
	public void addTask(Task newTask) {
		tasks.put(newTask.getTaskId(),newTask);
	}
	
	public void deleteTask(String taskId) {
		if(!tasks.containsKey(taskId)) {
			throw new IllegalArgumentException("Task not found");
		}
		tasks.remove(taskId);
	}
	
	public void updateTaskName(String taskId, String newName) {
		Task task = tasks.get(taskId);
		if(task == null) {
			throw new IllegalArgumentException("Task not found");
		}
		task.setTaskName(newName);
	}
	
	public void updateTaskDescription(String taskId, String taskDescription) {
		Task task = tasks.get(taskId);
		if(task == null) {
			throw new IllegalArgumentException("Task not found");
		}
		task.setTaskDescription(taskDescription);
	}
	
	public Task getTask(String taskId) {
		return tasks.get(taskId);
	}
}
