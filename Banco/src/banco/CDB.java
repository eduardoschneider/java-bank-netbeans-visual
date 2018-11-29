/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
}
