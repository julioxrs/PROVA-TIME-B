<?php
session_start();
	if(isset($_GET['msg'])){
		switch ($_GET['msg']){
			case 'success':
				echo "<script>alert('Avaliação inserida com sucesso!');</script>";
				break;
			case 'wrong':
				echo "<script>alert('Em decorrência de algum problema, a avaliação não pôde ser efetuada.');</script>";
				break;
			case 'nodata':
				echo "<script>alert('Não há avaliação para ser enviada, por favor tente novamente.');</script>";
				break;
		}
	}
	//Incluindo classes
	include 'functions/agendamento.php';
	include 'functions/connection.php';
	//include 'functions/horario.php';
	//VARIAVEIS PARA TESTE
	//$tipo_usuario = $_SESSION['permissao'];
	//$id_usuario = $_SESSION['idusuario'];
	if((isset($_SESSION['tipo_usuario']))&&(isset($_SESSION['id_usuario']))&&(isset($_SESSION['nome_usuario']))){
		$tipo_usuario = $_SESSION['tipo_usuario'];
		$id_usuario = $_SESSION['id_usuario'];
		$con = new Connection();
		$pdo = $con->pdoConnect(); //Cria conexão com o banco de dados
		$agendamento = new Agendamento();
		$agendamento->setid_usuario($id_usuario);
		switch ($tipo_usuario){
			case 0: //Aluno
				$resultAgendamentos = $agendamento->getAllDispAgendamentos($con, $pdo); //Função que pega todos os horários que ainda não foram avaliados e retorna um array
				if($resultAgendamentos!=false){ //Se houver dados
					//echo var_dump($resultAgendamentos);
					$data = '<div class="table-responsive text-center">
								<table class="table table-striped">
									<thead>
										<th class="text-center">Data</th>
										<th class="text-center">Hora</th>
										<th class="text-center">Avaliação</th>
									</thead>';
					for($i=0;$i<count($resultAgendamentos);$i++){
						$data = $data.'
						<tbody>
							<tr>
								<td>'.$resultAgendamentos[$i]->data_horario.'</td>
								<td>'.$resultAgendamentos[$i]->hora_horario.'</td>
								<td>
									<form action="processAval.php" method="post">
										<input type="text" name="notaAval" class="form-control" value="0" maxlength="1">
										<input type="hidden" name="idAgendamento" value="'.$resultAgendamentos[$i]->id_agendamento.'">
										<input type="hidden" name="idUsuario" value="'.$resultAgendamentos[$i]->id_usuario.'">
										<input type="hidden" name="tipoUsuario" value="'.$tipo_usuario.'">
										<input type="submit" name="Avaliar" value="Avaliar" class="btn btn-default">
									</form>
								</td>
							</tr>
						</tbody>';
					}
					$data = $data.'</table></div>';
				}else{
					//var_dump($_SESSION['permissao']);
					$data = "Não há agendamentos disponíveis para ser avaliados.";
				}
				break;
			case 1: //Funcionario
				$result = $agendamento->getAllAgendamentosData($con, $pdo); //Retorna os dados referentes À avaliação
				$data = "<strong>Relatório simplificado de avaliações.</strong>
				<br><br>
				Número total de agendamentos: <strong>{$result['total']}</strong>.<br>
				Número total de agendamentos avaliados: <strong>{$result['totalAval']}</strong>.<br>
				Número total de agendamentos não avaliados: <strong>{$result['noAval']}</strong>.<br>
				Média das avaliações: <strong>{$result['media']}</strong>.
				";
				break;
			default:
				//header("Location");
				break;
		}
	}else{
		$data = "Não há sessão criada";
	}
include('template/header.php');?>
	<!--<div id="espaco-pos-pesquisa"></div>-->
	<div style="height:55px;;"></div>
	<div id="page-wrapper">
		<div class="alert alert-info alert-dismissable">
			<?php 
			if($_SESSION['tipo_usuario']==0){
				echo "<div align='center'>Bom dia, {$_SESSION['nome_usuario']}! Gostaríamos da sua avaliação dos agendamentos. <br>A nota a ser dada varia de 1 a 5, sendo 1 a menor nota, e 5 a maior nota. <br><strong>Muito obrigado!</strong></div><br>"; 
			}else{
				echo "<div align='center'>Bom dia, {$_SESSION['nome_usuario']}! Abaixo os dados resumidos das avaliações dos agendamentos. <br> Muito obrigado!<br>";
			}
			?></div>
	</div> <!-- /PAINEL-GROUP -->
	<div class="col-md-12"><?php echo $data; ?></div>
<!-- /#page-wrapper -->
<?php
	include('template/footer.php');
 ?>
