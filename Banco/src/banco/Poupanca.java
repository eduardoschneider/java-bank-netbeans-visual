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
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.ZoneId;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author eduardo.schneider
 */
public class Poupanca {
    
    public static Poupanca logado = null;
    private String codigoPoupanca;
    private Cliente cliente;
    private BigDecimal saldo;

    public Poupanca(String idPoupanca, Cliente cliente, BigDecimal saldo) {
        this.codigoPoupanca = idPoupanca;
        this.cliente = cliente;
        this.saldo = saldo;
    }

    public Poupanca() {

    }

    public String getIdPoupanca() {
        return codigoPoupanca;
    }

    public void setIdPoupanca(String idPoupanca) {
        this.codigoPoupanca = idPoupanca;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public static Poupanca checaExistenciaDePoupanca(Cliente c, List<Poupanca> poupancas) {

        for (Poupanca p : poupancas) {
            if ((p.getCliente()).equals(c)) {
                return p;
            }
        }

        return null;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + Objects.hashCode(this.codigoPoupanca);
        hash = 11 * hash + Objects.hashCode(this.cliente);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Poupanca other = (Poupanca) obj;
        if (!Objects.equals(this.codigoPoupanca, other.codigoPoupanca)) {
            return false;
        }
        return Objects.equals(this.cliente, other.cliente);
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
                taxaAtual = (taxas.getSelicMensal()[month - 7] * 0.7);
        } else 
        {
            taxaAtual = taxas.getSelicMensal()[month + 5];
            if ((taxas.getSelicAnual()[month + 5]).compareTo(8.5) < 0)
                taxaAtual = (taxas.getSelicMensal()[month + 5] * 0.7);
        }
       
       String pegaMovimentos ="SELECT * FROM poupanca_extrato";
       ResultSet resultSet2 = stmt.executeQuery(pegaMovimentos);
       
        while (resultSet2.next()){
           int status = resultSet2.getInt("status");
           LocalDate aniversario = resultSet2.getDate("aniversario").toLocalDate();
           
           if (status == 1){
               if(aniversario.getDayOfMonth() == hoje.getDayOfMonth()){
                   Statement stmt2 = (Statement)con2.createStatement();
                   String update3 = "UPDATE poupanca_extrato SET saldo = saldo + (saldo * (" + taxaAtual / 100 + "))";
                   System.out.println(update3);
                   stmt2.execute(update3);
               }
           }
        }
        con2.close();
    } 
   
    public static void logar(Cliente cliente) throws SQLException {
        Connection con2 = DriverManager.getConnection("jdbc:mysql://127.0.0.1/banco","root","");
        Statement stmt = (Statement)con2.createStatement();
        int clientId = cliente.getIdCliente();
        String consulta ="SELECT * FROM poupanca WHERE cliente = '" + clientId + "'";
        ResultSet resultSet = stmt.executeQuery(consulta);
        
        while (resultSet.next()){
            Poupanca logado = new Poupanca(resultSet.getString("id"), cliente, new BigDecimal(resultSet.getDouble("saldo")));
                Poupanca.logado = logado;
            }
        
        con2.close();
    } 

    public void depositar(String codigoPoupanca, Double valor) throws SQLException {
        Connection con2 = DriverManager.getConnection("jdbc:mysql://127.0.0.1/banco","root","");
        Statement stmt = (Statement)con2.createStatement();  
        
        Date data = new Date();        
        java.sql.Date dateDB = new java.sql.Date(data.getTime());
        
        Date dataTermino = new Date(2019, 12, 21);
        java.sql.Date dateDBTermino = new java.sql.Date(dataTermino.getTime());
        
        String verificaPoup ="SELECT * FROM poupanca WHERE id = '" + codigoPoupanca + "'";
        stmt.executeQuery(verificaPoup);
        ResultSet resultSet = stmt.getResultSet();
        boolean existe = false;

        while(resultSet.next()){
            existe = true;
        }
        
        if (existe){
            String insert = "INSERT INTO poupanca_extrato(poupanca,saldo,dtInicio,dtTermino,aniversario,status) VALUES"
                            + " (" + codigoPoupanca + "," + valor + ",'" + dateDB + "','" + dateDBTermino + "','" + dateDB + "'," + true + ");" ;
            stmt.execute(insert);


            String juntaTodosOsDepositos ="SELECT * FROM poupanca_extrato WHERE poupanca = " + codigoPoupanca;
            System.out.println(juntaTodosOsDepositos);
            stmt.executeQuery(juntaTodosOsDepositos);
            ResultSet resultSet2 = stmt.getResultSet();
            Double saldoTotal = 0.0;

            while(resultSet2.next()){
                saldoTotal += resultSet2.getDouble("saldo");
            }


            String update = "UPDATE poupanca SET saldo = " + saldoTotal + " WHERE id = " + codigoPoupanca;
            System.out.println(update);
            stmt.execute(update);
            con2.close();
        }
        else {
            JFrame frame = new JFrame("");
            JOptionPane.showMessageDialog(frame,"Poupança não encontrada.",
            "ERRO",JOptionPane.INFORMATION_MESSAGE);  
            con2.close();
        }
    
    }
    
    public void sacar(String codigoPoupanca, Double valor) throws SQLException {
        Connection con2 = DriverManager.getConnection("jdbc:mysql://127.0.0.1/banco","root","");
        Statement stmt = (Statement)con2.createStatement();  
        
        String verificaPoup ="SELECT * FROM poupanca_extrato WHERE poupanca = " + codigoPoupanca + " ORDER BY ID DESC";
        stmt.executeQuery(verificaPoup);
        ResultSet resultSet = stmt.getResultSet();
        boolean existe = false;
        Double ultimoDeposito = 0.0;
        int ultimo = 0;
        Double valorComparativo = valor;
        while (valorComparativo != 0.0){
            while(resultSet.next()){
                int status = resultSet.getInt("status");
                ultimo = resultSet.getInt("id");
                ultimoDeposito = resultSet.getDouble("saldo");
                if (status == 1){
                        if (ultimoDeposito >= valorComparativo){
                            ultimoDeposito -= valorComparativo;
                            valorComparativo = 0.0;
                            String update = "UPDATE poupanca_extrato SET saldo = " + ultimoDeposito + " WHERE id = " + ultimo;
                            Statement stmt2 = (Statement)con2.createStatement();
                            stmt2.execute(update);
                            break;
                        } else {
                            valorComparativo -= ultimoDeposito;
                            String update = "UPDATE poupanca_extrato SET saldo = 0.0 WHERE id = " + ultimo;
                            Statement stmt3 = (Statement)con2.createStatement();
                            stmt3.execute(update);
                        }
                    }
                }
            }
        
        String delete = "DELETE FROM poupanca_extrato WHERE saldo = 0.0";
        System.out.println(delete);
        stmt.execute(delete);

        String juntaTodosOsDepositos ="SELECT * FROM poupanca_extrato WHERE poupanca = " + codigoPoupanca;
        System.out.println(juntaTodosOsDepositos);
        stmt.executeQuery(juntaTodosOsDepositos);
        ResultSet resultSet2 = stmt.getResultSet();
        Double saldoTotal = 0.0;

        while(resultSet2.next()){
            saldoTotal += resultSet2.getDouble("saldo");
        }


        String update = "UPDATE poupanca SET saldo = " + saldoTotal + " WHERE id = " + codigoPoupanca;
        System.out.println(update);
        stmt.execute(update);

        JFrame frame = new JFrame("");
        JOptionPane.showMessageDialog(frame,"Saque realizado com sucesso.",
        "Yay!",JOptionPane.INFORMATION_MESSAGE);  
        
        con2.close();
    }
    
    public String retirarExtrato() throws InterruptedException, SQLException {
        Connection con2 = DriverManager.getConnection("jdbc:mysql://127.0.0.1/banco","root","");
        Statement stmt = (Statement)con2.createStatement();
        
        String extrato = "SELECT * FROM poupanca_extrato WHERE poupanca = " + this.getIdPoupanca();
        stmt.executeQuery(extrato);
        ResultSet resultSet = stmt.getResultSet();
        String tudao = "\n";
        String positividade = "";
        Double saldoTotal = 0.0;
        while(resultSet.next()){
            saldoTotal += resultSet.getDouble("saldo");
            if (resultSet.getInt("status") == 1) 
            {
                positividade = "ATIVO";
            }
            else
            {
                positividade = "INATIVO";
            }
                
            tudao += "\n - R$" + String.format("%.2f", resultSet.getDouble("saldo")) + " - Aniversário: " + resultSet.getDate("aniversario") + " - (" + positividade + ")";
        }
        
        tudao += "\n\n Saldo total: R$" + saldoTotal;
        
        con2.close();
        return tudao;
    }
    
    
        public static void cadastrar(String cpfCliente) throws SQLException {
            Connection con2 = DriverManager.getConnection("jdbc:mysql://127.0.0.1/banco","root","");
            Statement stmt = (Statement)con2.createStatement();
            
            String achaCliente = "SELECT * FROM clientes WHERE cpf =" + cpfCliente;
            ResultSet result = stmt.executeQuery(achaCliente);
            int idCliente = 0;
            while (result.next()){
                idCliente = result.getInt("id");
            }
            
            String insert = "INSERT INTO poupanca(cliente,saldo) VALUES ('" + idCliente + "', 0.0);";
            stmt.execute(insert);
            
            con2.close();
        }
 }

