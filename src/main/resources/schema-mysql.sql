/*CREATE SCHEMA IF NOT EXISTS veterinaria ;
USE veterinaria ;

CREATE TABLE IF NOT EXISTS veterinaria.Usuario(
    idUsuario INT NOT NULL,
    nombre VARCHAR(155) NULL,
    correo VARCHAR(255) NULL,
    contrasena VARCHAR(45) NULL,
    estado VARCHAR(1) NULL,
    rol VARCHAR(45) NULL,
    PRIMARY KEY(idUsuario));

CREATE TABLE IF NOT EXISTS veterinaria.Cliente (
    tipo_documento VARCHAR(45) NULL,
    documento INT NOT NULL,
    nombre VARCHAR(155) NULL,
    ciudad VARCHAR(45) NULL,
    direccion VARCHAR(45) NULL,
    telefono VARCHAR(11) NULL,
    PRIMARY KEY (documento));

CREATE TABLE IF NOT EXISTS veterinaria.Raza (
    idRaza INT NOT NULL,
    nombre VARCHAR(155) NULL,
    PRIMARY KEY (idRaza));


CREATE TABLE IF NOT EXISTS veterinaria.Mascotas (
    idMascota INT NOT NULL,
    nombre VARCHAR(100) NULL,
    fecha_nac DATE NULL,
    fecha_reg DATE NULL,
    especie VARCHAR(56) NULL,
    idCliente INT NULL,
    idRaza INT NOT NULL,
    PRIMARY KEY (idMascota));
alter table Mascotas
    add constraint FK_mas_us_documento foreign key(idCliente)
        references Cliente(documento),

    add  constraint FK_mas_raz_idRaza foreign key (idRaza)
        references Raza(idRaza);
*/