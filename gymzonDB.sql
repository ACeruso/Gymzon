create database gymzonDB;
use gymzonDB;

CREATE TABLE prodotto (
IDProdotto CHAR(6) PRIMARY KEY,
nome char(20) not null,
descrizione char(100) not null,
prezzo NUMERIC(9) not null,
quantita INTEGER DEFAULT 0,
sconto INTEGER DEFAULT 0
);

CREATE TABLE cliente(
IDCliente CHAR(6) PRIMARY KEY,
nome char(20) not null,
cognome char(20) not null,
email char(50) not null,
password char(20) not null,
cellulare numeric(10) not null,
via char(50) not null,
cap numeric(5) not null,
paese char(20) not null,
provincia char(20) not null
);

CREATE TABLE ordine(
IDOrdine char(6) PRIMARY KEY,
stato char(10) not null,
data date not null,
nProdotti integer,
IDCliente char(6),
IDProdotto char(6),
foreign key(IDCliente) references cliente(IDCLiente),
foreign key(IDProdotto) references prodotto(IDProdotto)
);

CREATE TABLE admin(
email char(50) PRIMARY KEY,
password char(8) not null
);