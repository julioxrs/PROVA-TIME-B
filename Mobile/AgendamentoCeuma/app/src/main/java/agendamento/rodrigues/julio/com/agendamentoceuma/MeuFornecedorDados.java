package agendamento.rodrigues.julio.com.agendamentoceuma;

/**
 * Created by Júlio on 28/05/2016.
 */
public class MeuFornecedorDados {
    private String agenda, hora, data;

    public  MeuFornecedorDados(String agenda, String hora, String data){
        this.agenda = agenda;
        this.hora = hora;
        this.data = data;



    }

    public String getAgenda() {
        return agenda;
    }

    public String getHora() {
        return hora;
    }

    public String getData() {
        return data;
    }
}
