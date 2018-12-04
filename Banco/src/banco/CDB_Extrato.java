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
public class CDB_Extrato {

    private int id;
    private CDB cdb;
    private Cliente cliente;
    private BigDecimal saldo;
    private Date datainicio;
    private Date datatermino;
    private boolean status;
    
    public CDB_Extrato(int id, CDB cdb, Cliente cliente, BigDecimal saldo, Date datainicio, boolean status) {
        this.id = id;
        this.cdb = cdb;
        this.cliente = cliente;
        this.saldo = saldo;
        this.datainicio = datainicio;
        this.status = status;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CDB getCdb() {
        return cdb;
    }

    public void setCdb(CDB cdb) {
        this.cdb = cdb;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

//    public BigDecimal getSaldo() {
//        return formataDecimal(saldo);
//    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public Date getDatainicio() {
        return datainicio;
    }

    public void setDatainicio(Date datainicio) {
        this.datainicio = datainicio;
    }

    public Date getDatatermino() {
        return datatermino;
    }

    public void setDatatermino(Date datatermino) {
        this.datatermino = datatermino;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
