package br.com.banco.controllers;

import br.com.banco.models.Conta;
import br.com.banco.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/contas")
@CrossOrigin(origins = "http://localhost:3000")
public class ContaController {
    private final ContaService contaService;

    @Autowired
    public ContaController(ContaService contaService) {
        this.contaService = contaService;
    }
    @GetMapping
    public List<Conta> obterContas() {
        return contaService.listarContas();
    }
    @GetMapping("/id")
    public Conta obterContaPorId(
            @RequestParam long contaId
    ) {
        return contaService.obterContaPorId(contaId);
    }
}
