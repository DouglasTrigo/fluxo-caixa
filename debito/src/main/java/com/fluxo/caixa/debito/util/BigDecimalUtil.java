package com.fluxo.caixa.debito.util;

import java.math.BigDecimal;

public class BigDecimalUtil {

    private BigDecimalUtil(){}

    public static boolean isPrimeiroNumeroMaiorQueOSegundo(
            BigDecimal primeiroNumero, BigDecimal segundoNumero){
        return primeiroNumero.compareTo(segundoNumero) == 1;
    }

}
