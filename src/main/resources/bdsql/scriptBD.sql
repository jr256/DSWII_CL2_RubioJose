CREATE DATABASE  IF NOT EXISTS control2bd;
USE control2bd;


CREATE TABLE `producto` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `descripcion` varchar(45) DEFAULT NULL,
  `cantidad` int DEFAULT NULL,
  `fechavencimiento` date DEFAULT NULL,
  PRIMARY KEY (`id`)
);



INSERT INTO producto VALUES (1,'mantequilla','mantequilla glorial 100gr',30,'2023-12-01'),(2,'gaseosa','gaseosa inka kola 1 litro',100,'2024-06-15'),(3,'pan','pan de molde bimbo',30,'2023-11-03'),(4,'atun','atun en conserva 100gr',40,'2024-11-05');


