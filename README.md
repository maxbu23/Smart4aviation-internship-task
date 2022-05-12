
Application has been created using Java 17, Spring Boot, Spring Boot Jpa, Maven, Lombok 
and H2 Database. To test I used JUnit5 and Mockito.

## Endpoints using Spring Boot

#### Return response included: number of flights departing from this airport, number of flights arriving to this airport, total number (pieces) of baggage arriving to this airport, total number (pieces) of baggage departing from this airport 

```http
GET /airports{airportInfoRequest}
airportInfoRequest should be passed in such JSON format:
{
  "airportCode": "YYZ",
  "departureDate": "2014-07-22T12:25:26-02:00"
}
```

#### Return response included: cargo Weight for requested flight, baggage weight for requested flight, total weight for requested flight

```http
GET /flights{flightRequest}
flightRequest should be passed in such JSON format:
{
    "flightNumber": 1055,
    "departureDate": "2014-07-22T12:25:26-02:00"
}
```
I also created some endpoint to post data:
```http
POST /airports
Body should be passed in such JSON format:
[
  {
    "flightId": 0,
    "flightNumber": 1055,
    "departureAirportIATACode": "YYT",
    "arrivalAirportIATACode": "LEW",
    "departureDate": "2014-07-22T12:25:26-02:00"
  }
]
```
```http
POST /flights
Body should be passed in such JSON format:
[
  {
    "flightId": 0,
    "baggage": [
      {
        "weight": 195,
        "weightUnit": "kg",
        "pieces": 337
      },
      {
        "weight": 797,
        "weightUnit": "kg",
        "pieces": 481
      }
    ],
    "cargo": [
      {
        "weight": 741,
        "weightUnit": "kg",
        "pieces": 373
      },
      {
        "weight": 613,
        "weightUnit": "lb",
        "pieces": 40
      }
    ]
  }
]
```
I created some SQL schemas in data.sql file to have some data at the start of application.
It simplifies doing test in Postman.





