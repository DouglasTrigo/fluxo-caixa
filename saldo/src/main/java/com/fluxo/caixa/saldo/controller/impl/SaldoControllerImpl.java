package com.fluxo.caixa.saldo.controller.impl;

import com.fluxo.caixa.saldo.controller.SaldoController;
import com.fluxo.caixa.saldo.service.SaldoService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@Log4j
@AllArgsConstructor
@RestController
@RequestMapping("/v1/saldo")
public class SaldoControllerImpl implements SaldoController {

    private SaldoService saldoService;

    @GetMapping("por-data/{data}")
    @Override
    public ResponseEntity<BigDecimal> consultaSaldoPorData(
            @PathVariable String data) {
        log.info("Consultando saldo do dia");
        return ResponseEntity.ok(saldoService.consultaSaldoConsolidadePorDia(data));
    }
}
