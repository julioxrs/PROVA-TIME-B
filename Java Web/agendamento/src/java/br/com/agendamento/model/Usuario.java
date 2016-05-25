package br.com.agendamento.model;


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="usuario"
    ,catalog="agendamento"
)
public class Usuario  implements java.io.Serializable {


     private Integer idUsuario;
     private String nmUsuario;
     private String telUsuario;
     private String cpfUsuario;
     private String emailUsuario;
     private String senhaUsuario;
     private Set horarios = new HashSet(0);

    public Usuario() {
    }

	
    public Usuario(String nmUsuario, String telUsuario, String cpfUsuario, String emailUsuario, String senhaUsuario) {
        this.nmUsuario = nmUsuario;
        this.telUsuario = telUsuario;
        this.cpfUsuario = cpfUsuario;
        this.emailUsuario = emailUsuario;
        this.senhaUsuario = senhaUsuario;
    }
    public Usuario(String nmUsuario, String telUsuario, String cpfUsuario, String emailUsuario, String senhaUsuario, Set horarios) {
       this.nmUsuario = nmUsuario;
       this.telUsuario = telUsuario;
       this.cpfUsuario = cpfUsuario;
       this.emailUsuario = emailUsuario;
       this.senhaUsuario = senhaUsuario;
       this.horarios = horarios;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id_usuario", unique=true, nullable=false)
    public Integer getIdUsuario() {
        return this.idUsuario;
    }
    
    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    
    @Column(name="nm_usuario", nullable=false, length=100)
    public String getNmUsuario() {
        return this.nmUsuario;
    }
    
    public void setNmUsuario(String nmUsuario) {
        this.nmUsuario = nmUsuario;
    }

    
    @Column(name="tel_usuario", nullable=false, length=45)
    public String getTelUsuario() {
        return this.telUsuario;
    }
    
    public void setTelUsuario(String telUsuario) {
        this.telUsuario = telUsuario;
    }

    
    @Column(name="cpf_usuario", nullable=false, length=20)
    public String getCpfUsuario() {
        return this.cpfUsuario;
    }
    
    public void setCpfUsuario(String cpfUsuario) {
        this.cpfUsuario = cpfUsuario;
    }

    
    @Column(name="email_usuario", nullable=false, length=100)
    public String getEmailUsuario() {
        return this.emailUsuario;
    }
    
    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    
    @Column(name="senha_usuario", nullable=false, length=100)
    public String getSenhaUsuario() {
        return this.senhaUsuario;
    }
    
    public void setSenhaUsuario(String senhaUsuario) {
        this.senhaUsuario = senhaUsuario;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="usuario")
    public Set getHorarios() {
        return this.horarios;
    }
    
    public void setHorarios(Set horarios) {
        this.horarios = horarios;
    }




}


