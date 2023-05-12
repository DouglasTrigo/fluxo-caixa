package com.fluxo.caixa.saldo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;

@Api
public interface SaldoController {

    @ApiOperation(httpMethod = "GET", value = "Consulta o saldo por data",
            produces = "application/json", consumes = "application/json")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Ok", response = BigDecimal.class),
            @ApiResponse(code = 400, message = "Bad Request")})
    ResponseEntity<BigDecimal> consultaSaldoPorData(String data);

}
