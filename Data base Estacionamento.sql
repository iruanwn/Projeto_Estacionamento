create database Estacionamento;
use Estacionamento;

CREATE TABLE Cliente (
  cpf varchar(100) NOT NULL,
  nome varchar(150),
  idade int,
  id_V varchar(100) not null,
  primary key(cpf),
  FOREIGN KEY (id_V) REFERENCES Veiculo(placa)
  );
  
  CREATE TABLE Veiculo(
    placa VARCHAR(100) NOT NULL,
    nome VARCHAR(150) ,
    modelo  VARCHAR(100),
    PRIMARY KEY (placa)
);
