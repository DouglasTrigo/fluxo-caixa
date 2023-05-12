package com.fluxo.caixa.saldo.client.impl;

import com.fluxo.caixa.saldo.client.DebitoClient;
import com.fluxo.caixa.saldo.conf.Properties;
import com.fluxo.caixa.saldo.dto.TotalDebitadoDoDiaResponse;
import com.fluxo.caixa.saldo.util.AutenticacaoUtil;
import lombok.AllArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Repository
@AllArgsConstructor
public class DebitoClientImpl implements DebitoClient {

    private RestTemplate restTemplate;
    private Properties properties;

    @Override
    public TotalDebitadoDoDiaResponse getTotalDebitadoNoDia(String data) {
        String credenciaisBase64 = AutenticacaoUtil.getCredenciaisBasic(
                properties.usuarioServicoDebito, properties.senhaServicoDebito);

        String urlServicoSaldo = properties.urlDebito + "/v1/debito//total-por-data/" + data;

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", credenciaisBase64);

        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity entity = new HttpEntity<String>(headers);

        ResponseEntity<TotalDebitadoDoDiaResponse> response =
                restTemplate.exchange(urlServicoSaldo, HttpMethod.GET, entity, TotalDebitadoDoDiaResponse.class);

        return response.getBody();
    }
}
