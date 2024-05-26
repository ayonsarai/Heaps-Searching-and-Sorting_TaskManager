/*
Sarai Ayon
5/24/2024
CS 240 : Data Structures and Algorithms
Algorithms HW 7 : Heaps - Search and Sort - Create a heap that can do both searching and sorting
This project creates a task manager where the user inputs the task name, due date 
and priority rating 1-5. Once inputed the user can choose to add a task, mark a task done, 
delete a task, display all tasks, or quit the program.
*/
import java.time.LocalDate;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;


class Task {
    String taskName;
    LocalDate dueDate;
    int priority;

    public Task(String taskName, LocalDate dueDate, int priority) {
        this.taskName = taskName;
        this.dueDate = dueDate;
        this.priority = priority;
    }

    // getters and setters
}

class TaskComparator implements Comparator<Task> {
    @Override
    public int compare(Task t1, Task t2) {
        return t1.priority - t2.priority; // Min-Heap based on priority
    }
}

class TaskManager {
    private PriorityQueue<Task> taskQueue;

    public TaskManager() {
        taskQueue = new PriorityQueue<>(new TaskComparator());
    }

    public void addTask(String name, LocalDate dueDate, int priority) {
        if (dueDate.isBefore(LocalDate.now())) {
            System.out.println("Due date cannot be in the past.");
            return;
        }
        Task task = new Task(name, dueDate, priority);
        taskQueue.add(task);
    }

    public void markTaskDone(String name) {
        Task taskToMark = null;
        for (Task task : taskQueue) {
                        if (task.taskName.equals(name)) {
                            taskToMark = task;
                            break;
                        }
                    }
                    if (taskToMark != null) {
                        taskQueue.remove(taskToMark);
                        System.out.println("Task marked as done!");
                    } else {
                        System.out.println("Task not found!");
                    }
                }

                public void deleteTask(String name) {
                    Task taskToDelete = null;
                    for (Task task : taskQueue) {
                        if (task.taskName.equals(name)) {
                            taskToDelete = task;
                            break;
                        }
                    }
                    if (taskToDelete != null) {
                        taskQueue.remove(taskToDelete);
                        System.out.println("Task deleted successfully!");
                    } else {
                        System.out.println("Task not found!");
                    }
                }

                public void displayAllTasks() {
                    if (taskQueue.isEmpty()) {
                        System.out.println("No tasks available!");
                    } else {
                        System.out.println("All Tasks:");
                        for (Task task : taskQueue) {
                            System.out.println(task);
                        }
                    }
                }
            }

            public class TaskManagerApp {
                public static void main(String[] args) {
                    Scanner scanner = new Scanner(System.in);
                    TaskManager taskManager = new TaskManager();

                    while (true) {
                        System.out.println("\nTask Manager Menu:");
                        System.out.println("1. Add Task");
                        System.out.println("2. Mark Task Done");
                        System.out.println("3. Delete Task");
                        System.out.println("4. Display All Tasks");
                        System.out.println("5. Quit");
                        System.out.print("Enter your choice: ");
                        int choice = scanner.nextInt();
                        scanner.nextLine(); // Consume newline character

                    

                        switch (choice) {
                            case 1:
                                System.out.print("Enter task name: ");
                                String name = scanner.nextLine();
                                System.out.print("Enter due date as MM-DD-YY (use '-' between month, day, and year): ");
                                String dueDateString = scanner.nextLine();
                                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yy");
                                LocalDate dueDate = LocalDate.parse(dueDateString, formatter);
                                System.out.print("Enter priority (1-5): ");
                                int priority = scanner.nextInt();
                                taskManager.addTask(name, dueDate, priority);
                                break;
                            case 2:
                                System.out.print("Enter task name to mark as done: ");
                                String markName = scanner.nextLine();
                                taskManager.markTaskDone(markName);
                                break;
                            case 3:
                                System.out.print("Enter task name to delete: ");
                                String deleteName = scanner.nextLine();
                                taskManager.deleteTask(deleteName);
                                break;
                            case 4:
                                taskManager.displayAllTasks();
                                break;
                            case 5:
                                System.out.println("Quitting the program...");
                                scanner.close();
                                System.exit(0);
                                break;
                            default:
                                System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
