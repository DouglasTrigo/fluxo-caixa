package com.fluxo.caixa.saldo.client.impl;

import com.fluxo.caixa.saldo.client.CreditoClient;
import com.fluxo.caixa.saldo.conf.Properties;
import com.fluxo.caixa.saldo.dto.TotalCreditadoDoDiaResponse;
import com.fluxo.caixa.saldo.util.AutenticacaoUtil;
import lombok.AllArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Repository
@AllArgsConstructor
public class CreditoClientImpl implements CreditoClient {

    private RestTemplate restTemplate;
    private Properties properties;

    @Override
    public TotalCreditadoDoDiaResponse getTotalCreditadoNoDia(String data) {

        String credenciaisBase64 = AutenticacaoUtil.getCredenciaisBasic(
                properties.usuarioServicoCredito, properties.senhaServicoCredito);

        String urlServicoSaldo = properties.urlCredito + "/v1/credito/total-por-data/" + data;

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", credenciaisBase64);

        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity entity = new HttpEntity<String>(headers);

        ResponseEntity<TotalCreditadoDoDiaResponse> response =
                restTemplate.exchange(urlServicoSaldo, HttpMethod.GET, entity, TotalCreditadoDoDiaResponse.class);

        return response.getBody();
    }
}