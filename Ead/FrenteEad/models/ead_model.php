<?php

/**
 * Description of Usuario_model
 *
 * @author Werliton
 */

class Ead_model extends CI_Model {

    //put your code here
    private $_table = 'ead';
    private $id_ead;
    private $titulo_ead;
    private $video_ead;
    private $texto_ead;
    private $tipo_usuario_ead;
    private $audio_ead;


    public function __construct() {
        parent::__construct();
    }

    /**
     Retorna todos os dados da tabela informada de acordo com os parametros da consulta
     * eh um select * comum
    */
    public function selectAll($where) {
        // Cláusula where
        $this->db->where('tipo_usuario_ead',$where);
        return $this->db->get($this->_table)->result();
    }

    
}
