package br.com.banco.service;

import br.com.banco.models.Transferencia;

import java.time.LocalDateTime;
import java.util.List;

public interface TransferenciaService {
    List<Transferencia> obterTransferencias();
    List<Transferencia> obterTransferenciasPorPeriodo(LocalDateTime dataInicio, LocalDateTime dataFim);
    List<Transferencia> obterTransferenciasPorOperador(String nomeOperador);
    List<Transferencia> obterTransferenciasPorPeriodoEOperador(LocalDateTime dataInicio, LocalDateTime dataFim, String nomeOperador);
}


