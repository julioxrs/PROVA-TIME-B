
package br.ceuma.agendamento.modelo;

import java.util.Date;


public class Horario {
    
    private Integer id;
    private Date hora;
    private Date data;
    // var disponivel é tipo int, pois este campo no banco não assumi valor nulo
    // e tem como valor padrão o numero 0
    private int disponivel; 
    
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getDisponivel() {
        return disponivel;
    }

    public void setDisponivel(int disponivel) {
        this.disponivel = disponivel;
    }
       
    
}
