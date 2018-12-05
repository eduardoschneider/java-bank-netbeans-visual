/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import banco.Cliente;
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
public class telaDeCadastroDeCliente extends javax.swing.JFrame {

    /**
     * Creates new form telaPrincipalUsuario
     */
    public telaDeCadastroDeCliente() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Already there
        this.setUndecorated(true);
        this.setBackground(new Color(0,0,0,0));
        initComponents();
        setLocationRelativeTo(null); //abre a tela no centro 
        
        PromptSupport.setPrompt("Nome", txtNome);
        PromptSupport.setPrompt("CPF", txtCPF);
        PromptSupport.setPrompt("Data de Nascimento", txtDataNasc);
        PromptSupport.setPrompt("Login", txtLogin);
        PromptSupport.setPrompt("Senha", txtSenha);
        
        txtNome.setBackground(new Color(0, 0, 0, 0));
        txtCPF.setBackground(new Color(0, 0, 0, 0));
        txtDataNasc.setBackground(new Color(0, 0, 0, 0));
        txtLogin.setBackground(new Color(0, 0, 0, 0));
        txtSenha.setBackground(new Color(0, 0, 0, 0));
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
        txtNome = new javax.swing.JTextField();
        txtCPF = new javax.swing.JTextField();
        txtDataNasc = new javax.swing.JTextField();
        txtLogin = new javax.swing.JTextField();
        txtSenha = new javax.swing.JPasswordField();
        cancelaCadastroButton = new javax.swing.JButton();
        confirmaCadastroButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Digite os dados de cadastro:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 80, 210, 10));

        txtNome.setBackground(new java.awt.Color(204, 0, 51));
        txtNome.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtNome.setToolTipText("");
        txtNome.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        getContentPane().add(txtNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 100, 210, 20));

        txtCPF.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtCPF.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        getContentPane().add(txtCPF, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 130, 210, 20));

        txtDataNasc.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtDataNasc.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        getContentPane().add(txtDataNasc, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 160, 210, 20));

        txtLogin.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtLogin.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        getContentPane().add(txtLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 190, 210, 20));

        txtSenha.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtSenha.setToolTipText("Senha");
        txtSenha.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        getContentPane().add(txtSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 220, 210, 20));

        cancelaCadastroButton.setBackground(new java.awt.Color(255, 0, 0));
        cancelaCadastroButton.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        cancelaCadastroButton.setForeground(new java.awt.Color(255, 255, 255));
        cancelaCadastroButton.setText("Cancelar");
        cancelaCadastroButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelaCadastroButtonActionPerformed(evt);
            }
        });
        getContentPane().add(cancelaCadastroButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 250, 100, 20));

        confirmaCadastroButton1.setBackground(new java.awt.Color(0, 153, 0));
        confirmaCadastroButton1.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        confirmaCadastroButton1.setForeground(new java.awt.Color(255, 255, 255));
        confirmaCadastroButton1.setText("Cadastrar");
        confirmaCadastroButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                confirmaCadastroButton1MouseClicked(evt);
            }
        });
        getContentPane().add(confirmaCadastroButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 250, 100, 20));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bgcrud.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 680, 510));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelaCadastroButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelaCadastroButtonActionPerformed
        this.setVisible(false);
        new telaPrincipalAdmin().setVisible(true);
    }//GEN-LAST:event_cancelaCadastroButtonActionPerformed

    private void confirmaCadastroButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_confirmaCadastroButton1MouseClicked
        try {
            Cliente a = new Cliente();
            a.cadastrarCliente(txtNome.getText(), txtCPF.getText(), txtDataNasc.getText(), txtLogin.getText(), txtSenha.getText());
            this.setVisible(false);
            new telaPrincipalAdmin().setVisible(true);
        } catch (SQLException | ParseException ex) {
            Logger.getLogger(telaDeCadastroDeCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_confirmaCadastroButton1MouseClicked

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelaCadastroButton;
    private javax.swing.JButton confirmaCadastroButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField txtCPF;
    private javax.swing.JTextField txtDataNasc;
    private javax.swing.JTextField txtLogin;
    private javax.swing.JTextField txtNome;
    private javax.swing.JPasswordField txtSenha;
    // End of variables declaration//GEN-END:variables
}
