package br.com.banco.models;

public class TransferenciaRequest {
    private DatesRequest dates;
    private OperadorRequest operadorRequest;

    public DatesRequest getDates() {
        return dates;
    }

    public OperadorRequest getOperadorRequest() {
        return operadorRequest;
    }
}
