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
	if((isset($_GET['tipo_usuario']))&&(isset($_GET['id_usuario']))){
		$tipo_usuario = $_GET['tipo_usuario'];
		$id_usuario = $_GET['id_usuario'];
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
				$data = "funcionario";
				break;
			default:
				//header("Location");
				break;
		}
	}else{
		$data = "Não há sessão criada";
	}
include('template/header.php');?>
	<div id="espaco-pos-pesquisa"></div>
	<div id="page-wrapper">
		<div class="alert alert-danger alert-dismissable">
			<?php echo $data; ?>
		</div>


	</div> <!-- /PAINEL-GROUP -->
<!-- /#page-wrapper -->
<?php
	include('template/footer.php');
 ?>
