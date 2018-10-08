/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

import static banco.Helper.clearScreen;
import static banco.Helper.formataDecimal;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

/**
 *
 * @author eduardo.schneider
 */
public class Conta {

    private String codigoConta;
    private Cliente cliente;
    private BigDecimal saldo;
    private String senha;

    public Conta(String codigoConta, Cliente cliente, BigDecimal saldo, String senha) {
        this.codigoConta = codigoConta;
        this.cliente = cliente;
        this.saldo = saldo;
        this.senha = senha;
    }

    public Conta() {
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getCodigoConta() {
        return codigoConta;
    }

    public void setCodigoConta(String codigoConta) {
        this.codigoConta = codigoConta;
    }

    public BigDecimal getSaldo() {
        return formataDecimal(saldo);
    }

    public void setSaldo(BigDecimal saldo) {
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

    public Extrato sacar(Conta contaAtual) {
        System.out.println("Digite o valor que deseja sacar:\n");
        Scanner leitor = new Scanner(System.in);
        BigDecimal valor = new BigDecimal(leitor.next());

        if ((contaAtual.getSaldo()).compareTo(valor) < 0) {
            System.out.println("Saldo insuficiente para realizar o saque.\n");
            return null;
        }

        contaAtual.setSaldo((contaAtual.getSaldo()).subtract(valor));
        Extrato extrato = new Extrato(new Date(), valor, false, contaAtual);

        return extrato;
    }

    public void consultarSaldo() throws InterruptedException {
        System.out.println("O seu saldo é de: R$" + this.getSaldo());
        Thread.sleep(1500);
    }

    public static void cadastrarConta(List<Cliente> todos, List<Conta> todas, int idConta) throws InterruptedException {
        System.out.println("Digite o CPF do Cliente: \n");
        Scanner leitor = new Scanner(System.in);
        String cpf = leitor.next();

        Cliente atual = null; // só p inicializar
        Conta conta = null; // só p inicializar

        for (Cliente cadaCliente : todos) {
            if (cadaCliente.getCpfCliente().equals(cpf)) {
                atual = cadaCliente;
            }
        }
        boolean temConta = false;
        if (atual != null) {
            for (Conta cadaConta : todas) {
                if ((cadaConta.getCliente()).getCpfCliente().equals(cpf)) {
                    temConta = true;
                }
            }
            if (!temConta) {
                System.out.println("Digite uma senha para a nova conta: ");
                String senha = leitor.nextLine();
                conta = new Conta("000-0" + idConta, atual, new BigDecimal("0.0"), senha);
                todas.add(conta);
                idConta++;
                System.out.println("Conta cadastrada com sucesso.");
                System.out.println("O código é: " + conta.getCodigoConta());
                
                
            } else {
                System.out.println("Cliente já possui conta!");
            }
        } else {
            System.out.println("Cliente não encontrado.");
        }
        Thread.sleep(1500);
    }

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

    public void retirarExtrato(List<Extrato> extratos) throws InterruptedException {
        clearScreen();
        for (Extrato e : extratos) {
            if ((e.getConta()).equals(this)) {
                System.out.println(e.getData() + " - VALOR (" + e.getValorMexido() + ") - CONTA: (" + (e.getConta().getCodigoConta()) + ") TIPO: " + (e.getTipoMovimento() ? "(+++)":"(---)") + "\n");
            }
        }
        
        Thread.sleep(1500);
    }

    public void transferir(List<Conta> contas, List<Extrato> extratos) {
        clearScreen();
        System.out.println("Digite a conta que deseja depositar");
        Scanner leitor = new Scanner(System.in);
        String contaProcurada = leitor.next();

        for (Conta c : contas) {
            if ((c.getCodigoConta()).equals(contaProcurada)) {
                boolean tipoMovimento = true;
                BigDecimal valor = new BigDecimal("-50.0");
                while (valor.compareTo(new BigDecimal("0.0")) < 0) {
                    System.out.println("\nDigite o valor que gostaria de transferir:\n");
                    leitor = new Scanner(System.in);
                    valor = new BigDecimal(leitor.next());
                    if (valor.compareTo(new BigDecimal("0.0")) < 0) {
                        System.out.println("É impossível realizar depósitos negativos!");
                    }
                }
                if (valor.compareTo(this.getSaldo()) > 0) {
                    System.out.println("Saldo insuficiente para realizar a transação.");
                } else {
                    this.setSaldo(this.getSaldo().subtract(valor));
                    c.setSaldo(c.getSaldo().add(valor));
                    Extrato extratoSaida = new Extrato(new Date(), valor, false, this);
                    Extrato extratoEntrada = new Extrato(new Date(), valor, true, c);
                    extratos.add(extratoSaida);
                    extratos.add(extratoEntrada);
                }
            }
        }
    }

    public void depositar(List<Conta> contas, List<Extrato> extratos) throws InterruptedException {
        clearScreen();
        System.out.println("\nDigite a conta que deseja depositar:\n");
        Scanner leitor = new Scanner(System.in);
        String contaProcurada = leitor.next();
        boolean achou = false;
        for (Conta c : contas){
            if (c.getCodigoConta().equals(contaProcurada))
                achou = true;
        }
        if (achou){
            System.out.println("\nDigite o valor que gostaria de depositar:\n");
            BigDecimal valor = new BigDecimal(leitor.next());

            if (valor.compareTo(new BigDecimal("0.0")) < 0)
                System.out.println("\nÉ impossível realizar depósitos negativos!");
            else 
            {   
                this.setSaldo(this.getSaldo().add(valor));
                Extrato extratoEntrada = new Extrato(new Date(), valor, true, this);
                extratos.add(extratoEntrada);
                System.out.println("\nDepósito realizado com sucesso!");
            }
        } else
        {
            System.out.println("\nConta não encontrada. Verifique se digitou o código correto.");
        }
        Thread.sleep(1500);
    }
        
    

    public void pagarBoleto(List<Extrato> extratos) throws InterruptedException {
        System.out.println("Digite o código do documento a ser pago:\n");
        Scanner leitor = new Scanner(System.in);
        String codigo = leitor.next();

        System.out.println("Digite o valor a ser pago:\n");
        BigDecimal valor = new BigDecimal(leitor.next());

        if ((this.saldo).compareTo(valor) < 0) {
            System.out.println("\nVocê não tem saldo suficiente para realizar o pagamento.");
        } else {
            this.setSaldo((this.saldo).subtract(valor));
            Extrato saida = new Extrato(new Date(), valor, false, this);
            extratos.add(saida);
            System.out.println("\nPagamento realizado com sucesso.");
        }
        
        Thread.sleep(1500);
    }

    public static void excluirConta(List<Conta> contas) throws InterruptedException {
        System.out.println("Digite o CPF do dono da conta que deseja excluir:\n");
        Scanner leitor = new Scanner(System.in);
        String cpf = leitor.next();
        boolean achouConta = false;

        for (Conta co : contas) {
            if (((co.getCliente().getCpfCliente())).equals(cpf)) {
                achouConta = true;
            }
        }

        if (achouConta) {
            System.out.println("Conta encontrada, deseja excluir? (S/N)");
            String resposta = leitor.next();

            if ((resposta.equals("s")) || (resposta.equals("S")) || (resposta.equals("sim")) || (resposta.equals("SIM"))) {
                for (Iterator<Conta> iter = contas.listIterator(); iter.hasNext();) {
                    Conta a = iter.next();
                    if (((a.getCliente().getCpfCliente())).equals(cpf)) {
                        iter.remove();
                    }
                }
            }
            System.out.println("Conta excluida com sucesso!");
        } else {
            System.out.println("Conta não encontrada.");
        }
        Thread.sleep(1500);
    }

    public static void alterarConta(List<Conta> contas) throws InterruptedException {
        System.out.println("Digite o CPF do dono da conta que deseja alterar:\n");
        Scanner leitor = new Scanner(System.in);
        String cpf = leitor.next();
        boolean achouConta = false;

        for (Conta co : contas) {
            if (((co.getCliente().getCpfCliente())).equals(cpf)) {
                achouConta = true;
            }
        }

        if (achouConta) {
            System.out.println("Deseja alterar o código? ");
            String resposta = leitor.next();
            if ((resposta.equals("s")) || (resposta.equals("S")) || (resposta.equals("sim")) || (resposta.equals("SIM"))) {
            
                System.out.println("Digite o novo código da conta:");
                resposta = leitor.next();

                for (Iterator<Conta> iter = contas.listIterator(); iter.hasNext();) {
                    Conta a = iter.next();
                    if (((a.getCliente().getCpfCliente())).equals(cpf)) {
                        a.setCodigoConta(resposta);
                    }
                }
                
                System.out.println("Conta alterada com sucesso.");
                Thread.sleep(1000);
            } 
            System.out.println("Deseja alterar a senha? ");
            resposta = leitor.next();
            
            if ((resposta.equals("s")) || (resposta.equals("S")) || (resposta.equals("sim")) || (resposta.equals("SIM"))) {
            
                System.out.println("Digite a senha anterior:");
                String anterior = leitor.next();
                
                System.out.println("Digite a nova senha:");
                resposta = leitor.next();
                boolean alterou = false;
                
                for (Iterator<Conta> iter = contas.listIterator(); iter.hasNext();) {
                    Conta a = iter.next();
                    if ((a.getSenha().equals(anterior)) && ((a.getCliente().getCpfCliente())).equals(cpf)) {
                        a.setSenha(resposta);
                        alterou = true;
                        System.out.println("Conta alterada com sucesso.");
                    }
                }
                
                if (!alterou){
                    System.out.println("Senha anterior incompatível.");
                }
                Thread.sleep(1000);
            } 
        }
        else 
        {
            System.out.println("Conta não encontrada.");
        }
    }
    
    public static void pesquisarConta(List<Conta> contas) throws InterruptedException, ParseException{
        System.out.println("Digite o CPF do dono da conta que deseja pesquisar:\n");
        Scanner leitor = new Scanner(System.in);
        String cpf = leitor.next();
        clearScreen();
        Conta conta = null;
        boolean achouConta = false;
        for (Conta co : contas) {
            if (((co.getCliente().getCpfCliente())).equals(cpf)) {
                conta = co;
                achouConta = true;
            }
        }

        if (achouConta) {
            System.out.println("CPF: " + cpf);
            System.out.println((conta.getCliente().getNomeCliente()));
            System.out.println((conta.getCliente().getDataNascString()));
            System.out.println("Conta: " + conta.getCodigoConta());
            System.out.println("Saldo: R$" + conta.getSaldo());
            
            Thread.sleep(2500);
        } 
        else 
        {
            System.out.println("Conta não encontrada.");
        }
    }
}
