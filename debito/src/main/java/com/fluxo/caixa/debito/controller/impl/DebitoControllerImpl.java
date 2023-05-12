package com.fluxo.caixa.debito.controller.impl;

import com.fluxo.caixa.debito.controller.DeditoController;
import com.fluxo.caixa.debito.dto.DeditoRequest;
import com.fluxo.caixa.debito.dto.DeditoResponse;
import com.fluxo.caixa.debito.dto.ValorTotalDeDebitosResponse;
import com.fluxo.caixa.debito.mapper.DeditoMapper;
import com.fluxo.caixa.debito.model.Debito;
import com.fluxo.caixa.debito.service.DeditoService;
import io.swagger.annotations.Api;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Log4j
@Api
@AllArgsConstructor
@RestController
@RequestMapping("/v1/debito")
public class DebitoControllerImpl implements DeditoController {

    private DeditoService debitoService;
    private DeditoMapper deditoMapper;

    @PostMapping
    @Override
    public ResponseEntity<DeditoResponse> debitarValor(@Valid @RequestBody DeditoRequest request) {
        log.info("#### Registrando crédito ####");
        Debito debito = deditoMapper.toDebito(request);
        Debito debitoRegistrado = debitoService.debitarValor(debito);

        log.info("#### Crédito registrado com sucesso! ####");
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(deditoMapper.toDebitoResponse(debitoRegistrado));
    }

    @GetMapping("/total-por-data/{data}")
    @Override
    public ResponseEntity<ValorTotalDeDebitosResponse> debitoEfetivadoPorData(@PathVariable String data) {
        log.info("#### Consultando total debitado no dia " + data + "####");
        return ResponseEntity.ok(debitoService.getTotalDebitadoNodia(data));
    }

    @Override
    @DeleteMapping("/todos")
    @ResponseStatus(HttpStatus.OK)
    public void limparTodosOsDebitos() {
        debitoService.limparTodosOsDebitos();
    }
}
