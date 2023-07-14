package br.com.banco;

import br.com.banco.controllers.TransferenciaController;
import br.com.banco.models.Transferencia;
import br.com.banco.models.Conta;
import br.com.banco.service.TransferenciaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

public class TransferenciaControllerTest {

    @Mock
    private TransferenciaService transferenciaService;

    @InjectMocks
    private TransferenciaController transferenciaController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testObterTransferencias() {
        // Mock data
        Transferencia transferencia1 = createTransferencia(1L, LocalDateTime.parse("2019-01-01T12:00:00"), 1000.0, "DEPOSITO", null, createConta(1L, "Fulano"));
        Transferencia transferencia2 = createTransferencia(2L, LocalDateTime.parse("2019-02-03T09:53:27"), 1000.0, "DEPOSITO", null, createConta(2L, "Sicrano"));
        Transferencia transferencia3 = createTransferencia(3L, LocalDateTime.parse("2019-05-04T08:12:45"), -500.0, "SAQUE", null, createConta(1L, "Fulano"));
        Transferencia transferencia4 = createTransferencia(4L, LocalDateTime.parse("2019-08-07T08:12:45"), -530.0, "SAQUE", null, createConta(2L, "Sicrano"));
        Transferencia transferencia5 = createTransferencia(5L, LocalDateTime.parse("2020-06-08T10:15:01"), 300.0, "TRANSFERENCIA", "Beltrano", createConta(1L, "Fulano"));
        Transferencia transferencia6 = createTransferencia(6L, LocalDateTime.parse("2021-04-01T12:12:04"), 200.0, "TRANSFERENCIA", "Ronnyscley", createConta(2L, "Sicrano"));

        List<Transferencia> transferencias = Arrays.asList(transferencia1, transferencia2, transferencia3, transferencia4, transferencia5, transferencia6);

        when(transferenciaService.obterTransferencias()).thenReturn(transferencias);

        List<Transferencia> result = transferenciaController.obterTransferencias();

        assertThat(result).isNotNull();
        assertThat(result).hasSize(6);
        assertThat(result).containsExactlyInAnyOrder(transferencia1, transferencia2, transferencia3, transferencia4, transferencia5, transferencia6);
    }

    @Test
    public void testObterTransferenciasPorPeriodo() {
        LocalDateTime dataInicio = LocalDateTime.parse("2019-01-01T00:00:00");
        LocalDateTime dataFim = LocalDateTime.parse("2022-01-01T00:00:00");

        Transferencia transferencia1 = createTransferencia(1L, LocalDateTime.parse("2019-01-01T12:00:00"), 1000.0, "DEPOSITO", null, createConta(1L, "Fulano"));
        Transferencia transferencia2 = createTransferencia(2L, LocalDateTime.parse("2019-02-03T09:53:27"), 1000.0, "DEPOSITO", null, createConta(2L, "Sicrano"));
        Transferencia transferencia3 = createTransferencia(3L, LocalDateTime.parse("2019-05-04T08:12:45"), -500.0, "SAQUE", null, createConta(1L, "Fulano"));

        List<Transferencia> transferencias = Arrays.asList(transferencia1, transferencia2, transferencia3);

        when(transferenciaService.obterTransferenciasPorPeriodo(dataInicio, dataFim)).thenReturn(transferencias);

        List<Transferencia> result = transferenciaController.obterTransferenciasPorPeriodo(dataInicio, dataFim);

        assertThat(result).isNotNull();
        assertThat(result).hasSize(3);
        assertThat(result).containsExactlyInAnyOrder(transferencia1, transferencia2, transferencia3);
    }

    @Test
    public void testObterTransferenciasPorOperador() {
        String nomeOperador = "Beltrano";

        Transferencia transferencia5 = createTransferencia(5L, LocalDateTime.parse("2020-06-08T10:15:01"), 300.0, "TRANSFERENCIA", nomeOperador, createConta(1L, "Fulano"));

        List<Transferencia> transferencias = Arrays.asList(transferencia5);

        when(transferenciaService.obterTransferenciasPorOperador(nomeOperador)).thenReturn(transferencias);

        List<Transferencia> result = transferenciaController.obterTransferenciasPorOperador(nomeOperador);

        assertThat(result).isNotNull();
        assertThat(result).hasSize(1);
        assertThat(result).containsExactly(transferencia5);
    }

    @Test
    public void testObterTransferenciasPorPeriodoEOperador() {
        LocalDateTime dataInicio = LocalDateTime.parse("2019-01-01T00:00:00");
        LocalDateTime dataFim = LocalDateTime.parse("2022-01-01T00:00:00");
        String nomeOperador = "Ronnyscley";

        Transferencia transferencia6 = createTransferencia(6L, LocalDateTime.parse("2021-04-01T12:12:04"), 200.0, "TRANSFERENCIA", nomeOperador, createConta(2L, "Sicrano"));

        List<Transferencia> transferencias = Arrays.asList(transferencia6);

        when(transferenciaService.obterTransferenciasPorPeriodoEOperador(dataInicio, dataFim, nomeOperador)).thenReturn(transferencias);

        List<Transferencia> result = transferenciaController.obterTransferenciasPorPeriodoEOperador(dataInicio, dataFim, nomeOperador);

        assertThat(result).isNotNull();
        assertThat(result).hasSize(1);
        assertThat(result).containsExactly(transferencia6);
    }

    private Transferencia createTransferencia(Long id, LocalDateTime dataTransferencia, Double valor, String tipo, String nomeOperadorTransacao, Conta conta) {
        Transferencia transferencia = new Transferencia();
        transferencia.setId(id);
        transferencia.setDataTransferencia(dataTransferencia);
        transferencia.setValor(valor);
        transferencia.setTipo(tipo);
        transferencia.setNomeOperadorTransacao(nomeOperadorTransacao);
        transferencia.setConta(conta);
        return transferencia;
    }

    private Conta createConta(Long idConta, String nomeResponsavel) {
        Conta conta = new Conta();
        conta.setIdConta(idConta);
        conta.setNomeResponsavel(nomeResponsavel);
        return conta;
    }
}


