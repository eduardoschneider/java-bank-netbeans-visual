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
/**
 *
 * @author eduardo.schneider
 */
public class telaPrincipalUsuario extends javax.swing.JFrame {

    /**
     * Creates new form telaPrincipalUsuario
     */
    public telaPrincipalUsuario() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Already there
        this.setUndecorated(true);
        this.setBackground(new Color(0,0,0,0));
        initComponents();
        setLocationRelativeTo(null); //abre a tela no centro 
        
        if (Poupanca.logado != null){
            btnSacarPoupanca.setEnabled(true);
            btnDepositarPoupanca.setEnabled(true);
            btnConsultarPoupanca.setEnabled(true);
            poup1.setVisible(false);
            poup2.setVisible(false);
        }
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
        poup1 = new javax.swing.JLabel();
        poup2 = new javax.swing.JLabel();
        btnAvancarODia1 = new javax.swing.JButton();
        btnExtrato = new javax.swing.JButton();
        btnPagamento = new javax.swing.JButton();
        btnSaldo = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnConsultarPoupanca = new javax.swing.JButton();
        btnDepositarPoupanca = new javax.swing.JButton();
        btnSacarPoupanca = new javax.swing.JButton();
        btnCdb = new javax.swing.JButton();
        btnSaque = new javax.swing.JButton();
        btnDeposito = new javax.swing.JButton();
        btnInvestimentos = new javax.swing.JButton();
        lblInvestimentos = new javax.swing.JLabel();
        btnAvancarODia = new javax.swing.JButton();
        btnTransferencia = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();
        fundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        fundo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fundo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/eye.png"))); // NOI18N
        fundo1.setAlignmentX(0.5F);
        fundo1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(fundo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 0, 150, 150));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        poup1.setBackground(new java.awt.Color(255, 255, 255));
        poup1.setFont(new java.awt.Font("DialogInput", 1, 12)); // NOI18N
        poup1.setForeground(new java.awt.Color(153, 0, 0));
        poup1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        poup1.setText("Procure um administrador para mais informações. (ERROR 00x3717)");
        jPanel1.add(poup1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 630, 20));

        poup2.setBackground(new java.awt.Color(0, 0, 0));
        poup2.setFont(new java.awt.Font("DialogInput", 1, 12)); // NOI18N
        poup2.setForeground(new java.awt.Color(153, 0, 0));
        poup2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        poup2.setText("Atenção: Nenhuma poupança vinculada, e por isso suas ações foram bloqueadas.");
        jPanel1.add(poup2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 275, 620, 20));

        btnAvancarODia1.setBackground(new java.awt.Color(255, 255, 255));
        btnAvancarODia1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnAvancarODia1.setEnabled(false);
        btnAvancarODia1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAvancarODia1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAvancarODia1MouseExited(evt);
            }
        });
        jPanel1.add(btnAvancarODia1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 420, 350, 50));

        btnExtrato.setBackground(new java.awt.Color(255, 255, 255));
        btnExtrato.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnExtrato.setText("Extrato");
        btnExtrato.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnExtratoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnExtratoMouseExited(evt);
            }
        });
        btnExtrato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExtratoActionPerformed(evt);
            }
        });
        jPanel1.add(btnExtrato, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 40, 110, 86));

        btnPagamento.setBackground(new java.awt.Color(255, 255, 255));
        btnPagamento.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnPagamento.setText("Pagamento");
        btnPagamento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPagamentoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnPagamentoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnPagamentoMouseExited(evt);
            }
        });
        btnPagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPagamentoActionPerformed(evt);
            }
        });
        jPanel1.add(btnPagamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 140, 230, 60));

        btnSaldo.setBackground(new java.awt.Color(255, 255, 255));
        btnSaldo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnSaldo.setText("Saldo");
        btnSaldo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSaldoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSaldoMouseExited(evt);
            }
        });
        btnSaldo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaldoActionPerformed(evt);
            }
        });
        jPanel1.add(btnSaldo, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 40, 110, 86));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("________________________________________________");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 630, 10));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("____________________ Poupança __________________");
        jLabel2.setBorder(new javax.swing.border.MatteBorder(null));
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 630, 40));

        btnConsultarPoupanca.setBackground(new java.awt.Color(255, 255, 255));
        btnConsultarPoupanca.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnConsultarPoupanca.setText("Consultar");
        btnConsultarPoupanca.setEnabled(false);
        btnConsultarPoupanca.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnConsultarPoupancaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnConsultarPoupancaMouseExited(evt);
            }
        });
        btnConsultarPoupanca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarPoupancaActionPerformed(evt);
            }
        });
        jPanel1.add(btnConsultarPoupanca, new org.netbeans.lib.awtextra.AbsoluteConstraints(438, 256, 202, 70));

        btnDepositarPoupanca.setBackground(new java.awt.Color(255, 255, 255));
        btnDepositarPoupanca.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnDepositarPoupanca.setText("Depositar");
        btnDepositarPoupanca.setEnabled(false);
        btnDepositarPoupanca.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnDepositarPoupancaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnDepositarPoupancaMouseExited(evt);
            }
        });
        btnDepositarPoupanca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDepositarPoupancaActionPerformed(evt);
            }
        });
        jPanel1.add(btnDepositarPoupanca, new org.netbeans.lib.awtextra.AbsoluteConstraints(225, 256, 202, 70));

        btnSacarPoupanca.setBackground(new java.awt.Color(255, 255, 255));
        btnSacarPoupanca.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnSacarPoupanca.setText("Sacar");
        btnSacarPoupanca.setEnabled(false);
        btnSacarPoupanca.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSacarPoupancaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSacarPoupancaMouseExited(evt);
            }
        });
        btnSacarPoupanca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSacarPoupancaActionPerformed(evt);
            }
        });
        jPanel1.add(btnSacarPoupanca, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 256, 202, 70));

        btnCdb.setBackground(new java.awt.Color(255, 255, 255));
        btnCdb.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnCdb.setText("CDB");
        btnCdb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCdbMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCdbMouseExited(evt);
            }
        });
        btnCdb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCdbActionPerformed(evt);
            }
        });
        jPanel1.add(btnCdb, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 110, 150, 40));

        btnSaque.setBackground(new java.awt.Color(255, 255, 255));
        btnSaque.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnSaque.setText("Saque");
        btnSaque.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSaqueMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSaqueMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSaqueMouseExited(evt);
            }
        });
        btnSaque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaqueActionPerformed(evt);
            }
        });
        jPanel1.add(btnSaque, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, 110, 86));

        btnDeposito.setBackground(new java.awt.Color(255, 255, 255));
        btnDeposito.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnDeposito.setText("Depósito");
        btnDeposito.setActionCommand("");
        btnDeposito.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnDepositoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnDepositoMouseExited(evt);
            }
        });
        btnDeposito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDepositoActionPerformed(evt);
            }
        });
        jPanel1.add(btnDeposito, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 110, 86));

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
        btnInvestimentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInvestimentosActionPerformed(evt);
            }
        });
        jPanel1.add(btnInvestimentos, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 160, 150, 40));

        lblInvestimentos.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        lblInvestimentos.setText("(Investimentos)");
        jPanel1.add(lblInvestimentos, new org.netbeans.lib.awtextra.AbsoluteConstraints(428, 290, -1, -1));

        btnAvancarODia.setBackground(new java.awt.Color(255, 255, 255));
        btnAvancarODia.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnAvancarODia.setEnabled(false);
        btnAvancarODia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAvancarODiaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAvancarODiaMouseExited(evt);
            }
        });
        jPanel1.add(btnAvancarODia, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 360, 350, 50));

        btnTransferencia.setBackground(new java.awt.Color(255, 255, 255));
        btnTransferencia.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnTransferencia.setText("Transferência");
        btnTransferencia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnTransferenciaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnTransferenciaMouseExited(evt);
            }
        });
        btnTransferencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTransferenciaActionPerformed(evt);
            }
        });
        jPanel1.add(btnTransferencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 230, 60));

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
        jPanel1.add(btnVoltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 250, 110));

        fundo.setForeground(new java.awt.Color(0, 0, 0));
        fundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/112_hard.jpg"))); // NOI18N
        jPanel1.add(fundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -40, 660, 520));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 650, 480));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDepositoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDepositoMouseEntered
        btnDeposito.setBackground(Color.black);
        btnDeposito.setForeground(Color.white);
    }//GEN-LAST:event_btnDepositoMouseEntered

    private void btnDepositoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDepositoMouseExited
        btnDeposito.setBackground(Color.white);
        btnDeposito.setForeground(Color.black);
    }//GEN-LAST:event_btnDepositoMouseExited

    private void btnTransferenciaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTransferenciaMouseEntered
        btnTransferencia.setBackground(Color.black);
        btnTransferencia.setForeground(Color.white);
    }//GEN-LAST:event_btnTransferenciaMouseEntered

    private void btnTransferenciaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTransferenciaMouseExited
        btnTransferencia.setBackground(Color.white);
        btnTransferencia.setForeground(Color.black);
    }//GEN-LAST:event_btnTransferenciaMouseExited

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

    private void btnDepositoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDepositoActionPerformed
        this.setVisible(false);
        try {
            new telaDeDeposito().setVisible(true);
        } catch (ParseException ex) {
            Logger.getLogger(telaPrincipalUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDepositoActionPerformed

    private void btnVoltarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVoltarMouseClicked
        this.setVisible(false);
        Cliente.logado = null;
        Conta.logado = null;
        Poupanca.logado = null;
        new telaDeLogin().setVisible(true);
    }//GEN-LAST:event_btnVoltarMouseClicked

    private void btnSaqueMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaqueMouseEntered
        btnSaque.setBackground(Color.black);
        btnSaque.setForeground(Color.white);
    }//GEN-LAST:event_btnSaqueMouseEntered

    private void btnSaqueMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaqueMouseExited
        btnSaque.setBackground(Color.white);
        btnSaque.setForeground(Color.black);
    }//GEN-LAST:event_btnSaqueMouseExited

    private void btnSaqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaqueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSaqueActionPerformed

    private void btnCdbMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCdbMouseEntered
        btnCdb.setBackground(Color.black);
        btnCdb.setForeground(Color.white);
    }//GEN-LAST:event_btnCdbMouseEntered

    private void btnCdbMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCdbMouseExited
        btnCdb.setBackground(Color.white);
        btnCdb.setForeground(Color.black);
    }//GEN-LAST:event_btnCdbMouseExited

    private void btnSacarPoupancaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSacarPoupancaMouseEntered
        btnSacarPoupanca.setBackground(Color.black);
        btnSacarPoupanca.setForeground(Color.white);
    }//GEN-LAST:event_btnSacarPoupancaMouseEntered

    private void btnSacarPoupancaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSacarPoupancaMouseExited
        btnSacarPoupanca.setBackground(Color.white);
        btnSacarPoupanca.setForeground(Color.black);
    }//GEN-LAST:event_btnSacarPoupancaMouseExited

    private void btnPagamentoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPagamentoMouseEntered
        btnPagamento.setBackground(Color.black);
        btnPagamento.setForeground(Color.white);
    }//GEN-LAST:event_btnPagamentoMouseEntered

    private void btnPagamentoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPagamentoMouseExited
        btnPagamento.setBackground(Color.white);
        btnPagamento.setForeground(Color.black);
    }//GEN-LAST:event_btnPagamentoMouseExited

    private void btnPagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagamentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPagamentoActionPerformed

    private void btnSaldoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaldoMouseEntered
        btnSaldo.setBackground(Color.black);
        btnSaldo.setForeground(Color.white);
    }//GEN-LAST:event_btnSaldoMouseEntered

    private void btnSaldoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaldoMouseExited
        btnSaldo.setBackground(Color.white);
        btnSaldo.setForeground(Color.black);
    }//GEN-LAST:event_btnSaldoMouseExited

    private void btnAvancarODia1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAvancarODia1MouseEntered
        btnAvancarODia1.setBackground(Color.black);
        btnAvancarODia1.setForeground(Color.white);
    }//GEN-LAST:event_btnAvancarODia1MouseEntered

    private void btnAvancarODia1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAvancarODia1MouseExited
        btnAvancarODia1.setBackground(Color.white);
        btnAvancarODia1.setForeground(Color.black);
    }//GEN-LAST:event_btnAvancarODia1MouseExited

    private void btnExtratoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExtratoMouseEntered
        btnExtrato.setBackground(Color.black);
        btnExtrato.setForeground(Color.white);
    }//GEN-LAST:event_btnExtratoMouseEntered

    private void btnExtratoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExtratoMouseExited
        btnExtrato.setBackground(Color.white);
        btnExtrato.setForeground(Color.black);
    }//GEN-LAST:event_btnExtratoMouseExited

    private void btnCdbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCdbActionPerformed
        this.setVisible(false);
        try {
            new telaCDB().setVisible(true);
        } catch (ParseException ex) {
            Logger.getLogger(telaPrincipalUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnCdbActionPerformed

    private void btnDepositarPoupancaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDepositarPoupancaMouseEntered
        btnDepositarPoupanca.setBackground(Color.black);
        btnDepositarPoupanca.setForeground(Color.white);
    }//GEN-LAST:event_btnDepositarPoupancaMouseEntered

    private void btnDepositarPoupancaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDepositarPoupancaMouseExited
        btnDepositarPoupanca.setBackground(Color.white);
        btnDepositarPoupanca.setForeground(Color.black);
    }//GEN-LAST:event_btnDepositarPoupancaMouseExited

    private void btnConsultarPoupancaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConsultarPoupancaMouseEntered
        btnConsultarPoupanca.setBackground(Color.black);
        btnConsultarPoupanca.setForeground(Color.white);
    }//GEN-LAST:event_btnConsultarPoupancaMouseEntered

    private void btnConsultarPoupancaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConsultarPoupancaMouseExited
        btnConsultarPoupanca.setBackground(Color.white);
        btnConsultarPoupanca.setForeground(Color.black);
    }//GEN-LAST:event_btnConsultarPoupancaMouseExited

    private void btnInvestimentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInvestimentosActionPerformed
        this.setVisible(false);
        try {
            new telaFundo().setVisible(true);
        } catch (ParseException ex) {
            Logger.getLogger(telaPrincipalUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnInvestimentosActionPerformed

    private void btnSaqueMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaqueMouseClicked
        this.setVisible(false);
        try {
            new telaDeSaque().setVisible(true);
        } catch (ParseException ex) {
            Logger.getLogger(telaPrincipalUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSaqueMouseClicked

    private void btnTransferenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTransferenciaActionPerformed
        this.setVisible(false);
        try {
            new telaDeTransferencia().setVisible(true);
        } catch (ParseException ex) {
            Logger.getLogger(telaPrincipalUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnTransferenciaActionPerformed

    private void btnExtratoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExtratoActionPerformed
        this.setVisible(false);
        try {
            new telaExtrato().setVisible(true);
        } catch (InterruptedException | SQLException ex) {
            Logger.getLogger(telaPrincipalUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnExtratoActionPerformed

    private void btnSaldoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaldoActionPerformed
        try {
            Conta.logado.consultarSaldo();
        } catch (SQLException ex) {
            Logger.getLogger(telaPrincipalUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSaldoActionPerformed

    private void btnPagamentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPagamentoMouseClicked
        this.setVisible(false);
        try {
            new telaDePagamento().setVisible(true);
        } catch (ParseException ex) {
            Logger.getLogger(telaPrincipalUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnPagamentoMouseClicked

    private void btnDepositarPoupancaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDepositarPoupancaActionPerformed
        this.setVisible(false);
        try {
            new telaDeDepositoPoupanca().setVisible(true);
        } catch (ParseException ex) {
            Logger.getLogger(telaPrincipalUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDepositarPoupancaActionPerformed

    private void btnSacarPoupancaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSacarPoupancaActionPerformed
        this.setVisible(false);
        try {
            new telaDeSaquePoupanca().setVisible(true);
        } catch (ParseException ex) {
            Logger.getLogger(telaPrincipalUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSacarPoupancaActionPerformed

    private void btnConsultarPoupancaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarPoupancaActionPerformed
        this.setVisible(false);
        try {
            new telaExtratoPoupanca().setVisible(true);
        } catch (InterruptedException | SQLException ex) {
            Logger.getLogger(telaPrincipalUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnConsultarPoupancaActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAvancarODia;
    private javax.swing.JButton btnAvancarODia1;
    private javax.swing.JButton btnCdb;
    private javax.swing.JButton btnConsultarPoupanca;
    private javax.swing.JButton btnDepositarPoupanca;
    private javax.swing.JButton btnDeposito;
    private javax.swing.JButton btnExtrato;
    private javax.swing.JButton btnInvestimentos;
    private javax.swing.JButton btnPagamento;
    private javax.swing.JButton btnSacarPoupanca;
    private javax.swing.JButton btnSaldo;
    private javax.swing.JButton btnSaque;
    private javax.swing.JButton btnTransferencia;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JLabel fundo;
    private javax.swing.JLabel fundo1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblInvestimentos;
    private javax.swing.JLabel poup1;
    private javax.swing.JLabel poup2;
    // End of variables declaration//GEN-END:variables
}
