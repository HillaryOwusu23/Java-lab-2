package PartTwo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TaskSchedulerQueue {
    private Queue<String> taskQueue;

    public TaskSchedulerQueue() {
        taskQueue = new LinkedList<>();
    }

    public void addTask(String task) {
        taskQueue.add(task);
        System.out.println("Task \"" + task + "\" added to the queue.");
    }

    public void removeTask() {
        if (taskQueue.isEmpty()) {
            System.out.println("No tasks to remove.");
        } else {
            String removedTask = taskQueue.poll();
            System.out.println("Task \"" + removedTask + "\" completed and removed from the queue.");
        }
    }

    public void displayTasks() {
        if (taskQueue.isEmpty()) {
            System.out.println("The queue is empty.");
        } else {
            System.out.println("Current Task Queue: " + taskQueue);
        }
    }


    public static void main(String[] args) {
        TaskSchedulerQueue scheduler = new TaskSchedulerQueue();
        Scanner scanner = new Scanner(System.in);
        String command;

        do {
            System.out.println("\nCommands: addTask, removeTask, display, exit");
            System.out.print("Enter command: ");
            command = scanner.nextLine();

            switch (command.toLowerCase()) {
                case "addtask":
                    System.out.print("Enter task description: ");
                    String task = scanner.nextLine();
                    scheduler.addTask(task);
                    break;
                case "removetask":
                    scheduler.removeTask();
                    break;
                case "display":
                    scheduler.displayTasks();
                    break;
                case "exit":
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid command. Please try again.");
            }
        } while (!command.equalsIgnoreCase("exit"));

        scanner.close();
    }
}
