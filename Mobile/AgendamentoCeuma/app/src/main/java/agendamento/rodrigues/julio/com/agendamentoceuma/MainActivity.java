package agendamento.rodrigues.julio.com.agendamentoceuma;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText campoEmail,campoSenha;
    Button botaoLogin;
    ImageView logo;

    public void Login(View view){

       /* String n="123";

        String cpd= String.valueOf(campoCPD.getText()) ;
        String senha= String.valueOf(campoSenha.getText()) ;


        if (cpd.isEmpty() || senha.isEmpty()  ){

            System.out.println("cpd"+cpd);
            System.out.println("senha"+senha);
            System.out.println("n"+n);

            Toast.makeText(getApplication(), "Preencha todos os campos!", Toast.LENGTH_LONG).show();



        }else{
            if (cpd.equals(n) && senha.equals(n)){

                Toast.makeText(getApplication(), "Carreganddo...", Toast.LENGTH_LONG).show();
                MostraAgenda(view);
            }else {
                System.out.println("cpd" + cpd);
                System.out.println("senha" + senha);
                System.out.println("n" + n);

                Toast.makeText(getApplication(), "CPD ou Senha incorretos", Toast.LENGTH_LONG).show();
            }

        }*/



       HttpClient httpClient = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost("http://192.168.0.10/ConsutasAgendamentoCeuma/Login.php");
        String answer = "";

        try {
            ArrayList<NameValuePair> valores = new ArrayList<NameValuePair>();
            valores.add(new BasicNameValuePair("method", "save-form"));
            valores.add(new BasicNameValuePair("email", campoEmail.getText().toString()));
            valores.add(new BasicNameValuePair("senha", campoSenha.getText().toString()));

            httpPost.setEntity(new UrlEncodedFormEntity(valores));
            HttpResponse resposta = httpClient.execute(httpPost);
            answer = EntityUtils.toString(resposta.getEntity());
            System.out.println(answer);



                if (answer.compareTo("1") == 0) {


                    IdUsuario id_user = new IdUsuario();
                    id_user.getUserId(campoEmail.getText().toString());


                    startActivity(new Intent(MainActivity.this, Agenda.class));
                    finish();


                }
                if (answer.compareTo("0") == 0) {
                    //mensagenAlerta("Mensagem", "Usuário ou senha incorretos, por favor verifique usuário e senha e tente novamente.");
                    Toast.makeText(getApplication(), "Email ou senha incorretos", Toast.LENGTH_LONG).show();
                }
            }

        catch (UnsupportedEncodingException e) { e.printStackTrace(); }
        catch (ClientProtocolException e) {
            e.printStackTrace();
        }
        catch (IOException e) { e.printStackTrace(); }



    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                    .permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }



        campoEmail = (EditText) findViewById(R.id.editText_Email);
        campoSenha = (EditText) findViewById(R.id.editText_Senha);
        botaoLogin = (Button) findViewById(R.id.bt_Login);
        campoEmail.setTranslationX(-1000);
        campoSenha.setTranslationX(1000);
        botaoLogin.setTranslationX(-1000);
        logo  = (ImageView) findViewById(R.id.imageView);


        /*logo.setAlpha(0f);
        logo.animate().alpha(1f).setDuration(2000);*/

        logo.animate().translationX(0f).setDuration(2000);


            campoEmail.animate().translationX(0f).setDuration(1000);
            campoSenha.animate().translationX(0f).setDuration(1000);
            botaoLogin.animate().translationX(0f).setDuration(1000);







    }





    public void mensagenAlerta(String tituloAleta, String mensagemAlerta) {
        AlertDialog.Builder mensagem = new AlertDialog.Builder(MainActivity.this);
        mensagem.setTitle(tituloAleta);
        mensagem.setMessage(mensagemAlerta);
        mensagem.setNeutralButton("OK", null);
        mensagem.show();
    }

}
