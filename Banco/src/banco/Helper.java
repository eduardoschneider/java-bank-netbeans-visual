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
