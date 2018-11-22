/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

import static banco.Helper.clearScreen;
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
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

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
    
    public static Cliente cadastrarCliente(int idCliente) throws ParseException {
        System.out.println("Digite o nome do cliente\n");
        Scanner leitor = new Scanner(System.in);
        String nome = leitor.nextLine();

        System.out.println("Digite o CPF do cliente\n");
        String cpf = leitor.next();

        System.out.println("Digite a Data de Nascimento (ex: 12/04/97) \n");
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date data = format.parse(leitor.next());
        
        Cliente cliente = new Cliente(idCliente, nome, cpf, data);
        clearScreen();

        return cliente;
    }
    
//    public static void excluirCliente(List<Cliente> clientes, List<Conta> contas) throws InterruptedException{
//        System.out.println("Digite o CPF do cliente que deseja excluir:\n");
//        Scanner leitor = new Scanner(System.in);
//        String cpf = leitor.next();
//        boolean achouCliente = false;
//        boolean achouConta = false;
//        for (Cliente c : clientes){
//            if ((c.getCpfCliente()).equals(cpf)){
//                achouCliente = true;
//                for (Conta co : contas){
//                    if (((co.getCliente().getCpfCliente())).equals(cpf)){
//                        System.out.println("NOME:" + co.getCliente().getNomeCliente());
//                        System.out.println("CPF:" + co.getCliente().getCpfCliente());
//                        
//                        achouConta = true;
//                    }
//                }
//            }
//        }
//        if (achouConta){
//            System.out.println("Cliente possui conta, deseja excluir ambos? (S/N)");
//            String resposta = leitor.next();
//            
//            if((resposta.equals("s")) || (resposta.equals("S")) || (resposta.equals("sim")) || (resposta.equals("SIM"))){
//                for (Iterator<Conta> iter = contas.listIterator(); iter.hasNext(); ) {
//                    Conta a = iter.next();
//                    if (((a.getCliente().getCpfCliente())).equals(cpf)) {
//                        iter.remove();
//                    }
//                }
//                
//                for (Iterator<Cliente> iter = clientes.listIterator(); iter.hasNext(); ) {
//                    Cliente a = iter.next();
//                    if ((a.getCpfCliente()).equals(cpf)) {
//                        iter.remove();
//                    }
//                }
//                System.out.println("Cliente e Contas excluídos com sucesso!");
//            }
//            else {
//                System.out.println("Você não pode excluir um cliente sem excluir a conta também.");
//            }            
//        } else if (achouCliente && !achouConta){
//            System.out.println("Cliente encontrado, e não possui conta, deseja excluir? (S/N)");
//            String resposta = leitor.next();
//            
//            if((resposta.equals("s")) || (resposta.equals("S")) || (resposta.equals("sim")) || (resposta.equals("SIM"))){
//                for (Iterator<Cliente> iter = clientes.listIterator(); iter.hasNext(); ) {
//                    Cliente a = iter.next();
//                    if ((a.getCpfCliente()).equals(cpf)) {
//                        iter.remove();
//                    }
//                }
//            }
//        }
//        
//        Thread.sleep(1500);
//    }
    
    public static void pesquisarCliente(List<Cliente> clientes) throws InterruptedException, ParseException {
        System.out.println("Digite o CPF a ser procurado:");
        Scanner leitor = new Scanner(System.in);
        String cpf = leitor.next();
        boolean achou = false;
        for (Cliente c : clientes){
            if((c.getCpfCliente()).equals(cpf)){
                clearScreen();
                System.out.println(" - ID: " + c.getIdCliente() + "\n - NOME: " + c.getNomeCliente());
                System.out.println(" - CPF: " + c.getCpfCliente() + "\n - DATA DE NASCIMENTO: " + c.getDataNascString());
                System.out.println("\n Retornando ao menu em 3 segundos...");
                achou = true;
            }
        }
        if (!achou)
            System.out.println("Cliente não encontrado :(");
        
        Thread.sleep(2000);
    }
    
    public static Cliente alterarCliente(List<Cliente> clientes) throws InterruptedException, ParseException{
        
        System.out.println("Digite o CPF do cliente que deseja pesquisar:\n");
        Scanner leitor = new Scanner(System.in);
        String cpf = leitor.next();
        clearScreen();
        Cliente cliente = null;
        for (Cliente co : clientes) {
            if (((co.getCpfCliente())).equals(cpf)) {
                cliente = co;
            }
        }

        if (cliente != null) {
            System.out.println("CPF: " + cpf);
            System.out.println((cliente.getNomeCliente()));
            System.out.println((cliente.getDataNascString() + "\n"));
            System.out.println("Alterar CPF? (s/n)");
            String resposta = leitor.next();
             if((resposta.equals("s")) || (resposta.equals("S")) || (resposta.equals("sim")) || (resposta.equals("SIM"))){
                 System.out.println("Digite o novo CPF:");
                 String newCPF = leitor.next();
                 cliente.setCpfCliente(newCPF);
             }
            clearScreen();
            System.out.println("Alterar Nome? (s/n)");
            resposta = leitor.next();
            if((resposta.equals("s")) || (resposta.equals("S")) || (resposta.equals("sim")) || (resposta.equals("SIM"))){
                System.out.println("Digite o novo nome:");
                String newNome = leitor.nextLine();
                cliente.setNomeCliente(newNome);
                 
             }
             System.out.println("Operação finalizada com sucesso.");
        } 
        else 
        {
            System.out.println("Cliente não encontrado.");
        }
        Thread.sleep(2500);
        return new Cliente();
    }
    
    
    
    
    
    //-----------------------DATABASE
    
    
    
    
    
    
    
    
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
}


