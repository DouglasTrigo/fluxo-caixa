package com.fluxo.caixa.credito.service.impl;

import com.fluxo.caixa.credito.dto.TotalCreditadoDoDiaResponse;
import com.fluxo.caixa.credito.model.Credito;
import com.fluxo.caixa.credito.repository.CreditoRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.math.BigDecimal;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import static org.mockito.MockitoAnnotations.initMocks;

public class CreditoServiceImplTest {

    @InjectMocks
    private CreditoServiceImpl creditoService;
    @Mock
    private CreditoRepository creditoRepository;

    @Before
    public void init(){
        initMocks(this);
    }

    @Test
    public void deveRegistrarOCredito(){
        Credito credito = mock(Credito.class);

        when(creditoRepository.save(eq(credito)))
                .thenReturn(credito);

        Credito creditoSalvo = creditoService.registrarCredito(credito);

        verify(credito, times(1)).setData(any());
        assertNotNull(creditoSalvo);
    }

    @Test
    public void deveConsultaCreditosPorData(){
        String data = "12-05-2023";
        BigDecimal totalCreditadoNoDia = new BigDecimal("1000");

        when(creditoRepository.getCreditoTotalDoDia(any()))
                .thenReturn(totalCreditadoNoDia);

        TotalCreditadoDoDiaResponse totalCreditadoDoDiaResponse =
                creditoService.consultaCreditoEfetivadoPorData(data);

        assertEquals(totalCreditadoDoDiaResponse.getValor(), totalCreditadoNoDia);
    }

    @Test
    public void deveLimparTodosOsCreditos(){
        creditoService.limparTodosOsCreditos();
        verify(creditoRepository, times(1)).deleteAll();
    }
}
