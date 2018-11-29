/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

import static banco.Helper.clearScreen;
import static banco.Helper.formataDecimal;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
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

    public BigDecimal getSaldo() {
        return formataDecimal(saldo);
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

//    public static void depositarPoupanca(Conta contaAtual, List<Poupanca> poupancas, List<Extrato> extratos, List<Poupanca_Extrato> poupancaMovimento, int contadorPoupancaDepositos) throws InterruptedException {
//        clearScreen();
//        System.out.println("Digite o valor que deseja depositar na poupança: \n");
//        Scanner leitor = new Scanner(System.in);
//        BigDecimal valor = new BigDecimal(leitor.next());
//
//        System.out.println("Digite o ID da conta poupanca a ser depositado: \n");
//        String idAlvo = leitor.next();
//        Poupanca poupancaAlvo = null;
//        for (Poupanca p : poupancas) {
//            if (p.getIdPoupanca().equals(idAlvo)) {
//                poupancaAlvo = p;
//            }
//        }
//        if (poupancaAlvo != null) {
//            if ((contaAtual.getSaldo()).compareTo(valor.add(new BigDecimal("0.1"))) > 0) {
//                contaAtual.setSaldo((contaAtual.getSaldo()).subtract(valor));
//                poupancaAlvo.setSaldo((poupancaAlvo.getSaldo()).add(valor));
//                Extrato extratoSaida = new Extrato(new Date(), valor, false, contaAtual);
//                extratos.add(extratoSaida);
//                Poupanca_Extrato movimento = new Poupanca_Extrato(contadorPoupancaDepositos, poupancaAlvo, valor, new Date(), null, new Date(), true);
//                poupancaMovimento.add(movimento);
//                System.out.println("Depositado com sucesso.");
//            } else {
//                System.out.println("Saldo insuficiente na conta corrente para transferir para poupança.");
//            }
//        } else {
//            System.out.println("Conta poupança inserida não existe.");
//        }
//        Thread.sleep(1500);
//    }

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

    public void sacarPoupanca(List<Poupanca_Extrato> depositos) {
        System.out.println("Digite o valor que deseja sacar: ");
        Scanner leitor = new Scanner(System.in);
        BigDecimal valor = new BigDecimal(leitor.next());

        if (this.getSaldo().compareTo(valor) < 0) {
            System.out.println("Saldo insuficiente para realizar o saque.");
        } else {
            Poupanca_Extrato ultimoDeposito = null;
            BigDecimal valorFinal = this.getSaldo().subtract(valor);
            while (this.getSaldo().compareTo(valorFinal) > 0) {
                for (Poupanca_Extrato pd : depositos) {
                    if (pd.getContapoupanca().equals(this)) {
                        if (pd.getStatus() == true) {
                            ultimoDeposito = pd;
                        }
                    }
                }
            if (valor.compareTo(ultimoDeposito.getSaldo()) < 0){
                ultimoDeposito.setSaldo(ultimoDeposito.getSaldo().subtract(valor));
                this.setSaldo(this.getSaldo().subtract(valor));
            }
            else if (valor.compareTo(ultimoDeposito.getSaldo()) > 0){
                valor = valor.subtract(ultimoDeposito.getSaldo());
                this.setSaldo(this.getSaldo().subtract(ultimoDeposito.getSaldo()));
                ultimoDeposito.setSaldo(new BigDecimal("0.0"));
                ultimoDeposito.setStatus(false);
                 
                }
            }
        }
    }
    
    
    static void verificaJuros(List<Poupanca> poupancas, List<Poupanca_Extrato> poupancaMovimento, Date dia) {
       LocalDate localDate = dia.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
       int month = localDate.getMonthValue();
        
        Taxas taxas = new Taxas();
        BigDecimal taxaAtual;
        
        if (month >= 7){
            taxaAtual = taxas.getSelicMensal()[month - 7];
            if ((taxas.getSelicAnual()[month - 7]).compareTo(new BigDecimal("8.5")) < 0)
                taxaAtual = taxas.getSelicMensal()[month - 7].multiply(new BigDecimal("0.7"));
        } else 
        {
            taxaAtual = taxas.getSelicMensal()[month + 5];
            if ((taxas.getSelicAnual()[month + 5]).compareTo(new BigDecimal("8.5")) < 0)
                taxaAtual = taxas.getSelicMensal()[month + 5].multiply(new BigDecimal("0.7"));
        }
        
        for (Poupanca_Extrato po : poupancaMovimento){
            if (po.getStatus()){
                Date niver = po.getAniversario();
                localDate = niver.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                int day = localDate.getDayOfYear();
                localDate = dia.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                int dayToday = localDate.getDayOfYear();
                
                if ((dayToday - day) % 30 == 0){
                    po.setSaldo(po.getSaldo().add(po.getSaldo().multiply(taxaAtual.divide(new BigDecimal("100")))));
                    BigDecimal lucro = po.getSaldo().multiply(taxaAtual.divide(new BigDecimal("100")));
                    Poupanca a = po.getContapoupanca();
                    a.setSaldo(a.getSaldo().add(lucro));
                }
            }
        }
        
   }
    public void printSaldo() throws InterruptedException {
        System.out.println("O saldo da sua poupança é: R$" + this.getSaldo());
        Thread.sleep(1500);
    }
        
    
    
    
    
    //-----------------------DATABASE
    
    
    
    
    
    
    
    
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
        }
        else {
            JFrame frame = new JFrame("");
            JOptionPane.showMessageDialog(frame,"Poupança não encontrada.",
            "ERRO",JOptionPane.INFORMATION_MESSAGE);  
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
                
            tudao += "\n - R$" + resultSet.getDouble("saldo") + " - Aniversário: " + resultSet.getDate("aniversario") + " - (" + positividade + ")";
        }
        
        tudao += "\n\n Saldo total: R$" + saldoTotal;
        
        return tudao;
    }
    
 }

