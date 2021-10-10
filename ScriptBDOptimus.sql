--crear SCHEMA BD
CREATE SCHEMA `dboptimus`
DEFAULT CHARACTER SET = utf8


--Crear BD
CREATE DATABASE `dboptimus` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;


--Crear Tabla Producto
CREATE TABLE `dboptimus`.`producto` (  
`idProducto` INT NOT NULL AUTO_INCREMENT,  
`NombreProducto` VARCHAR(45) NOT NULL,  
`TipoReferencia` VARCHAR(45) NOT NULL,  
PRIMARY KEY (`idProducto`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


--Crear Tabla Lote
CREATE TABLE `dboptimus`.`lote` (  
`idLote` INT NOT NULL,
`NumeroLote` INT NOT NULL,
`FechaLote` DATETIME NOT NULL,  
PRIMARY KEY (`idLote`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


--Crear Tabla Lote_producto
CREATE TABLE `dboptimus`.`lote_producto` (  
`idLote_Producto` INT NOT NULL,  
`CantidadLote` VARCHAR(45) NOT NULL, 
PRIMARY KEY (`idLote_Producto`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


--Crear Tabla MuestreoProducto
CREATE TABLE `dboptimus`.`muestreoproducto` (
`idMuestreoProducto` INT NOT NULL,
`CantidadProducto` VARCHAR(45) NOT NULL,
`TipoEstado` 
VARCHAR(45) NOT NULL,  
PRIMARY KEY (`idMuestreoProducto`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


--Crear Tabla Especificaciones
CREATE TABLE `dboptimus`.`especificaciones` (  
`idEspecificaciones` INT NOT NULL,  
`DiametroMin` DECIMAL NOT NULL,  
`DiametroMax` DECIMAL NOT NULL,  
`LargoMin` DECIMAL NOT NULL,  
`LargoMax` DECIMAL NOT NULL,  
`Alto` DECIMAL NOT NULL,  
`PesoMin` DECIMAL NOT NULL,  
`PesoMax` DECIMAL NOT NULL,  
PRIMARY KEY (`idEspecificaciones`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


--Crear Tabla Defecto Muestreo
CREATE TABLE `dboptimus`.`defectomuestreo` (  
`idDefectoMuestreo` INT NOT NULL,  
`TipoDefecto` VARCHAR(45) NOT NULL, 
PRIMARY KEY (`idDefectoMuestreo`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


--Crear Relaciones
ALTER TABLE `dboptimus`.`producto` ADD COLUMN `idEspecificaciones` INT NOT NULL AFTER `TipoReferencia`;
ALTER TABLE `dboptimus`.`defectomuestreo` ADD COLUMN `idMuestreoProducto` INT NOT NULL AFTER `TipoDefecto`;
ALTER TABLE `dboptimus`.`lote_producto` ADD COLUMN `idProducto` INT NOT NULL AFTER `CantidadLote`,ADD COLUMN `idLote` INT NOT NULL AFTER `idProducto`;


--Crear Tabla Tipo Referencia
CREATE TABLE `dboptimus`.`tiporeferencia` (
`idTipoReferencia` INT NOT NULL AUTO_INCREMENT,  
`Referencia` VARCHAR(45) NOT NULL,  
PRIMARY KEY (`idTipoReferencia`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


--Crear Tabla Tipo Estado
CREATE TABLE `dboptimus`.`tipoestado` (
  `idTipoEstado` INT NOT NULL AUTO_INCREMENT,
  `Estado` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idTipoEstado`));
  
  
--Crear Tabla Tipo Defecto
CREATE TABLE `dboptimus`.`tipodefecto` (
  `idTipoDefecto` INT NOT NULL AUTO_INCREMENT,
  `Defecto` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idTipoDefecto`));

--Actualizaciones a la BD
ALTER TABLE `dboptimus`.`producto` CHANGE COLUMN `TipoReferencia` `idTipoReferencia` INT NOT NULL ;
ALTER TABLE `dboptimus`.`lote` CHANGE COLUMN `idLote` `idLote` INT NOT NULL AUTO_INCREMENT ;
ALTER TABLE `dboptimus`.`lote_producto` CHANGE COLUMN `idLote_Producto` `idLote_Producto` INT NOT NULL AUTO_INCREMENT ;
ALTER TABLE `dboptimus`.`especificaciones` CHANGE COLUMN `idEspecificaciones` `idEspecificaciones` INT NOT NULL AUTO_INCREMENT ;
ALTER TABLE `dboptimus`.`defectomuestreo` CHANGE COLUMN `idDefectoMuestreo` `idDefectoMuestreo` INT NOT NULL AUTO_INCREMENT ;
ALTER TABLE `dboptimus`.`muestreoproducto` CHANGE COLUMN `idMuestreoProducto` `idMuestreoProducto` INT NOT NULL AUTO_INCREMENT ;
ALTER TABLE `dboptimus`.`muestreoproducto` CHANGE COLUMN `TipoEstado` `idTipoEstado` VARCHAR(45) NOT NULL ;
ALTER TABLE `dboptimus`.`defectomuestreo` CHANGE COLUMN `TipoDefecto` `idTipoDefecto` INT NOT NULL ;
ALTER TABLE `dboptimus`.`muestreoproducto` CHANGE COLUMN `idTipoEstado` `idTipoEstado` INT NOT NULL ;
ALTER TABLE `dboptimus`.`especificaciones` CHANGE COLUMN `Alto` `Alto` DECIMAL(10,0) NULL ;
ALTER TABLE `dboptimus`.`especificaciones` 
CHANGE COLUMN `DiametroMin` `DiametroMin` FLOAT NOT NULL ,
CHANGE COLUMN `DiametroMax` `DiametroMax` FLOAT NOT NULL ,
CHANGE COLUMN `LargoMin` `LargoMin` FLOAT NOT NULL ,
CHANGE COLUMN `LargoMax` `LargoMax` FLOAT NOT NULL ,
CHANGE COLUMN `Alto` `Alto` FLOAT NULL DEFAULT NULL ,
CHANGE COLUMN `PesoMin` `PesoMin` FLOAT NOT NULL ,
CHANGE COLUMN `PesoMax` `PesoMax` FLOAT NOT NULL ;
ALTER TABLE especificaciones AUTO_INCREMENT=1;

--Ingresar datos tabla 
--Datos tabla Tipo Referencia
INSERT INTO tiporeferencia (Referencia) VALUES('FLORINETA');
INSERT INTO tiporeferencia (Referencia) VALUES('SUPER');
INSERT INTO tiporeferencia (Referencia) VALUES('ESPECIAL');
INSERT INTO tiporeferencia (Referencia) VALUES('GALLETA');
INSERT INTO tiporeferencia (Referencia) VALUES('FLORINETA GOURMET');


--Datos tabla Producto
INSERT INTO producto (NombreProducto,idTipoReferencia,idEspecificaciones) VALUES('FLORINETA CANASTA',1,1);
INSERT INTO producto (NombreProducto,idTipoReferencia,idEspecificaciones) VALUES('FLORINETA BANANA',1,2);
INSERT INTO producto (NombreProducto,idTipoReferencia,idEspecificaciones) VALUES('SUPER ARTESANAL',2,3);
INSERT INTO producto (NombreProducto,idTipoReferencia,idEspecificaciones) VALUES('ESPECIAL TERMINADO',3,4);
INSERT INTO producto (NombreProducto,idTipoReferencia,idEspecificaciones) VALUES('GLOTON',3,5);
INSERT INTO producto (NombreProducto,idTipoReferencia,idEspecificaciones) VALUES('FLORINETA WIDE',1,6);
INSERT INTO producto (NombreProducto,idTipoReferencia,idEspecificaciones) VALUES('GALLETA REDONDA',4,7);
INSERT INTO producto (NombreProducto,idTipoReferencia,idEspecificaciones) VALUES('BARQUILLO TRADICIONAL',3,8);
INSERT INTO producto (NombreProducto,idTipoReferencia,idEspecificaciones) VALUES('CONO DEGUSTACION',3,9);
INSERT INTO producto (NombreProducto,idTipoReferencia,idEspecificaciones) VALUES('GOZITO',3,10);
INSERT INTO producto (NombreProducto,idTipoReferencia,idEspecificaciones) VALUES('GALLETA DE LA FORTUNA',4,11);
INSERT INTO producto (NombreProducto,idTipoReferencia,idEspecificaciones) VALUES('FLORINETA DULCE Y SAL',1,12);


--Datos tabla Especificaciones
INSERT INTO especificaciones (DiametroMin, DiametroMax, LargoMin, LargoMax, Alto, PesoMin, PesoMax) VALUES(14.3,14.7,5.5,6.5,6.5,33,43);
INSERT INTO especificaciones (DiametroMin, DiametroMax, LargoMin, LargoMax, Alto, PesoMin, PesoMax) VALUES(7.8,8.2,17.5,18.5,3,25,35);
INSERT INTO especificaciones (DiametroMin, DiametroMax, LargoMin, LargoMax, Alto, PesoMin, PesoMax) VALUES(8.8,9.2,19.8,20.2,NULL,35,45);
INSERT INTO especificaciones (DiametroMin, DiametroMax, LargoMin, LargoMax, Alto, PesoMin, PesoMax) VALUES(7.3,7.7,15.5,16.5,NULL,25,35);
INSERT INTO especificaciones (DiametroMin, DiametroMax, LargoMin, LargoMax, Alto, PesoMin, PesoMax) VALUES(4.6,5,15.5,16.5,NULL,25,35);
INSERT INTO especificaciones (DiametroMin, DiametroMax, LargoMin, LargoMax, Alto, PesoMin, PesoMax) VALUES(16.8,17.2,16.5,17.5,3.6,30,40);
INSERT INTO especificaciones (DiametroMin, DiametroMax, LargoMin, LargoMax, Alto, PesoMin, PesoMax) VALUES(6.3,6.7,6,7,NULL,1.5,2.5);
INSERT INTO especificaciones (DiametroMin, DiametroMax,  LargoMin, LargoMax, Alto, PesoMin, PesoMax) VALUES(0.9,1.3,10,11,NULL,5.5,6.5);
INSERT INTO especificaciones (DiametroMin, DiametroMax, LargoMin, LargoMax, Alto, PesoMin, PesoMax) VALUES(2.8,3.2,6.5,7.5,NULL,3,4);
INSERT INTO especificaciones (DiametroMin, DiametroMax, LargoMin, LargoMax, Alto, PesoMin, PesoMax) VALUES(3.8,4.2,11.5,12.5,NULL,4.5,5.5);
INSERT INTO especificaciones (DiametroMin, DiametroMax, LargoMin, LargoMax, Alto, PesoMin, PesoMax) VALUES(4.8,5.2,NULL,4.5,5.5,3.5,4.5);
INSERT INTO especificaciones (DiametroMin, DiametroMax, LargoMin, LargoMax, Alto, PesoMin, PesoMax) VALUES(11.3,11.7,11,12,4,16.5,17);


--Otras actualizaciones de la BD 
ALTER TABLE `dboptimus`.`especificaciones` 
CHANGE COLUMN `LargoMin` `LargoMin` FLOAT NULL ,
CHANGE COLUMN `LargoMax` `LargoMax` FLOAT NULL ;