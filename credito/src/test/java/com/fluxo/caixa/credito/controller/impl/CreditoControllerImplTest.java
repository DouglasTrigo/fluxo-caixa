package com.fluxo.caixa.credito.controller.impl;

import com.fluxo.caixa.credito.dto.CreditoRequest;
import com.fluxo.caixa.credito.dto.CreditoResponse;
import com.fluxo.caixa.credito.mapper.CreditoMapper;
import com.fluxo.caixa.credito.mapper.CreditoMapperImpl;
import com.fluxo.caixa.credito.service.impl.CreditoServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.mockito.MockitoAnnotations.initMocks;

public class CreditoControllerImplTest {

    private CreditoControllerImpl controller;
    @Mock
    private CreditoServiceImpl service;
    private CreditoMapper creditoMapper = new CreditoMapperImpl();

    @Before
    public void init(){
        initMocks(this);
        controller = new CreditoControllerImpl(service, creditoMapper);
    }

    @Test
    public void deveRegistrarOCreditoComSucesso(){
        CreditoRequest request = new CreditoRequest();
        request.setDescricao("Algum valor");
        request.setValor(new BigDecimal("500"));

        ResponseEntity<CreditoResponse> responseEntity = controller.registrarCredito(request);
        assertEquals(responseEntity.getStatusCode(), HttpStatus.CREATED);
    }

}
