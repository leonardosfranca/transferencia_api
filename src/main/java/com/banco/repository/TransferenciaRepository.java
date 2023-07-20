package com.banco.repository;

import com.banco.entity.Transferencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TransferenciaRepository extends JpaRepository<Transferencia, Long> {

    List<Transferencia> findByContaId(Long idConta);

    List<Transferencia> findByDataTransferenciaBetween(LocalDate dataInicial, LocalDate dataFinal);

    List<Transferencia> findBynomeOperadorTransacao(String nomeOperadorTransacao);

    List<Transferencia> findByDataTransferenciaBetweenAndNomeOperadorTransacao
            (LocalDate dataInicial, LocalDate dataFinal, String nomeOperadorTransacao);

}
