<?php
 class Usuario{
	private $nome;
	private $aval_guia;
	private $aval_agendamentos;
	private $email;
	
	function getUserData($con, $pdo, $email){
		$data = $con->getUserData($pdo, $email);
		return $data;
	}
 }
?>