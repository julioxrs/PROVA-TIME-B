<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>CEUMA - Guia do Usuário</title>

    <link rel="stylesheet" type="text/css" href="<?php echo base_url().DIR_CSS;?>bootstrap/css/bootstrap.min.css" />
    <link rel="stylesheet" type="text/css" href="<?php echo base_url().DIR_CSS;?>style.css" />
    
    <script type="text/javascript" src="<?php echo base_url().DIR_CSS;?>bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="<?php echo base_url().DIR_JS;?>/login.js"></script>
</head>
<body>
    <div class="container">
        <div class="card card-container">
            <img id="profile-img" class="profile-img-card" src="<?php echo base_url().DIR_IMG;?>marca2.png" />
            <p id="profile-name" class="profile-name-card"></p>
            <form class="form-signin" action="<?php echo base_url('login/entrar');?>" method="post">
                <span id="reauth-email" class="reauth-email"></span>
                <input type="email" id="inputEmail" class="form-control" placeholder="Digite seu email" name="email" required autofocus>
                <input type="password" id="inputPassword" class="form-control" placeholder="Digite sua senha" name="password" required>
                
                <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit">Entrar no sistema</button>
            </form><!-- /form -->

            <?php 
            // Possibilidade de exibir mensagens do sistema (ERRO \ SUCESSO)
            include_once 'includes/mensagens-retorno.php';?>

        </div><!-- /card-container -->
    </div><!-- /container -->
  </div>
  </body>
  </html>
