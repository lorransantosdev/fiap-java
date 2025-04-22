# Sistema de Pedágio (Toll System)

Este projeto é um serviço REST em Spring Boot que processa informações de pedágios, calculando valores coletados por carros, motos e caminhões com base em uma lista de entradas.

Repositório: https://github.com/lorransantosdev/fiap-java/tree/main/7-toll-systems

## Tecnologias

- Java 17
- Spring Boot
- Lombok
- JUnit 5
- Mockito

## Como executar

1. Clone o repositório e entre na pasta:
   ```bash
   git clone https://github.com/lorransantosdev/fiap-java.git
   cd fiap-java/7-toll-systems
   ```
   
3. A API estará disponível em `http://localhost:8080`.

## Endpoint

### POST /toll/control-of-tolls

Processa a lista de pedágios e retorna os valores coletados por localização.

#### Exemplo de requisição cURL

```bash
curl --location 'http://localhost:8080/toll/control-of-tolls' \
--header 'Content-Type: application/json' \
--data '{
    "tollsInfo":
    [
        {
            "idToll": 1,
            "location": "São Paulo",
            "baseRate": 150,
            "cars":
            [
                "105-DA4", "50S-S4S", "SA8-99A"
            ],
            "motorcycles":
            [
                "105-DA4", "50S-S4S", "SA8-99A"
            ],
            "trucks":
            [
                {
                    "plateTruck": "111-111",
                    "axis": 4
                },
                {
                    "plateTruck": "222-222",
                    "axis": 6
                }
            ]
        },
        {
            "idToll": 2,
            "location": "Rio de Janeiro",
            "baseRate": 200.55,
            "cars":
            [
                "105-DA4", "50S-S4S", "SA8-99A"
            ],
            "motorcycles":
            [
                "105-DA4", "50S-S4S", "SA8-99A"
            ],
            "trucks":
            [
                {
                    "plateTruck": "111-111",
                    "axis": 4
                },
                {
                    "plateTruck": "222-222",
                    "axis": 6
                }
            ]
        }
    ]
}'
```

#### Exemplo de resposta

```json
{
  "amountCollectedPerLocationOfCars": {
    "São Paulo": [
      { "totalValue": 450.0, "amount": 3 }
    ],
    "Rio de Janeiro": [
      { "totalValue": 601.65, "amount": 3 }
    ]
  },
  "amountCollectedPerLocationOfMotorcycles": {
    "São Paulo": [
      { "totalValue": 225.0, "amount": 3 }
    ],
    "Rio de Janeiro": [
      { "totalValue": 300.825, "amount": 3 }
    ]
  },
  "amountCollectedPerLocationOfTrucks": {
    "São Paulo": [
      { "totalValue": 1500.0, "amount": 2 }
    ],
    "Rio de Janeiro": [
      { "totalValue": 2005.5, "amount": 2 }
    ]
  }
}
```



