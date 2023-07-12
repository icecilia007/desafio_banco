package br.com.banco.models;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class DatesRequest {
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dataInicio;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dataFim;

    public LocalDateTime getDataInicio() {
        return dataInicio;
    }

    public LocalDateTime getDataFim() {
        return dataFim;
    }
}
