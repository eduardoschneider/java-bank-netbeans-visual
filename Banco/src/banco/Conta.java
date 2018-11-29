    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

import static banco.Cliente.getHashMd5;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author eduardo.schneider
 */
public class Conta {

    private int idConta;
    private String codigoConta;
    private int cliente;
    private Double saldo;
    private String senha;
    public static Conta logado = null;

    public Conta(int idConta, String codigoConta, int cliente, Double saldo, String senha) {
        this.idConta = idConta;
        this.codigoConta = codigoConta;
        this.cliente = cliente;
        this.saldo = saldo;
        this.senha = senha;
    }
    
    public Conta(int idConta, String codigoConta, int cliente, Double saldo) {
        this.idConta = idConta;
        this.codigoConta = codigoConta;
        this.cliente = cliente;
        this.saldo = saldo;
    }

    public Conta() {
    }

    public int getCliente() {
        return cliente;
    }

    
    public int getIdConta() {
        return idConta;
    }

    public void setIdConta(int idConta) {
        this.idConta = idConta;
    }

    public static Conta getLogado() {
        return logado;
    }

    public static void setLogado(Conta logado) {
        Conta.logado = logado;
    }
    
    public void setCliente(int cliente) {
        this.cliente = cliente;
    }

    public String getCodigoConta() {
        return codigoConta;
    }

    public void setCodigoConta(String codigoConta) {
        this.codigoConta = codigoConta;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.codigoConta);
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
        final Conta other = (Conta) obj;
        if (!Objects.equals(this.codigoConta, other.codigoConta)) {
            return false;
        }
        return true;
    }

    public void sacar(Double valor) throws SQLException {
        Connection con2 = DriverManager.getConnection("jdbc:mysql://127.0.0.1/banco","root","");
        Statement stmt = (Statement)con2.createStatement();   
        Date data = new Date();
        LocalDate date = data.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        
        if (this.getSaldo() >= valor) {
                     
            String update2 ="UPDATE conta SET saldo = saldo - " + valor + "WHERE codigo = '" + this.getCodigoConta() + "'";
            stmt.execute(update2);

            String update4 ="INSERT INTO extrato(data,valor,tipoMovimento,conta) VALUES ('" + date + "'," + valor + "," + false + "," + this.getIdConta() + ");";
            stmt.execute(update4);
        }
        else
        {
            JFrame frame = new JFrame("");
            JOptionPane.showMessageDialog(frame,"Saldo insuficiente para realizar a transação.",
            "ERRO",JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void consultarSaldo() throws SQLException {
        Connection con2 = DriverManager.getConnection("jdbc:mysql://127.0.0.1/banco","root","");
        Statement stmt = (Statement)con2.createStatement();   
        
        String update2 ="SELECT * FROM conta WHERE id = " + this.getIdConta();
        stmt.executeQuery(update2);
        double saldo = 0;
        ResultSet resultSet = stmt.getResultSet();
        while(resultSet.next()){
           saldo = resultSet.getDouble("saldo"); 
                
         }
       
        JFrame frame = new JFrame("");
        JOptionPane.showMessageDialog(frame,"Seu saldo é de R$" + saldo,
        "Saldo",JOptionPane.INFORMATION_MESSAGE);
       
    }

    public String retirarExtrato() throws InterruptedException, SQLException {
        Connection con2 = DriverManager.getConnection("jdbc:mysql://127.0.0.1/banco","root","");
        Statement stmt = (Statement)con2.createStatement();
        
        String extrato = "SELECT * FROM extrato WHERE conta = " + this.getIdConta();
        stmt.executeQuery(extrato);
        ResultSet resultSet = stmt.getResultSet();
        String tudao = "\n";
        String positividade = "";
        while(resultSet.next()){
            if (resultSet.getInt("tipoMovimento") == 1) 
            {
                positividade = "---";
            }
            else
            {
                positividade = "+++";
            }
                
            tudao = tudao + "\n" + resultSet.getDate("data") + " - R$" + resultSet.getDouble("valor") + " - (" + positividade + ")";
        }
        
        return tudao;
    }

    public void depositar(String contaAlvo, double quantidade) throws InterruptedException, SQLException {
        Connection con2 = DriverManager.getConnection("jdbc:mysql://127.0.0.1/banco","root","");
        Statement stmt = (Statement)con2.createStatement();   
        Date data = new Date();
        LocalDate date = data.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                   
        String pegaContaAlvo ="SELECT * FROM conta WHERE codigo = '" + contaAlvo + "'";
        stmt.executeQuery(pegaContaAlvo);
        ResultSet resultSet = stmt.getResultSet();
        Conta alvo = null;

        while(resultSet.next()){
            alvo = new Conta(resultSet.getInt("id"), resultSet.getString("codigo"), resultSet.getInt("cliente"), resultSet.getDouble("saldo"));
        }

        String update1 ="UPDATE conta SET saldo = saldo + " + quantidade + "WHERE codigo = '" + contaAlvo + "'";
        stmt.execute(update1);

        String update3 ="INSERT INTO extrato(data,valor,tipoMovimento,conta) VALUES ('" + date + "'," + quantidade + "," + true + "," + alvo.getIdConta() + ");";
        System.out.println(update3);
        stmt.execute(update3);
     
    }

    public void transferir(String contaAlvo, double quantidade) throws InterruptedException, SQLException {
        Connection con2 = DriverManager.getConnection("jdbc:mysql://127.0.0.1/banco","root","");
        Statement stmt = (Statement)con2.createStatement();   
        Date data = new Date();
        LocalDate date = data.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        
        if (this.getSaldo() >= quantidade) {
            
            String pegaContaAlvo ="SELECT * FROM conta WHERE codigo = '" + contaAlvo + "'";
            stmt.executeQuery(pegaContaAlvo);
            ResultSet resultSet = stmt.getResultSet();
            Conta alvo = null;
            
            while(resultSet.next()){
                alvo = new Conta(resultSet.getInt("id"), resultSet.getString("codigo"), resultSet.getInt("cliente"), resultSet.getDouble("saldo"));
            }
            
            String update1 ="UPDATE conta SET saldo = saldo + " + quantidade + "WHERE codigo = '" + contaAlvo + "'";
            stmt.execute(update1);
            String update2 ="UPDATE conta SET saldo = saldo - " + quantidade + "WHERE codigo = '" + this.getCodigoConta() + "'";
            stmt.execute(update2);

            String update3 ="INSERT INTO extrato(data,valor,tipoMovimento,conta) VALUES ('" + date + "'," + quantidade + "," + true + "," + alvo.getIdConta() + ");";
            System.out.println(update3);
            stmt.execute(update3);
            String update4 ="INSERT INTO extrato(data,valor,tipoMovimento,conta) VALUES ('" + date + "'," + quantidade + "," + false + "," + this.getIdConta() + ");";
            stmt.execute(update4);
        }
        else
        {
            JFrame frame = new JFrame("");
            JOptionPane.showMessageDialog(frame,"Saldo insuficiente para realizar a transação.",
            "ERRO",JOptionPane.INFORMATION_MESSAGE);
        }
    }
        
    

    public void pagarBoleto(Double quantidade) throws SQLException {
        Connection con2 = DriverManager.getConnection("jdbc:mysql://127.0.0.1/banco","root","");
        Statement stmt = (Statement)con2.createStatement();   
        Date data = new Date();
        LocalDate date = data.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        
        if (this.getSaldo() >= quantidade) {
        
            String update1 ="UPDATE conta SET saldo = saldo - " + quantidade + "WHERE codigo = '" + this.getCodigoConta() + "'";
            stmt.execute(update1);

            String update3 ="INSERT INTO extrato(data,valor,tipoMovimento,conta) VALUES ('" + date + "'," + quantidade + "," + true + "," + this.getIdConta() + ");";
            System.out.println(update3);
            stmt.execute(update3);
        }
        else
        {
            JFrame frame = new JFrame("");
            JOptionPane.showMessageDialog(frame,"Saldo insuficiente para realizar a transação.",
            "ERRO",JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void logar(Cliente cliente) throws SQLException{
        Connection con2 = DriverManager.getConnection("jdbc:mysql://127.0.0.1/banco","root","");
        Statement stmt = (Statement)con2.createStatement();
        int clientId = cliente.getIdCliente();
        String consulta ="SELECT * FROM conta WHERE cliente = '" + clientId +"'";
        ResultSet resultSet = stmt.executeQuery(consulta);
        
        while (resultSet.next()){
            Conta logado = new Conta(resultSet.getInt("id"), resultSet.getString("codigo"), cliente.getIdCliente(), resultSet.getDouble("saldo"));
                Conta.logado = logado;
                Poupanca.logar(cliente);
            }
        } 
    
    public void cadastrarConta(String codigo, String cpf, Double saldo) throws SQLException, ParseException {
        Connection con2 = DriverManager.getConnection("jdbc:mysql://127.0.0.1/banco","root","");
        Statement stmt = (Statement)con2.createStatement();  

        String findCliente = "SELECT * FROM clientes WHERE cpf = '"+ cpf + "'";
        ResultSet resultSet = stmt.executeQuery(findCliente);
        Cliente encontrado = null;

        while (resultSet.next()){
            encontrado = new Cliente(resultSet.getInt("id"),resultSet.getString("nome"),resultSet.getString("cpf"),resultSet.getDate("dataNasc"));
        }

        String update3 = "INSERT INTO conta(codigo,cliente,saldo) VALUES ('" + codigo + "','" + encontrado.getIdCliente() + "','" + saldo + "');";
        stmt.execute(update3);

        JFrame frame = new JFrame("");
        JOptionPane.showMessageDialog(frame,"Conta cadastrada com sucesso.",
        "Yay!",JOptionPane.INFORMATION_MESSAGE);     
    }
    
    public void alterarConta(String codigoVelho, String novoCodigo) throws SQLException, ParseException {
        Connection con2 = DriverManager.getConnection("jdbc:mysql://127.0.0.1/banco","root","");
        Statement stmt = (Statement)con2.createStatement();  
        
        String update3 = "UPDATE conta SET codigo = '" + novoCodigo + "' WHERE codigo = '" + codigoVelho + "';";
        System.out.println(update3);
        stmt.execute(update3);
        
        JFrame frame = new JFrame("");
        JOptionPane.showMessageDialog(frame,"Conta alterada com sucesso.",
        "Yay!",JOptionPane.INFORMATION_MESSAGE);     
    }
    
    public void deletarConta(String cpf) throws SQLException, ParseException {
        Connection con2 = DriverManager.getConnection("jdbc:mysql://127.0.0.1/banco","root","");
        Statement stmt = (Statement)con2.createStatement();  

        String findCliente = "SELECT * FROM clientes WHERE cpf = '"+ cpf + "'";
        ResultSet resultSet = stmt.executeQuery(findCliente);
        Cliente c = null; 
        
        while (resultSet.next()){
            c = new Cliente(resultSet.getInt("id"),resultSet.getString("nome"),resultSet.getString("cpf"),resultSet.getDate("dataNasc"));      
            resultSet.close();
            break;
        } 
        
        String delete3 = "DELETE FROM conta WHERE cliente = '" + c.getIdCliente() + "'";
        stmt.execute(delete3);  
        
        JFrame frame = new JFrame("");
        JOptionPane.showMessageDialog(frame,"Conta deletada com sucesso.",
        "Yay!",JOptionPane.INFORMATION_MESSAGE);     
    }
}
