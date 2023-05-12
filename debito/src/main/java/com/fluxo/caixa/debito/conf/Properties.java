package com.fluxo.caixa.debito.conf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Properties {

    @Value("${servicos.saldo.usuario}")
    public String usuarioServicoSaldo;
    @Value("${servicos.saldo.senha}")
    public String senhaServicoSaldo;
    @Value("${servicos.saldo.url}")
    public String urlSaldo;

}
