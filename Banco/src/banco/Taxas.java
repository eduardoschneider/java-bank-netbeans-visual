/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

import java.math.BigDecimal;

/**
 *
 * @author eduardo.schneider
 */
public class Taxas {
    BigDecimal[] selicAnual = {new BigDecimal("9.25"), new BigDecimal("9.25"), new BigDecimal("8.25"), new BigDecimal("7.50"), new BigDecimal("7.50"), new BigDecimal("7.00"), new BigDecimal("7.00"), new BigDecimal("6.75"), new BigDecimal("6.5"), new BigDecimal("6.5"), new BigDecimal("6.5"), new BigDecimal("6.5")};//julho/x a junho/x+1
    BigDecimal[] selicMensal = {new BigDecimal("0.8"), new BigDecimal("0.8"), new BigDecimal("0.64"), new BigDecimal("0.64"), new BigDecimal("0.57"), new BigDecimal("0.54"), new BigDecimal("0.58"), new BigDecimal("0.47"), new BigDecimal("0.53"), new BigDecimal("0.52"), new BigDecimal("0.52"), new BigDecimal("0.52")};
    //BigDecimal[] cdiMensal = {new BigDecimal("0.7971"), new BigDecimal("0.8014"), new BigDecimal("0.6377"), new BigDecimal("0.6431"), new BigDecimal("0.5674"), new BigDecimal("0.5376"), new BigDecimal("0.5833"), new BigDecimal("0.4649"), new BigDecimal("0.5315"), new BigDecimal("0.5175"), new BigDecimal("0.5175"), new BigDecimal("0.5175")};
    BigDecimal[] cdiDiario = {new BigDecimal("0.0265"), new BigDecimal("0.0267"), new BigDecimal("0.0531"), new BigDecimal("0.0214"), new BigDecimal("0.0189"), new BigDecimal("0.0179"), new BigDecimal("0.0194"), new BigDecimal("0.0154"), new BigDecimal("0.0177"), new BigDecimal("0.172"), new BigDecimal("0.172"), new BigDecimal("0.172")};

    public BigDecimal[] getSelicAnual() {
        return selicAnual;
    }

    public BigDecimal[] getSelicMensal() {
        return selicMensal;
    }

//    public BigDecimal[] getCdiMensal() {
//        return cdiMensal;
//    }

    public BigDecimal[] getCdiDiario() {
        return cdiDiario;
    }

    
}

