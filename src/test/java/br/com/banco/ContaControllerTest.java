package br.com.banco;

import br.com.banco.controllers.ContaController;
import br.com.banco.models.Conta;
import br.com.banco.service.ContaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

public class ContaControllerTest {

    @Mock
    private ContaService contaService;

    @InjectMocks
    private ContaController contaController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testObterContas() {
        Conta conta1 = new Conta(1L, "Responsavel1");
        Conta conta2 = new Conta(2L, "Responsavel2");
        List<Conta> contas = Arrays.asList(conta1, conta2);

        when(contaService.listarContas()).thenReturn(contas);

        List<Conta> result = contaController.obterContas();

        assertThat(result).isNotNull();
        assertThat(result).hasSize(2);
        assertThat(result).contains(conta1, conta2);
    }

    @Test
    public void testObterContaPorId() {
        // Mock data
        long contaId = 1L;
        Conta conta = new Conta(contaId, "Responsavel1");

        when(contaService.obterContaPorId(contaId)).thenReturn(conta);

        Conta result = contaController.obterContaPorId(contaId);

        assertThat(result).isNotNull();
        assertThat(result).isEqualTo(conta);
    }

}
