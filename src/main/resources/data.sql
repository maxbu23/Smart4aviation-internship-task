--FLIGHT#0
INSERT INTO flight(flight_id,flight_number,arrival_airportiatacode,departure_airportiatacode,departure_date) VALUES(0,1055,'YYZ','LEW','2014-07-22T12:25:26-02:00')
INSERT INTO cargo_entity(flight_id) VALUES(0)

INSERT INTO baggage(id,pieces,weight,weight_unit) VALUES(0,299,200,'kg')
INSERT INTO baggage(id,pieces,weight,weight_unit) VALUES(1,998,150,'lb')
INSERT INTO baggage(id,pieces,weight,weight_unit) VALUES(2,101,878,'kg')
INSERT INTO cargo_entity_baggage(cargo_entity_flight_id,baggage_id) VALUES(0,0)
INSERT INTO cargo_entity_baggage(cargo_entity_flight_id,baggage_id) VALUES(0,1)
INSERT INTO cargo_entity_baggage(cargo_entity_flight_id,baggage_id) VALUES(0,2)

INSERT INTO cargo(id,pieces,weight,weight_unit) VALUES(0,100,100,'lb')
INSERT INTO cargo(id,pieces,weight,weight_unit) VALUES(1,320,420,'kg')
INSERT INTO cargo(id,pieces,weight,weight_unit) VALUES(2,299,100,'kg')
INSERT INTO cargo_entity_cargo(cargo_entity_flight_id,cargo_id) VALUES(0,0)
INSERT INTO cargo_entity_cargo(cargo_entity_flight_id,cargo_id) VALUES(0,1)
INSERT INTO cargo_entity_cargo(cargo_entity_flight_id,cargo_id) VALUES(0,2)

--FLIGHT#1
INSERT INTO flight(flight_id,flight_number,arrival_airportiatacode,departure_airportiatacode,departure_date) VALUES(1,1818,'SEA','KRK','2015-07-31T06:39:51-02:00')
INSERT INTO cargo_entity(flight_id) VALUES(1)

INSERT INTO baggage(id,pieces,weight,weight_unit) VALUES(3,299,200,'kg')
INSERT INTO baggage(id,pieces,weight,weight_unit) VALUES(4,55,787,'kg')
INSERT INTO baggage(id,pieces,weight,weight_unit) VALUES(5,100,298,'lb')
INSERT INTO cargo_entity_baggage(cargo_entity_flight_id,baggage_id) VALUES(1,3)
INSERT INTO cargo_entity_baggage(cargo_entity_flight_id,baggage_id) VALUES(1,4)
INSERT INTO cargo_entity_baggage(cargo_entity_flight_id,baggage_id) VALUES(1,5)

INSERT INTO cargo(id,pieces,weight,weight_unit) VALUES(3,299,100,'lb')
INSERT INTO cargo(id,pieces,weight,weight_unit) VALUES(4,190,10,'lb')
INSERT INTO cargo(id,pieces,weight,weight_unit) VALUES(5,452,132,'kg')
INSERT INTO cargo_entity_cargo(cargo_entity_flight_id,cargo_id) VALUES(1,3)
INSERT INTO cargo_entity_cargo(cargo_entity_flight_id,cargo_id) VALUES(1,4)
INSERT INTO cargo_entity_cargo(cargo_entity_flight_id,cargo_id) VALUES(1,5)
