package br.com.banco.service;

import br.com.banco.models.Transferencia;

import java.time.LocalDateTime;
import java.util.List;

public interface TransferenciaService {
    List<Transferencia> obterTransferencias();
}


