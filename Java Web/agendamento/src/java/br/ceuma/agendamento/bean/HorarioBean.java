
package br.ceuma.agendamento.bean;

import br.ceuma.agendamento.dao.HorarioDAO;
import br.ceuma.agendamento.modelo.Horario;
import br.ceuma.agendamento.sessao.SessionContext;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.SelectEvent;

@ViewScoped
@ManagedBean
public class HorarioBean implements Serializable {
    
    private HorarioDAO horarioDAO = new HorarioDAO();
        
    private List<Horario> horarios = new ArrayList<>();
    
    private Horario horarioSelecionado = new Horario();
    
    private HorarioDataModel horarioDados;

    
    public HorarioBean(){
        listar();        
    }
     
    public void listar(){
        horarios = horarioDAO.buscarDisponiveisAtuais();
        horarioDados = new HorarioDataModel(horarios);
        
    }

      
    public List<Horario> getHorarios() {
        listar();// para realizar atualização da tabela de horarios sempre que houver alteração
        return horarios;
    }

    public HorarioDataModel getHorarioDados() {
        listar();// para realizar atualização da tabela de horarios sempre que houver alteração
        
        return horarioDados;
    }

    public void setHorarioDados(HorarioDataModel horarioDados) {
        this.horarioDados = horarioDados;
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
        horarioSelecionado = (Horario) SessionContext.getInstancia().getAtributo("horarioSelecionado");
        return horarioSelecionado;
    }

    // salva o horario selecionado no Map da sessão
    public void setHorarioSelecionado(Horario horarioSelecionado) {
        SessionContext.getInstancia().setAtributo("horarioSelecionado", horarioSelecionado);
        this.horarioSelecionado = horarioSelecionado;
    }
    
    public void onRowSelect(SelectEvent event) {
        String hora = new SimpleDateFormat("kk:mm").format(((Horario) event.getObject()).getHora());
        String data = new SimpleDateFormat("dd/MM/yyyy").format(((Horario) event.getObject()).getData());
        
        
        String msgHorario = hora+" - "+data;
        
        FacesMessage msg = new FacesMessage("Horário selecionado: ", 
                msgHorario);
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
 
        
}
