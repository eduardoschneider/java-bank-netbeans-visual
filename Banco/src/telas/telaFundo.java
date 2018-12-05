/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import banco.Conta;
import banco.Fundo;
import java.awt.Color;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author eduardo.schneider
 */
public class telaFundo extends javax.swing.JFrame {

    /**
     * Creates new form telaDeSaque
     */
    public telaFundo() throws ParseException {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Already there
        this.setUndecorated(true);
        this.setBackground(new Color(0,0,0,0));
        initComponents();
        setLocationRelativeTo(null);
        mao.setVisible(false);
        card.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        txtFundo = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        card = new javax.swing.JLabel();
        maoComCartao = new javax.swing.JLabel();
        mao = new javax.swing.JLabel();
        confirmaDepositoButton = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        txtValor = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton2.setBackground(new java.awt.Color(102, 0, 0));
        jButton2.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Voltar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 200, 70, 20));

        txtFundo.setBackground(new java.awt.Color(236, 217, 205));
        txtFundo.setBorder(null);
        txtFundo.setForeground(new java.awt.Color(0, 0, 0));
        txtFundo.setText("1");
        txtFundo.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jPanel1.add(txtFundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 320, 130, 20));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Digite o código do Fundo:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 300, 140, 20));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/11111card.jpg"))); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(416, 244, 80, 40));

        card.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        card.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/card.png"))); // NOI18N
        jPanel1.add(card, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 260, 50, 70));

        maoComCartao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/mao c card.png"))); // NOI18N
        maoComCartao.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel1.add(maoComCartao, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 260, 230, 290));

        mao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/mao.png"))); // NOI18N
        mao.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel1.add(mao, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, 320, 200));

        confirmaDepositoButton.setBackground(new java.awt.Color(0, 153, 0));
        confirmaDepositoButton.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        confirmaDepositoButton.setForeground(new java.awt.Color(255, 255, 255));
        confirmaDepositoButton.setText("Depositar");
        confirmaDepositoButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                confirmaDepositoButtonMouseClicked(evt);
            }
        });
        confirmaDepositoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmaDepositoButtonActionPerformed(evt);
            }
        });
        jPanel1.add(confirmaDepositoButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 350, 90, 20));

        jButton1.setBackground(new java.awt.Color(102, 0, 0));
        jButton1.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Sacar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 350, 70, 20));

        txtValor.setBackground(new java.awt.Color(236, 217, 205));
        txtValor.setBorder(null);
        txtValor.setForeground(new java.awt.Color(0, 0, 0));
        txtValor.setText("R$ 00,00");
        txtValor.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jPanel1.add(txtValor, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 280, 140, 20));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Digite o valor:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 260, 80, 20));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/11111.jpg"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 620, 550));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void confirmaDepositoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmaDepositoButtonActionPerformed

        mao.setVisible(true);
        card.setVisible(true);
        maoComCartao.setVisible(false);
        int delayCartao = 100;
        int delay = 100;   // delay de 5 seg.
        int interval = 150;  // intervalo de 1 seg.
        int intervalMao = 150;
        Timer timer = new Timer();
        
        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                card.setBounds(420, 250, 70, 140);
            }
        }, delayCartao, interval);
        
        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                card.setBounds(420, 250, 70, 110);
            }
        }, delayCartao, interval);
        
        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                card.setBounds(420, 250, 70, 80);
            }
        }, delayCartao, interval);
        
        /////////////////////////////////////////////////////////////////////
        
        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                mao.setBounds(26, 350, 320, 200);
                confirmaDepositoButton.setBackground(new Color(0,102,0));
            }
            
        }, delay, intervalMao);
        
        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                mao.setBounds(20, 350, 320, 200);
                confirmaDepositoButton.setBackground(new Color(0,153,0));
            }
            
        }, delay, intervalMao);
       
        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                close();
                timer.cancel();
            }
            
        }, 2300, 1);
    }//GEN-LAST:event_confirmaDepositoButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            Fundo.sacar(txtFundo.getText(), Double.parseDouble(txtValor.getText()));
        } catch (SQLException ex) {
            Logger.getLogger(telaFundo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void confirmaDepositoButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_confirmaDepositoButtonMouseClicked
        try {
            Fundo.depositarFundo(txtFundo.getText(), Double.parseDouble(txtValor.getText()));
        } catch (SQLException ex) {
            Logger.getLogger(telaFundo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_confirmaDepositoButtonMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
    }//GEN-LAST:event_jButton2ActionPerformed

    
    public void close(){
        this.setVisible(false);
        new telaPrincipalUsuario().setVisible(true);
    }
    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel card;
    private javax.swing.JButton confirmaDepositoButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel mao;
    private javax.swing.JLabel maoComCartao;
    private javax.swing.JFormattedTextField txtFundo;
    private javax.swing.JFormattedTextField txtValor;
    // End of variables declaration//GEN-END:variables
}
