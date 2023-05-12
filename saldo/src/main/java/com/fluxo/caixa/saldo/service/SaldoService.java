package com.fluxo.caixa.saldo.service;

import com.fluxo.caixa.saldo.model.SaldoPorDataResponse;

public interface SaldoService {

    SaldoPorDataResponse consultaSaldoConsolidadePorDia(String data);
}
