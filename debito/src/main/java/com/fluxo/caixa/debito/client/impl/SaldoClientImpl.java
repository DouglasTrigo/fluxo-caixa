package com.fluxo.caixa.debito.client.impl;

import com.fluxo.caixa.debito.client.SaldoClient;
import com.fluxo.caixa.debito.conf.Properties;
import com.fluxo.caixa.debito.util.AutenticacaoUtil;
import com.fluxo.caixa.debito.util.DataUtil;
import lombok.AllArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.Arrays;

@Repository
@AllArgsConstructor
public class SaldoClientImpl implements SaldoClient {

    private RestTemplate restTemplate;
    private Properties properties;

    @Override
    public BigDecimal getSaldoDoDia() {

        String credenciaisBase64 = AutenticacaoUtil.getCredenciaisBasic(
                properties.usuarioServicoSaldo, properties.senhaServicoSaldo);

        String dataAtualString = DataUtil.getDataAtual("dd-MM-yyyy");
        String urlServicoSaldo = properties.urlSaldo + "/v1/saldo/por-data/" + dataAtualString;

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", credenciaisBase64);

        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity entity = new HttpEntity<String>(headers);

        ResponseEntity<BigDecimal> response =
                restTemplate.exchange(urlServicoSaldo, HttpMethod.GET, entity, BigDecimal.class);

        return response.getBody();
    }
}