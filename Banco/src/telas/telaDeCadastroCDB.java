/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import banco.CDB;
import banco.Cliente;
import java.awt.Color;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.jdesktop.swingx.prompt.PromptSupport;
/**
 *
 * @author eduardo.schneider
 */
public class telaDeCadastroCDB extends javax.swing.JFrame {

    /**
     * Creates new form telaPrincipalUsuario
     */
    public telaDeCadastroCDB() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Already there
        this.setUndecorated(true);
        this.setBackground(new Color(0,0,0,0));
        initComponents();
        setLocationRelativeTo(null); //abre a tela no centro 

        PromptSupport.setPrompt("Vencimento", txtVencimentoCdb);
        PromptSupport.setForeground(Color.white, txtVencimentoCdb);
        
        PromptSupport.setPrompt("Nome do CDB", txtNomeCdb);
        PromptSupport.setForeground(Color.white, txtNomeCdb);
        
        PromptSupport.setPrompt("Porcentagem", txtPorcentagemCDB);
        PromptSupport.setForeground(Color.white, txtPorcentagemCDB);
        
        txtVencimentoCdb.setBackground(new Color(0, 0, 0, 0));
        txtVencimentoCdb.setForeground(Color.white);
        txtNomeCdb.setBackground(new Color(0, 0, 0, 0));
        txtNomeCdb.setForeground(Color.white);
        txtPorcentagemCDB.setBackground(new Color(0, 0, 0, 0));
        txtPorcentagemCDB.setForeground(Color.white);
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
        jLabel3 = new javax.swing.JLabel();
        txtNomeCdb = new javax.swing.JTextField();
        txtVencimentoCdb = new javax.swing.JTextField();
        txtPorcentagemCDB = new javax.swing.JTextField();
        cancelaCadastroButton = new javax.swing.JButton();
        confirmaCadastroButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 51));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Digite os dados do CDB:");

        txtNomeCdb.setBackground(new java.awt.Color(102, 0, 0));
        txtNomeCdb.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtNomeCdb.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        txtVencimentoCdb.setBackground(new java.awt.Color(102, 0, 0));
        txtVencimentoCdb.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtVencimentoCdb.setToolTipText("");
        txtVencimentoCdb.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        txtPorcentagemCDB.setBackground(new java.awt.Color(102, 0, 0));
        txtPorcentagemCDB.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtPorcentagemCDB.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        cancelaCadastroButton.setBackground(new java.awt.Color(255, 0, 0));
        cancelaCadastroButton.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        cancelaCadastroButton.setForeground(new java.awt.Color(255, 255, 255));
        cancelaCadastroButton.setText("Voltar");
        cancelaCadastroButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelaCadastroButtonActionPerformed(evt);
            }
        });

        confirmaCadastroButton1.setBackground(new java.awt.Color(0, 153, 0));
        confirmaCadastroButton1.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        confirmaCadastroButton1.setForeground(new java.awt.Color(255, 255, 255));
        confirmaCadastroButton1.setText("Cadastrar");
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNomeCdb, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtVencimentoCdb, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPorcentagemCDB, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cancelaCadastroButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(confirmaCadastroButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(22, 22, 22))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtNomeCdb, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(txtVencimentoCdb, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(txtPorcentagemCDB, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cancelaCadastroButton)
                    .addComponent(confirmaCadastroButton1))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 85, 320, 205));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/mano-con-celular-png.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 620, 500));

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
            CDB.cadastrar(txtNomeCdb.getText(),txtPorcentagemCDB.getText(), txtVencimentoCdb.getText());
            JFrame frame = new JFrame("");
            JOptionPane.showMessageDialog(frame,"CDB inserido com sucesso.",
            "Yay!",JOptionPane.INFORMATION_MESSAGE); 
            this.setVisible(false);
            new telaPrincipalAdmin().setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(telaDeCadastroCDB.class.getName()).log(Level.SEVERE, null, ex);
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtNomeCdb;
    private javax.swing.JTextField txtPorcentagemCDB;
    private javax.swing.JTextField txtVencimentoCdb;
    // End of variables declaration//GEN-END:variables
}
