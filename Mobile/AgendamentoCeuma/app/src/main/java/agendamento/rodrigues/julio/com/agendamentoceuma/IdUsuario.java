package agendamento.rodrigues.julio.com.agendamentoceuma;

import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by Júlio on 26/05/2016.
 */
public class IdUsuario {

    public void getUserId(String email) {
        InputStream isr = null;
        String result = null;
        try {
            HttpClient httpClient = new DefaultHttpClient();
            HttpPost httpPost = new HttpPost(
                    "http://192.168.0.10/ConsutasAgendamentoCeuma/obterUserId.php?email="
                            +java.net.URLEncoder.encode(email, "UTF-8"));
            HttpResponse response = httpClient.execute(httpPost);
            HttpEntity entity = response.getEntity();
            isr = entity.getContent();
            System.out.println("Pegou Beleza");
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

        try {
            if (result != null) {
                JSONArray jsonArray = new JSONArray(result);

                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    String userId = jsonObject.getString("id_usuario");
                    MySingleton mDados = MySingleton.getInstance();
                    System.out.println("O id do Usuário é: "+userId);
                    mDados.setUserId(userId);
                }
            }
        } catch (JSONException e) {
            Log.e("log", "Erro ao mostrar dados" + e.toString());
        }
    }

}
