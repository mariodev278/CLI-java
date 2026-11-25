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
            System.out.println("4. exit");

            System.out.println("write a number: ");
            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {
                case 1 -> {
                    id++;
                    newTask(id, sc, tasks);
                }
                case 2 -> System.out.println("task deleted");
                case 3 -> viewTasks(tasks);
                case 4 -> System.out.println("closing...");
                default -> System.out.println("incorrect number");
            }


        } while (opcion != 4);
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
                System.out.println(t.getText() + " finished?: " + t.isCompleted() + " id " + t.getId());
            }
        }

    }
}

