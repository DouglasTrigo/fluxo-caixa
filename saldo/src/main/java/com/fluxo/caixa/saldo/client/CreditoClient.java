package com.fluxo.caixa.saldo.client;

import com.fluxo.caixa.saldo.dto.TotalCreditadoDoDiaResponse;

public interface CreditoClient {

    TotalCreditadoDoDiaResponse getTotalCreditadoNoDia(String data);

}
