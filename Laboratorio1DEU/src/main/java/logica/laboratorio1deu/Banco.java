/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica.laboratorio1deu;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Bravo
 */
public class Banco {

    public static void simularBanco(int cantidadClientes) {
        // Inicializa la lista de cajas
        List<Caja> cajas = new ArrayList<>();
        for (int i = 1; i <= 4; i++) {
            cajas.add(new Caja(i));
        }

        // Se inicializa una lista filaEspera de tipo PriorityQueue que compara los clientes por su orden de prioridad A,B,C,D
        Queue<Cliente> filaEspera = new PriorityQueue<>(Comparator.comparing(Cliente::getPrioridad));
        // Llena la lista filaEspera con clientes
        for (int i = 1; i <= cantidadClientes; i++) {
            filaEspera.add(new Cliente(i));
        }

        // se inicializa otra lista para mostrar los clientes comparados en orden de numero
        List<Cliente> clientesOrdenadosPorNumero = new ArrayList<>(filaEspera);
        clientesOrdenadosPorNumero.sort(Comparator.comparing(Cliente::getNumeroCliente));
        System.out.println("Clientes generados:");
        for (Cliente cliente : clientesOrdenadosPorNumero) {
            System.out.println("Cliente " + cliente.getNumeroCliente() + " - Tiquete " + cliente.getPrioridad());
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Pulse intro para iniciar la simulación...");
        scanner.nextLine(); // pedirle al usuario que digite la tecla

        int tiempoTranscurrido = 0;
        // este bucle principal se ejecuta mientras hay clientes esperando o cajas ocupadas.
        while (!filaEspera.isEmpty() || cajas.stream().anyMatch(caja -> !caja.estaLibre())) {
            System.out.print("\033[H\033[2J"); //limpiar la consola, pero no parece funcionar en Net Beans
            System.out.flush();

            for (int i = 0; i < 20; i++) { //entonces voy a imprimir varias lineas en blanco para que parezca que se limpia
                System.out.println("");
            }

            System.out.println("Tiempo transcurrido: " + tiempoTranscurrido + " minutos");
            // Itera sobre todas las cajas
            for (Caja caja : cajas) {
                if (caja.estaLibre() && !filaEspera.isEmpty()) {
                    // Asigna al proximo cliente de la fila a la caja libre
                    Cliente cliente = filaEspera.poll();
                    caja.atenderCliente(cliente);
                    caja.incrementarClientesAtendidos();
                } else {
                    // continua en la atención del cliente actual en la caja
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
        for (int i = 0; i < 10; i++) {
            System.out.println("");
        }

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
