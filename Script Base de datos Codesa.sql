-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         5.5.46 - MySQL Community Server (GPL)
-- SO del servidor:              Win64
-- HeidiSQL Versión:             11.0.0.5919
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Volcando estructura de base de datos para codesa
CREATE DATABASE IF NOT EXISTS `codesa` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `codesa`;

-- Volcando estructura para tabla codesa.rol
CREATE TABLE IF NOT EXISTS `rol` (
  `IDROL` int(10) NOT NULL DEFAULT '0',
  `NOMBRE` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`IDROL`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla codesa.rol: ~4 rows (aproximadamente)
/*!40000 ALTER TABLE `rol` DISABLE KEYS */;
INSERT INTO `rol` (`IDROL`, `NOMBRE`) VALUES
	(1, 'ADMINISTRADOR'),
	(2, 'AUDITOR'),
	(3, 'Pedro Ozuna'),
	(4, 'SUPERVISOR');
/*!40000 ALTER TABLE `rol` ENABLE KEYS */;

-- Volcando estructura para tabla codesa.usuario
CREATE TABLE IF NOT EXISTS `usuario` (
  `IDUSUARIO` int(10) NOT NULL AUTO_INCREMENT,
  `IDROL` int(10) DEFAULT NULL,
  `NOMBRE` varchar(50) DEFAULT NULL,
  `ACTIVO` char(10) DEFAULT NULL,
  `CORREO` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`IDUSUARIO`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla codesa.usuario: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` (`IDUSUARIO`, `IDROL`, `NOMBRE`, `ACTIVO`, `CORREO`) VALUES
	(1, 1, 'Juan', 'si', 'ing.juanbeltran@gmail.com'),
	(3, 3, 'Pedro Ozuna', 'no', 'pedroozuna@gmail.com');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
