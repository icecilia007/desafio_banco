# Consultas na API

## Contas

### requisição 
>**GET** `http://localhost:8080/api/v1/contas`

### retorno 
lista de contas

    [
        {
            "idConta": 1,
            "nomeResponsavel": "Fulano"
        },
        {
            "idConta": 2,
            "nomeResponsavel": "Sicrano"
        }
    ]


### requisição 
>**GET** `http://localhost:8080/api/v1/contas/id/?contaId=1`
>

### retorno 
Objeto do tipo conta

    {
        "idConta": 1,
        "nomeResponsavel": "Fulano"
    }

## Transferencias

### requisição 
>**GET**`http://localhost:8080/api/v1/transferencias`

### retorno 
lista de transferencias

    [
        {
            "id": 1,
            "dataTransferencia": "2019-01-01T12:00:00",
            "valor": 1000.0,
            "tipo": "DEPOSITO",
            "nomeOperadorTransacao": null,
            "conta": {
                "idConta": 1,
                "nomeResponsavel": "Fulano"
            }
        },
        {
            "id": 2,
            "dataTransferencia": "2019-02-03T09:53:27",
            "valor": 1000.0,
            "tipo": "DEPOSITO",
            "nomeOperadorTransacao": null,
            "conta": {
                "idConta": 2,
                "nomeResponsavel": "Sicrano"
            }
        },
        {
            "id": 3,
            "dataTransferencia": "2019-05-04T08:12:45",
            "valor": -500.0,
            "tipo": "SAQUE",
            "nomeOperadorTransacao": null,
            "conta": {
                "idConta": 1,
                "nomeResponsavel": "Fulano"
            }
        },
        {
            "id": 4,
            "dataTransferencia": "2019-08-07T08:12:45",
            "valor": -530.0,
            "tipo": "SAQUE",
            "nomeOperadorTransacao": null,
            "conta": {
                "idConta": 2,
                "nomeResponsavel": "Sicrano"
            }
        },
        {
            "id": 5,
            "dataTransferencia": "2020-06-08T10:15:01",
            "valor": 300.0,
            "tipo": "TRANSFERENCIA",
            "nomeOperadorTransacao": "Beltrano",
            "conta": {
                "idConta": 1,
                "nomeResponsavel": "Fulano"
            }
        },
        {
            "id": 6,
            "dataTransferencia": "2021-04-01T12:12:04",
            "valor": 200.0,
            "tipo": "TRANSFERENCIA",
            "nomeOperadorTransacao": "Ronnyscley",
            "conta": {
                "idConta": 2,
                "nomeResponsavel": "Sicrano"
            }
        }
    ]

### requisição 
>**GET** `http://localhost:8080/api/v1/transferencias/periodo?dataInicio=2019-01-01T00:00&dataFim=2019-07-31T10:00`
> 


### retorno 
lista de transferencias

    [
        {
            "id": 1,
            "dataTransferencia": "2019-01-01T12:00:00",
            "valor": 1000.0,
            "tipo": "DEPOSITO",
            "nomeOperadorTransacao": null,
            "conta": {
                "idConta": 1,
                "nomeResponsavel": "Fulano"
            }
        },
        {
            "id": 2,
            "dataTransferencia": "2019-02-03T09:53:27",
            "valor": 1000.0,
            "tipo": "DEPOSITO",
            "nomeOperadorTransacao": null,
            "conta": {
                "idConta": 2,
                "nomeResponsavel": "Sicrano"
            }
        },
        {
            "id": 3,
            "dataTransferencia": "2019-05-04T08:12:45",
            "valor": -500.0,
            "tipo": "SAQUE",
            "nomeOperadorTransacao": null,
            "conta": {
                "idConta": 1,
                "nomeResponsavel": "Fulano"
            }
        }
    ]

### requisição 
>**GET** `http://localhost:8080/api/v1/transferencias/operador?nomeOperador=Beltrano`

    

### retorno 
list de transferencias

    [
        {
            "id": 5,
            "dataTransferencia": "2020-06-08T10:15:01",
            "valor": 300.0,
            "tipo": "TRANSFERENCIA",
            "nomeOperadorTransacao": "Beltrano",
            "conta": {
                "idConta": 1,
                "nomeResponsavel": "Fulano"
            }
        }
    ]

### requisição 
>**GET** `http://localhost:8080/api/v1/transferencias/periodo-operador?dataInicio=2020-06-08T10:00:00&dataFim=2020-07-31T23:59:59&nomeOperador=Beltrano`
> 

### retorno 
list de transferencias

    [
        {
            "id": 5,
            "dataTransferencia": "2020-06-08T10:15:01",
            "valor": 300.0,
            "tipo": "TRANSFERENCIA",
            "nomeOperadorTransacao": "Beltrano",
            "conta": {
                "idConta": 1,
                "nomeResponsavel": "Fulano"
            }
        }
    ]


