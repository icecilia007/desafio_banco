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
>**GET** `http://localhost:8080/api/v1/contas\id`
> 
request body: 

application json

    {
        "idConta":"2",
        "nomeResponsavel":null
    }

### retorno 
Objeto do tipo conta

    {
        "idConta": 2,
        "nomeResponsavel": "Sicrano"
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
            "valor": 30895.46,
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
            "valor": 12.24,
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
            "valor": -500.5,
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
            "valor": -530.5,
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
            "valor": 3241.23,
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
            "valor": 25173.09,
            "tipo": "TRANSFERENCIA",
            "nomeOperadorTransacao": "Ronnyscley",
            "conta": {
                "idConta": 2,
                "nomeResponsavel": "Sicrano"
            }
        }
    ]

### requisição 
>**GET** `http://localhost:8080/api/v1/transferencias/periodo`
> 
request body: 

application json

    {
      "dataInicio": "2019-01-01 10:00:00",
      "dataFim": "2019-08-07 08:12:45"
    }


### retorno 
list de transferencias

    [
        {
            "id": 1,
            "dataTransferencia": "2019-01-01T12:00:00",
            "valor": 30895.46,
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
            "valor": 12.24,
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
            "valor": -500.5,
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
            "valor": -530.5,
            "tipo": "SAQUE",
            "nomeOperadorTransacao": null,
            "conta": {
                "idConta": 2,
                "nomeResponsavel": "Sicrano"
            }
        }
    ]

### requisição 
>**GET** `http://localhost:8080/api/v1/transferencias/operador`
> 
request body: 

application json

    {
          "nomeOperador": "Beltrano"
    }
    

### retorno 
list de transferencias

    [
        {
            "id": 5,
            "dataTransferencia": "2020-06-08T10:15:01",
            "valor": 3241.23,
            "tipo": "TRANSFERENCIA",
            "nomeOperadorTransacao": "Beltrano",
            "conta": {
                "idConta": 1,
                "nomeResponsavel": "Fulano"
            }
        }
    ]

### requisição 
>**GET** `http://localhost:8080/api/v1/transferencias/periodo-operador`
> 
request body: 

application json

    {
      "dates": {
        "dataInicio": "2019-01-01 10:00:00",
        "dataFim": "2020-06-08 10:15:01"
      },
      "operadorRequest": {
        "nomeOperador": "Beltrano"
      }
    }

### retorno 
list de transferencias

    [
        {
            "id": 5,
            "dataTransferencia": "2020-06-08T10:15:01",
            "valor": 3241.23,
            "tipo": "TRANSFERENCIA",
            "nomeOperadorTransacao": "Beltrano",
            "conta": {
                "idConta": 1,
                "nomeResponsavel": "Fulano"
            }
        }
    ]


