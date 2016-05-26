
package br.ceuma.agendamento.bean;

import br.ceuma.agendamento.dao.AgendamentoDAO;
import br.ceuma.agendamento.modelo.Horario;
import br.ceuma.agendamento.modelo.Usuario;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@SessionScoped
@ManagedBean
public class AgendamentoBean {  //INSERIR GETTERS e SETTERS
    
    private AgendamentoDAO agenda = new AgendamentoDAO();
    
    private Usuario usuario = new Usuario();
    private Horario horario = new Horario();
         
    
    public void agendamento(){
        
        if (agenda.agendar(usuario, horario))
            System.out.println("Agendado com sucesso!");
        else
            System.out.println("Falha ao agendar!");
            
    }

    
    
    public AgendamentoDAO getAgenda() {
        return agenda;
    }

    public void setAgenda(AgendamentoDAO agenda) {
        this.agenda = agenda;
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
