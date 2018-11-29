/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import banco.Cliente;
import banco.RoundedBorder;
import conexao.ConnectionFactory;
import java.awt.Color;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author eduardo.schneider
 */
public class telaDeLogin extends javax.swing.JFrame {
    /**
     * Creates new form telaDeLogin
     */
    public telaDeLogin() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Already there
        this.setUndecorated(true);
        this.setBackground(new Color(0,0,0,0));
        initComponents();

        setLocationRelativeTo(null); //abre a tela no centro
        txtLogin.setForeground(Color.gray);

        btnEntrar.setBorder(new RoundedBorder(15));
        btnEntrar.setForeground(Color.black);
        txtFocus.requestFocus();
        ConnectionFactory con = new ConnectionFactory();
        con.conectar();   
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        txtFocus = new javax.swing.JTextField();
        admRadio = new javax.swing.JRadioButton();
        txtLogin = new javax.swing.JTextField();
        txtSenha = new javax.swing.JPasswordField();
        btnEntrar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        jLabel2.setText("jLabel2");

        txtFocus.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        admRadio.setBackground(new java.awt.Color(255, 255, 255));
        admRadio.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        admRadio.setText("Admin");
        admRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                admRadioActionPerformed(evt);
            }
        });
        getContentPane().add(admRadio, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 270, 60, 30));

        txtLogin.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtLogin.setText("CPF");
        txtLogin.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txtLogin.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtLoginFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtLoginFocusLost(evt);
            }
        });
        getContentPane().add(txtLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 270, 190, 34));

        txtSenha.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtSenha.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        getContentPane().add(txtSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 310, 190, 34));

        btnEntrar.setBackground(new java.awt.Color(255, 255, 255));
        btnEntrar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnEntrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/key.png"))); // NOI18N
        btnEntrar.setBorder(null);
        btnEntrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEntrarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEntrarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEntrarMouseExited(evt);
            }
        });
        getContentPane().add(btnEntrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 360, 50, 40));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Sair");
        jLabel5.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 400, 70, -1));

        jLabel4.setBackground(new java.awt.Color(204, 0, 51));
        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel4.setText("Copyright © Eduardo Schneider - 2018 - All Rights Reserved ");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 200, -1, 20));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/backgroundLOGIN.png"))); // NOI18N
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, -10, 590, 530));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtLoginFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtLoginFocusGained
        if (txtLogin.getText().equals("CPF"))
            txtLogin.setText("");
        txtLogin.setForeground(Color.black);
    }//GEN-LAST:event_txtLoginFocusGained

    private void txtLoginFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtLoginFocusLost
        if (txtLogin.getText().equals("")){
            txtLogin.setText("CPF");
            txtLogin.setForeground(Color.gray);
        }
    }//GEN-LAST:event_txtLoginFocusLost

    private void btnEntrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEntrarMouseEntered
        btnEntrar.setBackground(Color.black);
        
    }//GEN-LAST:event_btnEntrarMouseEntered

    private void btnEntrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEntrarMouseExited
        btnEntrar.setBackground(Color.white);
        btnEntrar.setForeground(Color.black);
    }//GEN-LAST:event_btnEntrarMouseExited

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel5MouseClicked

    private void admRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_admRadioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_admRadioActionPerformed

    private void btnEntrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEntrarMouseClicked
        if (!admRadio.isSelected()) {
            try {
                if (Cliente.logar(txtLogin.getText(), txtSenha.getText())){
                    this.setVisible(false);
                    new telaPrincipalUsuario().setVisible(true);
                } else
                {
                    JFrame frame = new JFrame("");
                    JOptionPane.showMessageDialog(frame,"Usuário ou Senha inválidos.",
                        "ERRO",JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(telaDeLogin.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else
        {
            this.setVisible(false);
            new telaPrincipalAdmin().setVisible(true);
        }
        
    }//GEN-LAST:event_btnEntrarMouseClicked
       
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
            java.util.logging.Logger.getLogger(telaDeLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(telaDeLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(telaDeLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(telaDeLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new telaDeLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton admRadio;
    private javax.swing.JButton btnEntrar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField txtFocus;
    private javax.swing.JTextField txtLogin;
    private javax.swing.JPasswordField txtSenha;
    // End of variables declaration//GEN-END:variables
}
