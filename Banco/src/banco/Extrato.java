/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author eduardo.schneider
 */
public class Extrato {
    private Date data;
    private BigDecimal valorMexido;
    private boolean tipoMovimento; //false = saida true = entrada
    private Conta conta;

    public Extrato(Date data, BigDecimal valorMexido, boolean tipoMovimento, Conta conta){
        this.data = data;
        this.valorMexido = valorMexido;
        this.tipoMovimento = tipoMovimento;
        this.conta = conta;
    }
    
    public Extrato(){}
    
    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public BigDecimal getValorMexido() {
        return valorMexido;
    }

    public void setValorMexido(BigDecimal valorMexido) {
        this.valorMexido = valorMexido;
    }

    public boolean getTipoMovimento() {
        return tipoMovimento;
    }

    public void setTipoMovimento(boolean tipoMovimento) {
        this.tipoMovimento = tipoMovimento;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.conta);
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
        final Extrato other = (Extrato) obj;
        if (!Objects.equals(this.conta, other.conta)) {
            return false;
        }
        return true;
    }
}
