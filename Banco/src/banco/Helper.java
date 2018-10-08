/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author eduardo.schneider
 */
public class Helper {
    
    public void showAdminMenu() {
        System.out.println("█████████████████████████████████");
        System.out.println("Selecione uma das opções administrativas:███████");
        System.out.println("█████████████████████████████████");
        System.out.println("███ CLIENTES             ████████████████");
        System.out.println("1- Cadastrar               ████████████████");
        System.out.println("2- Excluir                 ████████████████");
        System.out.println("3- Alterar                 ████████████████");
        System.out.println("4- Pesquisar               ████████████████");
        System.out.println("█████████████████████████████████");
        System.out.println("███ CONTAS               ████████████████");
        System.out.println("5- Cadastrar               ████████████████");
        System.out.println("6- Excluir                 ████████████████");
        System.out.println("7- Alterar                 ████████████████");
        System.out.println("8- Pesquisar               ████████████████");
        System.out.println("█████████████████████████████████");
        System.out.println("9- Cadastrar Fundo Invest. ████████████████");
        System.out.println("10- Cadastrar CDB          ████████████████");
        System.out.println("11- Cadastrar Poupança     ████████████████");
        System.out.println("█████████████████████████████████");
        System.out.println("12- Avançar dias           ████████████████");
        System.out.println("█████████████████████████████████");
        System.out.println("13- Movimento Poupança     ████████████████");
        System.out.println("14- Movimento CDB          ████████████████");
        System.out.println("15- Movimento Fundo Invest.████████████████");
        System.out.println("█████████████████████████████████");
        System.out.println("16- Listar CDBS            ████████████████");
        System.out.println("17- Listar Fundos          ████████████████");
        System.out.println("█████████████████████████████████");
        System.out.println("18- Sair                   ████████████████");
        System.out.println("█████████████████████████████████");
    }

    public void showNormalMenu() {
        System.out.println("███████████████████████████████████");
        System.out.println("Selecione uma das opções:███████████████████");
        System.out.println("1- Depósito              ███████████████████");
        System.out.println("2- Pagamento             ███████████████████");
        System.out.println("3- Extrato               ███████████████████");
        System.out.println("4- Saque                 ███████████████████");
        System.out.println("5- Transferência         ███████████████████");
        System.out.println("6- Saldo                 ███████████████████");
        System.out.println("██████████████████████████████████");
        System.out.println("7- Fundo de Investimento ███████████████████");
        System.out.println("8- Investir CDB          ███████████████████");
        System.out.println("██████████████████████████████████");
        System.out.println("9- Depositar Poupança    ███████████████████");
        System.out.println("10- Sacar Poupança       ███████████████████");
        System.out.println("11- Consultar Poupança   ███████████████████");
        System.out.println("██████████████████████████████████");
        System.out.println("12- Sair                 ███████████████████");
        System.out.println("███████████████████████████████████");
    }

    public int perguntaTipo() {
        System.out.println("███████████████████████████████████");
        System.out.println("███████   BEM VINDO AO BANCO EM JAVA ☕  ███████");
        System.out.println("███████████████████████████████████");
        System.out.println("Digite o tipo de usuário que você gostaria de acessar:\n");
        System.out.println("1- Administrador");
        System.out.println("2- Usuário Normal");
        System.out.println("3- ❗❗❗ READ ME ❗❗❗");
        System.out.println("\n4- Sair\n");
        System.out.println("███████████████████████████████████");
        System.out.println("█████████   BY: EDUARDO SCHNEIDER   █████████");
        System.out.println("███████████████████████████████████");
        System.out.println("█████                                      ██████");

        Scanner leitor = new Scanner(System.in);
        int opcao = leitor.nextInt();

        return opcao;
    }
    
    //////////////////////////////////////////////////////////////////////////////
    //                          DADOS PRÉ CADASTRADOS                           //
    //////////////////////////////////////////////////////////////////////////////
    
    public void populaParaTestes(List<Cliente> clientes, List<Conta> contas,
                                List<Poupanca> poupancas,
                                List<CDB> cdbs, List<Fundo> fundos){
        
        Cliente cliente1 = new Cliente(0, "Eduardo Schneider", "46483321805", new Date());
        Cliente cliente2 = new Cliente(1, "Luis Almeida Pereira", "31438993013", new Date());
        Cliente cliente3 = new Cliente(2, "Roberto Justus", "30308850033", new Date());
        Cliente cliente4 = new Cliente(3, "Ciro Gomes", "34903167038", new Date());
        Cliente cliente5 = new Cliente(4, "Jair Esfaquenaro", "37047849076", new Date());
        Cliente cliente6 = new Cliente(5, "Cabo Daciolo", "78379730038", new Date());
        Cliente cliente7 = new Cliente(6, "Maria das Graças", "92656680085", new Date());
        clientes.add(cliente1);
        clientes.add(cliente2);
        clientes.add(cliente3);
        clientes.add(cliente4);
        clientes.add(cliente5);
        clientes.add(cliente6);
        clientes.add(cliente7);
        
        Conta conta1 = new Conta("000-00", cliente1, new BigDecimal("1500.0"), "12345");
        Conta conta2 = new Conta("000-01", cliente2, new BigDecimal("2200.0"), "12345");
        Conta conta3 = new Conta("000-02", cliente3, new BigDecimal("6300.0"), "12345");
        Conta conta4 = new Conta("000-03", cliente4, new BigDecimal("2400.0"), "12345");
        Conta conta5 = new Conta("000-04", cliente5, new BigDecimal("11100.0"), "12345");
        Conta conta6 = new Conta("000-05", cliente6, new BigDecimal("2400.0"), "12345");
        Conta conta7 = new Conta("000-06", cliente7, new BigDecimal("11100.0"), "12345");
        contas.add(conta1);
        contas.add(conta2);
        contas.add(conta3);
        contas.add(conta4);
        contas.add(conta5);
        contas.add(conta6);
        contas.add(conta7);

        Poupanca poupanca1 = new Poupanca("0221", cliente1, new BigDecimal("0.0"));
        Poupanca poupanca5 = new Poupanca("4334", cliente5, new BigDecimal("0.0"));
        poupancas.add(poupanca1);
        poupancas.add(poupanca5);

        Date vencimento = new Date();
        Calendar c = Calendar.getInstance(); 
        c.setTime(vencimento); 
        c.add(Calendar.DATE, 30);
        vencimento = c.getTime();
        
        CDB cdb30 = new CDB(0, "CDB do ADS", new BigDecimal("0.0"), vencimento, new BigDecimal("0.95"));
        
        c.add(Calendar.DATE, 30);
        vencimento = c.getTime();
        
        CDB cdb60 = new CDB(1, "CDB da EC", new BigDecimal("0.0"), vencimento, new BigDecimal("1.0"));
        
        c.add(Calendar.DATE, 30);
        vencimento = c.getTime();
        
        CDB cdb90 = new CDB(2, "CDB do EM", new BigDecimal("0.0"), vencimento, new BigDecimal("1.05"));
        
        c.add(Calendar.DATE, 30);
        vencimento = c.getTime();
        
        CDB cdb120 = new CDB(3, "CDB do EAD", new BigDecimal("0.0"), vencimento, new BigDecimal("1.10"));
        
        cdbs.add(cdb30);
        cdbs.add(cdb60);
        cdbs.add(cdb90);
        cdbs.add(cdb120);
        
        Fundo fundo1 = new Fundo(0, "FUNDO EASFODA", new BigDecimal("0.0"), new BigDecimal("0.99"));
        Fundo fundo2 = new Fundo(1, "FUNDO ILOVEPOO", new BigDecimal("0.0"), new BigDecimal("0.98"));
        Fundo fundo3 = new Fundo(2, "FUNDO ADSMINHAVIDAEVOCE", new BigDecimal("0.0"), new BigDecimal("0.97"));
        
        fundos.add(fundo1);
        fundos.add(fundo2);
        fundos.add(fundo3);
               
    }
    
    public int incrementaDia(Date data){
        System.out.println("Digite o número de dias que deseja incrementar: ");
        Scanner leitor = new Scanner(System.in);
        int dia = Integer.parseInt(leitor.next());
        
        return dia;
    } 
    
    public Date diaMaisMais(Date data){
        Calendar c = Calendar.getInstance(); 
        c.setTime(data); 
        c.add(Calendar.DATE, 1);
        data = c.getTime();
        
        return data;
    }

    public static BigDecimal formataDecimal(BigDecimal vlrFator){  
        BigDecimal numFormatado  = vlrFator.setScale(2, BigDecimal.ROUND_UP); 
        return numFormatado;		
    }
    
    public static void clearScreen() {
        for (int i = 0; i < 20; i++) {
            System.out.println(" ");
        }
    }

    void showToTheUserTheInfoHeOrSheNeeds() throws InterruptedException {
        clearScreen();
        System.out.println("Ao logar, digite a conta incluindo o hífen, exemplo: '000-00'");
        System.out.println("A senha padrão das contas é 12345");
        System.out.println("Todas as informações que você precisa, encontrará na classe Helper.");
        System.out.println("Apenas duas poupanças estão cadastradas, a da conta 000-00 e 000-04");
        System.out.println("Mas você pode cadastrar através do login de admin.");
        System.out.println("Os cpfs não tem pontuações, digite direto, ex: 46483321805");
        System.out.println("\nRetornando ao menu em 10 segundos...");
        
        Thread.sleep(13000);
        
    }
}
