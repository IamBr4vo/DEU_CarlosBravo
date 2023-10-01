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
    private int tiempo;

    public Cliente(int numeroCliente) {
        this.numeroCliente = numeroCliente;
        this.prioridad = generarPrioridadAleatoria(numeroCliente);
        this.tiempoTramiteSegundos = generarTiempoAleatorio();
        this.tiempo = 0;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public int getTiempo() {
        return tiempo;
    }

    public void aumentarTiempo() {
        tiempo++;
    }

    private int generarTiempoAleatorio() {
        return (int) (Math.random() * 23) + 2; // Entre 2 y 24 
    }

    public int getNumeroCliente() {
        return numeroCliente;
    }

    public int getTiempoTramiteSegundos() {
        return tiempoTramiteSegundos;
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
