
package br.ceuma.agendamento.bean;

import br.ceuma.agendamento.dao.UsuarioDAO;
import br.ceuma.agendamento.modelo.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@SessionScoped
@ManagedBean
public class UsuarioBean {
    
    private Usuario usuario = new Usuario();
    private List<Usuario> usuarios = new ArrayList<>();
    private UsuarioDAO usuarioDAO = new UsuarioDAO();
    
    public void adicionarBD(){
        usuarioDAO.inserir(usuario);
        //System.out.println("Dados Gravados!");        
    }
    
    public void listar(){
        usuarios = usuarioDAO.buscar();        
    }
    
    
    
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    
}
