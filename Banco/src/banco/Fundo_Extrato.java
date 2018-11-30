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
public class Fundo_Extrato {

    private int id;
    private Fundo fundo;
    private Cliente cliente;
    private BigDecimal saldo;
    private Date datainicio;
    private boolean status;

    public Fundo_Extrato(int id, Fundo fundo, Cliente cliente, BigDecimal saldo, Date datainicio, boolean status) {
        this.id = id;
        this.fundo = fundo;
        this.cliente = cliente;
        this.saldo = saldo;
        this.datainicio = datainicio;
        this.status = status;
    }
    
    public Fundo_Extrato(BigDecimal saldo) {
        this.id = 0;
        this.fundo = null;
        this.cliente = null;
        this.saldo = saldo;
        this.datainicio = null;
        this.status = false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Fundo getFundo() {
        return fundo;
    }

    public void setFundo(Fundo fundo) {
        this.fundo = fundo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public Date getDatainicio() {
        return datainicio;
    }

    public void setDatainicio(Date datainicio) {
        this.datainicio = datainicio;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
