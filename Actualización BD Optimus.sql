--Incluir los campos de especificaciones en la tabla producto
ALTER TABLE `dboptimus`.`producto` 
DROP COLUMN `idEspecificaciones`,
ADD COLUMN `diametromin` FLOAT NOT NULL AFTER `idTipoReferencia`,
ADD COLUMN `diametromax` FLOAT NOT NULL AFTER `diametromin`,
ADD COLUMN `largomin` FLOAT NULL AFTER `diametromax`,
ADD COLUMN `largomax` FLOAT NULL AFTER `largomin`,
ADD COLUMN `alto` FLOAT NULL AFTER `largomax`,
ADD COLUMN `pesomin` FLOAT NOT NULL AFTER `alto`,
ADD COLUMN `pesomax` FLOAT NOT NULL AFTER `pesomin`,
DROP INDEX `fk_Prod_Especif_id_idx` ;
;

--Eliminar la tabla especificaciones
DROP TABLE `dboptimus`.`especificaciones`;


--Creación llaves foraneas
ALTER TABLE `dboptimus`.`producto` 
ADD INDEX `fkReferenciaProducto_idx` (`idTipoReferencia` ASC) VISIBLE;
;
ALTER TABLE `dboptimus`.`producto` 
ADD CONSTRAINT `fkReferenciaProducto`
  FOREIGN KEY (`idTipoReferencia`)
  REFERENCES `dboptimus`.`tiporeferencia` (`idTipoReferencia`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;
  
 ALTER TABLE `dboptimus`.`lote_producto` 
ADD INDEX `fkProductoLoteProducto_idx` (`idProducto` ASC) VISIBLE,
ADD INDEX `fkLoteProductoLote_idx` (`idLote` ASC) VISIBLE;
;
ALTER TABLE `dboptimus`.`lote_producto` 
ADD CONSTRAINT `fkProductoLoteProducto`
  FOREIGN KEY (`idProducto`)
  REFERENCES `dboptimus`.`producto` (`idProducto`)
  ON DELETE CASCADE
  ON UPDATE CASCADE,
ADD CONSTRAINT `fkLoteProductoLote`
  FOREIGN KEY (`idLote`)
  REFERENCES `dboptimus`.`lote` (`idLote`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;
  
  ALTER TABLE `dboptimus`.`muestreoproducto` 
ADD INDEX `fkEstadoMuestreo_idx` (`idTipoEstado` ASC) VISIBLE;
;
ALTER TABLE `dboptimus`.`muestreoproducto` 
ADD CONSTRAINT `fkEstadoMuestreo`
  FOREIGN KEY (`idTipoEstado`)
  REFERENCES `dboptimus`.`tipoestado` (`idTipoEstado`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;
  
 ALTER TABLE `dboptimus`.`defectomuestreo` 
ADD INDEX `fkTipoDefecto_idx` (`idTipoDefecto` ASC) VISIBLE;
;
ALTER TABLE `dboptimus`.`defectomuestreo` 
ADD CONSTRAINT `fkTipoDefecto`
  FOREIGN KEY (`idTipoDefecto`)
  REFERENCES `dboptimus`.`tipodefecto` (`idTipoDefecto`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;


ALTER TABLE `dboptimus`.`defectomuestreo` 
ADD INDEX `fkDefectoMuestreo_idx` (`idMuestreoProducto` ASC) VISIBLE;
;
ALTER TABLE `dboptimus`.`defectomuestreo` 
ADD CONSTRAINT `fkDefectoMuestreo`
  FOREIGN KEY (`idMuestreoProducto`)
  REFERENCES `dboptimus`.`muestreoproducto` (`idMuestreoProducto`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;


-- Insertar datos de especificaciones en producto
update producto set DiametroMin = 14,	 DiametroMax = 14, LargoMin = 5,  LargoMax = 6,  Alto = 6, 	PesoMin = 33,  PesoMax = 43		Where idproducto = 1;
update producto set DiametroMin = 7,   DiametroMax = 8,  LargoMin = 17, LargoMax = 18, Alto = 3, 	PesoMin = 25,  PesoMax = 35		Where idproducto = 2;
update producto set DiametroMin = 8,   DiametroMax = 9,  LargoMin = 19, LargoMax = 20, Alto = NULL, PesoMin = 35,  PesoMax = 45		Where idproducto = 3;	
update producto set DiametroMin = 7,   DiametroMax = 7,  LargoMin = 15, LargoMax = 16, Alto = NULL, PesoMin = 25,  PesoMax = 35 	Where idproducto = 4;	
update producto set DiametroMin = 4,   DiametroMax = 5,	 LargoMin = 15, LargoMax = 16, Alto = NULL, PesoMin = 25,  PesoMax = 35 	Where idproducto = 5;
update producto set DiametroMin = 16,  DiametroMax = 17, LargoMin = 16,  LargoMax = 17, Alto = 3,  PesoMin = 30,  PesoMax = 40	Where idproducto = 6;
update producto set DiametroMin = 6,   DiametroMax = 6,  LargoMin = 6,    LargoMax = 7,    Alto = NULL, PesoMin = 1.5, PesoMax = 2	Where idproducto = 7;
update producto set DiametroMin = 1,   DiametroMax = 2,  LargoMin = 10,   LargoMax = 11,   Alto = NULL, PesoMin = 5, PesoMax = 6	Where idproducto = 8;
update producto set DiametroMin = 2,   DiametroMax = 3,  LargoMin = 6,  LargoMax = 7,  Alto = NULL, PesoMin = 3,   PesoMax = 4		Where idproducto = 9;
update producto set DiametroMin = 3,   DiametroMax = 4,  LargoMin = 11, LargoMax = 12, Alto = NULL, PesoMin = 4, PesoMax = 5	Where idproducto = 10;	
update producto set DiametroMin = 4,   DiametroMax = 5,  LargoMin = NULL,  LargoMax = 4,  Alto = 5,  PesoMin = 3, PesoMax = 4	Where idproducto = 11;
update producto set DiametroMin = 11,  DiametroMax = 11, LargoMin = 11,   LargoMax = 12,   Alto = 4,   PesoMin = 16, PesoMax = 17		Where idproducto = 12;

--Cambiar el tipo de dato de los campos de float a entero
ALTER TABLE `dboptimus`.`producto` 
CHANGE COLUMN `diametromin` `diametromin` INT NOT NULL ,
CHANGE COLUMN `diametromax` `diametromax` INT NOT NULL ,
CHANGE COLUMN `largomin` `largomin` INT NULL DEFAULT NULL ,
CHANGE COLUMN `largomax` `largomax` INT NULL DEFAULT NULL ,
CHANGE COLUMN `alto` `alto` INT NULL DEFAULT NULL ,
CHANGE COLUMN `pesomin` `pesomin` INT NOT NULL ,
CHANGE COLUMN `pesomax` `pesomax` INT NOT NULL ;
