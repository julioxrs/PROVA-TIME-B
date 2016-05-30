<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>CEUMA - Guia do Aluno</title>

        <link rel="stylesheet" type="text/css" href="<?php echo base_url() . DIR_CSS; ?>bootstrap/css/bootstrap.min.css" />
        <link rel="stylesheet" type="text/css" href="<?php echo base_url() . DIR_CSS; ?>font-awesome/css/font-awesome.min.css" />
        <link rel="stylesheet" type="text/css" href="<?php echo base_url() . DIR_CSS; ?>local.css" />

        <script type="text/javascript" src="<?php echo base_url() . DIR_JS; ?>jquery-1.10.2.min.js"></script>
        <script type="text/javascript" src="<?php echo base_url() . DIR_CSS; ?>bootstrap/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="<?php echo base_url() . DIR_JS; ?>scripts.js"></script>
    </head>
    <body>

        <div id="wrapper">

            <nav class="navbar navbar-inverse navbar-fixed-top">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#">CEUMA - Guia do Usuário</a>
                    
                    <a href="#" class="navbar-brand"><?php echo $msg_boas_vindas;?></a>
                </div>
                <div class="collapse navbar-collapse navbar-ex1-collapse">
                    <?php 
                    // Inclui o menu lateral
                    include_once 'sidebar.php';
                    ?>
                    <ul class="nav navbar-nav navbar-right navbar-user">
                        <li class="dropdown user-dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i> <?php echo $this->session->userdata('usuario'); ?><b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li class="divider"></li>
                                <li><a href="<?php echo base_url('login/logout'); ?>"><i class="fa fa-power-off"></i> Log Out</a></li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </nav>
