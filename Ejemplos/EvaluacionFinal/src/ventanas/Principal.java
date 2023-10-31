/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ventanas;

import herramientas.Archivo;
import herramientas.Varias;
import java.awt.Color;
import java.io.File;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author sebastian
 */
public class Principal extends javax.swing.JFrame {

    herramientas.Varias herrVarias = new Varias();
    herramientas.Archivo herrArchivo = new Archivo();
    File archivoConfig = new File("config.txt");
    
    Inicio ventanaInicio;
    int valorApuesta = 0;
    int puntos = 100;
    String jugador;
    String jugadorMax;
    int puntosMax;
    
    /**
     * Creates new form Principal
     */
    public Principal() {
        initComponents();
        lbl_puntos.setText(puntos+"");
    }
    
    //BLOQUE
    public Principal(Inicio inicio,String jugador){
        initComponents();
        this.ventanaInicio = inicio;
        lbl_puntos.setText(puntos+"");
        this.jugador = jugador;
        lbl_jugador.setText(jugador);
        
        
        String datosArchivo = herrArchivo.leerArchivo(archivoConfig);
        String[] datosJuego = datosArchivo.split(":");
        jugadorMax = datosJuego[0];
        puntosMax = Integer.parseInt(datosJuego[1].strip());
        
        lbl_puntosMax.setText(puntosMax + " de " + jugadorMax);
        
    }
    
    public void agregarBorde(JButton boton){
        boton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
    }
    
    public void quitarBorde(JButton boton){
        boton.setBorder(null);
    }
    //FIN DEL BLOQUE
    
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_puntos = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btn_azul = new javax.swing.JButton();
        btn_rojo = new javax.swing.JButton();
        btn_amarillo = new javax.swing.JButton();
        btn_verde = new javax.swing.JButton();
        btn_resultado = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        lbl_puntosMax = new javax.swing.JLabel();
        btn_apostar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        lbl_jugador = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lbl_puntos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_puntos.setText("---");

        jLabel2.setFont(new java.awt.Font("Liberation Sans", 1, 13)); // NOI18N
        jLabel2.setText("Puntos:");

        btn_azul.setBackground(new java.awt.Color(0, 0, 255));
        btn_azul.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_azulMouseClicked(evt);
            }
        });

        btn_rojo.setBackground(new java.awt.Color(255, 0, 0));
        btn_rojo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_rojoMouseClicked(evt);
            }
        });

        btn_amarillo.setBackground(new java.awt.Color(255, 255, 0));
        btn_amarillo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_amarilloMouseClicked(evt);
            }
        });

        btn_verde.setBackground(new java.awt.Color(0, 204, 0));
        btn_verde.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_verdeMouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Liberation Sans", 1, 13)); // NOI18N
        jLabel3.setText("Puntaje Máximo:");

        lbl_puntosMax.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_puntosMax.setText("---");

        btn_apostar.setText("Apostar");
        btn_apostar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_apostarMouseClicked(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Liberation Sans", 1, 13)); // NOI18N
        jLabel4.setText("Jugador:");

        lbl_jugador.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_jugador.setText("---");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_puntosMax, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(btn_apostar))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn_rojo, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_azul, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn_verde, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_amarillo, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_resultado, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbl_jugador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbl_puntos, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbl_puntosMax)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_azul, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_rojo, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_amarillo, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_verde, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_jugador)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_puntos)
                            .addComponent(jLabel2))
                        .addGap(48, 48, 48)
                        .addComponent(btn_resultado, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(btn_apostar)
                .addGap(14, 14, 14))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //BLOQUE 4
    private void btn_apostarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_apostarMouseClicked
        
        if (valorApuesta == 0) {
            JOptionPane.showMessageDialog(this, "Debes elegir un color");
        } else {
            int valorResultado = herrVarias.alAzarEntre(1, 4);
            switch (valorResultado) {
                case 1:
                    btn_resultado.setBackground(Color.red);
                    break;
                case 2:
                    btn_resultado.setBackground(Color.blue);
                    break;
                case 3:
                    btn_resultado.setBackground(Color.green);
                    break;
                case 4:
                    btn_resultado.setBackground(Color.yellow);
                    break;
            }

            if (valorResultado == valorApuesta) {
                JOptionPane.showMessageDialog(this, "Ganaste");
                puntos += 10;
            } else {
                JOptionPane.showMessageDialog(this, "Perdiste");
                puntos -= 10;
            }
            
            lbl_puntos.setText(puntos+"");
            
            quitarBorde(btn_amarillo);
            quitarBorde(btn_azul);
            quitarBorde(btn_verde);
            quitarBorde(btn_rojo);
            
            if (puntos == 0) {
                JOptionPane.showMessageDialog(this, 
                        "Ya no te quedan puntos.\nFin del juego.");
                ventanaInicio.setVisible(true);
                this.dispose();
            }
            if (puntos > puntosMax){
                
                puntosMax = puntos;
                jugadorMax = jugador;
                lbl_puntosMax.setText(puntosMax + " de " + jugadorMax);
                
                herrArchivo.guardarArchivo(
                        jugadorMax+":"+puntosMax, archivoConfig);
            }
        }
        
    }//GEN-LAST:event_btn_apostarMouseClicked
//FIN DEL BLOQUE 4
    
    
    //BLOQUE 1
    private void btn_rojoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_rojoMouseClicked
        agregarBorde(btn_rojo);
        quitarBorde(btn_amarillo);
        quitarBorde(btn_azul);
        quitarBorde(btn_verde);
        valorApuesta = 1;
    }//GEN-LAST:event_btn_rojoMouseClicked

    private void btn_azulMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_azulMouseClicked
        agregarBorde(btn_azul);
        quitarBorde(btn_amarillo);
        quitarBorde(btn_rojo);
        quitarBorde(btn_verde);
        valorApuesta = 2;
    }//GEN-LAST:event_btn_azulMouseClicked

    private void btn_verdeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_verdeMouseClicked
        agregarBorde(btn_verde);
        quitarBorde(btn_amarillo);
        quitarBorde(btn_azul);
        quitarBorde(btn_rojo);
        valorApuesta = 3;
    }//GEN-LAST:event_btn_verdeMouseClicked

    private void btn_amarilloMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_amarilloMouseClicked
        agregarBorde(btn_amarillo);
        quitarBorde(btn_verde);
        quitarBorde(btn_azul);
        quitarBorde(btn_rojo);
        valorApuesta = 4;
    }//GEN-LAST:event_btn_amarilloMouseClicked
//FIN DEL BLOQUE 1
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_amarillo;
    private javax.swing.JButton btn_apostar;
    private javax.swing.JButton btn_azul;
    private javax.swing.JButton btn_resultado;
    private javax.swing.JButton btn_rojo;
    private javax.swing.JButton btn_verde;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lbl_jugador;
    private javax.swing.JLabel lbl_puntos;
    private javax.swing.JLabel lbl_puntosMax;
    // End of variables declaration//GEN-END:variables
}
