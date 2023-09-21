/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package View;

import javax.swing.JOptionPane;
import javax.swing.tree.*;

/**
 *
 * @author Bravo
 */
public class JTree extends javax.swing.JDialog {

    DefaultMutableTreeNode Titulo = null;
    DefaultTreeModel modelo = null;

    /**
     * Creates new form JTree
     */
    public JTree(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        jTree1.setModel(cargarArbol());
    }

    public DefaultTreeModel cargarArbol() {
        DefaultMutableTreeNode categorias = null;
        DefaultMutableTreeNode subcategoria = null;
        Titulo = new DefaultMutableTreeNode("Centro de Administración");
        modelo = new DefaultTreeModel(Titulo);
        categorias = new DefaultMutableTreeNode("Adm. Redes");
        subcategoria = new DefaultMutableTreeNode("Dept. de planificación");
        modelo.insertNodeInto(categorias, Titulo, 0);
        modelo.insertNodeInto(subcategoria, categorias, 0);
        categorias = new DefaultMutableTreeNode("Adm. de Laboratorios");
        subcategoria = new DefaultMutableTreeNode("Dept. de Tecnologia");
        modelo.insertNodeInto(categorias, Titulo, 1);
        modelo.insertNodeInto(subcategoria, categorias, 0);
        categorias = new DefaultMutableTreeNode("Dept. de Investigación");
        subcategoria = new DefaultMutableTreeNode("Dept. A");
        modelo.insertNodeInto(categorias, Titulo, 2);
        modelo.insertNodeInto(subcategoria, categorias, 0);
        return modelo;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jScrollPane1.setViewportView(jTree1);

        jButton1.setText("Agregar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Remover");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Informacion");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Modificar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String cadena = JOptionPane.showInputDialog(this, "Ingrese un departamento");
        DefaultMutableTreeNode parentNodo = null;
        TreePath parentPath = jTree1.getSelectionPath();

        if (parentPath == null) {

        } else {
            parentNodo = (DefaultMutableTreeNode) parentPath.getLastPathComponent();
        }
        DefaultMutableTreeNode child = new DefaultMutableTreeNode(cadena);
        modelo.insertNodeInto(child, parentNodo, parentNodo.getChildCount());
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        DefaultMutableTreeNode parentNode = null;
        TreePath currentSelection = jTree1.getSelectionPath();
        if (currentSelection != null) {
            parentNode = (DefaultMutableTreeNode) currentSelection.getLastPathComponent();
            DefaultTreeModel model = ((DefaultTreeModel) jTree1.getModel());
            model.removeNodeFromParent(parentNode);
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) jTree1.getLastSelectedPathComponent();
        if (node == null) //Nothing is selected.
        {
            return;
        }
        Object nodeInfo = node.getUserObject();
        JOptionPane.showMessageDialog(this, nodeInfo.toString());
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) jTree1.getLastSelectedPathComponent();
        if (node == null) //Nothing is selected.
        {
            return;
        }
        Object nodeInfo = node.getUserObject();
        String cadena = JOptionPane.showInputDialog(this, "Ingrese el nuevo nombre", nodeInfo.toString());
        TreePath currentSelection = jTree1.getSelectionPath();
        if (currentSelection != null) {
            node = (DefaultMutableTreeNode) currentSelection.getLastPathComponent();
            node.setUserObject(cadena);
            DefaultTreeModel model = ((DefaultTreeModel) jTree1.getModel());
            model.nodeChanged(node);
        }

    }//GEN-LAST:event_jButton4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTree jTree1;
    // End of variables declaration//GEN-END:variables
}
