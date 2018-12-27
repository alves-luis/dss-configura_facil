USE `DSS`;

# DROP TABLE Componente;
# DROP TABLE Modelo;
# DROP TABLE Pacotes;
# DROP TABLE Modelo_Componente;
# DROP TABLE Pacote_Componente;

CREATE TABLE Componente (
    ID INTEGER PRIMARY KEY,
    Stock INTEGER,
    Price DOUBLE,
    Name CHAR(64),
    ID_Incompativeis CHAR(64),
    ID_extras CHAR(64),
    ID_modelos CHAR(64),
    Tipo INTEGER
);

CREATE TABLE Pacote (
    ID INTEGER PRIMARY KEY,
    Name CHAR(64),
    Desconto DOUBLE,
    ID_Componentes CHAR(64)
);
