package com.fluxo.caixa.saldo.client;

import com.fluxo.caixa.saldo.dto.TotalDebitadoDoDiaResponse;

public interface DebitoClient {
    TotalDebitadoDoDiaResponse getTotalDebitadoNoDia(String data);
}
