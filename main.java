import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.Iterator;

class Task {
    String description;
    int priority;

    public Task(String description, int priority) {
        this.description = description;
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Task{" +
                "description='" + description + '\'' +
                ", priority=" + priority +
                '}';
    }
}

public class TaskScheduler {
    private PriorityQueue<Task> taskQueue;

    public TaskScheduler() {
        // Priority Queue with custom comparator to process tasks by priority
        taskQueue = new PriorityQueue<>(Comparator.comparingInt(task -> task.priority));
    }

    // Add a new task to the scheduler
    public void addTask(String description, int priority) {
        taskQueue.add(new Task(description, priority));
        System.out.println("Added: " + description + " with priority " + priority);
    }

    // Remove the task with the highest priority
    public void processTask() {
        Task task = taskQueue.poll();
        if (task != null) {
            System.out.println("Processing: " + task);
        } else {
            System.out.println("No tasks to process.");
        }
    }

    // Update the priority of a specific task
    public void updateTaskPriority(String description, int newPriority) {
        Task foundTask = null;
        for (Task task : taskQueue) {
            if (task.description.equals(description)) {
                foundTask = task;
                break;
            }
        }
        
        if (foundTask != null) {
            taskQueue.remove(foundTask);
            foundTask.priority = newPriority;
            taskQueue.add(foundTask);
            System.out.println("Updated task: " + description + " to new priority " + newPriority);
        } else {
            System.out.println("Task not found.");
        }
    }

    // Remove a specific task by description
    public void removeTask(String description) {
        boolean removed = taskQueue.removeIf(task -> task.description.equals(description));
        if (removed) {
            System.out.println("Removed task: " + description);
        } else {
            System.out.println("Task not found.");
        }
    }

    // View all tasks in the scheduler
    public void viewAllTasks() {
        if (taskQueue.isEmpty()) {
            System.out.println("No tasks in the queue.");
        } else {
            System.out.println("Tasks in queue:");
            taskQueue.forEach(task -> System.out.println(task));
        }
    }

    // Search for a task by description
    public void searchTask(String description) {
        boolean found = taskQueue.stream().anyMatch(task -> task.description.equals(description));
        if (found) {
            System.out.println("Task found: " + description);
        } else {
            System.out.println("Task not found.");
        }
    }

    public static void main(String[] args) {
        TaskScheduler scheduler = new TaskScheduler();

        // Adding tasks
        scheduler.addTask("Finish project report", 2);
        scheduler.addTask("Check emails", 5);
        scheduler.addTask("Prepare for meeting", 1);
        scheduler.addTask("Review code submissions", 3);

        // View all tasks
        scheduler.viewAllTasks();

        // Process a task
        scheduler.processTask();

        // Update a task's priority
        scheduler.updateTaskPriority("Check emails", 1);

        // View all tasks after updating priority
        scheduler.viewAllTasks();

        // Remove a specific task
        scheduler.removeTask("Review code submissions");

        // View all tasks after removing one
        scheduler.viewAllTasks();

        // Search for a specific task
        scheduler.searchTask("Finish project report");
    }
}
