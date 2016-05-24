package agendamento.rodrigues.julio.com.agendamentoceuma;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

public class SplashScreen extends AppCompatActivity {

    ImageView logo;
    private static int SPLASH_TIME_OUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        logo = (ImageView) findViewById(R.id.imageView2);

        logo.setAlpha(0f);
        logo.animate().alpha(1f).setDuration(2000);


        new Handler().postDelayed(new Runnable() {

            //splash com um timer.

            @Override
            public void run() {

                Intent i = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(i);


                finish();
            }
        }, SPLASH_TIME_OUT);
    }
    }
