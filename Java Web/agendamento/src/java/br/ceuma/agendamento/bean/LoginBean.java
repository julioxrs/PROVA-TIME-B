
package br.ceuma.agendamento.bean;

import br.ceuma.agendamento.dao.LoginDAO;
import br.ceuma.agendamento.modelo.Usuario;
import br.ceuma.agendamento.sessao.SessionContext;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ViewScoped
@ManagedBean
public class LoginBean { 
    
    private Usuario usuario = new Usuario();
    private LoginDAO loginDAO = new LoginDAO();
    
    
    // realiza login no sistema e cria sessão para o usuario logado
    public String autenticar(){
        
        String redireciona = "";        
        
        System.out.println("Tentando logar com usuário "+usuario.getEmail());        
                
        if (loginDAO.logarDadosAluno(usuario)){
            
            setUsuarioLogado(loginDAO.getDadosUsuario(usuario));
            
            System.out.println("Login efetuado com sucesso!");// utilizado para visualizar no console do servidor e acompanhar testes
            
            redireciona = "agendamento.xhtml";
                        
        } else{
            
            System.out.println("Login ou Senha inválido. Tente novamente!"); // utilizado para visualizar no console do servidor e acompanhar testes
            
            FacesContext.getCurrentInstance().validationFailed();
            
        }
        
        return redireciona;        
    }
    
    public String sair(){
        System.out.println("Fazendo logout do usuario "+
                getUsuarioLogado().getEmail());
        
        //encerra sessão
        SessionContext.getInstancia().encerrarSessao();
        
        System.out.println("Logout realizado com sucesso!");
        
        return "/index.xhtml";
    }
    
    public Usuario getUsuarioLogado(){
           return (Usuario) SessionContext.getInstancia().getAtributo("usuarioLogado");
      }    
      
      public void setUsuarioLogado(Usuario usuario){
           SessionContext.getInstancia().setAtributo("usuarioLogado", usuario);
      }
    
    public Usuario getUsuario() {        
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        // faz com que os dados inserido no email sejam tratados como letras 
        //minusculas independete de como foi inserido pelo usuario
        usuario.setEmail(usuario.getEmail().toLowerCase().trim());
        this.usuario = usuario;
    }
    
    
}
