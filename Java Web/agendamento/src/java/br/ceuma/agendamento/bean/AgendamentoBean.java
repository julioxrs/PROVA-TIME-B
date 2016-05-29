
package br.ceuma.agendamento.bean;

import br.ceuma.agendamento.dao.AgendamentoDAO;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ViewScoped
@ManagedBean
public class AgendamentoBean {  
    
    private AgendamentoDAO agendaDAO = new AgendamentoDAO();
    
    private LoginBean loginBean = new LoginBean();
    private HorarioBean horarioBean = new HorarioBean();
         
    
    //realiza agendamento a partir de dados armazenados no Map da sessão
    public void agendar(){
        
        boolean agendado = agendaDAO.agendar(
                loginBean.getUsuarioLogado(),
                horarioBean.getHorarioSelecionado());
     
        if (agendado){
                System.out.println("Agendado com sucesso!");
        }else
            System.out.println("Falha ao agendar!");
    }
    
    public AgendamentoDAO getAgendaDAO() {
        return agendaDAO;
    }

    public void setAgendaDAO(AgendamentoDAO agenda) {
        this.agendaDAO = agenda;
    }

    
}
