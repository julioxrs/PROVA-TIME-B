<?php 

  $username = "root";
    $password = "MySQL";
   
	$conn = new PDO('mysql:host=localhost;dbname=agendamento', $username, $password);
    $conn->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION); 
  
	$email = $_GET['email'];
	$conn->query("SET NAMES 'utf8'");
    $data = $conn->query("SELECT id_usuario FROM usuario where email_usuario = '$email'");
	
	foreach($data as $row) {
        $output[]=$row; 
    }

	//var_dump($output);
	echo json_encode($output);

?>