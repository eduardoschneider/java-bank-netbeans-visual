/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author eduardo.schneider
 */
public class Fundo {
    
    private int id;
    private String nome;
    private BigDecimal saldo;
    private BigDecimal porcentagemCDI;

    public Fundo(int id, String nome, BigDecimal saldo, BigDecimal porcentagemCDI) {
        this.id = id;
        this.nome = nome;
        this.saldo = saldo;
        this.porcentagemCDI = porcentagemCDI;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public BigDecimal getPorcentagemCDI() {
        return porcentagemCDI;
    }

    public void setPorcentagemCDI(BigDecimal porcentagemCDI) {
        this.porcentagemCDI = porcentagemCDI;
    }
    
    public static void depositarFundo(String codigoFundo, Double valor) throws SQLException{
        Connection con2 = DriverManager.getConnection("jdbc:mysql://127.0.0.1/banco","root","");
        Statement stmt = (Statement)con2.createStatement();   
        Date data = new Date();
        java.sql.Date dataSQL = new java.sql.Date(data.getTime());
        
        String insert = "INSERT INTO fundo_extrato(fundo,cliente,saldo,dtInicio,status)"
                        + " VALUES (" + codigoFundo +"," + Cliente.logado.getIdCliente() + "," + valor + ",'"
                        + dataSQL + "'," + 1 + ");";
        System.out.println(insert);
        stmt.execute(insert);
        
        String updateConta = "UPDATE conta SET saldo = saldo -"+ valor +"WHERE id = " + Conta.logado.getIdConta();
        stmt.execute(updateConta);
        
        String juntaTodosOsDepositos ="SELECT * FROM fundo_extrato WHERE fundo = " + codigoFundo;
        System.out.println(juntaTodosOsDepositos);
        stmt.executeQuery(juntaTodosOsDepositos);
        ResultSet resultSet2 = stmt.getResultSet();
        Double saldoTotal = 0.0;
        
        while(resultSet2.next()){
            saldoTotal += resultSet2.getDouble("saldo");
        }

        String update = "UPDATE fundo SET saldo = " + saldoTotal + " WHERE id = " + codigoFundo;
        System.out.println(update);
        stmt.execute(update);
        
        con2.close();
    }
    
    
    public static void sacar(String codigoFundo, Double valor) throws SQLException {
        Connection con2 = DriverManager.getConnection("jdbc:mysql://127.0.0.1/banco","root","");
        Statement stmt = (Statement)con2.createStatement();  
        
        String verificaPoup ="SELECT * FROM fundo_extrato WHERE fundo = " + codigoFundo + " AND cliente = " + Cliente.logado.getIdCliente() + " ORDER BY ID DESC";
        System.out.println(verificaPoup);
        stmt.executeQuery(verificaPoup);
        ResultSet resultSet = stmt.getResultSet();
        boolean existe = false;
        Double ultimoDeposito = 0.0;
        int ultimo = 0;
        Double valorComparativo = valor;
        while (valorComparativo != 0.0){
            while(resultSet.next()){
                existe = true;
                int status = resultSet.getInt("status");
                ultimo = resultSet.getInt("id");
                ultimoDeposito = resultSet.getDouble("saldo");
                if (status == 1){
                        if (ultimoDeposito >= valorComparativo){
                            ultimoDeposito -= valorComparativo;
                            valorComparativo = 0.0;
                            String update = "UPDATE fundo_extrato SET saldo = " + ultimoDeposito + " WHERE id = " + ultimo;
                            Statement stmt2 = (Statement)con2.createStatement();
                            stmt2.execute(update);
                            break;
                        } else {
                            valorComparativo -= ultimoDeposito;
                            String update = "UPDATE fundo_extrato SET saldo = 0.0 WHERE id = " + ultimo;
                            Statement stmt3 = (Statement)con2.createStatement();
                            stmt3.execute(update);
                        }
                        
                    }
                }
            if (existe){
                String updateConta = "UPDATE conta SET saldo = saldo +"+ valor +"WHERE id = " + Conta.logado.getIdConta();
                stmt.execute(updateConta);
                
            } else {
                break;
            }
            }
        if (existe){
            String delete = "DELETE FROM fundo_extrato WHERE saldo = 0.0";
            System.out.println(delete);
            stmt.execute(delete);

            atualizaSaldoTotal(codigoFundo);


            JFrame frame = new JFrame("");
            JOptionPane.showMessageDialog(frame,"Saque realizado com sucesso.",
            "Yay!",JOptionPane.INFORMATION_MESSAGE);  
        } else {
            JFrame frame = new JFrame("");
            JOptionPane.showMessageDialog(frame,"Você não pode realizar um saque.",
            "ERRO",JOptionPane.INFORMATION_MESSAGE); 
        }
        con2.close();
    }
    
    public static void atualizaSaldoTotal(String codigoFundo) throws SQLException {
        
        Connection con2 = DriverManager.getConnection("jdbc:mysql://127.0.0.1/banco","root","");
        Statement stmt = (Statement)con2.createStatement();  
        String juntaTodosOsDepositos ="SELECT * FROM fundo_extrato WHERE fundo = " + codigoFundo;
        System.out.println(juntaTodosOsDepositos);
        stmt.executeQuery(juntaTodosOsDepositos);
        ResultSet resultSet2 = stmt.getResultSet();
        Double saldoTotal = 0.0;

        while(resultSet2.next()){
            saldoTotal += resultSet2.getDouble("saldo");
        }


        String update = "UPDATE fundo SET saldo = " + saldoTotal + " WHERE id = " + codigoFundo;
        System.out.println(update);
        stmt.execute(update);
        
        con2.close();
    }
    
    public static void verificaJurosBD() throws SQLException {
       Connection con2 = DriverManager.getConnection("jdbc:mysql://127.0.0.1/banco","root","");
       Statement stmt = (Statement)con2.createStatement();
       String consulta ="SELECT data FROM hoje WHERE id = 1";
       ResultSet resultSet = stmt.executeQuery(consulta);
       LocalDate hoje = null;
        while (resultSet.next()){
           hoje = resultSet.getDate("data").toLocalDate();
        }
       int month = hoje.getMonthValue();
       Taxas taxas = new Taxas();
       Double taxaAtual;
       
       if (month >= 7){
            taxaAtual = taxas.getSelicMensal()[month - 7];
            if ((taxas.getSelicAnual()[month - 7]).compareTo(8.5) < 0)
                taxaAtual = (taxas.getCdiDiario()[month - 7]);
        } else 
        {
            taxaAtual = taxas.getSelicMensal()[month + 5];
            if ((taxas.getSelicAnual()[month + 5]).compareTo(8.5) < 0)
                taxaAtual = (taxas.getCdiDiario()[month + 5]);
        }
       
       String pegaMovimentos ="SELECT * FROM fundo_extrato";
       ResultSet resultSet2 = stmt.executeQuery(pegaMovimentos);
       
        while (resultSet2.next()){
           int status = resultSet2.getInt("status");
           String codigoFundo = resultSet2.getInt("fundo") + "";
           Statement stmtx = (Statement)con2.createStatement();
           String pegaPorcentagem = " SELECT porcentagem FROM fundo WHERE id = " + resultSet2.getInt("fundo");
           ResultSet resultSetx = stmtx.executeQuery(pegaPorcentagem);
           int porcentagem = 0;
           while (resultSetx.next()){
                 porcentagem = resultSetx.getInt("porcentagem");
           }
            System.out.println(porcentagem);
           if (status == 1){
                Statement stmt2 = (Statement)con2.createStatement();
                String update3 = "UPDATE fundo_extrato SET saldo = saldo + (saldo * (" + taxaAtual / 100 + ") * " + porcentagem * 0.01 + ")";
                System.out.println(update3);
                stmt2.execute(update3);
               }
           atualizaSaldoTotal(codigoFundo);
           }
        
           con2.close();
        }
    
    
        public static void cadastrar(String nomeFundo, String porcentagem) throws SQLException {
            Connection con2 = DriverManager.getConnection("jdbc:mysql://127.0.0.1/banco","root","");
            Statement stmt = (Statement)con2.createStatement();
            
            String insert = "INSERT INTO fundo(nome,saldo,porcentagem) VALUES ('" + nomeFundo + "', 0.0," + porcentagem + ");";
            stmt.execute(insert);
            
            con2.close();
        }

        public static String pegaTudo() throws SQLException {
            Connection con2 = DriverManager.getConnection("jdbc:mysql://127.0.0.1/banco","root","");
            Statement stmt = (Statement)con2.createStatement();

            String extrato = "SELECT * FROM fundo_extrato";
            stmt.executeQuery(extrato);
            ResultSet resultSet = stmt.getResultSet();
            String tudao = "";
            while(resultSet.next()){  
                tudao = tudao + "\nFundo:" + resultSet.getInt("fundo") + " - R$" + String.format("%.2f", resultSet.getDouble("saldo")) + " - (Data:" + resultSet.getDate("dtInicio") + " - (STATUS:" + resultSet.getInt("status") + ")";
            }

            con2.close();
        return tudao;

      }
}
