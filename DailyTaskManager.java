
// Import Scanner, LinkedList and Stack java function
import java.util.Scanner;
import java.util.LinkedList;
import java.util.Stack;

public class DailyTaskManager {
    // Declare the the Stack and LinkedList function
    Stack<String[]> TaskArrayVersion;
    LinkedList<String> ListTaskLinkedListVersion;
    Stack<LinkedList<String>> undoStackLinkedListVersion; 
    Stack<LinkedList<String>> TaskLinkedListVersion; 

    public DailyTaskManager() {

        // Declare the stack to save the first build in task and create stack
        TaskArrayVersion = new Stack<>();
        TaskLinkedListVersion = new Stack<>();
        undoStackLinkedListVersion = new Stack<>();
        TaskLinkedListVersion = new Stack<>();

        TaskArrayVersion.push(new String[] { "Bangun", "Mandi", "Makan", "Belajar", "Tidur" });

        // Declare the LinkedList and save the first build in task
        ListTaskLinkedListVersion = new LinkedList<>();
        ListTaskLinkedListVersion.add("Bangun");
        ListTaskLinkedListVersion.add("Mandi");
        ListTaskLinkedListVersion.add("Makan");
        ListTaskLinkedListVersion.add("Belajar");
        ListTaskLinkedListVersion.add("Tidur");

        // update the updated task
        TaskLinkedListVersion.push(new LinkedList<>(ListTaskLinkedListVersion));
    }

    public static void FirstMenuArrayVersion() {

        // Welcome message and the list function to use
        flush();
        System.out.println("==============================================");
        System.out.println("| Welcome To Task Manager With Array Version |");
        System.out.println("==============================================\n");

        System.out.println("Function that you can use:");
        System.out.println("1. Review task");
        System.out.println("2. Edit task");
        System.out.println("3. Mark task done");
        System.out.println("4. Undo the edited task ");
        System.out.println("5. Exit");

    }

    public void EditingDailyTaskManagerArrayVersion(Scanner scanner) {

        // Clear the terminal with flush function
        flush();

        // Peek the task from stack and calculate the total number from the task
        String[] NowTaskArrayVersion = TaskArrayVersion.peek();
        int TotalTaskArrayVersion = NowTaskArrayVersion.length;

        // Print all the task 
        System.out.println("You have total " + TotalTaskArrayVersion + " tasks:");
        for (int i = 0; i < TotalTaskArrayVersion; i++) {
            System.out.println((i + 1) + ". " + NowTaskArrayVersion[i]);
        }

        // Question to edit massage
        System.out.println("Do you want to edit a task?");
        System.out.println("1. Yes");
        System.out.println("2. No");

        // User input the number of the task
        System.out.print("Please input your choice: ");
        String editingAnswer = scanner.nextLine();

        // Run condition when yes and check the invalid input from the user
        if (editingAnswer.equals("1")) {
            System.out.print("Enter task number to edit (1-" + TotalTaskArrayVersion + "): ");
            try {
                int editNumber = Integer.parseInt(scanner.nextLine()) - 1;

                if (editNumber < 0 || editNumber >= TotalTaskArrayVersion) {
                    System.out.println("Invalid choice! Please enter a valid number.");

                    // Set timer before move to the next step
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }

                    return;
                }

                // Question name of the task massage and user inout the name of the task
                System.out.print("New Task Name: ");
                String newTask = scanner.nextLine();

                // Clone the task from the stack and put it to the array to edit the task
                String[] newTaskArray = NowTaskArrayVersion.clone();
                newTaskArray[editNumber] = newTask;

                // Update the edited task to the stack
                TaskArrayVersion.push(newTaskArray);

                // Print the waiting message and set timer before move to the next step
                System.out.println("Updating task, please wait...");
                Thread.sleep(1000);

                // Print the completed update massage and set timer before move to the next step
                System.out.println("Task updated successfully.");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }

                // Print the updated task 
                System.out.println("Updated Task List:");
                for (String task : newTaskArray) {
                    System.out.println(task);
                }

            // Invalid message from the user input number
            } catch (Exception e) {
                System.out.println("Invalid input! Please enter a valid number.");

            }
        }
    }

    public void UndoTaskArrayVersion() {

        // Cleare the terminal with flush function
        flush();

        // Condition if the stack size bigger then one and remove the new updated task
        if (TaskArrayVersion.size() > 1) {
            TaskArrayVersion.pop();

            // Print the waiting meassage and set timer before move to the next step
            System.out.println("Undo the task, please wait ...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            // Print the completed undo message and set timer before move to the next step
            System.out.println("Undo successful! Restored previous task list.");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

        // Condition if the stack size smaller then one and print the cancel undo message
        } else {
            System.out.println("No previous task list available to undo.");

            // Set timer before move to the next step
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public void ReviewTaskArrayVersion() {

        // Clear the terminal with flush function
        flush();

        // Print all the task and set timer before move to the next step
        System.out.println("Your current task list:");
        for (String task : TaskArrayVersion.peek()) {
            System.out.println(task);
        }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void MarkDoneTaskArrayVersion(Scanner scanner) {

        // Clear the terminal with flush function
        flush();

        // See the new updated task and print all the task
        String[] NowTaskArrayVersion = TaskArrayVersion.peek();
        System.out.println("All tasks:");
        for (int i = 0; i < NowTaskArrayVersion.length; i++) {
            System.out.println((i + 1) + ". " + NowTaskArrayVersion[i]);
        }

        // User input the number of the task message
        System.out.print("Enter the task number to mark as done: ");

        // Condition when the number is integer and user input the number of the task
        if (scanner.hasNextInt()) {
            int taskIndex = scanner.nextInt();
            scanner.nextLine();

            // Condition when user input is smaller then one and bigger then array length
            if (taskIndex < 1 || taskIndex > NowTaskArrayVersion.length) {
                System.out.println("Invalid choice! Please enter a valid task number.");

                // Set timer before move to the next step
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }

                return;
            }

            // Clone the array from the stack and mark the task done 
            String[] newTaskArray = NowTaskArrayVersion.clone();
            newTaskArray[taskIndex - 1] += " [Done]";

            // Update the array to stack and print the completed mark massage
            TaskArrayVersion.push(newTaskArray);
            System.out.println("Task marked as done!");

        // Condition when the user input not match with the first condition and print the invalid input message
        } else {
            System.out.println("Invalid input! Please enter a number.");
            scanner.nextLine(); // Consume invalid input


            // Set timer before move to next step
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

        }
    }

    public static void FirstMenuLinkedListVersion() {

        // Clear the terminal with flush function
        flush();

        // Print message and list function to use
        System.out.println("===================================================");
        System.out.println("| Welcome To Task Manager With LinkedList Version |");
        System.out.println("===================================================\n");

        System.out.println("Function that you can use:");
        System.out.println("1. Review task");
        System.out.println("2. Add task");
        System.out.println("3. Remove task");
        System.out.println("4. Mark task done");
        System.out.println("5. Undo edited task");
        System.out.println("6. Exit");

    }

    public void AddTaskLinkedListVersion(Scanner scanner) {

        // Clear the terminal with flush function
        flush();

        // User input the name of the task
        System.out.print("Enter the name of the new task: ");
        String newTask = scanner.nextLine();

        // Save current state before modifying
        undoStackLinkedListVersion.push(new LinkedList<>(ListTaskLinkedListVersion));

        // Print the waiting message and add the task to the linkedllist
        System.out.println("Adding task, please wait...");
        ListTaskLinkedListVersion.add(newTask);

        // Set timer before move to the next step
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Print the completed proses and set timer
        System.out.println("Task added successfully.");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void DeleteTaskLinkedListVersion(Scanner scanner) {

        // Clear the terminal with flush function
        flush();

        // Print all the task
        System.out.println("Your current tasks:");
        for (int i = 0; i < ListTaskLinkedListVersion.size(); i++) {
            System.out.println((i + 1) + ". " + ListTaskLinkedListVersion.get(i));
        }

        // Condition when the number is integer and user input the number of the task
        System.out.print("Enter the task number to remove: ");
        if (scanner.hasNextInt()) {
            int taskNumber = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            // Condition when user input smaller them one or bigger then linkedlist size
            if (taskNumber < 1 || taskNumber > ListTaskLinkedListVersion.size()) {
                System.out.println("Invalid task number! Please enter a valid number.");
                return;
            }

            // Print waiting message and remove the task 
            System.out.println("Removing task, please wait...");
            ListTaskLinkedListVersion.remove(taskNumber - 1);

            // Set timer before move to the next step
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            // Print the completed proses message and set timer
            System.out.println("Task removed successfully.");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

        // Condition when the user input not match with the first condition and print the invalid input message
        } else {
            System.out.println("Invalid input! Please enter a number.");
            scanner.nextLine(); // Consume invalid input

            // Set timer before move to the next step
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            // Print all the task and set timer
            System.out.println("Your current tasks:");
            for (int i = 0; i < ListTaskLinkedListVersion.size(); i++) {
                System.out.println((i + 1) + ". " + ListTaskLinkedListVersion.get(i));
            }
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public void ReviewTaskLinkedListVersion() {

        // Clear the terminal with flush function
        flush();

        // Print all the task and set timer
        System.out.println("Your current tasks:");
        for (int i = 0; i < ListTaskLinkedListVersion.size(); i++) {
            System.out.println((i + 1) + ". " + ListTaskLinkedListVersion.get(i));
        }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void MarkDoneTaskLinkedListVersion(Scanner scanner) {

        // Clear the terminal with flush function
        flush();

        // Print all the task
        System.out.println("Your current tasks:");
        for (int i = 0; i < ListTaskLinkedListVersion.size(); i++) {
            System.out.println((i + 1) + ". " + ListTaskLinkedListVersion.get(i));
        }

        // User input number of the task message
        System.out.print("Enter the task number to mark done: ");

        //Condition when the number is integer and user input the number of the task
        if (scanner.hasNextInt()) {
            int taskDone = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            // Condition when user input smaller then one or bigger then linkedlist size
            if (taskDone < 1 || taskDone > ListTaskLinkedListVersion.size()) {
                System.out.println("Invalid task number! Please enter a valid number.");
                return;
            }

            // Save current state before modifying
            undoStackLinkedListVersion.push(new LinkedList<>(ListTaskLinkedListVersion));

            // Mark the task as done and push the updated task
            String updatedTask = ListTaskLinkedListVersion.get(taskDone - 1) + " [Done]";
            ListTaskLinkedListVersion.set(taskDone - 1, updatedTask);
            TaskLinkedListVersion.push(new LinkedList<>(ListTaskLinkedListVersion));

            // Set timer before move to the next step
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            // Print the completed proses message and set timer
            System.out.println("Task marked as done successfully.");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        
        // Condition when the user input not match with the first condition and print the invalid input message
        } else {
            System.out.println("Invalid input! Please enter a number.");
            scanner.nextLine(); // Consume invalid input

            // Set timer before move to the next step
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public void UndoMarkDoneTaskLinkedListVersion() {

        // Clear the terminal with flush function
        flush();

        // Check the stack and push restored task
        if (!undoStackLinkedListVersion.isEmpty()) {
            ListTaskLinkedListVersion = undoStackLinkedListVersion.pop();
            TaskLinkedListVersion.push(new LinkedList<>(ListTaskLinkedListVersion)); // Push restored state

            // Print the waiting message and set timer
            System.out.println("Undo the task, please wait ...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            // Print the completed message and set timer
            System.out.println("Undo successful! The last marked task has been restored.");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

        // Condition when the user input not match with the first condition and set timer
        } else {
            System.out.println("No actions to undo.");
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static void flush() {

        // Declare the flush function
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void main(String[] args) {

        // Clear the terminal eith flush function
        flush();

        // Set up the scanner for user input
        Scanner scanner = new Scanner(System.in);
        DailyTaskManager manager = new DailyTaskManager();

        // Looping state
        while (true) {

            // Print the message and list function to use
            System.out.println("Choose the version:");
            System.out.println("1. Array Version");
            System.out.println("2. LinkedList Version");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            // User input the choice function
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            // Condition to run choice function
            if (choice == 1) {
                manager.runArrayVersion(scanner);
            } else if (choice == 2) {
                manager.runLinkedListVersion(scanner);
            } else if (choice == 3) {
                System.out.println("Exiting Task Manager...");

                // Set timer before move to the next step and stop the proses
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                break;

            // Condition when the user input not match with the first condition and print the invalid input message
            } else {
                System.out.println("Invalid choice. Please enter again.");

                // Set timer before move to the next step and stop the proses
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public void runArrayVersion(Scanner scanner) {

        // Clear the terminal eith flush function
        flush();

        // Looping state
        while (true) {

            // Run the function and user input the choice function
            FirstMenuArrayVersion();
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            // Condition to run choice function
            switch (choice) {
                case 1:
                    ReviewTaskArrayVersion();
                    break;
                case 2:
                    EditingDailyTaskManagerArrayVersion(scanner);
                    break;
                case 3:
                    MarkDoneTaskArrayVersion(scanner);
                    break;
                case 4:
                    UndoTaskArrayVersion();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice! Please enter a valid option.");

                    // Set timer before move to the next step
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
            }
        }
    }

    public void runLinkedListVersion(Scanner scanner) {

        // Clear the terminal eith flush function
        flush();

        // Lopping state
        while (true) {

            // Run the function and user input the choice function
            FirstMenuLinkedListVersion();
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            // Condition to run choice function
            switch (choice) {
                case 1:
                    ReviewTaskLinkedListVersion();
                    break;
                case 2:
                    AddTaskLinkedListVersion(scanner);
                    break;
                case 3:
                    DeleteTaskLinkedListVersion(scanner);
                    break;
                case 4:
                    MarkDoneTaskLinkedListVersion(scanner);
                    break;
                case 5:
                    UndoMarkDoneTaskLinkedListVersion();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Invalid choice! Please enter a valid option.");

                    // Set timer before move to the next step
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
            }
        }
    }
}