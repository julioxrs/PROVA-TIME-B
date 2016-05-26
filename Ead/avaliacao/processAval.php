<?php
	if((isset($_POST['notaAval']))&&(isset($_POST['idAgendamento']))&&(isset($_POST['Avaliar']))){
		if((0<$_POST['notaAval'])&&($_POST['notaAval']<=5)){
			include ("functions/agendamento.php");
			include ("functions/connection.php");
			$con = new Connection();
			$pdo = $con->pdoConnect();
			$agendamento = new Agendamento();
			$agendamento->setid_agendamento($_POST['idAgendamento']);
			$agendamento->setAval_Agendamento($_POST['notaAval']);
			$resultAval_Agendamento = $agendamento->insertAvalValue($con, $pdo);
			if($resultAval_Agendamento){
				header("Location: index.php?msg=success");
			}else{
				header("Location: index.php?msg=wrong");
			}
		}else{
			header("Location: index.php");
		}
	}
?>
