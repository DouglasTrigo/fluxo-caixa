package com.fluxo.caixa.saldo.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class TotalCreditadoDoDiaResponse {

    private BigDecimal valor;
    private LocalDate data;
}
