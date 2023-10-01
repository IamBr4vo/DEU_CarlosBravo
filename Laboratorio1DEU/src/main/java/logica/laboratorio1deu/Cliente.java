/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica.laboratorio1deu;

import java.util.*;

/**
 *
 * @author Bravo
 */
public class Cliente {

    private int numeroCliente;
    private String prioridad;
    private int tiempoTramiteSegundos;

    public Cliente(int numeroCliente) {
        this.numeroCliente = numeroCliente;
        this.prioridad = generarPrioridadAleatoria(numeroCliente);
        this.tiempoTramiteSegundos = generarTiempoAleatorio();
    }

    public Cliente(String prioridad, int tiempoTramiteSegundos) {
        this.prioridad = generarPrioridadAleatoria(numeroCliente);
        this.tiempoTramiteSegundos = generarTiempoAleatorio();
    }

    public int getNumeroCliente() {
        return numeroCliente;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public int getTiempoTramiteSegundos() {
        return tiempoTramiteSegundos;
    }

    private int generarTiempoAleatorio() {
        Random rand = new Random();
        return rand.nextInt(24) + 2;// 2 segundos como mínimo, 25 segundos como máximo
    }

    private String generarPrioridadAleatoria(int numeroCliente) {
        Random rand = new Random();
        int randomPriority = rand.nextInt(4);
        char prioridadLetra;
        switch (randomPriority) {
            case 0:
                prioridadLetra = 'A';
                break;
            case 1:
                prioridadLetra = 'B';
                break;
            case 2:
                prioridadLetra = 'C';
                break;
            default:
                prioridadLetra = 'D';
                break;
        }
        return prioridadLetra + Integer.toString(numeroCliente); // Combina letra de prioridad con número de cliente
    }
}
