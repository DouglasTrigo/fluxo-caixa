package com.fluxo.caixa.debito.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class SaldoPorDataResponse {

    private BigDecimal valorCreditado;
    private BigDecimal valorDebitado;
    private BigDecimal saldo;

}