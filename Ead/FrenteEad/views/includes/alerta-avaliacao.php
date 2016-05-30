<?php

// Verifica se o usuário já realizou a avaliação
if (!$avaliou) {
    echo '<div class="alert alert-danger alert-dismissable text-center">';
    echo '     <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>';
    echo '     BEM VINDO AO GUIA DO USUÁRIO! <br>';
    echo '     Diga-nos se este guia foi útil para você. Por favor, <a href="#avaliacao">Clique Aqui</a> para realizar sua avaliação.';
    echo '     <strong>Sua opinião é muito importante para nós.</strong>';
    echo '     <p>Você precisará avaliar <b>um única vez</b>.</p>';
    echo ' </div><!-- / alert -->';
}