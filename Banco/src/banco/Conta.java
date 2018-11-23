    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

import static banco.Helper.clearScreen;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static jdk.nashorn.tools.ShellFunctions.input;

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

//    public static void cadastrarConta(List<Cliente> todos, List<Conta> todas, int idConta) throws InterruptedException {
//        System.out.println("Digite o CPF do Cliente: \n");
//        Scanner leitor = new Scanner(System.in);
//        String cpf = leitor.next();
//
//        Cliente atual = null; // só p inicializar
//        Conta conta = null; // só p inicializar
//
//        for (Cliente cadaCliente : todos) {
//            if (cadaCliente.getCpfCliente().equals(cpf)) {
//                atual = cadaCliente;
//            }
//        }
//        boolean temConta = false;
//        if (atual != null) {
//            for (Conta cadaConta : todas) {
//                if ((cadaConta.getCliente()).getCpfCliente().equals(cpf)) {
//                    temConta = true;
//                }
//            }
//            if (!temConta) {
//                System.out.println("Digite uma senha para a nova conta: ");
//                String senha = leitor.nextLine();
//                conta = new Conta("000-0" + idConta, atual, new BigDecimal("0.0"), senha);
//                todas.add(conta);
//                idConta++;
//                System.out.println("Conta cadastrada com sucesso.");
//                System.out.println("O código é: " + conta.getCodigoConta());
//                
//                
//            } else {
//                System.out.println("Cliente já possui conta!");
//            }
//        } else {
//            System.out.println("Cliente não encontrado.");
//        }
//        Thread.sleep(1500);
//    }

    public static Conta perguntaUsuario(List<Conta> todas) throws InterruptedException {
        System.out.println("Digite sua conta\n");
        Scanner leitor = new Scanner(System.in);
        String conta = leitor.next();
        
        System.out.println("Digite sua senha:");
        String senha = leitor.next();
        
        clearScreen();
        for (Conta cadaConta : todas) {
            if (cadaConta.getCodigoConta().equals(conta)) {
                if (cadaConta.getSenha().equals(senha))
                return cadaConta;
            }
        }
        System.out.println("Código ou senha inválidos.");
        Thread.sleep(1500);
        return null;
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
//
    public void depositar(String contaAlvo, double quantidade) throws InterruptedException, SQLException {
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

            String update3 ="INSERT INTO extrato(data,valor,tipoMovimento,conta) VALUES ('" + date + "'," + quantidade + "," + true + "," + alvo.getIdConta() + ");";
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

//    public static void excluirConta(List<Conta> contas) throws InterruptedException {
//        System.out.println("Digite o CPF do dono da conta que deseja excluir:\n");
//        Scanner leitor = new Scanner(System.in);
//        String cpf = leitor.next();
//        boolean achouConta = false;
//
//        for (Conta co : contas) {
//            if (((co.getCliente().getCpfCliente())).equals(cpf)) {
//                achouConta = true;
//            }
//        }
//
//        if (achouConta) {
//            System.out.println("Conta encontrada, deseja excluir? (S/N)");
//            String resposta = leitor.next();
//
//            if ((resposta.equals("s")) || (resposta.equals("S")) || (resposta.equals("sim")) || (resposta.equals("SIM"))) {
//                for (Iterator<Conta> iter = contas.listIterator(); iter.hasNext();) {
//                    Conta a = iter.next();
//                    if (((a.getCliente().getCpfCliente())).equals(cpf)) {
//                        iter.remove();
//                    }
//                }
//            }
//            System.out.println("Conta excluida com sucesso!");
//        } else {
//            System.out.println("Conta não encontrada.");
//        }
//        Thread.sleep(1500);
//    }
//
//    public static void alterarConta(List<Conta> contas) throws InterruptedException {
//        System.out.println("Digite o CPF do dono da conta que deseja alterar:\n");
//        Scanner leitor = new Scanner(System.in);
//        String cpf = leitor.next();
//        boolean achouConta = false;
//
//        for (Conta co : contas) {
//            if (((co.getCliente().getCpfCliente())).equals(cpf)) {
//                achouConta = true;
//            }
//        }
//
//        if (achouConta) {
//            System.out.println("Deseja alterar o código? ");
//            String resposta = leitor.next();
//            if ((resposta.equals("s")) || (resposta.equals("S")) || (resposta.equals("sim")) || (resposta.equals("SIM"))) {
//            
//                System.out.println("Digite o novo código da conta:");
//                resposta = leitor.next();
//
//                for (Iterator<Conta> iter = contas.listIterator(); iter.hasNext();) {
//                    Conta a = iter.next();
//                    if (((a.getCliente().getCpfCliente())).equals(cpf)) {
//                        a.setCodigoConta(resposta);
//                    }
//                }
//                
//                System.out.println("Conta alterada com sucesso.");
//                Thread.sleep(1000);
//            } 
//            System.out.println("Deseja alterar a senha? ");
//            resposta = leitor.next();
//            
//            if ((resposta.equals("s")) || (resposta.equals("S")) || (resposta.equals("sim")) || (resposta.equals("SIM"))) {
//            
//                System.out.println("Digite a senha anterior:");
//                String anterior = leitor.next();
//                
//                System.out.println("Digite a nova senha:");
//                resposta = leitor.next();
//                boolean alterou = false;
//                
//                for (Iterator<Conta> iter = contas.listIterator(); iter.hasNext();) {
//                    Conta a = iter.next();
//                    if ((a.getSenha().equals(anterior)) && ((a.getCliente().getCpfCliente())).equals(cpf)) {
//                        a.setSenha(resposta);
//                        alterou = true;
//                        System.out.println("Conta alterada com sucesso.");
//                    }
//                }
//                
//                if (!alterou){
//                    System.out.println("Senha anterior incompatível.");
//                }
//                Thread.sleep(1000);
//            } 
//        }
//        else 
//        {
//            System.out.println("Conta não encontrada.");
//        }
//    }
//    
//    public static void pesquisarConta(List<Conta> contas) throws InterruptedException, ParseException{
//        System.out.println("Digite o CPF do dono da conta que deseja pesquisar:\n");
//        Scanner leitor = new Scanner(System.in);
//        String cpf = leitor.next();
//        clearScreen();
//        Conta conta = null;
//        boolean achouConta = false;
//        for (Conta co : contas) {
//            if (((co.getCliente().getCpfCliente())).equals(cpf)) {
//                conta = co;
//                achouConta = true;
//            }
//        }
//
//        if (achouConta) {
//            System.out.println("CPF: " + cpf);
//            System.out.println((conta.getCliente().getNomeCliente()));
//            System.out.println((conta.getCliente().getDataNascString()));
//            System.out.println("Conta: " + conta.getCodigoConta());
//            System.out.println("Saldo: R$" + conta.getSaldo());
//            
//            Thread.sleep(2500);
//        } 
//        else 
//        {
//            System.out.println("Conta não encontrada.");
//        }
//    }
        
    
    
    
    
    //-----------------------DATABASE
    
    
    
    
    
    
    
    
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
    }
