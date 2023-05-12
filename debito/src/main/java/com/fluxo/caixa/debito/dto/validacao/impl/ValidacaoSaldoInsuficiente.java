package com.fluxo.caixa.debito.dto.validacao.impl;

import com.fluxo.caixa.debito.dto.validacao.Validacao;

public class ValidacaoSaldoInsuficiente implements Validacao {
    @Override
    public Long getCodigoValidacao() {
        return 1l;
    }

    @Override
    public String getMensagemValidacao() {
        return "Saldo insuficiente para esta operação";
    }
}
