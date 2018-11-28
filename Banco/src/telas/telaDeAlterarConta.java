/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import banco.Cliente;
import banco.Conta;
import banco.Poupanca;
import java.awt.Color;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import org.jdesktop.swingx.prompt.PromptSupport;
/**
 *
 * @author eduardo.schneider
 */
public class telaDeAlterarConta extends javax.swing.JFrame {

    /**
     * Creates new form telaPrincipalUsuario
     */
    public telaDeAlterarConta() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Already there
        this.setUndecorated(true);
        this.setBackground(new Color(0,0,0,0));
        initComponents();
        setLocationRelativeTo(null); //abre a tela no centro 
        
        PromptSupport.setPrompt("Código Novo", txtCodigoNovo);
        PromptSupport.setPrompt("Código Atual", txtCodigoVelho);
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
        jLabel2 = new javax.swing.JLabel();
        txtCodigoNovo = new javax.swing.JTextField();
        txtCodigoVelho = new javax.swing.JTextField();
        cancelaCadastroButton = new javax.swing.JButton();
        confirmaAlterarButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Digite a código que deseja alterar:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, 210, -1));

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Novo código:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 230, 210, -1));

        txtCodigoNovo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtCodigoNovo.setToolTipText("");
        txtCodigoNovo.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        getContentPane().add(txtCodigoNovo, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 250, 210, 30));

        txtCodigoVelho.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtCodigoVelho.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        getContentPane().add(txtCodigoVelho, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, 210, 30));

        cancelaCadastroButton.setBackground(new java.awt.Color(255, 0, 0));
        cancelaCadastroButton.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        cancelaCadastroButton.setForeground(new java.awt.Color(255, 255, 255));
        cancelaCadastroButton.setText("Cancelar");
        cancelaCadastroButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelaCadastroButtonActionPerformed(evt);
            }
        });
        getContentPane().add(cancelaCadastroButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 360, 210, 40));

        confirmaAlterarButton1.setBackground(new java.awt.Color(0, 153, 0));
        confirmaAlterarButton1.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        confirmaAlterarButton1.setForeground(new java.awt.Color(255, 255, 255));
        confirmaAlterarButton1.setText("Alterar");
        confirmaAlterarButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmaAlterarButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(confirmaAlterarButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 310, 210, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/prancheta.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 340, 510));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelaCadastroButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelaCadastroButtonActionPerformed
        this.setVisible(false);
        new telaPrincipalAdmin().setVisible(true);
    }//GEN-LAST:event_cancelaCadastroButtonActionPerformed

    private void confirmaAlterarButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmaAlterarButton1ActionPerformed
        try {
            Conta a = new Conta();
            a.alterarConta(txtCodigoVelho.getText(), txtCodigoNovo.getText());
            this.setVisible(false);
            new telaPrincipalAdmin().setVisible(true);
        } catch (SQLException | ParseException ex) {
            Logger.getLogger(telaDeCadastroDeConta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_confirmaAlterarButton1ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelaCadastroButton;
    private javax.swing.JButton confirmaAlterarButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField txtCodigoNovo;
    private javax.swing.JTextField txtCodigoVelho;
    // End of variables declaration//GEN-END:variables
}