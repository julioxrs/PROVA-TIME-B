<?php

## RESTRINGUE O NÍVEL DE ACESSO DE UM USUÁRIO ESPECIFICADO
## Verifica se a permissão gravada na sessão eh a mesma dos tipos de usuários cadastrados
/**
 * Restringe o acesso de usuários não autenticados
 * @param type $nivelPermitido
 * @param type $nivelPermitido2
 * @param type $pageDestino
 */
function restringeNivelAcesso($nivelPermitido,$nivelPermitido2,$pageDestino){
    // Get current CI Instance
    $CI = & get_instance();
    if (!$CI->session->userdata('session_id') || !$CI->session->userdata('logado') ||
            $CI->session->userdata('permissao') != $nivelPermitido && $CI->session->userdata('permissao') != $nivelPermitido2) {
        redirect('/'.$pageDestino);
    }
}

/**
 * Gera mensagem de alerta
 * @param type $class_msg
 * @param type $msg
 * @param type $page_destino
 */
function gera_flash_msg($class_msg, $msg, $page_destino) {
    // Get current CI Instance
    $CI = & get_instance();
    if($class_msg==0) $class_msg="flash_error";
    else $class_msg="flash_sucesso";
    $CI->session->set_flashdata($class_msg,$msg);
    redirect($page_destino);
}