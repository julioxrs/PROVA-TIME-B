<?php
// Listagem de todo conteúdo vindo do banco
foreach ($eads as $ead) :
    ?>
    <div id="click<?php echo $ead->id_ead; ?>" class="espaco-pre-titulo"></div>
    <div class="row">
        <div class="col-xs-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <span class="h3"><i class="glyphicon glyphicon-align-justify"></i> <?php echo $ead->titulo_ead; ?></span>
                </div>
                <div class="panel-body">

                    <!-- TABS -->
                    <div class="tabs">
                        <!-- Nav tabs -->
                        <ul class="nav nav-tabs" role="tablist">
                            <li role="presentation" class="active">
                                <a href="#texto<?php echo $ead->id_ead; ?>" aria-controls="texto" role="tab" data-toggle="tab">
                                    <i class="glyphicon glyphicon-text-background"></i> Texto completo</a></li>
                            <li role="presentation">
                                <a href="#video<?php echo $ead->id_ead; ?>" aria-controls="video" role="tab" data-toggle="tab">
                                    <i class="fa fa-video-camera"></i> Vídeo</a></li>
                            <li role="presentation">
                                <a href="#audio<?php echo $ead->id_ead; ?>" aria-controls="audio" role="tab" data-toggle="tab">
                                    <i class="glyphicon glyphicon-volume-up"></i> Áudio</a></li>

                        </ul>

                        <!-- Tab panes -->
                        <div class="tab-content">

                            <div role="tabpanel" class="tab-pane active" id="texto<?php echo $ead->id_ead; ?>">
                                <div class="row">
                                    <div class="col-md-12 text-justify">
                                        <?php echo $ead->texto_ead; ?>
                                    </div><!-- / col-md-12-->
                                </div><!-- / row-->
                            </div><!-- / tab-pane TEXTO-->

                            <div role="tabpanel" class="tab-pane" id="video<?php echo $ead->id_ead; ?>">
                                <div class="row">
                                    <div class="col-xs-12 col-sm-6 col-md-8">
                                        <div class="embed-responsive embed-responsive-16by9 video_ead">
                                            <!-- REPRODUTOR DE VIDEO -->
                                            <video controls>
                                                <!--source src="foo.ogg" type="video/ogg"-->
                                                <source src="<?php echo base_url() . DIR_VIDEO . $ead->video_ead; ?>" type="video/mp4">
                                                Seu navegador não suporta o elemento <code>video</code>. Por favor,
                                                tente acessar por outro navegador. Pode ser <i></i> Mozila Firefox ou Google Chrome.
                                            </video>
                                        </div><!-- / video_ead -->
                                    </div><!-- / col-xs-12 -->
                                    <div class="col-xs-6 col-md-4">
                                    <div class="alert alert-info">
                                        <p class="text-justify">
                                            <i class="glyphicon glyphicon-info-sign"></i>  <?php echo $mensagem_video;?>       
                                        </p>
                                    </div><!-- / alert-info-->
                                    </div><!-- / col-xs-6-->
                                </div><!-- / row -->
                            </div><!-- / tab-pane VIDEO-->
                            
                            <div role="tabpanel" class="tab-pane" id="audio<?php echo $ead->id_ead; ?>">
                                <div class="row">
                                    <div class="col-xs-12 text-center">
                                        <div class="alert alert-info center-block">
                                            <i class="glyphicon glyphicon-info-sign"></i> <?php echo $mensagem_audio;?>                                       
                                        </div>
                                        <!-- ÁUDIO -->
                                        <audio controls>
                                            <source src="<?php echo base_url() . DIR_AUDIO . $ead->audio_ead; ?>" type="audio/mpeg" />
                                            <a href="<?php echo base_url() . DIR_AUDIO . $ead->audio_ead; ?>"/>$ead->audio_ead</a>
                                        </audio>
                                    </div><!-- / col-xs-12 -->
                                    
                                </div><!-- / row -->
                                
                            </div><!-- / tab-pane AUDIO-->
                            
                        </div><!-- / tab-content-->
                    </div><!-- /TABS -->

                </div><!--/ panel-body -->

            </div><!--/ painel -->

        </div><!--/ col-xs-12 -->
    </div><!--/ row -->
    <?php
endforeach;
// Fim de Listagem de todo conteúdo vindo do banco
