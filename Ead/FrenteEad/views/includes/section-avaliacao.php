<div id="video-aval" class="espaco-pre-titulo"></div>
<div class="row">
    <div class="col-xs-12">
        <div class="panel panel-default">
            <div class="panel-heading">Vídeo da Avaliação do Atendimento</div>
            <div class="panel-body">
                <div class="embed-responsive embed-responsive-16by9 video_ead">
                    <!-- REPRODUTOR DE VIDEO -->
                    <video controls>
                        <?php
                        if (!$this->session->userdata('permissao')) {
                            $path_video = base_url() . DIR_VIDEO . "efetuarAvaliacao.mp4";
                        } else
                            $path_video = base_url() . DIR_VIDEO . "ListaAvaliacoes.mp4";
                        ?>
                        <source src="<?php echo $path_video; ?>" type="video/mp4">
                        Seu navegador não suporta o elemento <code>video</code>. Por favor,
                        tente acessar por outro navegador. Pode ser <i></i> Mozila Firefox ou Google Chrome.
                    </video>
                </div><!-- / video_ead -->
            </div><!-- / panel-body-->
        </div>  <!-- / panel--> 
    </div><!--/ col-xs-12 -->
</div><!--/ row -->