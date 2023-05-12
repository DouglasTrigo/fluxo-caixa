package com.fluxo.caixa.debito.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class DeditoRequest {

    @NotNull(message = "valor é obrigatório")
    private BigDecimal valor;
    @NotNull(message = "descricao é obrigatória")
    private String descricao;
}
