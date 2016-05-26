-- MySQL Script generated by MySQL Workbench
-- 05/25/16 17:10:20
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema agendamento
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema agendamento
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `agendamento` DEFAULT CHARACTER SET utf8 ;
USE `agendamento` ;

-- -----------------------------------------------------
-- Table `agendamento`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `agendamento`.`usuario` (
  `id_usuario` INT NOT NULL AUTO_INCREMENT,
  `nm_usuario` VARCHAR(100) NOT NULL,
  `tel_usuario` VARCHAR(45) NOT NULL,
  `cpf_usuario` VARCHAR(20) NOT NULL,
  `email_usuario` VARCHAR(100) NOT NULL,
  `senha_usuario` VARCHAR(100) NOT NULL,
  `tipo_usuario` INT NOT NULL COMMENT 'Aceita valores 0 e 1\n0 - Aluno\n1 - Funcionário',
  PRIMARY KEY (`id_usuario`),
  UNIQUE INDEX `id_usuario_UNIQUE` (`id_usuario` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `agendamento`.`horario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `agendamento`.`horario` (
  `id_horario` INT NOT NULL AUTO_INCREMENT,
  `hora_horario` TIME(0) NOT NULL,
  `data_horario` DATE NOT NULL,
  `disp_horario` INT NOT NULL DEFAULT 0 COMMENT 'Aceita 0 e 1\n\n0 - Disponivel\n1 - Não Disponivel',
  PRIMARY KEY (`id_horario`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `agendamento`.`ead`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `agendamento`.`ead` (
  `id_ead` INT NOT NULL AUTO_INCREMENT,
  `titulo_ead` VARCHAR(50) NULL,
  `video_ead` VARCHAR(250) NULL,
  `texto_ead` TEXT(1000) NULL,
  `tipo_usuario_ead` INT NOT NULL,
  PRIMARY KEY (`id_ead`),
  INDEX `fk_ead_usuario1_idx` (`tipo_usuario_ead` ASC),
  CONSTRAINT `fk_ead_usuario1`
    FOREIGN KEY (`tipo_usuario_ead`)
    REFERENCES `agendamento`.`usuario` (`id_usuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `agendamento`.`agendamento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `agendamento`.`agendamento` (
  `id_agendamento` INT NOT NULL AUTO_INCREMENT,
  `id_horario` INT NOT NULL,
  `id_usuario` INT NOT NULL,
  `aval_agendamento` INT(1) NULL DEFAULT 0,
  PRIMARY KEY (`id_agendamento`),
  INDEX `fk_agendamento_horario1_idx` (`id_horario` ASC),
  INDEX `fk_agendamento_usuario1_idx` (`id_usuario` ASC),
  CONSTRAINT `fk_agendamento_horario1`
    FOREIGN KEY (`id_horario`)
    REFERENCES `agendamento`.`horario` (`id_horario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_agendamento_usuario1`
    FOREIGN KEY (`id_usuario`)
    REFERENCES `agendamento`.`usuario` (`id_usuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;