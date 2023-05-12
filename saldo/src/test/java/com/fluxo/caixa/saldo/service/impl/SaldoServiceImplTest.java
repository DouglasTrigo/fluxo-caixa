package com.fluxo.caixa.saldo.service.impl;

import com.fluxo.caixa.saldo.client.CreditoClient;
import com.fluxo.caixa.saldo.client.DebitoClient;
import com.fluxo.caixa.saldo.dto.TotalCreditadoDoDiaResponse;
import com.fluxo.caixa.saldo.dto.TotalDebitadoDoDiaResponse;
import com.fluxo.caixa.saldo.model.SaldoPorDataResponse;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.math.BigDecimal;

import static org.junit.Assert.*;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.mockito.Mockito.*;

public class SaldoServiceImplTest {

    @InjectMocks
    private SaldoServiceImpl saldoService;

    @Mock
    private CreditoClient creditoClient;
    @Mock
    private DebitoClient debitoClient;

    @Before
    public void init(){
        initMocks(this);
    }

    @Test
    public void deveConsultarSaldoConsolidado(){
        TotalCreditadoDoDiaResponse totalCreditadoDoDia = new TotalCreditadoDoDiaResponse();
        totalCreditadoDoDia.setValor(new BigDecimal("2000"));

        TotalDebitadoDoDiaResponse totalDebitadoDoDia = new TotalDebitadoDoDiaResponse();
        totalDebitadoDoDia.setValor(new BigDecimal("1000"));

        when(creditoClient.getTotalCreditadoNoDia(any()))
                .thenReturn(totalCreditadoDoDia);

        when(debitoClient.getTotalDebitadoNoDia(any()))
                .thenReturn(totalDebitadoDoDia);

        SaldoPorDataResponse saldoPorData =
                saldoService.consultaSaldoConsolidadePorDia("12-05-2023");

        assertEquals(saldoPorData.getValorCreditado(), totalCreditadoDoDia.getValor());
        assertEquals(saldoPorData.getValorDebitado(), totalDebitadoDoDia.getValor().negate());
        assertEquals(saldoPorData.getSaldo(), totalCreditadoDoDia.getValor().subtract(totalDebitadoDoDia.getValor()));
    }
}
