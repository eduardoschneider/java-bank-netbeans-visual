/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import banco.RoundedBorder;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author eduardo.schneider
 */
public class telaPrincipalAdmin extends javax.swing.JFrame {

    /**
     * Creates new form telaPrincipalUsuario
     */
    public telaPrincipalAdmin() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Already there
        this.setUndecorated(true);
        this.setBackground(new Color(0,0,0,0));
        initComponents();
        setLocationRelativeTo(null); //abre a tela no centro
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fundo1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnInvestimentos3 = new javax.swing.JButton();
        btnAvancarODia1 = new javax.swing.JButton();
        btnPesquisaClientes4 = new javax.swing.JButton();
        btnCadastroCliente4 = new javax.swing.JButton();
        btnInvestimentos4 = new javax.swing.JButton();
        btnCadastroCliente5 = new javax.swing.JButton();
        btnPesquisaClientes5 = new javax.swing.JButton();
        btnInvestimentos5 = new javax.swing.JButton();
        btnInvestimentos2 = new javax.swing.JButton();
        btnInvestimentos1 = new javax.swing.JButton();
        btnCadastroCliente3 = new javax.swing.JButton();
        btnPesquisaClientes2 = new javax.swing.JButton();
        btnCadastroCliente = new javax.swing.JButton();
        btnInvestimentos = new javax.swing.JButton();
        lblInvestimentos = new javax.swing.JLabel();
        btnAvancarODia = new javax.swing.JButton();
        btnPesquisaClientes = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();
        fundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        fundo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fundo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bank3.png"))); // NOI18N
        fundo1.setAlignmentX(0.5F);
        fundo1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(fundo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 0, 150, 130));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("CONTA");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 10, 90, 30));

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CLIENTE");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 110, 30));

        btnInvestimentos3.setBackground(new java.awt.Color(204, 255, 204));
        btnInvestimentos3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnInvestimentos3.setForeground(new java.awt.Color(0, 102, 51));
        btnInvestimentos3.setText("+");
        btnInvestimentos3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnInvestimentos3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnInvestimentos3MouseExited(evt);
            }
        });
        jPanel1.add(btnInvestimentos3, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 240, 50, 86));

        btnAvancarODia1.setBackground(new java.awt.Color(255, 255, 255));
        btnAvancarODia1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnAvancarODia1.setText("Avançar o Dia");
        btnAvancarODia1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAvancarODia1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAvancarODia1MouseExited(evt);
            }
        });
        jPanel1.add(btnAvancarODia1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 400, 350, 50));

        btnPesquisaClientes4.setBackground(new java.awt.Color(255, 255, 255));
        btnPesquisaClientes4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnPesquisaClientes4.setText("Pesquisa");
        btnPesquisaClientes4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnPesquisaClientes4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnPesquisaClientes4MouseExited(evt);
            }
        });
        jPanel1.add(btnPesquisaClientes4, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 140, 110, 86));

        btnCadastroCliente4.setBackground(new java.awt.Color(255, 255, 255));
        btnCadastroCliente4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnCadastroCliente4.setText("Excluir");
        btnCadastroCliente4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCadastroCliente4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCadastroCliente4MouseExited(evt);
            }
        });
        btnCadastroCliente4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastroCliente4ActionPerformed(evt);
            }
        });
        jPanel1.add(btnCadastroCliente4, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 140, 110, 86));

        btnInvestimentos4.setBackground(new java.awt.Color(204, 255, 204));
        btnInvestimentos4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnInvestimentos4.setForeground(new java.awt.Color(0, 102, 51));
        btnInvestimentos4.setText("+");
        btnInvestimentos4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnInvestimentos4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnInvestimentos4MouseExited(evt);
            }
        });
        jPanel1.add(btnInvestimentos4, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 116, 50, 110));

        btnCadastroCliente5.setBackground(new java.awt.Color(255, 255, 255));
        btnCadastroCliente5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnCadastroCliente5.setText("Cadastrar");
        btnCadastroCliente5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCadastroCliente5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCadastroCliente5MouseExited(evt);
            }
        });
        btnCadastroCliente5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastroCliente5ActionPerformed(evt);
            }
        });
        jPanel1.add(btnCadastroCliente5, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 40, 110, 86));

        btnPesquisaClientes5.setBackground(new java.awt.Color(255, 255, 255));
        btnPesquisaClientes5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnPesquisaClientes5.setText("Alterar");
        btnPesquisaClientes5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnPesquisaClientes5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnPesquisaClientes5MouseExited(evt);
            }
        });
        jPanel1.add(btnPesquisaClientes5, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 40, 110, 86));

        btnInvestimentos5.setBackground(new java.awt.Color(204, 255, 204));
        btnInvestimentos5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnInvestimentos5.setForeground(new java.awt.Color(0, 102, 51));
        btnInvestimentos5.setText("+");
        btnInvestimentos5.setAlignmentX(0.5F);
        btnInvestimentos5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnInvestimentos5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnInvestimentos5MouseExited(evt);
            }
        });
        btnInvestimentos5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInvestimentos5ActionPerformed(evt);
            }
        });
        jPanel1.add(btnInvestimentos5, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 240, 50, 86));

        btnInvestimentos2.setBackground(new java.awt.Color(255, 255, 255));
        btnInvestimentos2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnInvestimentos2.setText("Poupança");
        btnInvestimentos2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnInvestimentos2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnInvestimentos2MouseExited(evt);
            }
        });
        jPanel1.add(btnInvestimentos2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 240, 310, 86));

        btnInvestimentos1.setBackground(new java.awt.Color(255, 255, 255));
        btnInvestimentos1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnInvestimentos1.setText("CDB");
        btnInvestimentos1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnInvestimentos1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnInvestimentos1MouseExited(evt);
            }
        });
        jPanel1.add(btnInvestimentos1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 116, 120, 110));

        btnCadastroCliente3.setBackground(new java.awt.Color(255, 255, 255));
        btnCadastroCliente3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnCadastroCliente3.setText("Excluir");
        btnCadastroCliente3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCadastroCliente3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCadastroCliente3MouseExited(evt);
            }
        });
        btnCadastroCliente3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastroCliente3ActionPerformed(evt);
            }
        });
        jPanel1.add(btnCadastroCliente3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 110, 86));

        btnPesquisaClientes2.setBackground(new java.awt.Color(255, 255, 255));
        btnPesquisaClientes2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnPesquisaClientes2.setText("Pesquisa");
        btnPesquisaClientes2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnPesquisaClientes2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnPesquisaClientes2MouseExited(evt);
            }
        });
        jPanel1.add(btnPesquisaClientes2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, 110, 86));

        btnCadastroCliente.setBackground(new java.awt.Color(255, 255, 255));
        btnCadastroCliente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnCadastroCliente.setText("Cadastrar");
        btnCadastroCliente.setActionCommand("");
        btnCadastroCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCadastroClienteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCadastroClienteMouseExited(evt);
            }
        });
        btnCadastroCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastroClienteActionPerformed(evt);
            }
        });
        jPanel1.add(btnCadastroCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 110, 86));

        btnInvestimentos.setBackground(new java.awt.Color(255, 255, 255));
        btnInvestimentos.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnInvestimentos.setText("Investimentos");
        btnInvestimentos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnInvestimentosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnInvestimentosMouseExited(evt);
            }
        });
        jPanel1.add(btnInvestimentos, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 310, 86));

        lblInvestimentos.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        lblInvestimentos.setText("(Investimentos)");
        jPanel1.add(lblInvestimentos, new org.netbeans.lib.awtextra.AbsoluteConstraints(428, 290, -1, -1));

        btnAvancarODia.setBackground(new java.awt.Color(255, 255, 255));
        btnAvancarODia.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnAvancarODia.setText("Avançar o Dia");
        btnAvancarODia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAvancarODiaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAvancarODiaMouseExited(evt);
            }
        });
        jPanel1.add(btnAvancarODia, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 340, 350, 50));

        btnPesquisaClientes.setBackground(new java.awt.Color(255, 255, 255));
        btnPesquisaClientes.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnPesquisaClientes.setText("Alterar");
        btnPesquisaClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnPesquisaClientesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnPesquisaClientesMouseExited(evt);
            }
        });
        jPanel1.add(btnPesquisaClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, 110, 86));

        btnVoltar.setBackground(new java.awt.Color(255, 255, 255));
        btnVoltar.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        btnVoltar.setText("Sair");
        btnVoltar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnVoltarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnVoltarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnVoltarMouseExited(evt);
            }
        });
        jPanel1.add(btnVoltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 250, 110));

        fundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/112_hard.jpg"))); // NOI18N
        jPanel1.add(fundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 660, 460));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 650, 480));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastroClienteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCadastroClienteMouseEntered
        btnCadastroCliente.setBackground(Color.black);
        btnCadastroCliente.setForeground(Color.white);
    }//GEN-LAST:event_btnCadastroClienteMouseEntered

    private void btnCadastroClienteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCadastroClienteMouseExited
        btnCadastroCliente.setBackground(Color.white);
        btnCadastroCliente.setForeground(Color.black);
    }//GEN-LAST:event_btnCadastroClienteMouseExited

    private void btnPesquisaClientesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPesquisaClientesMouseEntered
        btnPesquisaClientes.setBackground(Color.black);
        btnPesquisaClientes.setForeground(Color.white);
    }//GEN-LAST:event_btnPesquisaClientesMouseEntered

    private void btnPesquisaClientesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPesquisaClientesMouseExited
        btnPesquisaClientes.setBackground(Color.white);
        btnPesquisaClientes.setForeground(Color.black);
    }//GEN-LAST:event_btnPesquisaClientesMouseExited

    private void btnInvestimentosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInvestimentosMouseEntered
        btnInvestimentos.setBackground(Color.black);
        btnInvestimentos.setForeground(Color.white);
    }//GEN-LAST:event_btnInvestimentosMouseEntered

    private void btnInvestimentosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInvestimentosMouseExited
        btnInvestimentos.setBackground(Color.white);
        btnInvestimentos.setForeground(Color.black);
    }//GEN-LAST:event_btnInvestimentosMouseExited

    private void btnAvancarODiaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAvancarODiaMouseEntered
        btnAvancarODia.setBackground(Color.black);
        btnAvancarODia.setForeground(Color.white);
    }//GEN-LAST:event_btnAvancarODiaMouseEntered

    private void btnAvancarODiaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAvancarODiaMouseExited
        btnAvancarODia.setBackground(Color.white);
        btnAvancarODia.setForeground(Color.black);
    }//GEN-LAST:event_btnAvancarODiaMouseExited

    private void btnVoltarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVoltarMouseEntered
        btnVoltar.setBackground(Color.red);
        btnVoltar.setForeground(Color.white);
    }//GEN-LAST:event_btnVoltarMouseEntered

    private void btnVoltarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVoltarMouseExited
        btnVoltar.setBackground(Color.white);
        btnVoltar.setForeground(Color.red);
    }//GEN-LAST:event_btnVoltarMouseExited

    private void btnCadastroClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastroClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCadastroClienteActionPerformed

    private void btnVoltarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVoltarMouseClicked
        this.setVisible(false);
        new telaDeLogin().setVisible(true);
    }//GEN-LAST:event_btnVoltarMouseClicked

    private void btnCadastroCliente3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCadastroCliente3MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCadastroCliente3MouseEntered

    private void btnCadastroCliente3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCadastroCliente3MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCadastroCliente3MouseExited

    private void btnCadastroCliente3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastroCliente3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCadastroCliente3ActionPerformed

    private void btnPesquisaClientes2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPesquisaClientes2MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPesquisaClientes2MouseEntered

    private void btnPesquisaClientes2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPesquisaClientes2MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPesquisaClientes2MouseExited

    private void btnInvestimentos1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInvestimentos1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnInvestimentos1MouseEntered

    private void btnInvestimentos1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInvestimentos1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnInvestimentos1MouseExited

    private void btnInvestimentos2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInvestimentos2MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnInvestimentos2MouseEntered

    private void btnInvestimentos2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInvestimentos2MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnInvestimentos2MouseExited

    private void btnPesquisaClientes4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPesquisaClientes4MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPesquisaClientes4MouseEntered

    private void btnPesquisaClientes4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPesquisaClientes4MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPesquisaClientes4MouseExited

    private void btnCadastroCliente4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCadastroCliente4MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCadastroCliente4MouseEntered

    private void btnCadastroCliente4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCadastroCliente4MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCadastroCliente4MouseExited

    private void btnCadastroCliente4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastroCliente4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCadastroCliente4ActionPerformed

    private void btnCadastroCliente5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCadastroCliente5MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCadastroCliente5MouseEntered

    private void btnCadastroCliente5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCadastroCliente5MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCadastroCliente5MouseExited

    private void btnCadastroCliente5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastroCliente5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCadastroCliente5ActionPerformed

    private void btnPesquisaClientes5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPesquisaClientes5MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPesquisaClientes5MouseEntered

    private void btnPesquisaClientes5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPesquisaClientes5MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPesquisaClientes5MouseExited

    private void btnAvancarODia1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAvancarODia1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAvancarODia1MouseEntered

    private void btnAvancarODia1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAvancarODia1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAvancarODia1MouseExited

    private void btnInvestimentos3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInvestimentos3MouseEntered
        btnInvestimentos3.setBackground(Color.green);
    }//GEN-LAST:event_btnInvestimentos3MouseEntered

    private void btnInvestimentos3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInvestimentos3MouseExited
        btnInvestimentos3.setBackground(new Color(204, 255, 204));
    }//GEN-LAST:event_btnInvestimentos3MouseExited

    private void btnInvestimentos4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInvestimentos4MouseEntered
        btnInvestimentos4.setBackground(Color.green);
    }//GEN-LAST:event_btnInvestimentos4MouseEntered

    private void btnInvestimentos4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInvestimentos4MouseExited
        btnInvestimentos4.setBackground(new Color(204, 255, 204));
    }//GEN-LAST:event_btnInvestimentos4MouseExited

    private void btnInvestimentos5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInvestimentos5MouseEntered
        btnInvestimentos5.setBackground(Color.green);
    }//GEN-LAST:event_btnInvestimentos5MouseEntered

    private void btnInvestimentos5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInvestimentos5MouseExited
        btnInvestimentos5.setBackground(new Color(204, 255, 204));
    }//GEN-LAST:event_btnInvestimentos5MouseExited

    private void btnInvestimentos5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInvestimentos5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnInvestimentos5ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAvancarODia;
    private javax.swing.JButton btnAvancarODia1;
    private javax.swing.JButton btnCadastroCliente;
    private javax.swing.JButton btnCadastroCliente3;
    private javax.swing.JButton btnCadastroCliente4;
    private javax.swing.JButton btnCadastroCliente5;
    private javax.swing.JButton btnInvestimentos;
    private javax.swing.JButton btnInvestimentos1;
    private javax.swing.JButton btnInvestimentos2;
    private javax.swing.JButton btnInvestimentos3;
    private javax.swing.JButton btnInvestimentos4;
    private javax.swing.JButton btnInvestimentos5;
    private javax.swing.JButton btnPesquisaClientes;
    private javax.swing.JButton btnPesquisaClientes2;
    private javax.swing.JButton btnPesquisaClientes4;
    private javax.swing.JButton btnPesquisaClientes5;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JLabel fundo;
    private javax.swing.JLabel fundo1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblInvestimentos;
    // End of variables declaration//GEN-END:variables
}
