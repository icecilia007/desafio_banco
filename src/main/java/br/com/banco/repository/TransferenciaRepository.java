package br.com.banco.repository;


import br.com.banco.models.Transferencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;


@Repository
public interface TransferenciaRepository extends JpaRepository<Transferencia, Long> {
    @Query("SELECT t FROM Transferencia t WHERE t.dataTransferencia BETWEEN :dataInicio AND :dataFim")
    List<Transferencia> findByDataTransferenciaBetween(LocalDateTime dataInicio, LocalDateTime dataFim);

}

