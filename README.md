# AZShip API
### _API REST to manage shippings._ :truck:
Project made for a technical test at the company AZShip.
The API manages freight shipments, such as creating, updating, etc. 
The main technologies used were: Java, Spring and MongoDB as a non-relational database, 
and using clean architecture as software architecture.

## Tech

- Java 17
- Spring Boot 3.2.3
- JUnit
- Maven
- Mockito
- Spring Data JPA
- Swagger & OpenAPI3
- Docker & Docker Compose
- MongoDb Database

## Main Features

- Create, read, update and delete a shipping.
- Find a shipping passing any field.
- Calculates dimensional weight.
- Calculates shipping value based on shipment type.

## Run

> [!NOTE]
> AZShip Api requires [Docker and Docker Compose](https://www.docker.com/).

### Step 1

Run docker-compose.yml
```sh
mvn clean package
docker-compose up
```


### Step 2

You can use _Swagger_ to test the endpoints.

[Swagger-ui](http://localhost:8080/swagger-ui/index.html#/)



### Step 3

You can use the **POST** endpoint to save your first shipping.
> v1/shippings

```sh
{
  "recipientName": "Thiago C",
  "recipientAddress": {
    "streetName": "Rua dos Testes",
    "streetNumber": "Numero Teste",
    "suburb": "Bairro Dos Testes",
    "city": "Cidade dos Testes",
    "state": "Estado dos Testes",
    "postcode": 1234567
  },
  "shippingMethod": {
    "cargoType": "IN_BULK_LOAD",
    "vehicleType": "TRUCK"
  },
  "shippingSelectedType": "WEIGHT_CALCULATE",
  "cargoPropertiesRequest": {
    "weight": 60,
    "length": 80,
    "width": 60,
    "height": 40
  },
  "trackingNumber": "Tracking Number",
  "expectedDeliveryDate": "2024-03-08T06:01:20.881Z"
}
```

> [!TIP]
> To calculate shipping value based on cubed weight, change the _ShippingSelectedType_ "WEIGHT_CALCULATE" to "CUBED_CALCULATE", and add the Cubed Factor value in _CargoProperties_.

```sh
{
  "recipientName": "Thiago C",
  "recipientAddress": {
    "streetName": "Rua dos Testes",
    "streetNumber": "Numero Teste",
    "suburb": "Bairro Dos Testes",
    "city": "Cidade dos Testes",
    "state": "Estado dos Testes",
    "postcode": 1234567
  },
  "shippingMethod": {
    "cargoType": "IN_BULK_LOAD",
    "vehicleType": "TRUCK"
  },
  "shippingSelectedType": "CUBED_CALCULATE",
  "cargoPropertiesRequest": {
    "weight": 60,
    "length": 80,
    "width": 60,
    "height": 40,
    "cubageFactor": 300
  },
  "trackingNumber": "Tracking Number",
  "expectedDeliveryDate": "2024-03-08T06:01:20.881Z"
}
```

### Step 4

Done! You can use all other endpoints now.
