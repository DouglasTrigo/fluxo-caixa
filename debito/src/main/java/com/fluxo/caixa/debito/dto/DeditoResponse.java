package com.fluxo.caixa.debito.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class DeditoResponse {

    private Long id;
    private BigDecimal valor;
    private LocalDate data;
    private String descricao;

}
