<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>CEUMA - Guia do Aluno</title>

        <link rel="stylesheet" type="text/css" href="template/css/bootstrap/css/bootstrap.min.css" />
        <link rel="stylesheet" type="text/css" href="template/css/font-awesome/css/font-awesome.min.css" />
        <link rel="stylesheet" type="text/css" href="template/css/local.css" />

        <script type="text/javascript" src="template/js/jquery-1.10.2.min.js"></script>
        <script type="text/javascript" src="template/css/bootstrap/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="template/js/scripts.js"></script>
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
                </div>
                <div class="collapse navbar-collapse navbar-ex1-collapse">
                    <?php 
                    // Inclui o menu lateral
                    include 'template/sidebar.php';
                    ?>
                    <ul class="nav navbar-nav navbar-right navbar-user">
                        <li class="dropdown user-dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i> <?php echo $_SESSION['nome_usuario'];?> <b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li class="divider"></li>
                                <li><a href="../FrenteEad/index.php"><i class="fa fa-power-off"></i> Log Out</a></li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </nav>
