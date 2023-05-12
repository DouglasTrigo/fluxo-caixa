package com.fluxo.caixa.credito.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class CreditoRequest {

    @NotNull(message = "valor é obrigatório")
    private BigDecimal valor;
    @NotNull(message = "descricao é obrigatória")
    private String descricao;
}
