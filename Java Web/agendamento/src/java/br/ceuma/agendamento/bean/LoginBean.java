
package br.ceuma.agendamento.bean;

import br.ceuma.agendamento.dao.LoginDAO;
import br.ceuma.agendamento.modelo.Usuario;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@SessionScoped
@ManagedBean
public class LoginBean { //INSERIR GETTERS e SETTERS
    
    private Usuario usuario = new Usuario();
    private LoginDAO loginDAO = new LoginDAO();
    
    
    public String autenticar(){
        //String redireciona = "/resources/erro/erroUsuario.xhtml";
        String redireciona = null;        
                
        if (loginDAO.logarDadosAluno(usuario)){
            System.out.println("Usuario logado!");
            redireciona = "agendar-horario.xhtml";
            
            
        } else{
            System.out.println("Usuario nao logou!");
            
        }
        
        return redireciona;        
    }

    
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    
}
