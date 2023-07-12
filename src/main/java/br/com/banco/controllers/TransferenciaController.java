package br.com.banco.controllers;

import br.com.banco.models.DatesRequest;
import br.com.banco.models.OperadorRequest;
import br.com.banco.models.Transferencia;
import br.com.banco.models.TransferenciaRequest;
import br.com.banco.service.TransferenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/transferencias")
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
            @RequestBody @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) DatesRequest dates) {
        LocalDateTime dataInicio = dates.getDataInicio();
        LocalDateTime dataFim = dates.getDataFim();
        return transferenciaService.obterTransferenciasPorPeriodo(dataInicio, dataFim);
    }

    @GetMapping("/operador")
    public List<Transferencia> obterTransferenciasPorOperador(@RequestBody OperadorRequest operadorRequest) {
        String nomeOperador = operadorRequest.getNomeOperador();
        return transferenciaService.obterTransferenciasPorOperador(nomeOperador);
    }

}
