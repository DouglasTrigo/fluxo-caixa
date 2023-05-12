package com.fluxo.caixa.debito.service.impl;

import com.fluxo.caixa.debito.client.SaldoClient;
import com.fluxo.caixa.debito.dto.ValorTotalDeDebitosResponse;
import com.fluxo.caixa.debito.exception.SaldoInsuficienteException;
import com.fluxo.caixa.debito.model.Debito;
import com.fluxo.caixa.debito.repository.DeditoRepositoryImpl;
import com.fluxo.caixa.debito.service.DeditoService;
import com.fluxo.caixa.debito.util.BigDecimalUtil;
import com.fluxo.caixa.debito.util.DataUtil;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

@Log4j
@Service
@AllArgsConstructor
public class DeditoServiceImpl implements DeditoService {

    private DeditoRepositoryImpl debitoRepository;
    private SaldoClient saldoClient;

    @Override
    public Debito debitarValor(Debito debito) {

        BigDecimal saldoDoDia = saldoClient.getSaldoDoDia();
        log.info("#### Saldo do dia " + saldoDoDia + " ####");

        if(BigDecimalUtil.isPrimeiroNumeroMaiorQueOSegundo(debito.getValor(), saldoDoDia)){
            log.warn("#### Saldo insuficiente para devitar valor ####");
            throw new SaldoInsuficienteException();
        }

        debito.setData(LocalDate.now());
        log.info("#### Debitando valor ####");
        return debitoRepository.save(debito);
    }

    @Override
    public ValorTotalDeDebitosResponse getTotalDebitadoNodia(String data) {
        LocalDate dataLocalDate = DataUtil.getLocalDate(data, "dd-MM-yyyy");
        BigDecimal totalDebitoNoDia = debitoRepository.getDebitoTotalDoDia(dataLocalDate);
        log.info("#### Total de débitos " + totalDebitoNoDia + " ####");
        return new ValorTotalDeDebitosResponse(totalDebitoNoDia, dataLocalDate);
    }

    @Override
    public void limparTodosOsDebitos() {
        debitoRepository.deleteAll();
    }
}