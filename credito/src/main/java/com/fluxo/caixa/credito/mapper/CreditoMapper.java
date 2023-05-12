package com.fluxo.caixa.credito.mapper;

import com.fluxo.caixa.credito.dto.CreditoRequest;
import com.fluxo.caixa.credito.dto.CreditoResponse;
import com.fluxo.caixa.credito.model.Credito;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CreditoMapper {

    Credito toCredito(CreditoRequest request);
    CreditoResponse toCreditoResponse(Credito credito);
}