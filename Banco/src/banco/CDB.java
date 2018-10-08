/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

import static banco.Helper.formataDecimal;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author eduardo.schneider
 */
public class CDB {

    private int id;
    private String nome;
    private BigDecimal saldo;
    private Date vencimento;
    private BigDecimal porcentagemCDI;

    public CDB(int id, String nome, BigDecimal saldo, Date data, BigDecimal porcentagemCDI) {
        this.id = id;
        this.nome = nome;
        this.saldo = saldo;
        this.vencimento = data;
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

    public BigDecimal getSaldo() {
        return formataDecimal(saldo);
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public Date getVencimento() {
        return vencimento;
    }
    
    public String getVencimentoString() throws ParseException {
        DateFormat targetFormat = new SimpleDateFormat("dd/MM/yyyy");
        String str = targetFormat.format(vencimento);
        
        return str;
    }
    

    public void setVencimento(Date vencimento) {
        this.vencimento = vencimento;
    }

    public BigDecimal getPorcentagemCDI() {
        return porcentagemCDI;
    }

    public void setPorcentagemCDI(BigDecimal porcentagemCDI) {
        this.porcentagemCDI = porcentagemCDI;
    }
    
    

    public static void cadastrarCDB(List<CDB> cdbs, int idAtual) throws InterruptedException {

        System.out.println("Digite o nome do CDB:");
        Scanner leitor = new Scanner(System.in);
        String nome = leitor.nextLine();

        System.out.println("Digite o prazo do CDB:");
        int vencimento = Integer.parseInt(leitor.next());
        
        Date venciment = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(venciment);
        c.add(Calendar.DATE, vencimento);
        venciment = c.getTime();
        
        System.out.println("Digite a % do CDI de juros que serão aplicados: (Exemplo: 95)");
        BigDecimal porcentagem = new BigDecimal(leitor.next());
        
        CDB cdb = new CDB(idAtual, nome, new BigDecimal("0.0"), venciment, porcentagem.divide(new BigDecimal("100")));
        
        cdbs.add(cdb);
        
        System.out.println("CDB cadastrado com sucesso.");
        Thread.sleep(1500);
    }

    public static void investirCDB(Conta contaAtual, List<CDB> cdbs, List<CDB_Extrato> cdbMovimento, int idDeposito, List<Extrato> extratos) throws InterruptedException {
        System.out.println("Digite o código do CDB que deseja investir:");
        Scanner leitor = new Scanner(System.in);
        int codigo = Integer.parseInt(leitor.next());

        System.out.println("Digite o valor que deseja investir:");
        BigDecimal valor = new BigDecimal(leitor.next());

        if (contaAtual.getSaldo().compareTo(valor) > 0) {
            CDB cdbAlvo = null;
            for (CDB cdb : cdbs) {
                if (cdb.getId() == codigo) {
                    cdbAlvo = cdb;
                }
            }
            if (cdbAlvo != null) {
                cdbAlvo.setSaldo(cdbAlvo.getSaldo().add(valor));
                contaAtual.setSaldo(contaAtual.getSaldo().subtract(valor));
                CDB_Extrato movimento = new CDB_Extrato(idDeposito, cdbAlvo, contaAtual.getCliente(), valor, new Date(), true);
                cdbMovimento.add(movimento);
                System.out.println("Investimento realizado com sucesso!");
                Extrato extratoSaida = new Extrato(new Date(), valor, false, contaAtual);
                extratos.add(extratoSaida);
            } else {
                System.out.println("CDB Inexistente, por favor, verifique o código digitado.");
            }

        } else {
            System.out.println("Saldo insuficiente para realizar a transação.");
        }

        Thread.sleep(1500);
    }

    public static void verificaJuros(List<CDB> cdbs, List<Conta> contas, List<CDB_Extrato> cdbMovimento, Date dataDeHoje, List<Extrato> extratos) {
        LocalDate localDate = dataDeHoje.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int month = localDate.getMonthValue();

        Taxas taxas = new Taxas();
        BigDecimal taxaAtual;
        if (month >= 7) {
            taxaAtual = taxas.getCdiDiario()[month - 7];
        } else {
            taxaAtual = taxas.getCdiDiario()[month + 5];
        }

        for (CDB_Extrato movimento : cdbMovimento) {
            movimento.setSaldo(movimento.getSaldo().add(movimento.getSaldo().multiply(taxaAtual.divide(new BigDecimal("100")))));
        }

        for (CDB cdb : cdbs) {
            cdb.setSaldo(cdb.getSaldo().add(cdb.getSaldo().multiply(taxaAtual.divide(new BigDecimal("100")))));

            Date vencimento = cdb.getVencimento();
            localDate = vencimento.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            int day = localDate.getDayOfYear();
            localDate = dataDeHoje.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            int dayToday = localDate.getDayOfYear();

            if (((day - dayToday) == 0)) { // vence hoje
                for (CDB_Extrato movimento : cdbMovimento) {
                    if (movimento.getStatus()) {
                        if (movimento.getCdb() == cdb) { //movimento do CDB que venceu

                            for (Conta conta : contas) {
                                if (movimento.getCliente() == conta.getCliente()) {
                                    Extrato extratoEntrada = new Extrato(new Date(), movimento.getSaldo(), false, conta);
                                    extratos.add(extratoEntrada);
                                    conta.setSaldo(conta.getSaldo().add(movimento.getSaldo()));
                                }
                            }
                            
                            movimento.setSaldo(new BigDecimal("0.0"));
                            movimento.getCdb().setNome("VENCIDO(" + movimento.getCdb().getNome() + ")");
                            movimento.setStatus(false);
                        }
                    }
                }
                cdb.setSaldo(new BigDecimal("0.0"));
            }
        }
    }
}
