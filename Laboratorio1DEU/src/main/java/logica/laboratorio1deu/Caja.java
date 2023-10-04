/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica.laboratorio1deu;

/**
 *
 * @author Bravo
 */
public class Caja {

    private int totalClientesAtendidos;
    private Cliente clienteActual;
    private int numeroCaja;
    private int tiempoTotalAtencion;
    private int tiempoClienteActual;
    private int clientesAtendidos;

    public Caja(int numeroCaja) {
        this.numeroCaja = numeroCaja;
        this.clienteActual = null;
        clientesAtendidos = 0;
        this.tiempoTotalAtencion = 0;
        this.tiempoClienteActual = 0;
    }

    public int totalClientesAtendidos() {
        return totalClientesAtendidos;
    }

    public int getNumeroCaja() {
        return numeroCaja;
    }

    public Cliente getClienteActual() {
        return clienteActual;
    }

    public int getClientesAtendidos() {
        return clientesAtendidos;
    }

    public int getTiempoAtencionTotal() {
        return tiempoTotalAtencion;
    }

    public int incrementarClientesAtendidos() {
        return clientesAtendidos++;
    }

    public boolean estaLibre() {
        return clienteActual == null;
    }

    // metodo para asignar un cliente para ser atendido en una caja
    public void atenderCliente(Cliente cliente) {
        clienteActual = cliente;
        tiempoClienteActual = 0;
    }

    // metodo para continar atendiendo al cliente actual.
    public void atenderCliente() {
        if (clienteActual != null) { // verifica si hay un cliente actual para atender
            clienteActual.aumentarTiempo();
            tiempoClienteActual++;
            tiempoTotalAtencion++;
            if (clienteActual.getTiempo() >= clienteActual.getTiempoTramiteSegundos()) {   //Verifica si el cliente ha sido atendido completamente
                clienteActual = null; // marca la caja como libre
            }
        }
    }

    //metodo toString para mostrar el estado de las caja
    @Override
    public String toString() {
        String estado;
        if (clienteActual == null) {
            estado = "------------------------------------" + "\n"
                    + "\n"
                    + "Caja " + numeroCaja + ": Libre" + "\n"
                    + "Caja " + numeroCaja + " Tiempo total de atención: " + tiempoTotalAtencion + " minutos." + "\n";
        } else {
            estado = "------------------------------------" + "\n"
                    + "\n"
                    + "Caja " + numeroCaja + ": Atendiendo a Cliente " + clienteActual.getNumeroCliente()
                    + " Con tiquete: " + clienteActual.getPrioridad() + " Tiempo que lleva siendo atendido: " + clienteActual.getTiempo() + " minutos." + "\n"
                    + "Caja " + numeroCaja + " Tiempo total de atención: " + tiempoTotalAtencion + " minutos." + "\n";
        }
        return estado;
    }
}
