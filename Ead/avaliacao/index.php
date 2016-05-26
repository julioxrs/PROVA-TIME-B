<?php
	//Incluindo classes
	include 'functions/agendamento.php';
	include 'functions/connection.php';
	include 'functions/horario.php';
	//VARIAVEIS PARA TESTE
	$tipo_usuario = '0';
	$id_usuario = '1';
	//if(!((isset($_SESSION['']))&&(isset($_SESSION[''])))){
		$con = new Connection();
		$pdo = $con->pdoConnect(); //Cria conexão com o banco de dados
		switch ($tipo_usuario){
			case 0: //Aluno
				$agendamento = new Agendamento();
				$agendamento->setid_usuario($id_usuario);
				$resultAgendamentos = $agendamento->getAllDispAgendamentos($con, $pdo); //Função que pega todos os horários que ainda não foram avaliados e retorna um array
				if($resultAgendamentos!=false){ //Se houver dados
					//echo var_dump($resultAgendamentos);
					$data = '<table border="1" align="center">';
					for($i=0;$i<count($resultAgendamentos);$i++){
						$data = $data.'
						<tr>
							<td>'.$resultAgendamentos[$i]->data_horario.'</td>
							<td>'.$resultAgendamentos[$i]->hora_horario.'</td>
							<td>
								<form action="processAval.php" method="post">
									<input type="text" name="notaAval" value="0" maxlength="1">
									<input type="hidden" name="idAgendamento" value="'.$resultAgendamentos[$i]->id_agendamento.'">
									<input type="submit" name="Avaliar" value="Avaliar">
								</form>
							</td>
						</tr>';
					}
					$data = $data.'</table>';
				}else{
					echo "Não há informações de agendamentos não havaliados.";
				}
				break;
			case 1: //Funcionario
				break;
			default:
				//header("Location");
				break;
		}
	//}
?>
<html lang="pt-br">
	<head>
		<title>Título</title>
	</head>
	<body>
		<?php
			echo $data;
		?>
	</body>
</html>