package com.fluxo.caixa.debito.controller;

import com.fluxo.caixa.debito.dto.DeditoRequest;
import com.fluxo.caixa.debito.dto.DeditoResponse;
import com.fluxo.caixa.debito.dto.ValorTotalDeDebitosResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;

@Api
public interface DeditoController {

    @ApiOperation(httpMethod = "POST", value = "Debita valor do saldo",
            produces = "application/json", consumes = "application/json")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Created", response = DeditoResponse.class),
            @ApiResponse(code = 400, message = "Bad Request")})
    ResponseEntity<DeditoResponse> debitarValor(DeditoRequest request);


    @ApiOperation(httpMethod = "GET", value = "Retorna o total de débitos",
            produces = "application/json", consumes = "application/json")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Ok", response = ValorTotalDeDebitosResponse.class),
            @ApiResponse(code = 400, message = "Bad Request")})
    ResponseEntity<ValorTotalDeDebitosResponse> debitoEfetivadoPorData(String data);

    @ApiOperation(httpMethod = "DELETE", value = "Limpa todos os débitos da base de dados",
            produces = "application/json", consumes = "application/json")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 400, message = "Bad Request")})
    void limparTodosOsDebitos();
}
