package br.com.banco.controllers;

import br.com.banco.models.Conta;
import br.com.banco.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/contas")
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
            @RequestBody Conta conta
    ) {
        long id=conta.getIdConta();
        return contaService.obterContaPorId(id);
    }
}
