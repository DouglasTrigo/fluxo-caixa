package com.fluxo.caixa.credito.service;

import com.fluxo.caixa.credito.dto.TotalCreditadoDoDiaResponse;
import com.fluxo.caixa.credito.model.Credito;

public interface CreditoService {

    Credito registrarCredito(Credito credito);

    TotalCreditadoDoDiaResponse consultaCreditoEfetivadoPorData(String data);

    void limparTodosOsCreditos();
}
