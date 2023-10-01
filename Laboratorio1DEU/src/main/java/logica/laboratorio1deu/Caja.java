/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica.laboratorio1deu;

/**
 *
 * @author Bravo
 */
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Caja {

    private JTable tablaCaja;
    private DefaultTableModel modeloCaja;
    private int totalClientesAtendidos;
    private int sumaTiempoAtencion;

    public Caja(JTable tablaCaja) {
        this.tablaCaja = tablaCaja;
        modeloCaja = (DefaultTableModel) tablaCaja.getModel();
        totalClientesAtendidos = 0;
        sumaTiempoAtencion = 0;
    }

    public int totalClientesAtendidos() {
        return totalClientesAtendidos;
    }

    public int getSumaTiempoAtencion() {
        return sumaTiempoAtencion;
    }

    public void aumentarSumaTiempoAtencion(int tiempo) {
        sumaTiempoAtencion += tiempo;
    }

    public JTable getTablaCaja() {
        return tablaCaja;
    }

    public void setTablaCaja(JTable tablaCaja) {
        this.tablaCaja = tablaCaja;
    }

    public DefaultTableModel getModeloCaja() {
        return modeloCaja;
    }

    public void setModeloCaja(DefaultTableModel modeloCaja) {
        this.modeloCaja = modeloCaja;
    }

    public void agregarCliente(String prioridad, int tiempoTramite) {
        getModeloCaja().addRow(new Object[]{prioridad, tiempoTramite, tiempoTramite});
    }

    public boolean estaDisponible() {
        return getModeloCaja().getRowCount() == 0;
    }

    public void atenderClientes() {
        for (int i = 0; i < getModeloCaja().getRowCount(); i++) {
            int tiempoRestante = (int) getModeloCaja().getValueAt(i, 2);
            if (tiempoRestante > 0) {
                getModeloCaja().setValueAt(tiempoRestante - 1, i, 2);
            } else {
                getModeloCaja().removeRow(i);
                i--;
            }
        }
    }

    public void actualizarCaja() {
        for (int i = 0; i < getModeloCaja().getRowCount(); i++) {
            int tiempoRestante = (int) getModeloCaja().getValueAt(i, 2);
            getModeloCaja().setValueAt(tiempoRestante, i, 2);
        }
    }

    public void eliminarClienteActual() {
        getModeloCaja().removeRow(0);
    }

    public boolean clienteActualTerminado() {
        if (getModeloCaja().getRowCount() > 0) {
            int tiempoRestante = (int) getModeloCaja().getValueAt(0, 2);
            return tiempoRestante == 0;
        }
        return false;
    }
}
