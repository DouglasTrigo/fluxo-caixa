package com.fluxo.caixa.debito.repository;

import com.fluxo.caixa.debito.model.Debito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;

@Repository
public interface DeditoRepositoryImpl extends JpaRepository<Debito, Long> {

    @Query("select sum(d.valor) from Debito d where d.data = ?1")
    BigDecimal getDebitoTotalDoDia(LocalDate data);

}
