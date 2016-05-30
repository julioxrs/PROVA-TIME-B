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
	include 'functions/usuario.php';
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
				
				if((isset($_POST['email']))&&(isset($_POST['Enviar']))){
					$user = new Usuario();
					$return = $user->getUserData($con, $pdo, $_POST['email']);
					if($return!=false){
						$totalAval = 0;
						$count = 0;
						for($i=0; $i<count($return); $i++){
							//Fazendo os cálculos para retornar na tabela
							if($return[$i]->aval_agendamento>0){
								$totalAval+=$return[$i]->aval_agendamento;
								$count++;
							}
						}
						$mediaAval = $totalAval/$count;
						if($return[0]->avaliou_ead_usuario==1){
							$aval_guia = "Sim";
						}else{
							$aval_guia = "Não";
						}
						if($mediaAval<3){
							$result_type = "Chato";
						}elseif(($mediaAval>=3)&&($mediaAval<4)){
							$result_type = "Normal";
						}else{
							$result_type = "Tranquilo";
						}
						if($totalAval>0){
							$data = $data."<br><br><br><div class='table-responsive text-center'>
									<table class='table table-striped'>
										<thead>
											<th class='text-center'>Nome do aluno</th>
											<th class='text-center'>Média de avaliação dos agendamentos</th>
											<th class='text-center'>Avaliação do guia</th>
											<th class='text-center'>Resultado</th>
										</thead>
										<tbody>
											<tr>
												<td>{$return[0]->nm_usuario}</td>
												<td>{$mediaAval}</td>
												<td>{$aval_guia}</td>
												<td>{$result_type}</td>
											</tr>
										</tbody></table><br>
										<a href='home.php'>Voltar</a>";
						}else{
							$data = $data."<br><br><br>Ainda não há avaliações do aluno <br><br><a href='home.php'>Voltar</a>";
						}
					}else{
						$data = $data."<br><br><br>Ainda não há avaliações do aluno <br><br><a href='home.php'>Voltar</a>";
					}
				}else{
				$data = $data."<br><br>
				<div class='alert alert-info alert-dismissable'>
					<div align='center'>Saiba qual a avaliação de determinado aluno aqui.<br><br>
					<form action='home.php' method='post'>
						Digite o e-mail do aluno: 
						<input type='text' name='email'>
						<input type='submit' value='Enviar' name='Enviar'>
				</form></div> 
				";
				}
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
