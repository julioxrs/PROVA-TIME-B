<?php

/**
 * Description of Usuario_model
 *
 * @author Werliton
 */

class Aval_Ead_model extends CI_Model {

    //put your code here
    private $_table = 'aval_ead';
    private $id_aval_ead;
    private $id_usuario;    
    private $data_aval_ead;
    private $tipo_aval_ead;


    public function __construct() {
        parent::__construct();
    }

    /**
     * Método de inserção de dados no banco
     * retorna TRUE ou FALSE
     * @param type $dados
     * @return type
     */
    function insert($dados) {
        return $this->db->insert($this->_table, $dados);
    }
    /**
     Retorna todos os dados da tabela informada de acordo com os parametros da consulta
    */
    public function selectAll($where) {
        $this->db->where($where);
        return $this->db->get($this->_table)->result();
    }
    
}
