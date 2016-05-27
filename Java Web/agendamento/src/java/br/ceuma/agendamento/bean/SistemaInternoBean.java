
package br.ceuma.agendamento.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@SessionScoped
@ManagedBean(name="sistemaInterno")
public class SistemaInternoBean {
    
    private LoginBean loginBean = new LoginBean();
    private AgendamentoBean agendamentoBean = new AgendamentoBean();
    private HorarioBean horarioBean = new HorarioBean();
    
    public String logar(){
        return loginBean.autenticar();                
    }
    
    public void listaHorarios(){
        horarioBean.listar();
    }
        
    public void realizarAgendamento(){
        agendamentoBean.setUsuario(loginBean.getUsuario());
        //System.out.println("Horario selecionado: "+horarioBean.getHorarioSelecionado().getId());
                
        agendamentoBean.setHorario(horarioBean.getHorarioSelecionado());
        
        agendamentoBean.agendamento();
        
        // atualiza a lista de horarios na tela
        listaHorarios(); 
    }
    
    public String sair(){
        loginBean = new LoginBean();
        agendamentoBean = new AgendamentoBean();
        horarioBean = new HorarioBean();
        
        return "index.html";
    }

    public LoginBean getLoginBean() {
        return loginBean;
    }

    public void setLoginBean(LoginBean loginBean) {
        this.loginBean = loginBean;
    }

    public AgendamentoBean getAgendamentoBean() {
        return agendamentoBean;
    }

    public void setAgendamentoBean(AgendamentoBean agendamentoBean) {
        this.agendamentoBean = agendamentoBean;
    }

    public HorarioBean getHorarioBean() {
        return horarioBean;
    }

    public void setHorarioBean(HorarioBean horarioBean) {
        this.horarioBean = horarioBean;
    }                
    
}
