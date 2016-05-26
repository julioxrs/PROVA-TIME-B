<?php
	// Arquivo que guarda a clase relacionada a avaliação do usuário em relação ao atendimento
	class Agendamento{
		private $aval_agendamento;
		private $id_horario;
		private $id_usuario;
		private $id_agendamento;
		
		//Métodos de inserção dos dados nas variáveis privadas
		function setAval_agendamento($data){
			$this->aval_agendamento = $data;
		}
		
		function setid_horario($data){
			$this->id_horario = $data;
		}
		
		function setid_usuario($data){
			$this->id_usuario = $data;
		}
		
		function setid_agendamento($data){
			$this->id_agendamento = $data;
		}
		//Termino dos métodos de inserção dos dados nas variáveis privadas
		
		//Métodos de acesso dos dados na tabela		
		//Função que pega todos os agendamentos do usuário disponíveis
		function getAllDispAgendamentos($con,$pdo){
			$result = $con->getAllDispAvalINNER($pdo, $this->id_usuario);
			return $result;
		}
		
		function insertAvalValue($con, $pdo){
			$result = $con->insertAvalValue($pdo, $this->aval_agendamento, $this->id_agendamento);
			return $result;
		}
	}
?>
