package com.fluxo.caixa.saldo.service.impl;

import com.fluxo.caixa.saldo.client.CreditoClient;
import com.fluxo.caixa.saldo.client.DebitoClient;
import com.fluxo.caixa.saldo.dto.TotalCreditadoDoDiaResponse;
import com.fluxo.caixa.saldo.dto.TotalDebitadoDoDiaResponse;
import com.fluxo.caixa.saldo.service.SaldoService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Log4j
@Service
@AllArgsConstructor
public class SaldoServiceImpl implements SaldoService {
    private CreditoClient creditoClient;
    private DebitoClient debitoClient;

    @Override
    public BigDecimal consultaSaldoConsolidadePorDia(String data) {
        TotalCreditadoDoDiaResponse totalCreditadoDoDia = creditoClient.getTotalCreditadoNoDia(data);
        log.info("total credito hoje: " + totalCreditadoDoDia.getValor());
        TotalDebitadoDoDiaResponse totalDebitadoDoDia = debitoClient.getTotalDebitadoNoDia(data);
        log.info("total debitado hoje: " + totalDebitadoDoDia.getValor());
        return totalCreditadoDoDia.getValor().subtract(totalDebitadoDoDia.getValor());
    }
}