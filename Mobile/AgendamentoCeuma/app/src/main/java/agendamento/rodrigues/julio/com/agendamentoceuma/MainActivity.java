package agendamento.rodrigues.julio.com.agendamentoceuma;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText campoCPD,campoSenha;
    Button botaoLogin;
    ImageView logo;

    public void Login(View view){

        String n="123";

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

        }

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        campoCPD = (EditText) findViewById(R.id.editText_CPD);
        campoSenha = (EditText) findViewById(R.id.editText_Senha);
        botaoLogin = (Button) findViewById(R.id.bt_Login);
        campoCPD.setTranslationX(-1000);
        campoSenha.setTranslationX(1000);
        botaoLogin.setTranslationX(-1000);
        logo  = (ImageView) findViewById(R.id.imageView);
        logo.animate().alpha(1f).setDuration(2000);



            campoCPD.animate().translationX(0f).setDuration(1000);
            campoSenha.animate().translationX(0f).setDuration(1000);
            botaoLogin.animate().translationX(0f).setDuration(1000);







    }

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

   // @Override*/
  /*  public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/

    public  void MostraAgenda(View view){
        Intent i =  new Intent(this,Agenda.class );
        startActivity(i);

    }

}
