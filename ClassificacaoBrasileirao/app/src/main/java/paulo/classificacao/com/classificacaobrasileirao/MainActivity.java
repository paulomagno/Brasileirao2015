package paulo.classificacao.com.classificacaobrasileirao;

import android.app.ProgressDialog;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import paulo.classificacao.com.classificacaobrasileirao.adapter.TimeAdapter;
import paulo.classificacao.com.classificacaobrasileirao.task.TimesTask;
import paulo.classificacao.com.classificacaobrasileirao.to.TORedeTimes;


public class MainActivity extends ActionBarActivity {

    private ProgressDialog pd;
    private ListView listaTimes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listaTimes = (ListView) findViewById(R.id.listEquipes);

        obterTimes();
    }

    public void obterTimes()
    {
        pd = new ProgressDialog(this);
        pd.setMessage("Carregando....");
        pd.show();

        TimesTask r = new TimesTask(){
            @Override
            protected void onPostExecute(TORedeTimes toRede) {
                pd.hide();

                if(toRede != null)
                {
                    TimeAdapter adapter = new TimeAdapter(toRede,MainActivity.this);
                    listaTimes.setAdapter(adapter);
                }
            }
        };

        r.execute("");
    }



}
