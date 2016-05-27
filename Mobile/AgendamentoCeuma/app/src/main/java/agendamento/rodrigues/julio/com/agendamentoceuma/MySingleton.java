package agendamento.rodrigues.julio.com.agendamentoceuma;

/**
 * Created by Júlio on 26/05/2016.
 */
public class MySingleton {
    private String userId;

    private static MySingleton instance;

    private MySingleton() {
        userId = "";
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

}
