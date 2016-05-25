package br.com.agendamento.model;


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="horario"
    ,catalog="agendamento"
)
public class Horario  implements java.io.Serializable {


     private Integer idHorario;
     private Usuario usuario;
     private Date horaHorario;
     private Date dataHorario;
     private int dispHorario;

    public Horario() {
    }

	
    public Horario(Date horaHorario, Date dataHorario, int dispHorario) {
        this.horaHorario = horaHorario;
        this.dataHorario = dataHorario;
        this.dispHorario = dispHorario;
    }
    public Horario(Usuario usuario, Date horaHorario, Date dataHorario, int dispHorario) {
       this.usuario = usuario;
       this.horaHorario = horaHorario;
       this.dataHorario = dataHorario;
       this.dispHorario = dispHorario;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id_horario", unique=true, nullable=false)
    public Integer getIdHorario() {
        return this.idHorario;
    }
    
    public void setIdHorario(Integer idHorario) {
        this.idHorario = idHorario;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_usuario_agendamento")
    public Usuario getUsuario() {
        return this.usuario;
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Temporal(TemporalType.TIME)
    @Column(name="hora_horario", nullable=false, length=8)
    public Date getHoraHorario() {
        return this.horaHorario;
    }
    
    public void setHoraHorario(Date horaHorario) {
        this.horaHorario = horaHorario;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="data_horario", nullable=false, length=10)
    public Date getDataHorario() {
        return this.dataHorario;
    }
    
    public void setDataHorario(Date dataHorario) {
        this.dataHorario = dataHorario;
    }

    
    @Column(name="disp_horario", nullable=false)
    public int getDispHorario() {
        return this.dispHorario;
    }
    
    public void setDispHorario(int dispHorario) {
        this.dispHorario = dispHorario;
    }




}


