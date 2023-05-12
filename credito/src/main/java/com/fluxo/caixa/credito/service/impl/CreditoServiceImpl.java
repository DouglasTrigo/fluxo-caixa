package com.fluxo.caixa.credito.service.impl;

import com.fluxo.caixa.credito.dto.TotalCreditadoDoDiaResponse;
import com.fluxo.caixa.credito.model.Credito;
import com.fluxo.caixa.credito.repository.CreditoRepository;
import com.fluxo.caixa.credito.service.CreditoService;
import com.fluxo.caixa.credito.util.DataUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
@AllArgsConstructor
public class CreditoServiceImpl implements CreditoService {

    private CreditoRepository creditoRepository;

    @Override
    public Credito registrarCredito(Credito credito) {
        credito.setData(LocalDate.now());
        return creditoRepository.save(credito);
    }

    @Override
    public TotalCreditadoDoDiaResponse consultaCreditoEfetivadoPorData(String data) {
        LocalDate dataLocalDate = DataUtil.getLocalDate(data, "dd-MM-yyyy");
        BigDecimal totalCreditadoNoDia = creditoRepository.getCreditoTotalDoDia(dataLocalDate);
        return new TotalCreditadoDoDiaResponse(totalCreditadoNoDia, dataLocalDate);
    }

    @Override
    public void limparTodosOsCreditos() {
        creditoRepository.deleteAll();
    }
}