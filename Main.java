import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        do {
            System.out.println("----- Opciones -----");
            System.out.println("1. Crear tarea");
            System.out.println("2. Borrar tarea");
            System.out.println("3. Salir");

            System.out.println("escriba el numero: ");
            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {
                case 1 -> System.out.println("tarea creada");
                case 2 -> System.out.println("tarea borrada");
                case 3 -> System.out.println("saliendo...");
                default -> System.out.println("numero no valido");
            }
        } while (opcion != 3);


    }
}
