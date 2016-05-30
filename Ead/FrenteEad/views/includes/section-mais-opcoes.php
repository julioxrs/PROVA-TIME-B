<!-- PAINEL DE MAIS OPÇÕES -->
<div class="panel-group">
    <div class="panel panel-primary">
        <div class="panel-heading" role="tab" id="headingOne">
            <h1 class="panel-title text-center">
                <span class="h3"><i class="glyphicon glyphicon-plus-sign"></i> Mais Opções</span>
            </h1>
        </div><!-- /headingOne -->

        <div id="collapseOne" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingOne">
            <div class="panel-body text-center">
                <?php
                // Caso o usuário logado seja aluno, inclui o pdf do aluno
                if ($this->session->userdata('permissao')) 
                    $pdf_name = "Guia_do_Usuário_Aluno.pdf";
                else $pdf_name = "Guia_do_Usuário_Funcionário.pdf";
                ?>
                <a href="<?php echo base_url() . DIR_PDF.$pdf_name; ?>"><i class="fa fa-download"></i> Baixar tutorial completo em PDF</a>
            
            </div><!-- /panel-body -->
            <?php
            // Esta div só será exibida se o usuário ainda não avaliou o guia
            if (!$avaliou):
                ?>
                <div class="panel-body text-center" id="avaliacao">
                    <h2>Esta página foi útil para você?</h2>
                    <a href="<?php echo base_url('home/eadUtil'); ?>" class="btn btn-success">Sim <i class="fa fa-thumbs-o-up"></i></a>
                    <a href="<?php echo base_url('home/eadInutil'); ?>" class="btn btn-danger"><i class="fa fa-thumbs-down"></i> Não</a> 
                </div><!-- /avaliacao -->
            <?php endif; ?>

        </div><!-- /collapseOne -->
    </div><!-- /panel panel-default -->
</div> <!-- /accordion -->