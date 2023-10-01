/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica.laboratorio1deu;

/**
 *
 * @author Bravo
 */
import java.util.List;

public class Caja {

    private int totalClientesAtendidos;
    private int sumaTiempoAtencion;
    private Cliente clienteActual;
    private int tiempoActual;
    private List<Cliente> filaEspera;
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

    public void atenderCliente(Cliente cliente) {
        clienteActual = cliente;
        tiempoClienteActual = 0;
    }

    public void atenderCliente() {
        if (clienteActual != null) {
            clienteActual.aumentarTiempo();
            tiempoClienteActual++;
            tiempoTotalAtencion++;
            if (clienteActual.getTiempo() >= clienteActual.getTiempoTramiteSegundos()) {
                clienteActual = null;
            }
        }
    }

    @Override
    public String toString() {
        String estado;
        if (clienteActual == null) {
            estado = "------------------------------------" + "\n"
                    + "Caja " + numeroCaja + ": Libre" + "\n"
                    + "Caja " + numeroCaja + " tiempo total de atención: " + tiempoTotalAtencion + " minutos";
        } else {
            estado = "------------------------------------" + "\n"
                    + "Caja " + numeroCaja + ": Atendiendo a Cliente " + clienteActual.getNumeroCliente()
                    + " Prioridad " + clienteActual.getPrioridad() + " Tiempo que lleva en la caja: " + clienteActual.getTiempo() + " minutos" + "\n"
                    + "Caja " + numeroCaja + " tiempo total de atención: " + tiempoTotalAtencion + " minutos";

        }

        return estado;
    }
}
