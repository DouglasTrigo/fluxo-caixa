package com.fluxo.caixa.credito.controller;

import com.fluxo.caixa.credito.dto.CreditoRequest;
import com.fluxo.caixa.credito.dto.CreditoResponse;
import com.fluxo.caixa.credito.dto.TotalCreditadoDoDiaResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;

@Api
public interface CreditoController {

    @ApiOperation(httpMethod = "POST", value = "Registra um novo crédito",
            produces = "application/json", consumes = "application/json")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Created", response = CreditoResponse.class),
            @ApiResponse(code = 400, message = "Bad Request")})
    ResponseEntity<CreditoResponse> registrarCredito(CreditoRequest request);

    @ApiOperation(httpMethod = "GET", value = "Consulta os créditos efetivados por data",
            produces = "application/json", consumes = "application/json")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Ok", response = TotalCreditadoDoDiaResponse.class),
            @ApiResponse(code = 400, message = "Bad Request")})
    ResponseEntity<TotalCreditadoDoDiaResponse> consultaCreditoEfetivadoPorData(String data);

    @ApiOperation(httpMethod = "DELETE", value = "Limpa todos os créditos da base de dados",
            produces = "application/json", consumes = "application/json")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 400, message = "Bad Request")})
    void limparTodosOsCreditos();
}
