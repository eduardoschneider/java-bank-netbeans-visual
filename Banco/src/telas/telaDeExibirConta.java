/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import banco.Cliente;
import banco.Conta;
import java.awt.Color;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import org.jdesktop.swingx.prompt.PromptSupport;
/**
 *
 * @author eduardo.schneider
 */
public class telaDeExibirConta extends javax.swing.JFrame {

    /**
     * Creates new form telaPrincipalUsuario
     */
    public telaDeExibirConta() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Already there
        this.setUndecorated(true);
        this.setBackground(new Color(0,0,0,0));
        initComponents();
        setLocationRelativeTo(null); //abre a tela no centro 
        
        PromptSupport.setPrompt("CPF", txtCodigo);
        PromptSupport.setForeground(Color.white, txtCodigo);
        
        txtCliente.setBackground(new Color(0, 0, 0, 0));
        txtCliente.setForeground(Color.white);
        txtCodigo.setBackground(new Color(0, 0, 0, 0));
        txtCodigo.setForeground(Color.white);
        txtSaldo.setBackground(new Color(0, 0, 0, 0));
        txtSaldo.setForeground(Color.white);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        txtCliente = new javax.swing.JTextField();
        txtCodigo = new javax.swing.JTextField();
        txtSaldo = new javax.swing.JTextField();
        cancelaCadastroButton = new javax.swing.JButton();
        confirmaCadastroButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Digite o código do alvo:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 210, -1));

        txtCliente.setBackground(new java.awt.Color(102, 0, 0));
        txtCliente.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtCliente.setToolTipText("");
        txtCliente.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        getContentPane().add(txtCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 270, 20));

        txtCodigo.setBackground(new java.awt.Color(102, 0, 0));
        txtCodigo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtCodigo.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        getContentPane().add(txtCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 170, 20));

        txtSaldo.setBackground(new java.awt.Color(102, 0, 0));
        txtSaldo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtSaldo.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        getContentPane().add(txtSaldo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 270, 20));

        cancelaCadastroButton.setBackground(new java.awt.Color(255, 0, 0));
        cancelaCadastroButton.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        cancelaCadastroButton.setForeground(new java.awt.Color(255, 255, 255));
        cancelaCadastroButton.setText("Voltar");
        cancelaCadastroButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelaCadastroButtonActionPerformed(evt);
            }
        });
        getContentPane().add(cancelaCadastroButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 270, -1));

        confirmaCadastroButton1.setBackground(new java.awt.Color(0, 153, 0));
        confirmaCadastroButton1.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        confirmaCadastroButton1.setForeground(new java.awt.Color(255, 255, 255));
        confirmaCadastroButton1.setText("Pesquisar");
        confirmaCadastroButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                confirmaCadastroButton1MouseClicked(evt);
            }
        });
        confirmaCadastroButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmaCadastroButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(confirmaCadastroButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, -1, 20));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/giphy.gif"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 290, 170));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelaCadastroButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelaCadastroButtonActionPerformed
        this.setVisible(false);
        new telaPrincipalAdmin().setVisible(true);
    }//GEN-LAST:event_cancelaCadastroButtonActionPerformed

    private void confirmaCadastroButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_confirmaCadastroButton1MouseClicked

    }//GEN-LAST:event_confirmaCadastroButton1MouseClicked

    private void confirmaCadastroButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmaCadastroButton1ActionPerformed
        List<String> dados = new ArrayList();
        try {
            dados = Conta.pesquisar(txtCodigo.getText());
            txtCliente.setText(dados.get(0));
            txtSaldo.setText(dados.get(1));
        } catch (SQLException ex) {
            Logger.getLogger(telaDeExibirConta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_confirmaCadastroButton1ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelaCadastroButton;
    private javax.swing.JButton confirmaCadastroButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField txtCliente;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtSaldo;
    // End of variables declaration//GEN-END:variables
}
