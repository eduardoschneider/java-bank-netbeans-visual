/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

import static banco.Helper.clearScreen;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author eduardo.schneider
 */
public class Banco {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     * @throws java.lang.InterruptedException
     */
    
    @SuppressWarnings("ResultOfObjectAllocationIgnored") //só pra warning não encher o saco (:
    public void main(String[] args) throws IOException, InterruptedException, ParseException {
        new Banco();
    }

    private Banco() throws InterruptedException, ParseException {
        Date dataDeHoje = new Date();
        int idCliente = 5;
        int idConta = 5;
        int idCDB = 4;
        Helper help = new Helper();
        Conta contaAtual = new Conta();
        Poupanca poupancaAtual = new Poupanca();
        List<Cliente> clientes = new ArrayList();
        List<Conta> contas = new ArrayList();
        List<Poupanca> poupancas = new ArrayList();
        List<Poupanca_Extrato> poupancaMovimento = new ArrayList();
        List<CDB> cdbs = new ArrayList();
        List<CDB_Extrato> cdbMovimento = new ArrayList();
        List<Fundo> fundos = new ArrayList();
        List<Fundo_Extrato> fundoMovimento = new ArrayList();
        List<Extrato> extratos = new ArrayList();
        int contadorPoupancaDepositos = 0;
        int contadorCDBDepositos = 0;
        int contadorFundoDepositos = 0;
        
        ///////////////////////////FUNÇÃO COM OS DADOS//////////////////////////////
        help.populaParaTestes(clientes, contas, poupancas, cdbs, fundos);
        ///////////////////////////////////////////////////////////////////////////
        
        int opcao = 0;
        Scanner leitor = new Scanner(System.in);
        while (opcao != 4) {
            opcao = help.perguntaTipo();
            switch (opcao) {
                
                //////////////////////////// ADMINISTRADOR ///////////////////////////////////
                case 1:
                    clearScreen();
                    while ((opcao != 18)) {
                        help.showAdminMenu();
                        opcao = leitor.nextInt();
                        switch (opcao) {
                            //CADASTRAR CLIENTE
                            case 1:
                                clearScreen();
                                clientes.add(Cliente.cadastrarCliente(idCliente));
                                idCliente++;
                                break;
                                
                            //EXCLUIR CLIENTE
                            case 2:
                                clearScreen();
                                Cliente.excluirCliente(clientes, contas);
                                break;
                                
                            //ALTERAR CLIENTE
                            case 3:
                                clearScreen();
                                Cliente.alterarCliente(clientes);
                                break;
                                
                            //PESQUISAR CLIENTE
                            case 4:
                                clearScreen();
                                Cliente.pesquisarCliente(clientes);
                                break;
                                
                            //CADASTRAR CONTA
                            case 5:
                                clearScreen();
                                Conta.cadastrarConta(clientes,contas, idConta);
                                idConta++;
                                break;
                                
                            //EXCLUIR CONTA
                            case 6:
                                clearScreen();
                                Conta.excluirConta(contas);
                                break;
                                
                            //ALTERAR CONTA
                            case 7:
                                clearScreen();
                                Conta.alterarConta(contas);
                                break;
                                
                            //PESQUISAR CONTA
                            case 8:
                                clearScreen();
                                Conta.pesquisarConta(contas);
                                break;
                               
                            //CADASTRAR FUNDO DE INVESTIMENTO
                            case 9:
                                clearScreen();
                                Fundo.cadastrarFundo(fundos, idCDB);
                                break;
                                
                            //CADASTRAR CDB
                            case 10:
                                clearScreen();
                                CDB.cadastrarCDB(cdbs, idCDB);
                                idCDB++;
                              break;  
                            
                            //AVANÇAR O DIA E APLICAR OS JUROS
                            case 12:
                                clearScreen();
                                
                                int quantos = help.incrementaDia(dataDeHoje);
                                
                                for (int i = 0; i <= quantos; i++){
                                    dataDeHoje = help.diaMaisMais(dataDeHoje);
                                    Poupanca.verificaJuros(poupancas, poupancaMovimento, dataDeHoje);
                                    CDB.verificaJuros(cdbs, contas, cdbMovimento, dataDeHoje, extratos);
                                    Fundo.verificaJuros(fundos, fundoMovimento, dataDeHoje);
                                }
                                break;
                                
                            //LISTAR MOVIMENTOS DAS POUPANÇAS
                            case 13:
                                clearScreen();
                                if (poupancaAtual != null)
                                    Poupanca_Extrato.printaDepositos(poupancaMovimento);
                                break;
                                
                            //LISTAR MOVIMENTOS DOS CDBS
                            case 14:
                                clearScreen();
                                CDB_Extrato.printaDepositos(cdbMovimento);
                                break;
                                
                            //LISTAR MOVIMENTOS DO FUNDO DE INVESTIMENTO
                            case 15:
                                clearScreen();
                                Fundo_Extrato.printaDepositos(fundoMovimento);
                                break;
                                
                            //LISTAR CDBS CADASTRADOS
                            case 16:
                                clearScreen();
                                for (CDB c : cdbs)
                                    System.out.println("CODIGO: " + c.getId() + "\nNOME: " + c.getNome() + "\nSALDO:" + c.getSaldo()
                                    + " \nPORCEGENTAGEM CDI: " + c.getPorcentagemCDI().multiply(new BigDecimal("100"))
                                    + "% \nVENCIMENTO: " + "\n" + c.getVencimentoString() + "\n \n");
                                Thread.sleep(2000);
                                break;
                                
                            //LISTAR FUNDOS DE INVESTIMENTO CADASTRADOS
                            case 17:
                                clearScreen();
                                for (Fundo c : fundos)
                                    System.out.println(" CODIGO: " + c.getId() + "\n NOME: " + c.getNome() + "\n SALDO: " + c.getSaldo() + "\n");
                                Thread.sleep(2000);
                                break;
                                
                            //RETORNAR AO MENU ANTERIOR
                            case 18:
                                clearScreen();
                                break;
                            default:
                                System.out.println("Digite uma opção válida.");
                                break;
                        }
                    }
                    clearScreen();
                    break;
                    
                ////////////////////////// USUÁRIO ///////////////////////////
                case 2:
                    clearScreen();
                    if ((contaAtual = Conta.perguntaUsuario(contas)) != null) {
                        poupancaAtual = Poupanca.checaExistenciaDePoupanca(contaAtual.getCliente(), poupancas);
                        clearScreen();
                        while (opcao != 12) {
                            help.showNormalMenu();
                            opcao = leitor.nextInt();
                            switch (opcao) {
                                //DEPOSITAR EM ALGUMA CONTA
                                case 1:
                                    clearScreen();              
                                    contaAtual.depositar(contas, extratos);
                                    break;
                                    
                                //PAGAR ALGUM DOCUMENTO (?)
                                case 2:
                                    clearScreen();
                                    contaAtual.pagarBoleto(extratos);
                                    break;
                                    
                                //RETIRAR EXTRATO(MOVIMENTAÇÃO DA CONTA)
                                case 3:
                                    clearScreen();
                                    contaAtual.retirarExtrato(extratos);
                                    break;
                                    
                                //SACAR DA CONTA ATUAL
                                case 4:
                                    clearScreen();
                                    Extrato saque = contaAtual.sacar(contaAtual);
                                    if (saque != null) {
                                        extratos.add(saque);
                                    }
                                    break;
                                    
                                //TRANSFERIR
                                case 5:
                                    clearScreen();
                                    contaAtual.transferir(contas, extratos);
                                    break;
                                    
                                //CHECAR SALDO
                                case 6:
                                    clearScreen();
                                    contaAtual.consultarSaldo();
                                    break;
                                    
                                //APLICAR DINHEIRO NO FUNDO DE INVESTIMENTO
                                case 7:
                                    clearScreen();
                                    Fundo.investir(fundos, fundoMovimento, contaAtual, contadorFundoDepositos, extratos);
                                    break;
                                    
                                //APLICAR DINHEIRO EM UM CDB
                                case 8:
                                    clearScreen();
                                    CDB.investirCDB(contaAtual, cdbs, cdbMovimento, contadorCDBDepositos, extratos);
                                    contadorCDBDepositos++;
                                    break;
                                    
                                //DEPOSITAR DINHEIRO NA POUPANÇA
                                case 9:
                                    clearScreen();
                                    Poupanca.depositarPoupanca(contaAtual, poupancas, extratos, poupancaMovimento, contadorPoupancaDepositos);
                                    contadorPoupancaDepositos++;
                                    break;
                                    
                                //SACAR DA POUPANÇA
                                case 10:
                                    clearScreen();
                                    if (poupancaAtual != null) 
                                        poupancaAtual.sacarPoupanca(poupancaMovimento);
                                    else
                                        System.out.println("Você não possui uma conta poupança.");
                                    break;
                                    
                                //CHECAR SALDO DA POUPANÇA
                                case 11:
                                    clearScreen();
                                    if (poupancaAtual != null)
                                        poupancaAtual.printSaldo();
                                    break;
                                    
                                //RETORNAR AO MENU ANTERIOR
                                case 12:
                                    break;
                                default:
                                    System.out.println("Digite uma opção válida!");
                                    break;
                            }
                        }
                    }
                    clearScreen();
                    break;
                    
                //READ ME
                case 3:
                    help.showToTheUserTheInfoHeOrSheNeeds();
                   break;
                   
                //SAIR
                case 4:
                    clearScreen();
                    System.out.println("Obrigado por utilizar o Banco!");
                    break;
                default:
                    System.out.println("Digite uma opção válida!");
                    break;
            }
        }
    }
}
