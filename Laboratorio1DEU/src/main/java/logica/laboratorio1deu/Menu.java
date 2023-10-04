/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica.laboratorio1deu;

import java.util.Scanner;

/**
 *
 * @author Bravo
 */
public class Menu {

    public static void iniciarMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("Menú:");
            System.out.println("1. Banco");
            System.out.println("2. Salir");
            System.out.print("Seleccione una opción: ");

            try {
                int opcion = scanner.nextInt();

                switch (opcion) {
                    case 1:
                        int cantidadClientes;
                        do {
                            System.out.print("Ingrese la cantidad de clientes que llegarán al banco: ");
                            while (!scanner.hasNextInt()) {
                                System.out.println("Error: Debe ingresar un número válido.");
                                scanner.nextLine();
                            }
                            cantidadClientes = scanner.nextInt();
                        } while (cantidadClientes <= 0); // Valida que sea un número positivo
                        Banco.simularBanco(cantidadClientes);
                        break;
                    case 2:
                        salir = true;
                        break;
                    default:
                        System.out.println("Opción no válida. Intente de nuevo.");
                        break;
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Error: Debe ingresar un número válido.");
                scanner.nextLine(); // Limpiar el búfer del scanner
            }
        }

        System.out.println("¡Hasta luego!");
        scanner.close();
    }
}
