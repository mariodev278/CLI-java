import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String pass = "";
        do {
            System.out.println("----- Opciones -----");
            System.out.println("1. Crear tarea");
            System.out.println("2. Borrar tarea");
            System.out.println("3. Salir");
            pass = sc.nextLine();
        } while (pass.isEmpty());
    }
}
