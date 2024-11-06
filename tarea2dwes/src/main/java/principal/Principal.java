package principal;

import java.util.Scanner;

import control.ViveroController;

public class Principal {
    private static ViveroController controller = ViveroController.getInstance();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("Menú Principal");
            System.out.println("1. Registrar nueva planta");
            System.out.println("2. Ver todas las plantas");
            System.out.println("3. Salir");
            int opcion = scanner.nextInt();
            scanner.nextLine();  // Limpia el buffer

            switch (opcion) {
                case 1:
                    System.out.print("Código: ");
                    String codigo = scanner.nextLine();
                    System.out.print("Nombre Común: ");
                    String nombreComun = scanner.nextLine();
                    System.out.print("Nombre Científico: ");
                    String nombreCientifico = scanner.nextLine();
                    controller.registrarNuevaPlanta(codigo, nombreComun, nombreCientifico);
                    break;
                case 2:
                    controller.mostrarTodasLasPlantas();
                    break;
                case 3:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        }
        scanner.close();
    }
}
