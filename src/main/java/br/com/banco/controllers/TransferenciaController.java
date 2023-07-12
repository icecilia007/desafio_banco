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

}
