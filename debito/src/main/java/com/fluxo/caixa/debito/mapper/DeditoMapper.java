package com.fluxo.caixa.debito.mapper;

import com.fluxo.caixa.debito.dto.DeditoRequest;
import com.fluxo.caixa.debito.dto.DeditoResponse;
import com.fluxo.caixa.debito.model.Debito;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DeditoMapper {

    Debito toDebito(DeditoRequest request);
    DeditoResponse toDebitoResponse(Debito debito);
}