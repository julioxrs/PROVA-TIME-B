package agendamento.rodrigues.julio.com.agendamentoceuma;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

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
    TextView info_usuario,lblCPF;
    Button button;
    String agendamento[];
    String id_agend[] , hora_agend[], data_agend[];//, nome_user[], cpf_user[];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agenda);

        listView = (ListView) findViewById(R.id.listView);
        info_usuario = (TextView) findViewById(R.id.info_usuario);
        lblCPF = (TextView) findViewById(R.id.lblCPF);
        button = (Button) findViewById(R.id.button);
        MySingleton mDados = MySingleton.getInstance();
        obter_agendamento(mDados.getUserId());

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String textoNome = agendamento[position];

                Toast.makeText(getApplicationContext(),textoNome,Toast.LENGTH_LONG).show();
            }
        });

        MeuAdaptadorCustom adaptador;

        int i = 0;

        adaptador = new MeuAdaptadorCustom(getApplicationContext(),R.layout.celula_lista);

        for (String nome:id_agend){
            MeuFornecedorDados fornecedor =  new MeuFornecedorDados(nome,hora_agend[i],data_agend[i]);
            adaptador.add(fornecedor);
            i++;

        }

        info_usuario.setText(mDados.getNome());
        lblCPF.setText(mDados.getCpf());
        listView.setAdapter(adaptador);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Agenda.this, MainActivity.class));
                finish();
            }
        });

    }

    public void obter_agendamento(String id){
        InputStream isr = null;
        String result = null;
        try {
            HttpClient client = new DefaultHttpClient();
            String getURL = "http://192.168.0.10/ConsutasAgendamentoCeuma/obter_agendamento.php?id_usuario="
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

        List<String> id_agendamento = new ArrayList<String>();
        List<String> hora = new ArrayList<String>();
        List<String> data = new ArrayList<String>();
        //List<String> nome = new ArrayList<String>();
        //List<String> cpf = new ArrayList<String>();
        String nome = null, cpf = null;

        try {
            if (result != null) {
                JSONArray jsonArray = new JSONArray(result);

                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);

                    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

                    id_agendamento.add(jsonObject.getString("id_agendamento"));
                    hora.add(jsonObject.getString("hora_horario"));
                    data.add(jsonObject.getString("data_horario"));
                    nome = jsonObject.getString("nm_usuario");
                    cpf = jsonObject.getString("cpf_usuario");

                    lista_agendamento.add("Cód: "+jsonObject.getString("id_agendamento")+"   Hora: "+jsonObject.getString("hora_horario")+"   Data: "+jsonObject.getString("data_horario"));
                }
            }

            agendamento = (String[]) lista_agendamento.toArray(new String[0]);

            id_agend = (String[]) id_agendamento.toArray(new String[0]);
            hora_agend = (String[]) hora.toArray(new String[0]);
            data_agend = (String[]) data.toArray(new String[0]);
            MySingleton mDados = MySingleton.getInstance();
            mDados.setNome("Nome: "+nome);
            mDados.setCpf("CPF: "+cpf);

            //nome_user = (String[]) nome.toArray(new String[0]);
           // cpf_user = (String[]) cpf.toArray(new String[0]);

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, agendamento);
            listView.setAdapter(adapter);


        } catch (JSONException erro) {
            Log.e("log", "Erro ao mostrar dados" + erro.toString());

        }
    }

   /* public void Logout(View v){
        startActivity(new Intent(Agenda.this, MainActivity.class));
        finish();
    }*/
}
