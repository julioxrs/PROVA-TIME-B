<?php

class Home extends CI_Controller {

    // Variável que guardará o id do usuário corrente 
    private $id_user_current;
    
    function __construct() {
        parent::__construct();
        /**
         *  Função que restringe o acesso de um usuário não autenticado
         * 1º parametro: restrição 1 
         * 2º parametro: restrição 2
         * 3º parametro: tela destino 
         * As duas restrições iniciais são para restringir de usuário que não seja 
         * nem aluno, nem funcionário
         */
        restringeNivelAcesso(0, 1, 'login');
        $this->id_user_current = $this->session->userdata('idusuario');
    }

    /**
     | Método inicial
     */
    function index() {
        // Carrega o modelo ead_model
        $this->load->model('ead_model','ead');
        // Coloca na variavel eads todos os resultados da tabela ead de acordo com a permissão, se eh aluno ou funcionario
        $dados['eads'] =  $this->ead->selectAll($this->session->userdata('permissao'));
        $dados['avaliou'] = $this->_usuarioAvaliouEad();
        $dados['msg_boas_vindas'] = $this->_msgBoasVindas();
        
        $icone_play = "<i class='ícone glyphicon glyphicon-play'></i>";
        $dados['mensagem_audio'] = "    <p>Olá, você também pode ouvir todo o tutorial, caso esteja tendo algum problema 
                                            com a reprodução do vídeo. Para isso clique  </p>
                                            <p>Clique ao lado/abaixo no ícone ".$icone_play." para ouvir o tutorial em áudio mp3.</p> ";
        $dados['mensagem_video'] = "    <p>Olá, você também pode ver todo o tutorial em vídeo para isso
                                            Clique no ícone ".$icone_play." no vídeo ao lado/abaixo para assistir.</p> ";
        // Carrega a view home
        $this->template->show('home',$dados);
    }

    /**
     * 
     * @return Uma string contendo uma mensagem de boas vindas, de acordo com a data e hora do sistema
     */
    function _msgBoasVindas() {
        $dataAtual = date('d/m/Y');
        $horaAtual = date('H');
        $msg = 'Bom dia';
        switch ($horaAtual) {
            case $horaAtual>0 && $horaAtual<=12:$msg;
                break;
            case $horaAtual>12 && $horaAtual<=18:$msg="Boa tarde";
                break;
            default:$msg="Boa Noite";
                break;
        }
        $msg .= ", ".$dataAtual." ".date('H:m');
        return $msg;
    }
    /**
     * Verificar se o aluno já avaliou o tutorial
     */
    function _usuarioAvaliouEad() {
        // Carregar o model do usário
        $this->load->model('usuario_model','usuario');
        // Chama o método usuarioAvaliouEad passando id corrente para saber se um usuário já realizou a avaliação do guia
        return $this->usuario->usuarioAvaliouEad($this->id_user_current);
    }
    
    // Método salva uma avaliação UTIL
    function eadUtil() {
        $this->_salvaAvaliacao(1);
    }
    // Método salva uma avaliação INUTIL
    function eadInutil() {
        $this->_salvaAvaliacao(0);
    }
    // Método Salva a avaliação do usuário no banco
    function _salvaAvaliacao($idAvaliacao) {
        // Carrega o model aval_ead_model
        $this->load->model('aval_ead_model','aval');
        
        $dados = array(
            'id_usuario'=>  $this->id_user_current,
            'data_aval_ead'=> date('Y-m-d H:m:s'),
            'tipo_aval_ead'=> $idAvaliacao
        );
        // Verifica se a avaliação foi salva no banco
        if ($this->aval->insert($dados)) {     
            // Verifica se a tabela usuário foi atualizada
            if($this->_atualizaUsuario($idAvaliacao))
                gera_flash_msg(1, 'Avaliação feita com sucesso. Agradecemos sua participação', 'home');
        }
        else gera_flash_msg(0, ' Erro ao efetuar avaliação. Tente novamente por favor.', 'home'); 
    }
    
    /**
     * Atualiza na tabela usuário se o usuário avaliou o guia
     * @param type $idAval
     */
    function _atualizaUsuario($idAval) {
        $this->load->model('usuario_model','usuario');
        return $this->usuario->update($this->id_user_current,array('avaliou_ead_usuario'=>$idAval));
    }
    
    /**
     * Chama o sistema de avaliação de Thiago
     */
    function avaliacao() {
        session_start();
        $_SESSION['id_usuario'] = $this->session->userdata('idusuario');
        $_SESSION['usuario']    = $this->session->userdata('usuario');
        
        header('location:../../avaliaçao/home.php');
    }

}
