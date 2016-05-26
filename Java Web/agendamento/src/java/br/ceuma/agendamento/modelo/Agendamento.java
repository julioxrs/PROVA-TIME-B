
package br.ceuma.agendamento.modelo;


public class Agendamento {
    
    private Integer id;
    private Usuario usuario;
    private Horario horario;
    private Integer avalicao;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getAvalicao() {
        return avalicao;
    }

    public void setAvalicao(Integer avalicao) {
        this.avalicao = avalicao;
    }
    
    
}
