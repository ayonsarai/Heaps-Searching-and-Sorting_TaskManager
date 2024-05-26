Explanation

Task Class:
Represents a task with attributes: name, due date, and priority.
Includes a toString method to provide a readable representation of the task.

TaskComparator Class:
Implements the Comparator interface to compare tasks based on their priority for use in the priority queue.
Higher priority tasks (higher priority value) are given precedence.

TaskManager Class:
Manages a priority queue of tasks.
Provides methods to add tasks, mark tasks as done, delete tasks, and display all tasks.
Uses a PriorityQueue with a custom comparator to maintain a max-heap based on task priority.

TaskManagerApp Class:
Contains the main method to run the task manager application.
Provides a simple text-based menu for user interaction.
Allows users to add tasks, mark tasks as done, delete tasks, display all tasks, and quit the program.

Usage (User Prompt)
Add Task: Adds a new task to the task manager with a specified name, due date, and priority.
Mark Task Done: Removes a task from the task manager by its name, marking it as completed.
Delete Task: Deletes a task from the task manager by its name.
Display All Tasks: Displays all tasks currently in the task manager, sorted by priority.
Quit: Exits the application.

This implementation provides a basic yet functional task manager using a max-heap to prioritize tasks efficiently based on their priority ratings.






