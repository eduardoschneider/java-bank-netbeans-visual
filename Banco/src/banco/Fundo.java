/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

import static banco.Helper.formataDecimal;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

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

    public BigDecimal getSaldo() {
        return formataDecimal(saldo);
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
    
    

    public static void cadastrarFundo(List<Fundo> fundos, int idAtual) throws InterruptedException {

        System.out.println("Digite o nome do Fundo de Investimento:");
        Scanner leitor = new Scanner(System.in);
        String nome = leitor.nextLine();
        boolean achou = false;
        for (Fundo f : fundos){
            if (f.getNome().equals(nome))
                achou = true;
        }
        if (!achou){
            System.out.println("Digite a porcentagem do CDI: (ex: 95)");
            BigDecimal porcentagem = new BigDecimal(leitor.next());
            Fundo fundo = new Fundo(idAtual, nome, new BigDecimal("0.0"), porcentagem.divide(new BigDecimal("100")));
            fundos.add(fundo);

            System.out.println("\nFundo de Investimento cadastrado com sucesso!");
        }
        else
            System.out.println("\nEsse Fundo de Investimento já existe.");
        Thread.sleep(1500);
    }

    public static void verificaJuros(List<Fundo> fundos, List<Fundo_Extrato> fundoMovimento, Date dataDeHoje) {
        LocalDate localDate = dataDeHoje.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int month = localDate.getMonthValue();

        Taxas taxas = new Taxas();
        BigDecimal taxaAtual;
        if (month >= 7) {
            taxaAtual = taxas.getCdiDiario()[month - 7];
            
        } else {
            taxaAtual = taxas.getCdiDiario()[month + 5];
        }

        for (Fundo_Extrato movimento : fundoMovimento) {
            movimento.setSaldo(movimento.getSaldo().add
            (movimento.getSaldo().multiply
            ((taxaAtual.divide
            (new BigDecimal("100")).multiply
            (movimento.getFundo().getPorcentagemCDI())))));
        }

        for (Fundo fundo : fundos) {
            fundo.setSaldo(fundo.getSaldo().add
            (fundo.getSaldo().multiply
            (taxaAtual.divide(new BigDecimal("100").multiply(fundo.getPorcentagemCDI()),RoundingMode.HALF_UP))));
            
           

        }
    }

    static void investir(List<Fundo> fundos, List<Fundo_Extrato> fundoMovimento, Conta contaAtual, int contadorFundoDepositos, List<Extrato> extratos) throws InterruptedException {

        System.out.println("Deseja sacar ou investir? Digite 0 para sacar e 1 para investir.");
        Scanner leitor = new Scanner(System.in);
        int opcao = Integer.parseInt(leitor.next());
        Fundo fundoEscolhido = new Fundo(-1, "a", new BigDecimal("0.0"), new BigDecimal("0.0"));
        if (opcao == 0) {

            System.out.println("Digite o código do fundo:");
            int fundo = Integer.parseInt(leitor.next());

            for (Fundo escolhido : fundos) {
                if (escolhido.getId() == fundo) {
                    fundoEscolhido = escolhido;
                }
            }

            if (fundoEscolhido.getId() != -1) {

                System.out.println("Digite o valor que deseja sacar:");
                BigDecimal valor = new BigDecimal(leitor.next());

                Fundo_Extrato valorInvestido = new Fundo_Extrato(new BigDecimal("0.0"));

                for (Fundo_Extrato fe : fundoMovimento) {
                    if (fe.getId() == fundo) {
                        if (fe.getCliente() == contaAtual.getCliente()) {
                            valorInvestido.setSaldo(valorInvestido.getSaldo().add(fe.getSaldo()));
                        }
                    }
                }

                if (valorInvestido.getSaldo().compareTo(valor) < 0) {
                    System.out.println("Saldo insuficiente para realizar o saque.");
                } else {
                    Fundo_Extrato ultimoDeposito = null;
                    BigDecimal valorFinal = valorInvestido.getSaldo().subtract(valor);
                    while (valorInvestido.getSaldo().compareTo(valorFinal) > 0) {
                        for (Fundo_Extrato fe : fundoMovimento) {
                            if (fe.getId() == fundo) {
                                if (fe.getCliente() == contaAtual.getCliente()) {
                                    if (fe.getStatus() == true) {
                                        ultimoDeposito = fe;
                                    }
                                }
                            }
                        }
                        if (valor.compareTo(ultimoDeposito.getSaldo()) < 0) {
                            
                            ultimoDeposito.setSaldo(ultimoDeposito.getSaldo().subtract(valor));
                            fundoEscolhido.setSaldo(fundoEscolhido.getSaldo().subtract(valor));
                            valorInvestido.setSaldo(valorInvestido.getSaldo().subtract(valor));
                            contaAtual.setSaldo(contaAtual.getSaldo().add(valor));
                            
                        } else if (valor.compareTo(ultimoDeposito.getSaldo()) > 0) {
                            
                            valor = valor.subtract(ultimoDeposito.getSaldo());
                            fundoEscolhido.setSaldo(fundoEscolhido.getSaldo().subtract(ultimoDeposito.getSaldo()));
                            valorInvestido.setSaldo(valorInvestido.getSaldo().subtract(ultimoDeposito.getSaldo()));
                            contaAtual.setSaldo(contaAtual.getSaldo().add(ultimoDeposito.getSaldo()));
                            ultimoDeposito.setSaldo(new BigDecimal("0.0"));
                            ultimoDeposito.setStatus(false);
                        }
                    }
                }

            }
        } else if (opcao == 1) {
            System.out.println("Digite o valor que deseja depositar no fundo: \n");

            BigDecimal valor = new BigDecimal(leitor.next());

            System.out.println("Digite o ID do fundo a ser depositado: \n");
            int idAlvo = Integer.parseInt(leitor.next());

            Fundo fundoAlvo = null;

            for (Fundo p : fundos) {
                if (p.getId() == idAlvo) {
                    fundoAlvo = p;
                }
            }
            if (fundoAlvo != null) {
                if ((contaAtual.getSaldo()).compareTo(valor.add(new BigDecimal("0.1"))) > 0) {
                    contaAtual.setSaldo((contaAtual.getSaldo()).subtract(valor));
                    fundoAlvo.setSaldo((fundoAlvo.getSaldo()).add(valor));
                    Extrato extratoSaida = new Extrato(new Date(), valor, false, contaAtual);
                    extratos.add(extratoSaida);
                    Fundo_Extrato movimento = new Fundo_Extrato(contadorFundoDepositos, fundoAlvo, contaAtual.getCliente(), valor, new Date(), true);
                    fundoMovimento.add(movimento);
                    System.out.println("Depositado com sucesso.");
                } else {
                    System.out.println("Saldo insuficiente na conta corrente para transferir para o fundo.");
                }
            } else {
                System.out.println("Fundo inserido não existe.");
            }

        } else {
            System.out.println("Opção inválida!");
        }

        Thread.sleep(1500);
    }
}
