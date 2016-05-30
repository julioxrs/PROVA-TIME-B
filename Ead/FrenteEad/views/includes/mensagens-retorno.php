<?php

if ($this->session->flashdata('flash_sucesso')) {
    echo '
        <div class="alert alert-success">
         <span class="text text-center">
             <i class="glyphicon glyphicon-ok-sign"></i> Sucesso:                                        
            ' . $this->session->flashdata('flash_sucesso') . '</span>
        
        </div>
     ';
}

if ($this->session->flashdata('flash_error')) {
    echo '
        <div class="alert alert-danger">
        <span class="text text-center">
        <i class="glyphicon glyphicon-exclamation-sign"></i>
        ' . $this->session->flashdata('flash_error') . '</span>
         
        </div>
     ';
}
