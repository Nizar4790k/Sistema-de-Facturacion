CREATE DATABASE  IF NOT EXISTS `sistema_de_facturacion`;
USE `sistema_de_facturacion`;


DROP TABLE IF EXISTS `cliente`;

CREATE TABLE `cliente` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `apellido` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `telefono` varchar(12) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `producto`;

CREATE TABLE `producto` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) DEFAULT NULL,
  `precio` decimal(10,4) DEFAULT null,
  `tasa_itbis` decimal(10,4) DEFAULT null,
  `cantidad_disponible` int(255) default null,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `productos_facturados`;

CREATE TABLE `productos_facturados` (
  `indice` int(11) NOT NULL AUTO_INCREMENT,
  `indice_factura` int(11) NOT NULL ,
   `precio` decimal(10,4) NOT NULL ,
  `descripcion` varchar(45) NOT NULL ,
  `tasa_itbis` decimal(10,4) NOT NULL ,
  `id_producto` int(11) NOT NULL ,
  `id_factura` int(11) NOT NULL,
  `cantidad_facturada` int(255) default null,
  PRIMARY KEY (`indice`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;





DROP TABLE IF EXISTS `factura`;

CREATE TABLE `factura` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  
  `subtotal` double(10,4) DEFAULT NULL,
   `total_a_pagar` double(10,4) DEFAULT NULL,
  `total_itbis` double(10,4) DEFAULT NULL,
  `fecha` varchar(10) DEFAULT NULL,
  `idcliente` int(11) DEFAULT null,
  `hora` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;
