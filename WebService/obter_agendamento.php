<?php 

  $username = "root";
    $password = "MySQL";
   
	$conn = new PDO('mysql:host=localhost;dbname=agendamento', $username, $password);
    $conn->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION); 
  
	$id_usuario = $_GET['id_usuario'];
	
	$conn->query("SET NAMES 'utf8'");
    $data = $conn->query("select a.id_agendamento, u.nm_usuario,u.cpf_usuario, h.hora_horario, date_format(h.data_horario,'%d/%m/%Y') data_horario
							from agendamento a, usuario u, horario h
							where a.id_usuario = u.id_usuario
							and a.id_horario = h.id_horario
							and u.id_usuario = '$id_usuario'	
							order by 1");
	
	foreach($data as $row) {
        $output[]=$row; 
    }

	//var_dump($output);
	echo json_encode($output);

?>