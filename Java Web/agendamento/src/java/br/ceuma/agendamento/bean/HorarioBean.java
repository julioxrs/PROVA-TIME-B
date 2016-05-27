
package br.ceuma.agendamento.bean;

import br.ceuma.agendamento.dao.HorarioDAO;
import br.ceuma.agendamento.modelo.Horario;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@SessionScoped
@ManagedBean
public class HorarioBean {
    
    //@ManagedProperty(value = "#{horarioDAO}")
    private HorarioDAO horarioDAO = new HorarioDAO();
        
    private List<Horario> horarios = new ArrayList<>();
    
    private Horario horarioSelecionado = new Horario();

     
    //@PostConstruct
    public void listar(){
        horarios = horarioDAO.buscarDisponiveisAtuais();
        //horarios = horarioDAO.buscarDisponiveis();
    }

    public List<Horario> getHorarios() {
        return horarios;
    }

    public void setHorarios(List<Horario> horarios) {
        this.horarios = horarios;
    }

    public HorarioDAO getHorarioDAO() {
        return horarioDAO;
    }

    public void setHorarioDAO(HorarioDAO horarioDAO) {
        this.horarioDAO = horarioDAO;
    }

    public Horario getHorarioSelecionado() {        
        return horarioSelecionado;
    }

    public void setHorarioSelecionado(Horario horarioSelecionado) {
        this.horarioSelecionado = horarioSelecionado;
    }
    
    
    
}
