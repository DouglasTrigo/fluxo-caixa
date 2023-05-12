package com.fluxo.caixa.credito.repository;

import com.fluxo.caixa.credito.model.Credito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;

@Repository
public interface CreditoRepository extends JpaRepository<Credito, Long> {

    @Query("select sum(c.valor) from Credito c where c.data = ?1")
    BigDecimal getCreditoTotalDoDia(LocalDate data);

}
