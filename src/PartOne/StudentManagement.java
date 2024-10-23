package PartOne;

import java.util.Scanner;

public class StudentManagement {
    private String[] students;
    private int count;
    private static final int MAX_SIZE = 100;

    public StudentManagement() {
        students = new String[MAX_SIZE];
        count = 0;
    }

    // Add student name
    public void addStudent(String name) {
        if (count < MAX_SIZE) {
            students[count++] = name;
            System.out.println(name + " added successfully.");
        } else {
            System.out.println("Cannot add student. Array is full!");
        }
    }

    // Search student name
    public void searchStudent(String name) {
        for (int i = 0; i < count; i++) {
            if (students[i].equalsIgnoreCase(name)) {
                System.out.println(name + " found at index " + i);
                return;
            }
        }
        System.out.println(name + " not found.");
    }

    // Delete student name
    public void deleteStudent(String name) {
        for (int i = 0; i < count; i++) {
            if (students[i].equalsIgnoreCase(name)) {
                // Shift elements to the left to fill the gap
                for (int j = i; j < count - 1; j++) {
                    students[j] = students[j + 1];
                }
                students[--count] = null; // Clear the last element
                System.out.println(name + " deleted successfully.");
                return;
            }
        }
        System.out.println(name + " not found.");
    }

    // Display student names
    public void displayStudents() {
        if (count == 0) {
            System.out.println("No students enrolled.");
            return;
        }
        System.out.println("List of Students:");
        for (int i = 0; i < count; i++) {
            System.out.println((i + 1) + ". " + students[i]);
        }
    }

    // Main method to run the program
    public static void main(String[] args) {
        StudentManagement sm = new StudentManagement();
        Scanner scanner = new Scanner(System.in);
        String command;

        do {
            System.out.println("\nCommands: add, search, delete, display, exit");
            System.out.print("Enter command: ");
            command = scanner.nextLine();

            switch (command.toLowerCase()) {
                case "add":
                    System.out.print("Enter student name: ");
                    String nameToAdd = scanner.nextLine();
                    sm.addStudent(nameToAdd);
                    break;
                case "search":
                    System.out.print("Enter student name to search: ");
                    String nameToSearch = scanner.nextLine();
                    sm.searchStudent(nameToSearch);
                    break;
                case "delete":
                    System.out.print("Enter student name to delete: ");
                    String nameToDelete = scanner.nextLine();
                    sm.deleteStudent(nameToDelete);
                    break;
                case "display":
                    sm.displayStudents();
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
