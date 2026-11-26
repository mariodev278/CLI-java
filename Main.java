import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Task> tasks = new ArrayList<>();
        int opcion = 0;
        int id = 0;
        do {
            System.out.println("----- Opciones -----");
            System.out.println("1. new task");
            System.out.println("2. delete task");
            System.out.println("3. view tasks");
            System.out.println("4. complete a task");
            System.out.println("5. exit");

            System.out.println("write a number: ");
            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {
                case 1 -> {
                    id++;
                    newTask(id, sc, tasks);
                }
                case 2 -> deleteTask(tasks,sc);
                case 3 -> viewTasks(tasks);
                case 4 -> taskDone(tasks, sc);
                case 5 -> System.out.println("closing...");
                default -> System.out.println("incorrect number");
            }


        } while (opcion != 5);
    }

    public static void deleteTask(ArrayList<Task> tasks,Scanner sc) {
        int option = 99;
        if (tasks.isEmpty()) {
            System.out.println("no tasks");
        } else {
            do {
                boolean found = false;
                System.out.println("write the id of the task you want to delete, 0 to exit");
                option = Integer.parseInt(sc.nextLine());{
                    if (tasks.isEmpty()) {
                        System.out.println("no tasks");
                        break;
                    }
                    for (Task t : tasks) {
                        if (option == t.getId()) {
                            found = true;
                            System.out.println("deleting task...");
                            tasks.remove(t);
                            break;
                        }
                    }
                    if (!found && option != 0) {
                        System.out.println("no task with that id ");
                    }
                }
            } while (option != 0);
        }

    }

    public static void newTask(int id, Scanner sc, ArrayList<Task> tasks) {
        System.out.print("Write your task: ");
        String text = sc.nextLine();
        Task task = new Task(text, false, id);
        tasks.add(task);
    }


    public static void viewTasks(ArrayList<Task> tasks) {
        if (tasks.isEmpty()) {
            System.out.println("no tasks");
        } else {
            for (Task t : tasks) {
                System.out.println(t.getText() + "| is finished?: " + t.isCompleted() + " (id " + t.getId() + ")");
            }
        }

    }

    public static void taskDone(ArrayList<Task> tasks, Scanner sc) {
        int option = 99;
        if (tasks.isEmpty()) {
            System.out.println("no tasks");
        } else {
            do {
                boolean found = false;
                System.out.println("Write the id of the task you want to complete or 0 to exit: ");
                option = Integer.parseInt(sc.nextLine());
                if (tasks.isEmpty()) {
                    System.out.println("no tasks");
                    break;
                }
                for (Task t : tasks) {
                    if (option == t.getId()) {
                        found = true;
                        System.out.println("task is now completed");
                        t.setisCompleted(true);
                    }
                }
                if (!found && option !=0) {
                    System.out.println("no task with that id");
                }
            } while (option != 0);
        }

    }
}

