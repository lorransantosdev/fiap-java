# Vehicle Rental API

Este projeto é uma API REST desenvolvida com Java e Spring Boot para simular a devolução de veículos. Ele realiza cálculos baseados na quantidade de dias de aluguel e em possíveis penalidades, além de aplicar regras de desconto ou multa.

## Tecnologias utilizadas

- Java 17
- Spring Boot
- Spring Web
- Bean Validation (Jakarta)
- JUnit 5
- Mockito

---

## Endpoints

### `POST /rent/rentvehicle`

Este endpoint realiza o cálculo de devolução de um veículo alugado.

#### Requisição

```json
{
  "firstName": "João",
  "model": "Volkswagen Jetta",
  "daysRent": 10,
  "penaltyPerDay": 2
}
```
#### Veículos que podem ser enviados na request

```json
{
  "Fiat Uno", "Chevrolet Onix", "Volkswagen Gol", "Ford Ka", "Renault Kwid",
  "Toyota Corolla", "Hyundai HB20", "Honda Civic", "Jeep Renegade", "Peugeot 208",
  "Volkswagen Jetta", "Volkswagen Golf"
}
```

#### Curl para Postman
````json
{
  curl --location 'http://localhost:8080/rent/rentvehicle' \
  --header 'Content-Type: application/json' \
  --data '{
  "firstName": "Lorran",
  "model": "Volkswagen Jetta",
  "daysRent": 10,
  "penaltyPerDay": 0
}
````

## Regras de Negócio

- O valor do aluguel por dia é gerado aleatoriamente (entre 1000 e 3000).
- Se penaltyPerDay == 0, o cliente recebe 10% de desconto no valor total.
- Se penaltyPerDay > 0, o valor por dia sofre um acréscimo de 20%.
- A lista de veículos disponíveis é fixa e armazenada em memória.

