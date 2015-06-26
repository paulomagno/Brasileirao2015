package paulo.classificacao.com.classificacaobrasileirao;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;


public class TelaSplashActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_splash);
        iniciaApp();
    }

    public void iniciaApp() {
        Handler h = new Handler();

        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(TelaSplashActivity.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        }, 2000);

    }



}
