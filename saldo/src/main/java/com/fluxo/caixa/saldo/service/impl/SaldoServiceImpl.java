package com.fluxo.caixa.saldo.service.impl;

import com.fluxo.caixa.saldo.client.CreditoClient;
import com.fluxo.caixa.saldo.client.DebitoClient;
import com.fluxo.caixa.saldo.dto.TotalCreditadoDoDiaResponse;
import com.fluxo.caixa.saldo.dto.TotalDebitadoDoDiaResponse;
import com.fluxo.caixa.saldo.model.SaldoPorDataResponse;
import com.fluxo.caixa.saldo.service.SaldoService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;

@Log4j
@Service
@AllArgsConstructor
public class SaldoServiceImpl implements SaldoService {
    private CreditoClient creditoClient;
    private DebitoClient debitoClient;

    @Override
    public SaldoPorDataResponse consultaSaldoConsolidadePorDia(String data) {
        TotalCreditadoDoDiaResponse totalCreditadoDoDia = creditoClient.getTotalCreditadoNoDia(data);
        log.info("total credito hoje: " + totalCreditadoDoDia.getValor());
        TotalDebitadoDoDiaResponse totalDebitadoDoDia = debitoClient.getTotalDebitadoNoDia(data);
        log.info("total debitado hoje: " + totalDebitadoDoDia.getValor());

        return SaldoPorDataResponse.builder()
                .saldo(totalCreditadoDoDia.getValor().subtract(totalDebitadoDoDia.getValor()))
                .valorCreditado(totalCreditadoDoDia.getValor())
                .valorDebitado(totalDebitadoDoDia.getValor().negate())
                .build();
    }
}