package com.banco.controller;

import com.banco.entity.Transferencia;
import com.banco.repository.TransferenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/transferencias")
public class TransferenciaController {

    @Autowired
    TransferenciaRepository transferenciaRepository;


    @GetMapping("/conta/{numeroConta}")
    public List<Transferencia> getTransferenciasByContaBancaria(@PathVariable Long numeroConta) {
        return transferenciaRepository.findByContaId(numeroConta);
    }

    @GetMapping("/periodo")
    public List<Transferencia> getTransferenciasByPeriodo(
            @RequestParam("dataInicial") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataInicial,
            @RequestParam("dataFinal") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataFinal) {
        return transferenciaRepository.findByDataTransferenciaBetween(dataInicial, dataFinal);
    }

    @GetMapping("/operador")
    public List<Transferencia> getTransferenciasByOperador(@RequestParam("nomeOperador") String nomeOperador) {
        return transferenciaRepository.findBynomeOperadorTransacao(nomeOperador);
    }

    @GetMapping("/filtros")
    public List<Transferencia> getTransferenciasByFiltros(
            @RequestParam("dataInicial") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataInicial,
            @RequestParam("dataFinal") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataFinal,
            @RequestParam("nomeOperador") String nomeOperador) {
        return transferenciaRepository.findByDataTransferenciaBetweenAndNomeOperadorTransacao(dataInicial, dataFinal, nomeOperador);
    }

}
