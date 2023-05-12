package com.fluxo.caixa.credito.controller.impl;

import com.fluxo.caixa.credito.controller.CreditoController;
import com.fluxo.caixa.credito.dto.CreditoRequest;
import com.fluxo.caixa.credito.dto.CreditoResponse;
import com.fluxo.caixa.credito.dto.TotalCreditadoDoDiaResponse;
import com.fluxo.caixa.credito.mapper.CreditoMapper;
import com.fluxo.caixa.credito.model.Credito;
import com.fluxo.caixa.credito.service.CreditoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Log4j
@AllArgsConstructor
@RestController
@RequestMapping("/v1/credito")
public class CreditoControllerImpl implements CreditoController {

    private CreditoService creditoService;
    private CreditoMapper creditoMapper;

    @PostMapping
    @Override
    public ResponseEntity<CreditoResponse> registrarCredito(@Valid @RequestBody CreditoRequest request) {
        log.info("Registrando crédito");
        Credito credito = creditoMapper.toCredito(request);
        Credito creditoRegistrado = creditoService.registrarCredito(credito);

        log.info("Crédito registrado com sucesso!");
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(creditoMapper.toCreditoResponse(creditoRegistrado));
    }

    @GetMapping("/total-por-data/{data}")
    @Override
    public ResponseEntity<TotalCreditadoDoDiaResponse> consultaCreditoEfetivadoPorData(@PathVariable String data) {
        return ResponseEntity.ok(creditoService.consultaCreditoEfetivadoPorData(data));
    }

    @Override
    @DeleteMapping("/todos")
    @ResponseStatus(HttpStatus.OK)
    public void limparTodosOsCreditos() {
        creditoService.limparTodosOsCreditos();
    }
}
