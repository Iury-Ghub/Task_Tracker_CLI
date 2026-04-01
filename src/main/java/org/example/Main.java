package org.example;

import org.example.enums.Progress;
import org.example.service.TaskTracker;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        TaskTracker taskTracker = new TaskTracker();
        Scanner scanner = new Scanner(System.in);
        int choice,id;
        Progress progress;
        String string;
        do {
            System.out.println(
                    """
                            1- Add new task
                            2- Remove task
                            3- Edit task
                            4- List all tasks
                            5- List to do tasks
                            6- List in progress tasks
                            7- List Done tasks
                            0- Exit""");
            System.out.print("Choice: ");
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
                    break;
                case 3:
                    System.out.print("ID to edit: ");
                    id = scanner.nextInt();
                    System.out.print(
                            """
                            1.To do
                            2.In progress
                            3.Done
                            Choice:\s""");
                    choice = scanner.nextInt();
                    if(choice == 1) {
                        progress = Progress.TODO;
                    } else if (choice == 2) {
                        progress = Progress.IN_PROGRESS;
                    }else {
                        progress = Progress.DONE;
                    }
                    taskTracker.update(id,progress);
                    break;
                case 4:
                    taskTracker.listAll();
                    break;
                case 5:
                    taskTracker.listAllToDo();
                    break;
                case 6:
                    taskTracker.listAllInProgress();
                    break;
                case 7:
                    taskTracker.listAllDone();
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + choice);
            }
        } while (choice != 0);
    }
}