<?php 
	class Connection{
		private $DB_HOST='localhost';
		private $DB_USER = 'root';
		private $DB_PASSWORD = '';
		private $DB_NAME = 'agendamento';
		
		function pdoConnect(){
			try{ //Tenta fazer
				$pdo = new PDO("mysql:host=".$this->DB_HOST.";dbname=".$this->DB_NAME, $this->DB_USER, $this->DB_PASSWORD); //Conexão com o banco
			}catch(PDOException $e){ //Exceção
				echo $e->getMessage(); //Imprimindo a variável de erro
			}
			return $pdo;
		}
		
		/* Função de SELECT genérica*/
		function getAllDispAvalINNER($pdo,$id_usuario){
			//echo "SELECT {$dataType} FROM {$table} {$whereStmt}";
			$resultofQuery = $pdo->prepare("
			SELECT * FROM agendamento 
			INNER JOIN horario ON agendamento.id_horario = horario.id_horario
			WHERE aval_agendamento=0 AND id_usuario=:user ORDER BY id_agendamento DESC
			;");
			$resultofQuery->bindValue(':user', $id_usuario);
			$resultofQuery->execute();
			if($resultofQuery->rowCount()>=1){
				$count = 0;
				$return = array();
				while($row = $resultofQuery->fetch(PDO::FETCH_OBJ)){
					$return[$count] = $row;
					$count++;
				}
				return $return;
			}else{
				return false;
			}
		}
		
		function getAllAgendamentos($pdo){
			$resultofQuery = $pdo->prepare("SELECT * FROM agendamento");
			$resultofQuery->execute();
			if($resultofQuery->rowCount()>=1){
				$count = 0;
				$return = array();
				while($row = $resultofQuery->fetch(PDO::FETCH_OBJ)){
					$return[$count] = $row;
					$count++;
				}
				return $return;
			}else{
				return false;
			}
		}
		
		function insertAvalValue($pdo, $aval_value, $id_agendamento){
			$resultofQuery = $pdo->prepare("UPDATE agendamento SET aval_agendamento=:aval WHERE id_agendamento=:agen");
			$resultofQuery->bindValue(":aval", $aval_value);
			$resultofQuery->bindValue(":agen", $id_agendamento);
			if($resultofQuery->execute()){
				return true;
			}else{
				return false;
			}
		}
	}
?>