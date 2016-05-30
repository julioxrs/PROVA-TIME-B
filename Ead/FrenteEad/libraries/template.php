<?php if(!defined('BASEPATH')) exit('No direct access allowed');

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Description of Template
 *
 * @author Werliton Carlos
 */
class Template {
    function show($view, $data = array())
    {
        // Get current CI Instance
        $CI = & get_instance();
 
        // Load template views
        $CI->load->view('template/header', $data);
        $CI->load->view($view, $data);
        $CI->load->view('template/footer', $data);
        
    }
 
    function menu($view)
    {
        // Get current CI Instance
        $CI = & get_instance();
 
        // Load menu template
        $CI->load->view('template/menu', array('view' => $view));
    }
 
}
