<?php
if(!defined('BASEPATH')) exit('No direct script access allowed');
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Description of Login
 *
 * @author Werliton
 */
class Login extends CI_Controller{

    public function __construct() {
        parent::__construct();
    }

    public function index(){
        $this->load->view('login');
    }
    /**
     | Método chamado pelo formulário de login
     | recebendo os valores dos campos email e senha
     | e passa esses valores para o método logar();
     */
    function entrar() {
        $this->logar($this->input->post('email'), $this->input->post('password'));
    }

    /**
    |Método responsavel pelo login do usuário
    */
    function logar($email,$senha) {
        // Verificar existencia de cadastro de paciente
        // Carrega o model usuario (usuario_model)
        $this->load->model('usuario_model','usuario');
        // Salva na variável $usuario o retorno do método usuarioExiste(). Que pode ser true ou false
        $usuario = $this->usuario->usuarioExiste(array('email_usuario'=>$email,'senha_usuario'=>$senha));
        // Verifica se a contagem é maior que zero
        if(count($usuario)>0){
            // criar a sessão do usuário
            $this->_createSession($usuario);
            // acessa a página inicial
            redirect('home');
        }else{
            // Seta mensagem de erro caso ocorra
            // Esta mensagem será exibida apenas na primeira requisição
            $this->session->set_flashdata("flash_error","Email ou senha inválida.");
            // Redireciono o usuário para a página de login
            redirect('login');
        }
    }

  /**
  |Cria a sessão do usuário salvando alguns dados do mesmo para
  | uso no decorrer da aplicação
  */
    function _createSession($usuario) {
        $dados = array(
            'usuario'=>$usuario[0]->nm_usuario,
            'logado'=>true,
            'permissao'=>$usuario[0]->tipo_usuario,
            'email'=>$usuario[0]->email_usuario,
            'idusuario'=>$usuario[0]->id_usuario
                );
        $this->session->set_userdata($dados);
    }

    
    /**
     | Realiza o loggof do usuário
     | e redireciona para a tela inicial
    */
    function logout() {
        // Destroi a sessão atual
        $this->session->sess_destroy();
        redirect('/home');
    }

}
