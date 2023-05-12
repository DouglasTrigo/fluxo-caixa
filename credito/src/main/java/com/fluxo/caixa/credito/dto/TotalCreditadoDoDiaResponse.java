package com.fluxo.caixa.credito.dto;

import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
public class TotalCreditadoDoDiaResponse {

    private BigDecimal valor = BigDecimal.ZERO;
    private LocalDate data;

    public TotalCreditadoDoDiaResponse(BigDecimal valor, LocalDate data){
        if(valor != null){
            this.valor = valor;
        }
        this.data = data;
    }
}
