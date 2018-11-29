/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author eduardo.schneider
 */
public class Cliente {
    private int idCliente;
    private String nomeCliente;
    private String cpfCliente;
    private Date dataNasc;
    public static Cliente logado = null;

    public Cliente(int idCliente, String nomeCliente, String cpfCliente, Date dataNasc) {
        this.idCliente = idCliente;
        this.nomeCliente = nomeCliente;
        this.cpfCliente = cpfCliente;
        this.dataNasc = dataNasc;
    }

   public Cliente(){}

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    public Date getDataNasc() {
        return dataNasc;
    }
    
    public String getDataNascString() throws ParseException {
        DateFormat targetFormat = new SimpleDateFormat("dd/MM/yyyy");
        String str = targetFormat.format(dataNasc);
        
        return str;
    }

    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }

    public static boolean logar(String login, String senhaa) throws SQLException, ClassNotFoundException{

    Connection con2 = DriverManager.getConnection("jdbc:mysql://127.0.0.1/banco","root","");
    Statement stmt = (Statement)con2.createStatement();
    String senha = getHashMd5(senhaa);
    String consulta ="SELECT * FROM clientes WHERE login = '"+ login + "' AND senha = '" + senha + "'";
    ResultSet resultSet = stmt.executeQuery(consulta);

    while (resultSet.next()){
        Cliente logado = new Cliente(resultSet.getInt("id"),resultSet.getString("nome"),resultSet.getString("cpf"),resultSet.getDate("dataNasc"));
        String a = resultSet.getString("login");
        String b = resultSet.getString("senha");
        if ((a.equals(login)) && (b.equals(senha))){
            Cliente.logado = logado;
            Conta.logar(logado);
            return true;
        }
    }

    return false;
}

    public static String getHashMd5(String value) {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        BigInteger hash = new BigInteger(1, md.digest(value.getBytes()));
        return hash.toString(16);
    }

    public void cadastrarCliente(String nome, String cpf, String dataNasc, String login, String senha) throws SQLException, ParseException {
        Connection con2 = DriverManager.getConnection("jdbc:mysql://127.0.0.1/banco","root","");
        Statement stmt = (Statement)con2.createStatement();  
        String senhaa = getHashMd5(senha);
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy"); // your template here
        java.util.Date dateStr = formatter.parse(dataNasc);
        java.sql.Date dateDB = new java.sql.Date(dateStr.getTime());
        String update3 ="INSERT INTO clientes(nome,cpf,dataNasc,login,senha) VALUES ('" + nome + "','" + cpf + "','" + dateDB + "','" + login +"','" + senhaa + "');";
        System.out.println(update3);
        stmt.execute(update3);

        JFrame frame = new JFrame("");
        JOptionPane.showMessageDialog(frame,"Usuário inserido com sucesso.",
        "Yay!",JOptionPane.INFORMATION_MESSAGE);     
    }

    public void alterarCliente(String nome, String cpf, String dataNasc, String login, String senha) throws SQLException, ParseException {
        Connection con2 = DriverManager.getConnection("jdbc:mysql://127.0.0.1/banco","root","");
        Statement stmt = (Statement)con2.createStatement();  
        String senhaa = getHashMd5(senha);
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy"); // your template here
        java.util.Date dateStr = formatter.parse(dataNasc);
        java.sql.Date dateDB = new java.sql.Date(dateStr.getTime());

        String findCliente = "SELECT * FROM clientes WHERE login = '"+ login + "'";
        ResultSet resultSet = stmt.executeQuery(findCliente);
        Cliente encontrado = null;

        while (resultSet.next()){
            encontrado = new Cliente(resultSet.getInt("id"),resultSet.getString("nome"),resultSet.getString("cpf"),resultSet.getDate("dataNasc"));
        }

        String update3 = "UPDATE clientes SET nome = '" + nome + "', cpf = '"+ cpf + "', dataNasc = '" + dateDB + "', senha = '"+ senhaa + "' WHERE login = '" + login + "';";
        System.out.println(update3);
        stmt.execute(update3);

        JFrame frame = new JFrame("");
        JOptionPane.showMessageDialog(frame,"Usuário alterado com sucesso.",
        "Yay!",JOptionPane.INFORMATION_MESSAGE);     
    }

    public void deletarCliente(String cpf) throws SQLException, ParseException {
        Connection con2 = DriverManager.getConnection("jdbc:mysql://127.0.0.1/banco","root","");
        Statement stmt = (Statement)con2.createStatement();  

        String findCliente = "SELECT * FROM clientes WHERE cpf = '"+ cpf + "'";
        ResultSet resultSet = stmt.executeQuery(findCliente);

        while (resultSet.next()){
            String delete3 = "DELETE FROM clientes WHERE id = '" + resultSet.getInt("id") + "'";
            stmt.execute(delete3);            
            resultSet.close();
            break;
        }

        JFrame frame = new JFrame("");
        JOptionPane.showMessageDialog(frame,"Cliente deletado com sucesso.",
        "Yay!",JOptionPane.INFORMATION_MESSAGE);     
    }
}


