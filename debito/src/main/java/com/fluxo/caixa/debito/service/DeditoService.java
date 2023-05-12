package com.fluxo.caixa.debito.service;

import com.fluxo.caixa.debito.dto.ValorTotalDeDebitosResponse;
import com.fluxo.caixa.debito.model.Debito;

public interface DeditoService {

    Debito debitarValor(Debito debito);

    ValorTotalDeDebitosResponse getTotalDebitadoNodia(String data);

    void limparTodosOsDebitos();
}
