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
		
		/* Função de SELECT genérica
				$pdo = retorno da conexão feita com o banco de dados acima
				$dataType = tipo de dado que deverá ser retornado (exemplo: '*')
				$table = tabela a qual se irá executar o comando SQL
				$whereStmt = parte do where sem o bindValue (exemplo:  'WHERE id=:id')
				$whereStmtArray = array responsável pelo bindValue em si. O mesmo deverá ser povoado
					exemplo:
						
		*/
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
		
		function insertAvalValue($aval_value){
			
		}
	}
?>