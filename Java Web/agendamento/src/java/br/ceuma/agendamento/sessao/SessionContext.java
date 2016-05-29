package br.ceuma.agendamento.sessao;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;


// usa padrão Singleton (garantido a existencia de apenas um objeto)
public class SessionContext {
      
      private static SessionContext instancia;
      
      
      public static SessionContext getInstancia(){
           if (instancia == null){
               instancia = new SessionContext();
           }
           
           return instancia;
      }
      
      private SessionContext(){
           
      }
      
      private ExternalContext currentExternalContext(){
           if (FacesContext.getCurrentInstance() == null){
               throw new RuntimeException("O FacesContext não pode ser chamado fora de uma requisição HTTP");
           }else{
               return FacesContext.getCurrentInstance().getExternalContext();
           }
      }
                  
      public void encerrarSessao(){   
           currentExternalContext().invalidateSession();
      }
      
      public Object getAtributo(String nome){
           return currentExternalContext().getSessionMap().get(nome);
      }
      
      public void setAtributo(String nome, Object valor){
           currentExternalContext().getSessionMap().put(nome, valor);
      }
      
  }