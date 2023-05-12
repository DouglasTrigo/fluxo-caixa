package com.fluxo.caixa.saldo.conf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Properties {

    @Value("${servicos.credito.usuario}")
    public String usuarioServicoCredito;
    @Value("${servicos.credito.senha}")
    public String senhaServicoCredito;
    @Value("${servicos.credito.url}")
    public String urlCredito;

    @Value("${servicos.debito.usuario}")
    public String usuarioServicoDebito;
    @Value("${servicos.debito.senha}")
    public String senhaServicoDebito;
    @Value("${servicos.debito.url}")
    public String urlDebito;

}
