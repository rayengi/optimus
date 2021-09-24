--CREACIÓN DE LA BASE DE DATOS
------------------------------

CREATE DATABASE IF NOT EXISTS `dbmisjuguetes`



--CREACIÓN DE LA TABLA ESTADOS_JUGUETES Y ADICIÓN DE DATOS
----------------------------------------------------------

CREATE TABLE `dbmisjuguetes`.`estados_juguetes` (
  `id` int NOT NULL AUTO_INCREMENT,
  `estado` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;

INSERT INTO estados_juguetes (estado) VALUES ('Bueno');
INSERT INTO estados_juguetes (estado) VALUES ('Modificado');
INSERT INTO estados_juguetes (estado) VALUES ('Dañado');



--CREACIÓN DE LA TABLA TIPOS_JUGUETES Y ADICIÓN DE DATOS
--------------------------------------------------------

CREATE TABLE `tipos_juguetes` (
  `id` int NOT NULL AUTO_INCREMENT,
  `tipo` varchar(25) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;

INSERT INTO tipos_juguetes VALUES ('Videojuego');
INSERT INTO tipos_juguetes VALUES ('Electrónico');
INSERT INTO tipos_juguetes VALUES ('Peluche');
INSERT INTO tipos_juguetes VALUES ('Otro');



--CREACIÓN DE LA TABLA JUGUETES Y ADICIÓN DE DATOS
--------------------------------------------------

CREATE TABLE `juguetes` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `fechacompra` date DEFAULT NULL,
  `disponibilidad` varchar(30) NOT NULL,
  `tipojuguete_id` int DEFAULT NULL,
  `estadojuguete_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_tipos_idx` (`tipojuguete_id`),
  KEY `fk_estados_idx` (`estadojuguete_id`),
  CONSTRAINT `fk_estados` FOREIGN KEY (`estadojuguete_id`) REFERENCES `estados_juguetes` (`id`),
  CONSTRAINT `fk_tipos` FOREIGN KEY (`tipojuguete_id`) REFERENCES `tipos_juguetes` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;

INSERT INTO juguetes (nombre, tipojuguete_id, fechacompra, estadojuguete_id disponibilidad) VALUES ('Juguete de prueba', 1, '2018-01-01', 1, 'Disponible');
