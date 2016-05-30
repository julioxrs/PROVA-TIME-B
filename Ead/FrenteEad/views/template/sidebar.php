<ul class="nav navbar-nav side-nav">
    <?php foreach ($eads as $ead) : ?>
        <li><a href="#click<?php echo $ead->id_ead; ?>"><i class="glyphicon glyphicon-tasks"></i> <?php echo $ead->titulo_ead; ?></a></li>
    <?php endforeach; ?>

    <li><a href="<?php echo base_url('home/avaliacao'); ?>"><i class="fa fa-edit"></i> Avaliação</a></li>
    <li><a href="#"><i class="glyphicon glyphicon-eye-close"></i> Acessibilidade</a></li>
    <ul class="list-group-item-heading">
        <!-- Funcionalidade de acessibilidade adicionada em 25/05/16 15:25  -->
        <li>
            <a href="#" class="fontMaior btn-sm btn-default">
                <img src="<?php echo base_url() . DIR_IMG; ?>btn_aumentar_fonte.gif" alt="Aumentar fonte" /></a></li>
        <li><a href="#" class="fontMenor btn-sm btn-default"><img src="<?php echo base_url() . DIR_IMG; ?>btn_diminuir_fonte.gif" alt="Diminuir fonte" /></a></li>

    </ul>
</ul>