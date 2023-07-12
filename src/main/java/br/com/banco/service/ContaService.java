package br.com.banco.service;

import br.com.banco.models.Conta;
import br.com.banco.models.Transferencia;

import java.util.List;

public interface ContaService {
    List<Conta> listarContas();
    Conta obterContaPorId(Long id);

}
