<?php
	if((isset($_POST['notaAval']))&&(isset($_POST['idAgendamento']))&&(isset($_POST['Avaliar']))){
		if((0<$_POST['notaAval'])&&($_POST['notaAval']<=5)){
			//$_POST[''] = preg_replace('/[^[:num:]_]/', '',$_POST['notaAval']);
			//$_POST[''] = preg_replace('/[^[:num:]_]/', '',$_POST['']);
			//$_POST[''] = preg_replace('/[^[:num:]_]/', '',$_POST['login']);
			//echo "not entre";
			
		}else{
			header("Location:index.php");
		}
	}
?>