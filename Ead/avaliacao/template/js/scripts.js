/* Implementando a acessibilidade*/
// Aumentar e diminuir o tamanho da fonte da página

$(document).ready(function() {

  var tamanhoNormal = $("body").css('font-size');
    //Aumentar o tamanho da fonte
    $(".fontMaior").click(function(){
      // Pega o tamanho da fonte do corpo da página
      var tamanho = tamanhoNormal;

      tamanho = tamanho.replace('px','');
      tamanho = parseInt(tamanho) + 1.4;

      $("body").animate({'font-size': tamanho + 'px'});
    });

    // Diminuindo o tamanho da fonte
    $(".fontMenor").click(function(){
      // Pega o tamanho da fonte do corpo da página
      var tamanho = $("body").css('font-size');

      tamanho = tamanho.replace('px','');
      tamanho = parseInt(tamanho) - 1.4;

      $("body").animate({'font-size': tamanho + 'px'});
    });

    // Resetando ao tamnho normal
    $(".tamNormal").click(function(){
      $("body").animate({'font-size':tamanhoNormal + 'px'});
    });
    
    /*
    $('#util').click(function(){
        $.ajax({
            type:'POST',
            url: '',
            data: dados,
            success: function(response){
                location.reload();
            }
        });
        return false;
    });
    */
});
