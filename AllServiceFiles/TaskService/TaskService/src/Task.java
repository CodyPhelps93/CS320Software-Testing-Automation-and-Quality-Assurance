import java.util.HashSet;
import java.util.Set;

public class Task {
	private static final Set<String>usedTaskIds = new HashSet<>(); // use a hash set to keep track of used Ids
	private final String taskId;
	private String taskName;
	private String taskDescription;
	
	public Task(String taskId, String taskName, String taskDescription) {
		if (taskId == null || taskId.length() > 10) {
			throw new IllegalArgumentException("Task ID must not be Null or over 10 characters");
		}
		
		if (!isIdUsed(taskId)) {
			throw new IllegalArgumentException("Task ID " + taskId + " already in use");
		}
		
		if (taskName == null || taskName.length() > 20) {
			throw new IllegalArgumentException("Task name may not be null or longer than 20 characters!");
		}
		
		if (taskDescription == null || taskDescription.length() > 50) {
			throw new IllegalArgumentException("Task description may not be null or longer than 50 characters!");
		}
		
		this.taskId = taskId;
		this.taskName = taskName;
		this.taskDescription = taskDescription;
		usedTaskIds.add(taskId);
	}
	
	// check if id is unique
	public static boolean isIdUsed(String taskId) {
		return !usedTaskIds.contains(taskId);
	}
	
	// getters
	public String getTaskId() {
		return taskId;
	}
	
	public String getTaskName() {
		return taskName;
	}
	
	public String getTaskDescription() {
		return taskDescription;
	}
	
	// setters
	public void setTaskName(String name) {
		if (name == null || name.length() > 20) {
			throw new IllegalArgumentException("Task name may not be null or longer than 20 characters!");
		}
		this.taskName = name;
	}
	
	public void setTaskDescription(String description) {
		if (description == null || description.length() > 50) {
			throw new IllegalArgumentException("Task description may not be null or longer than 50 characters!");
		}
		this.taskDescription = description;
	}
	
	public static void clearUsedTaskIds() {
		usedTaskIds.clear();
	}

	

};
