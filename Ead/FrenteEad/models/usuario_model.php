<?php

/**
 * Description of Usuario_model
 *
 * @author Werliton
 */

class Usuario_model extends CI_Model {

    //put your code here
    private $_table = 'usuario';
    private $id_usuario;
    private $nm_usuario;
    private $tel_usuario;
    private $cpf_usuario;
    private $email_usuario;
    private $senha_usuario;
    private $tipo_usuario;

    function __construct() {
        parent::__construct();
    }

    /**
     * Função que insere dados no banco de dados
     * @param array $dados
     * @return retorna o último id inserido
     */
    function insert($dados) {
        $this->db->insert($this->_table, $dados);
        return $this->db->insert_id();
    }

    /**
      Verifica se o usuário informado já existe na base de dados
     * @param type $where
     * @return lista de usuario encontrados
     */
    function usuarioExiste($where) {
        $this->db->where($where);
        return $this->db->get($this->_table)->result();
    }

    /**
     Retorna todos os dados da tabela informada
    */
    function selectAll() {
        return $this->db->get($this->_table)->result();
    }
    
    /**
    Retorna apenas uma linha da tabela
    */
    function selectOne($where) {
        $this->db->where($where);
        $usuarios = $this->db->get($this->_table)->result();
        if(count($usuarios) > 0){
            foreach ($usuarios as $usuario) {
                $this->id_usuario    = $usuario->id_usuario;
                $this->nm_usuario    = $usuario->nm_usuario;
                $this->cpf_usuario   = $usuario->cpf_usuario;
                $this->email_usuario = $usuario->email_usuario;
                $this->senha_usuario = $usuario->tipo_usuario;
            }
            return $this;
        }  else  return null;
    }

    /**
     * Verifica se o usuário já avaliou o Guia do usuário
     * @param type $idUsuario
     * retorna a quantidade de resultado
     */
    function usuarioAvaliouEad($idUsuario) {
        $this->db->where('id_usuario',$idUsuario);
        $this->db->where('avaliou_ead_usuario',1);
        return count($this->db->get($this->_table)->result());
    }
    
    /**
     * Atualiza dados na tabela 
     * @param type $id
     * @param type $dados
     * @return boolean
     */
    function update($id, $dados = array()) {
        $this->db->where("id_{$this->_table}", $id);
        if($this->db->update($this->_table, $dados)) return true;
        else return false;
    }
}
