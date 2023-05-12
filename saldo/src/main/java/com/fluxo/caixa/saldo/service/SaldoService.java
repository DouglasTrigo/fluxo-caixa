package com.fluxo.caixa.saldo.service;

import java.math.BigDecimal;

public interface SaldoService {

    BigDecimal consultaSaldoConsolidadePorDia(String data);
}
