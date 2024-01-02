-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 02-01-2024 a las 11:39:38
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `empleados`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleado`
--

CREATE TABLE `empleado` (
  `ID` int(11) NOT NULL,
  `APELLIDO` varchar(255) DEFAULT NULL,
  `CARGO` varchar(255) DEFAULT NULL,
  `FECHAINICIO` datetime DEFAULT NULL,
  `NOMBRE` varchar(255) DEFAULT NULL,
  `SALARIO` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `empleado`
--

INSERT INTO `empleado` (`ID`, `APELLIDO`, `CARGO`, `FECHAINICIO`, `NOMBRE`, `SALARIO`) VALUES
(8, 'Perez', 'Desarrollador', '2022-01-01 08:00:00', 'Juan', 50000),
(9, 'Gomez', 'Diseñador', '2022-02-05 09:30:00', 'María', 45000),
(10, 'López', 'Analista', '2022-03-10 11:15:00', 'Carlos', 55000),
(11, 'Martínez', 'Gerente', '2022-04-20 13:45:00', 'Ana', 70000),
(12, 'Fernández', 'Programador', '2022-05-15 10:00:00', 'Luis', 48000),
(13, 'Ramírez', 'Diseñador', '2022-06-22 14:20:00', 'Laura', 46000),
(14, 'García', 'Analista', '2022-07-18 12:30:00', 'Pedro', 60000),
(15, 'Hernández', 'Desarrollador', '2022-08-25 09:00:00', 'Isabel', 52000),
(16, 'Torres', 'Programador', '2022-09-30 15:10:00', 'Miguel', 49000),
(17, 'Díaz', 'Gerente', '2022-10-12 16:45:00', 'Sofía', 75000);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `empleado`
--
ALTER TABLE `empleado`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `empleado`
--
ALTER TABLE `empleado`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
