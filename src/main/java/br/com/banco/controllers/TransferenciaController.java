package br.com.banco.controllers;

import br.com.banco.models.Transferencia;
import br.com.banco.service.TransferenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/transferencias")
@CrossOrigin(origins = "http://localhost:3000")
public class TransferenciaController {
    private final TransferenciaService transferenciaService;

    @Autowired
    public TransferenciaController(TransferenciaService transferenciaService) {
        this.transferenciaService = transferenciaService;
    }

    @GetMapping
    public List<Transferencia> obterTransferencias() {
        return transferenciaService.obterTransferencias();
    }

    @GetMapping("/periodo")
    public List<Transferencia> obterTransferenciasPorPeriodo(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataInicio,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataFim) {
        return transferenciaService.obterTransferenciasPorPeriodo(dataInicio, dataFim);
    }

    @GetMapping("/operador")
    public List<Transferencia> obterTransferenciasPorOperador(@RequestParam String nomeOperador) {
        return transferenciaService.obterTransferenciasPorOperador(nomeOperador);
    }

    @GetMapping("/periodo-operador")
    public List<Transferencia> obterTransferenciasPorPeriodoEOperador(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataInicio,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataFim,
            @RequestParam String nomeOperador) {
        return transferenciaService.obterTransferenciasPorPeriodoEOperador(dataInicio, dataFim, nomeOperador);
    }
}
