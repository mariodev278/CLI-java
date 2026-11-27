import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Task> tasks = new ArrayList<>();
        int opcion = 0;
        int id = 0;
        do {
            System.out.println("----- options -----");
            System.out.println("1. new task");
            System.out.println("2. delete task");
            System.out.println("3. view tasks");
            System.out.println("4. complete a task");
            System.out.println("5. exit");

            System.out.println("write a number: ");
            opcion = errorNumberCatch(sc);

            switch (opcion) {
                case 1 -> {
                    id++;
                    newTask(id, sc, tasks);
                }
                case 2 -> deleteTask(tasks,sc, opcion);
                case 3 -> viewTasks(tasks);
                case 4 -> taskDone(tasks, sc, opcion);
                case 5 -> System.out.println("closing...");
                default -> System.out.println("incorrect number");
            }


        } while (opcion != 5);
    }

    public static void deleteTask(ArrayList<Task> tasks,Scanner sc, int opcion) {
        if (tasks.isEmpty()) {
            System.out.println("no tasks");
        } else {
            searchById(tasks, sc, opcion);
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

    public static void taskDone(ArrayList<Task> tasks, Scanner sc, int opcion) {
        if (tasks.isEmpty()) {
            System.out.println("no tasks");
        } else {
            searchById(tasks, sc, opcion);
        }

    }

    public static void searchById(ArrayList<Task> tasks, Scanner sc, int opcion){
        int option;
        do {
            boolean found = false;
            if (tasks.isEmpty()) {
                System.out.println("no tasks");
                break;
            }
            System.out.println("Write the id of the task you want to complete or 0 to exit: ");
            option = errorNumberCatch(sc);
            for (Task t : tasks) {
                if (option == t.getId()) {
                    if (opcion == 4) {
                        found = true;
                        System.out.println("task is now completed");
                        t.setisCompleted(true);
                    }
                    if (opcion == 2) {
                        if (option == t.getId()) {
                            found = true;
                            System.out.println("deleting task...");
                            tasks.remove(t);
                            break;
                        }
                    }
                }
            }
            if (!found && option !=0) {
                System.out.println("no task with that id");
            }
        } while (option != 0);
    }

    public static int errorNumberCatch(Scanner sc) {

        do {
            try {
                return Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("error encountered:" + e.getMessage() + "try again: ");
            }
        } while (true);

    }


}

