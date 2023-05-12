package com.fluxo.caixa.saldo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class SaldoPorDataResponse {

    private BigDecimal valorCreditado;
    private BigDecimal valorDebitado;
    private BigDecimal saldo;

}