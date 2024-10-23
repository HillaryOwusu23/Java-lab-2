package PartOne;

import java.util.Scanner;

public class StudentManagementLinkedList {
    class Node {
        String data;
        Node next;

        public Node(String data) {
            this.data = data;
            this.next = null;
        }
    }

    class LinkedList {
        private Node head;

        // Add to beginning of the list
        public void addFirst(String data) {
            Node newNode = new Node(data);
            newNode.next = head;
            head = newNode;
            System.out.println(data + " added to the beginning.");
        }

        // Add to end of the list
        public void addLast(String data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = newNode;
                System.out.println(data + " added as the first element.");
                return;
            }
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
            System.out.println(data + " added to the end.");
        }

        // Add to specific position in the list
        public void addAtPosition(String data, int position) {
            Node newNode = new Node(data);
            if (position == 0) {
                addFirst(data);
                return;
            }
            Node current = head;
            for (int i = 0; i < position - 1; i++) {
                if (current == null) {
                    System.out.println("Position out of bounds.");
                    return;
                }
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
            System.out.println(data + " added at position " + position + ".");
        }

        // Search for element
        public void search(String data) {
            Node current = head;
            int index = 0;
            while (current != null) {
                if (current.data.equalsIgnoreCase(data)) {
                    System.out.println(data + " found at index " + index + ".");
                    return;
                }
                current = current.next;
                index++;
            }
            System.out.println(data + " not found.");
        }

        // Delete element
        public void delete(String data) {
            if (head == null) {
                System.out.println("List is empty.");
                return;
            }
            if (head.data.equalsIgnoreCase(data)) {
                head = head.next;
                System.out.println(data + " deleted.");
                return;
            }
            Node current = head;
            while (current.next != null) {
                if (current.next.data.equalsIgnoreCase(data)) {
                    current.next = current.next.next;
                    System.out.println(data + " deleted.");
                    return;
                }
                current = current.next;
            }
            System.out.println(data + " not found.");
        }

        // Display list
        public void display() {
            if (head == null) {
                System.out.println("List is empty.");
                return;
            }
            System.out.print("Linked List: ");
            Node current = head;
            while (current != null) {
                System.out.print(current.data + " ");
                current = current.next;
            }
            System.out.println();
        }
    }

    public static class LinkedListDemo {
        public static void main(String[] args) {
            StudentManagementLinkedList smLinkedList = new StudentManagementLinkedList();
            LinkedList linkedList = smLinkedList.new LinkedList(); // Create an instance of LinkedList
            Scanner scanner = new Scanner(System.in);
            String command;

            do {
                System.out.println("\nCommands: addFirst, addLast, addAtPosition, search, delete, display, exit");
                System.out.print("Enter command: ");
                command = scanner.nextLine();

                switch (command.toLowerCase()) {
                    case "addfirst":
                        System.out.print("Enter student name to add at beginning: ");
                        String firstName = scanner.nextLine();
                        linkedList.addFirst(firstName);
                        break;
                    case "addlast":
                        System.out.print("Enter student name to add at end: ");
                        String lastName = scanner.nextLine();
                        linkedList.addLast(lastName);
                        break;
                    case "addatposition":
                        System.out.print("Enter student name to add: ");
                        String data = scanner.nextLine();
                        System.out.print("Enter position: ");
                        int position = scanner.nextInt();
                        linkedList.addAtPosition(data, position);
                        break;
                    case "search":
                        System.out.print("Enter student name to search: ");
                        String searchData = scanner.nextLine();
                        linkedList.search(searchData);
                        break;
                    case "delete":
                        System.out.print("Enter student name to delete: ");
                        String deleteData = scanner.nextLine();
                        linkedList.delete(deleteData);
                        break;
                    case "display":
                        linkedList.display();
                        break;
                    case "exit":
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid command. Please try again.");
                }
                scanner.nextLine(); // Clear the newline
            } while (!command.equalsIgnoreCase("exit"));

            scanner.close();
        }
    }
}
