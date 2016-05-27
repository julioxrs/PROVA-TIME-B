-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 27-Maio-2016 às 14:18
-- Versão do servidor: 5.6.21
-- PHP Version: 5.6.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `agendamento`
--
CREATE DATABASE IF NOT EXISTS `agendamento` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `agendamento`;

-- --------------------------------------------------------

--
-- Estrutura da tabela `agendamento`
--

CREATE TABLE IF NOT EXISTS `agendamento` (
`id_agendamento` int(11) NOT NULL,
  `id_horario` int(11) NOT NULL,
  `id_usuario` int(11) NOT NULL,
  `aval_agendamento` int(1) DEFAULT '0'
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `agendamento`
--

INSERT INTO `agendamento` (`id_agendamento`, `id_horario`, `id_usuario`, `aval_agendamento`) VALUES
(1, 3, 2, 0),
(2, 2, 2, 0),
(3, 4, 2, 0),
(4, 1, 1, 0);

-- --------------------------------------------------------

--
-- Estrutura da tabela `aval_ead`
--

CREATE TABLE IF NOT EXISTS `aval_ead` (
`id_aval_ead` int(11) NOT NULL,
  `id_usuario` int(11) NOT NULL,
  `data_aval_ead` datetime NOT NULL,
  `tipo_aval_ead` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `aval_ead`
--

INSERT INTO `aval_ead` (`id_aval_ead`, `id_usuario`, `data_aval_ead`, `tipo_aval_ead`) VALUES
(1, 2, '2016-05-07 12:05:08', 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `ead`
--

CREATE TABLE IF NOT EXISTS `ead` (
`id_ead` int(11) NOT NULL,
  `titulo_ead` varchar(50) DEFAULT NULL,
  `video_ead` varchar(250) DEFAULT NULL,
  `texto_ead` text,
  `tipo_usuario_ead` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `horario`
--

CREATE TABLE IF NOT EXISTS `horario` (
`id_horario` int(11) NOT NULL,
  `hora_horario` time NOT NULL,
  `data_horario` date NOT NULL,
  `disp_horario` int(11) NOT NULL DEFAULT '0' COMMENT 'Aceita 0 e 1\n\n0 - Disponivel\n1 - Não Disponivel'
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `horario`
--

INSERT INTO `horario` (`id_horario`, `hora_horario`, `data_horario`, `disp_horario`) VALUES
(1, '15:00:00', '2016-05-26', 1),
(2, '17:00:00', '2016-05-30', 1),
(3, '12:15:00', '2016-05-31', 1),
(4, '18:00:00', '2016-05-26', 1),
(5, '15:00:00', '2016-05-28', 0),
(6, '12:30:00', '2016-05-31', 0),
(7, '14:00:00', '2016-05-31', 0),
(8, '14:00:00', '2016-06-01', 0);

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuario`
--

CREATE TABLE IF NOT EXISTS `usuario` (
`id_usuario` int(11) NOT NULL,
  `nm_usuario` varchar(100) NOT NULL,
  `tel_usuario` varchar(45) NOT NULL,
  `cpf_usuario` varchar(20) NOT NULL,
  `email_usuario` varchar(100) NOT NULL,
  `senha_usuario` varchar(100) NOT NULL,
  `tipo_usuario` int(11) NOT NULL COMMENT 'Aceita valores 0 e 1\n0 - Aluno\n1 - Funcionário',
  `avaliou_ead_usuario` int(1) DEFAULT '0'
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `usuario`
--

INSERT INTO `usuario` (`id_usuario`, `nm_usuario`, `tel_usuario`, `cpf_usuario`, `email_usuario`, `senha_usuario`, `tipo_usuario`, `avaliou_ead_usuario`) VALUES
(1, 'Teste Funcionário', '(98)98146-8103', '234.342.342-42', 'teste.funcionario@teste.com', '123', 1, 0),
(2, 'Teste Aluno', '(98)98146-8103', '432.342.342-34', 'teste.aluno@teste.com', '123', 0, 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `agendamento`
--
ALTER TABLE `agendamento`
 ADD PRIMARY KEY (`id_agendamento`), ADD KEY `fk_agendamento_horario1_idx` (`id_horario`), ADD KEY `fk_agendamento_usuario1_idx` (`id_usuario`);

--
-- Indexes for table `aval_ead`
--
ALTER TABLE `aval_ead`
 ADD PRIMARY KEY (`id_aval_ead`);

--
-- Indexes for table `ead`
--
ALTER TABLE `ead`
 ADD PRIMARY KEY (`id_ead`), ADD KEY `fk_ead_usuario1_idx` (`tipo_usuario_ead`);

--
-- Indexes for table `horario`
--
ALTER TABLE `horario`
 ADD PRIMARY KEY (`id_horario`);

--
-- Indexes for table `usuario`
--
ALTER TABLE `usuario`
 ADD PRIMARY KEY (`id_usuario`), ADD UNIQUE KEY `id_usuario_UNIQUE` (`id_usuario`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `agendamento`
--
ALTER TABLE `agendamento`
MODIFY `id_agendamento` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `aval_ead`
--
ALTER TABLE `aval_ead`
MODIFY `id_aval_ead` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `ead`
--
ALTER TABLE `ead`
MODIFY `id_ead` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `horario`
--
ALTER TABLE `horario`
MODIFY `id_horario` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT for table `usuario`
--
ALTER TABLE `usuario`
MODIFY `id_usuario` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=18;
--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `agendamento`
--
ALTER TABLE `agendamento`
ADD CONSTRAINT `fk_agendamento_horario1` FOREIGN KEY (`id_horario`) REFERENCES `horario` (`id_horario`) ON DELETE NO ACTION ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_agendamento_usuario1` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `ead`
--
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
