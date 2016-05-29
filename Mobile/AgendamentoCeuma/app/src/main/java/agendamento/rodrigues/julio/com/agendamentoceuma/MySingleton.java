package agendamento.rodrigues.julio.com.agendamentoceuma;

/**
 * Created by Júlio on 26/05/2016.
 */
public class MySingleton {
    private String userId;
    private String nome;
    private String cpf;

    private static MySingleton instance;

    private MySingleton() {
        userId = "";
        nome = "";
        cpf = "";
    }

    public static MySingleton getInstance() {
        if (MySingleton.instance == null) {
            MySingleton.instance = new MySingleton();
        }
        return MySingleton.instance;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String i) {
        this.userId = i;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String i) {
        this.nome = i;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String i) {
        this.cpf = i;
    }

}
