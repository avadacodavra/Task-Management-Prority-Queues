# Task-Management-Prority-Queues
In our daily lives, we often prioritize tasks based on urgency. For example, at work, you might have a list of tasks that need to be completed, with some tasks having higher priority than others. A priority queue can be used to manage these tasks, where the most important (or urgent) task is always handled first.


# Explanation of Code
## Task Class: Represents a task with a description and a priority. The toString() method is overridden to print task details.
## Priority Queue: A PriorityQueue is initialized with a custom comparator that orders tasks by priority. Lower numbers signify higher priority.
## Adding Tasks: Tasks are added with different priority levels.
## Processing Tasks: By polling the priority queue, tasks are processed in order of their priority.

# Explanation of New Features
addTask(String description, int priority):

Adds a new task to the queue with the specified priority.
processTask():

Processes (removes) the highest priority task from the queue.
updateTaskPriority(String description, int newPriority):

Searches for a task by its description, removes it, updates its priority, and re-adds it to maintain queue order.
removeTask(String description):

Finds and removes a task by its description from the queue.
viewAllTasks():

Displays all tasks currently in the queue with their priorities.
searchTask(String description):

Checks if a specific task is in the queue by description and prints whether it's found.
