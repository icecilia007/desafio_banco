package br.com.banco.service;

import br.com.banco.models.Transferencia;
import br.com.banco.repository.TransferenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TransferenciaServiceImpl implements TransferenciaService {
    private final TransferenciaRepository transferenciaRepository;

    @Autowired
    public TransferenciaServiceImpl(TransferenciaRepository transferenciaRepository) {
        this.transferenciaRepository = transferenciaRepository;
    }
        @Override
        public List<Transferencia> obterTransferencias() {
            return transferenciaRepository.findAll();
        }

        @Override
        public List<Transferencia> obterTransferenciasPorPeriodo(LocalDateTime dataInicio,LocalDateTime dataFim) {
            return transferenciaRepository.findByDataTransferenciaBetween(dataInicio, dataFim);
        }

    }


