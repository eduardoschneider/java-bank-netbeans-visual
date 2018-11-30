/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

import java.math.BigDecimal;
import java.util.Date;
/**
 *
 * @author eduardo.schneider
 */
public class Poupanca_Extrato {
    private int idPoupancaDeposito;
    private Poupanca contapoupanca;
    private BigDecimal saldo; //juros e retiradas movimentam o saldo, se saldo for 
    private Date dataInicio;
    private Date datatermino;
    private Date aniversario;
    private boolean status; //ativo ou inativo

    public Poupanca_Extrato(int idPoupancaDeposito, Poupanca contapoupanca, BigDecimal saldo, Date dataInicio, Date datatermino, Date aniversario, boolean status) {
        this.idPoupancaDeposito = idPoupancaDeposito;
        this.contapoupanca = contapoupanca;
        this.saldo = saldo;
        this.dataInicio = dataInicio;
        this.datatermino = datatermino;
        this.aniversario = aniversario;
        this.status = status;
    }
    
    public int getIdPoupancaDeposito() {
        return idPoupancaDeposito;
    }

    public void setIdPoupancaDeposito(int idPoupancaDeposito) {
        this.idPoupancaDeposito = idPoupancaDeposito;
    }

    public Poupanca getContapoupanca() {
        return contapoupanca;
    }

    public void setContapoupanca(Poupanca contapoupanca) {
        this.contapoupanca = contapoupanca;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDatatermino() {
        return datatermino;
    }

    public void setDatatermino(Date datatermino) {
        this.datatermino = datatermino;
    }

    public Date getAniversario() {
        return aniversario;
    }

    public void setAniversario(Date aniversario) {
        this.aniversario = aniversario;
    }

    public boolean getStatus() {
        return status;
    }
    
    public void setStatus(boolean status) {
        this.status = status;
    }    
}
