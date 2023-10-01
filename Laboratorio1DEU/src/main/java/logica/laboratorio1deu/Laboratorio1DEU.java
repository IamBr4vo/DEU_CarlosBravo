/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package logica.laboratorio1deu;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Bravo
 */
public class Laboratorio1DEU {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("Menú:");
            System.out.println("1. Banco");
            System.out.println("2. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese la cantidad de clientes que llegarán al banco: ");
                    int cantidadClientes = scanner.nextInt();
                    simularBanco(cantidadClientes);
                    break;
                case 2:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        }

        System.out.println("¡Hasta luego!");
        scanner.close();
    }

    public static void simularBanco(int cantidadClientes) {
        List<Caja> cajas = new ArrayList<>();
        Queue<Cliente> filaEspera = new PriorityQueue<>(Comparator.comparing(Cliente::getPrioridad));
        // Inicializa las cajas
        for (int i = 1; i <= 4; i++) {
            cajas.add(new Caja(i));
        }
        // Llena la fila de espera con clientes
        for (int i = 1; i <= cantidadClientes; i++) {
            filaEspera.add(new Cliente(i));
        }

        List<Cliente> clientesOrdenadosPorNumero = new ArrayList<>(filaEspera);
        clientesOrdenadosPorNumero.sort(Comparator.comparing(Cliente::getNumeroCliente));

        System.out.println("Clientes generados1:");
        for (Cliente cliente : clientesOrdenadosPorNumero) {
            System.out.println("Cliente " + cliente.getNumeroCliente() + " - Prioridad " + cliente.getPrioridad());
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Pulse intro para iniciar la simulación...");
        scanner.nextLine(); // pedirle al usuario que digite la tecla

        int tiempoTranscurrido = 0;

        while (!filaEspera.isEmpty() || cajas.stream().anyMatch(caja -> !caja.estaLibre())) {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("");
            System.out.println("");
            System.out.println("Tiempo transcurrido: " + tiempoTranscurrido + " minutos");

            for (Caja caja : cajas) {
                if (caja.estaLibre() && !filaEspera.isEmpty()) {
                    Cliente cliente = filaEspera.poll();
                    caja.atenderCliente(cliente);
                    caja.incrementarClientesAtendidos();
                } else {
                    caja.atenderCliente();
                }
                System.out.println(caja.toString());
            }
            tiempoTranscurrido++;
            try {
                TimeUnit.SECONDS.sleep(1); // Espera 1 segundo para simular el tiempo real
            } catch (InterruptedException e) {
                System.out.println("Error en el temporizador");
            }
        }
        System.out.println("");
        System.out.println("RESUMEN");
        for (Caja caja : cajas) {
            System.out.println("------------------------------------");
            System.out.println("Caja " + caja.getNumeroCaja() + ":");
            System.out.println("Clientes atendidos: " + caja.getClientesAtendidos());
            System.out.println("Tiempo de atención total: " + caja.getTiempoAtencionTotal() + " minutos");
        }
        System.out.println("------------------------------------");
        System.out.println("Total de clientes que entraron en el banco: " + cantidadClientes);
        System.out.println("Todos los clientes han sido atendidos en " + tiempoTranscurrido + " minutos.");
    }
}
