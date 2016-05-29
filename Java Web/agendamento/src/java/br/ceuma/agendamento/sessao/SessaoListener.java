
package br.ceuma.agendamento.sessao;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

// monitora o ciclo de vida de uma sessão para controle no servidor
public class SessaoListener  implements HttpSessionListener{
    
    @Override
    public void sessionCreated(HttpSessionEvent event) {        
           System.out.println("Sessão criada " + event.getSession().getId());
      }
   
    @Override
      public void sessionDestroyed(HttpSessionEvent event) {     
           String ultimoAcesso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss")).format(new Date(event.getSession().getLastAccessedTime()));
           System.out.println("Sessão finalizada "+event.getSession().getId()+". Ultimo Acesso = "+ultimoAcesso);
      }
    
}
