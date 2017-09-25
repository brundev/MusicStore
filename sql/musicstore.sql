DROP TABLE IF EXISTS Musician CASCADE;

CREATE TABLE Musician(
    id serial PRIMARY KEY,
    name varchar(150),
    genre varchar(150),
    birthdate DATE,
    instruments TEXT ARRAY
);

DROP TABLE IF EXISTS Products CASCADE;

CREATE TABLE Products (
	id serial PRIMARY KEY, 
	title VARCHAR(150), 
	tracklist TEXT ARRAY, 
	coverimage VARCHAR(60), 
	price NUMERIC(5,2),
	firstadded DATE,
	description VARCHAR(512), 
  artist NUMERIC,
	genre VARCHAR(20),
  involvedartists TEXT ARRAY,
	usedinstruments TEXT ARRAY, 
	productstocks integer
);

DROP TABLE IF EXISTS Utente CASCADE;

CREATE TABLE Utente(
	cf CHAR(16), 
	username VARCHAR(15) PRIMARY KEY, 
	password VARCHAR(20) NOT NULL, 
	name VARCHAR(20), 
	surname VARCHAR(20), 
	address VARCHAR(100), 
	telephone VARCHAR(15), 
	cellphone VARCHAR(15),
	isemployee BOOLEAN
);

DROP TABLE IF EXISTS Sale CASCADE;

CREATE TABLE Sale(
  id SERIAL PRIMARY KEY,
	username VARCHAR(15) REFERENCES Utente(username) ON UPDATE CASCADE ON DELETE SET DEFAULT ,
	products INTEGER ARRAY,
	price NUMERIC, 
	saledatetime TIMESTAMP with TIME ZONE , 
	ip VARCHAR(15), 
	paymenttype VARCHAR(20), 
	deliverytype VARCHAR(10)
);

INSERT INTO Products (id,title,tracklist,coverimage,price,firstadded,description,artist,genre,involvedartists,usedinstruments,productstocks)
  VALUES(1,'animals','{"pigs,dogs,sheeps"}','indirizzolel',24,'2017-09-09','i like music',20,'rock','{"gino"}','{chitarra}',10);
INSERT INTO Products (id,title,tracklist,coverimage,price,firstadded,description,artist,genre,involvedartists,usedinstruments,productstocks)
  VALUES(2,'meddle','{"pigs,dogs,sheeps"}','indirizzolel',24,'2015-09-09','i like music',20,'rock','{"jelly"}','{chitarra}',10);

INSERT INTO Musician (id,name,genre,birthdate,instruments) VALUES (20, 'gino','pupu','2017-02-21','{"pupu"}');

INSERT INTO Utente (cf, username, password, name, surname, address, telephone, cellphone, isemployee)  VALUES ('aaaaaaaaaaaaaaaa','john','a','john','jonhyllo','hello city','1234567','12345456', FALSE );

INSERT INTO Utente (cf, username, password, name, surname, address, telephone, cellphone, isemployee)  VALUES ('aaaaaaaaaaaaaaaa','admin','admin','admin','admin','hello city','1234567','12345456', TRUE );

INSERT INTO Sale (username, products, price, saledatetime, ip, paymenttype, deliverytype) VALUES ('john','{1,2}',1,'2016-06-22 22:10:25-04','','','');
