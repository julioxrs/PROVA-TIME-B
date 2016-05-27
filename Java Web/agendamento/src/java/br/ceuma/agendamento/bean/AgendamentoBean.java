
package br.ceuma.agendamento.bean;

import br.ceuma.agendamento.dao.AgendamentoDAO;
import br.ceuma.agendamento.modelo.Horario;
import br.ceuma.agendamento.modelo.Usuario;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@SessionScoped
@ManagedBean
public class AgendamentoBean {  //INSERIR GETTERS e SETTERS
    
    private AgendamentoDAO agendaDAO = new AgendamentoDAO();
    
    private Usuario usuario = new Usuario();
    private Horario horario = new Horario();
         
    
    public void agendamento(){
        
        if (agendaDAO.agendar(usuario, horario))
            System.out.println("Agendado com sucesso!");
        else
            System.out.println("Falha ao agendar!");
            
    }

    
    
    public AgendamentoDAO getAgendaDAO() {
        return agendaDAO;
    }

    public void setAgendaDAO(AgendamentoDAO agenda) {
        this.agendaDAO = agenda;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }
    
    
}
