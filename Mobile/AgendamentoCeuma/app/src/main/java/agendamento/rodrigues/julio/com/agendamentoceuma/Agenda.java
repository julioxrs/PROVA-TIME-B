package agendamento.rodrigues.julio.com.agendamentoceuma;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Agenda extends AppCompatActivity {

    ListView listView;
    String agendamento[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agenda);

        listView = (ListView) findViewById(R.id.listView);

        MySingleton mDados = MySingleton.getInstance();
        obter_agendamento(mDados.getUserId());
    }

    public void obter_agendamento(String id){
        InputStream isr = null;
        String result = null;
        try {
            HttpClient client = new DefaultHttpClient();
            String getURL = "http://192.168.1.28/ConsutasAgendamentoCeuma/obter_agendamento.php?id_usuario="
                    + java.net.URLEncoder.encode(id, "UTF-8");
            HttpGet get = new HttpGet(getURL);
            HttpResponse response = client.execute(get);
            HttpEntity entity = response.getEntity();
            isr = entity.getContent();
            Log.e("log","Funcionou");
            System.out.println("Funcionou!");
        } catch (Exception e) {
            System.out.println("Deu erro: " + e.toString());
        }

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    isr, "iso-8859-1"), 8);
            StringBuilder sb = new StringBuilder();
            String line = null;

            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }

            isr.close();
            result = sb.toString();
        } catch (Exception e) {
            Log.e("log", "Erro ao converter resultado" + e.toString());
        }

       // String id = null, usuario = null, senha = null;
        List<String> lista_agendamento = new ArrayList<String>();
        try {
            if (result != null) {
                JSONArray jsonArray = new JSONArray(result);

                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);

                    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

                    lista_agendamento.add("Cód: "+jsonObject.getString("id_agendamento")+"   Hora: "+jsonObject.getString("hora_horario")+"   Data: "+jsonObject.getString("data_horario"));
                }
            }

            agendamento = (String[]) lista_agendamento.toArray(new String[0]);

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, agendamento);
            listView.setAdapter(adapter);

        } catch (JSONException erro) {
            Log.e("log", "Erro ao mostrar dados" + erro.toString());

        }
    }
}
