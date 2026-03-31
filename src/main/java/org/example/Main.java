package org.example;

import org.example.service.TaskTracker;

import java.io.IOException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {
        TaskTracker taskTracker = new TaskTracker();
        Scanner scanner = new Scanner(System.in);
        int choice;
        int id;
        String string;
        do {
            taskTracker.listAll();
            System.out.println(
                    """
                            1- Add new task
                            2- Remove task
                            3- Edit task
                            4- List all tasks
                            5- List to do tasks
                            6- List in progress tasks
                            7- List Done tasks
                            0- Exit
                            
                            """);
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Description: ");
                    string = scanner.next();
                    taskTracker.addTask(string);
                    break;
                case 2:
                    System.out.print("ID to remove: ");
                    id = scanner.nextInt();
                    taskTracker.delete(id);
                case 3:
                    System.out.print("ID to edit: ");
                    id = scanner.nextInt();
                    taskTracker.
                default:
                    throw new IllegalStateException("Unexpected value: " + choice);
            }
        } while (choice != 0);
    }
}