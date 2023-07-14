package br.com.banco.service;

import br.com.banco.models.Conta;
import br.com.banco.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContaServiceImpl implements ContaService {
    private final ContaRepository contaRepository;

    @Autowired
    public ContaServiceImpl(ContaRepository contaRepository) {
        this.contaRepository = contaRepository;
    }

    @Override
    public List<Conta> listarContas() {
        return contaRepository.findAll();
    }

    @Override
    public Conta obterContaPorId(Long id) {
        return contaRepository.findById(id).orElse(null);
    }


}

