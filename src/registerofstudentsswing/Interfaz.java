/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package registerofstudentsswing;

import java.io.BufferedWriter;
import javax.swing.UIManager.LookAndFeelInfo;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import static java.lang.System.exit;
import java.util.*;
import javax.swing.JOptionPane;
import static registerofstudentsswing.LibraryFilesDirectoriesSwing.*;

/**
 *
 * @author roroc
 */
public class Interfaz extends javax.swing.JFrame {

    public String nombre;
    public ArrayList<String> registerOfStudents;

    //public WriteStudent write;
    /**
     * Creates new form Interfaz
     */
    public Interfaz() {
        initComponents();
        makeRegister();
        registerOfStudents = readRegisterStudents(false);
        initStudents(registerOfStudents);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jBWrite = new javax.swing.JButton();
        jBRead = new javax.swing.JButton();
        jBDelete = new javax.swing.JButton();
        jBFind = new javax.swing.JButton();
        jBExit = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Hola");
        setBackground(new java.awt.Color(163, 73, 164));
        setForeground(new java.awt.Color(255, 51, 204));

        jPanel1.setBackground(new java.awt.Color(153, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Verdana", 3, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 0, 51));
        jLabel1.setText("Bienvenido al Programa de Gestión de Estudiante");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jBWrite.setText("Write student");
        jBWrite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBWriteActionPerformed(evt);
            }
        });
        jPanel1.add(jBWrite, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 60, 116, -1));

        jBRead.setText("Read all student");
        jBRead.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBReadActionPerformed(evt);
            }
        });
        jPanel1.add(jBRead, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 130, 110, -1));

        jBDelete.setText("Delete student");
        jBDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBDeleteActionPerformed(evt);
            }
        });
        jPanel1.add(jBDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 100, 110, -1));

        jBFind.setText("Find student");
        jBFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBFindActionPerformed(evt);
            }
        });
        jPanel1.add(jBFind, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 170, 110, -1));

        jBExit.setText("Exit program");
        jBExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBExitActionPerformed(evt);
            }
        });
        jPanel1.add(jBExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 210, 110, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/registerofstudentsswing/Captura de pantalla 2025-02-15 011746.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 260, 240, 60));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBWriteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBWriteActionPerformed

        WriteStudent write = new WriteStudent(this, true);
        write.setVisible(true);
    }//GEN-LAST:event_jBWriteActionPerformed

    private void jBReadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBReadActionPerformed

        String alumnos = readRegisterStudentsSwing();
        if (alumnos == null || alumnos.isEmpty()) {
            alumnos = "No hay alumnos registrados.";
        }
        JOptionPane.showMessageDialog(null, "Alumnos:" + alumnos, "Ventana Alumnos", 1);


    }//GEN-LAST:event_jBReadActionPerformed

    private void jBDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBDeleteActionPerformed
        String dni = JOptionPane.showInputDialog(null, "Diga el DNI del alumno a eliminar: ", "Eliminar alumno", 3);
        String estudiante = buscarEstudiante(registerOfStudents, dni);

        if (estudiante != null) {
            registerOfStudents.remove(estudiante);
            for (int i = 0; i < students.size(); i++) {
                StudentS estudianteAborrar = students.get(i);
                if (estudianteAborrar.toString().equals(estudiante)) {
                    students.remove(i);
                    break;
                }
            }
            try {
                FileWriter fw = new FileWriter(register);
                BufferedWriter bw = new BufferedWriter(fw);
                for (int i = 0; i < registerOfStudents.size(); i++) {
                    bw.write(registerOfStudents.get(i));
                    bw.newLine();
                }
                bw.flush();
                bw.close();
                System.out.println("Estudiante eliminado");
            } catch (IOException ex) {
                System.err.println("Error generico");
            }

    }//GEN-LAST:event_jBDeleteActionPerformed
    }
    private void jBFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBFindActionPerformed

        String dni = JOptionPane.showInputDialog(null, "Diga el DNI del alumno: ", "Buscar alumno", 3);
        buscarEstudiante(registerOfStudents, dni);
    }//GEN-LAST:event_jBFindActionPerformed

    private void jBExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jBExitActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBDelete;
    private javax.swing.JButton jBExit;
    private javax.swing.JButton jBFind;
    private javax.swing.JButton jBRead;
    private javax.swing.JButton jBWrite;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
