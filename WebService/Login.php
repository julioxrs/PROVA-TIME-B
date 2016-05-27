<?php
	
	
	 $username = "root";
    $password = "MySQL";
   
	$conn = new PDO('mysql:host=localhost;dbname=agendamento', $username, $password);
    $conn->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);  
	
	if(preg_match('/^(save-form){1}$/', $_POST['method'])){
		
	$email = $_POST['email'];
	$senha =  $_POST['senha'];

	$res = $conn->query("SELECT * FROM usuario WHERE email_usuario = '$email' AND senha_usuario = '$senha'");
		
	$contagem = $res->rowCount();
	print $contagem;

	}
?>