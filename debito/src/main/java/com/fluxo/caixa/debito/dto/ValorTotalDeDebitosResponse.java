package com.fluxo.caixa.debito.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class ValorTotalDeDebitosResponse {

    private BigDecimal valor = BigDecimal.ZERO;
    private LocalDate data;

    public ValorTotalDeDebitosResponse(BigDecimal valor, LocalDate data){
        if(valor != null){
            this.valor = valor;
        }
        this.data = data;
    }
}
