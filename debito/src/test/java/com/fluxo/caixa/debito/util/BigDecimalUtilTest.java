package com.fluxo.caixa.debito.util;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class BigDecimalUtilTest {

    @Test
    public void primeiroNumeroDeveSerMaiorQuiPrimeiro(){
        BigDecimal primeiroNumero = new BigDecimal("1000");
        BigDecimal segundoNumero = new BigDecimal("999");
        assertTrue(BigDecimalUtil
                .isPrimeiroNumeroMaiorQueOSegundo(primeiroNumero, segundoNumero));
    }

    @Test
    public void segundoNumeroDeveSerMaiorQuiPrimeiro(){
        BigDecimal primeiroNumero = new BigDecimal("1000");
        BigDecimal segundoNumero = new BigDecimal("5000");
        assertFalse(BigDecimalUtil
                .isPrimeiroNumeroMaiorQueOSegundo(primeiroNumero, segundoNumero));
    }
}
