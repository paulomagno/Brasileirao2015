package paulo.classificacao.com.classificacaobrasileirao.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import paulo.classificacao.com.classificacaobrasileirao.R;
import paulo.classificacao.com.classificacaobrasileirao.task.DownloadEscudoTimeTask;
import paulo.classificacao.com.classificacaobrasileirao.to.TORedeTimes;
import paulo.classificacao.com.classificacaobrasileirao.to.TOTime;

/**
 * Created by Paulo on 17/06/2015.
 */
public class TimeAdapter extends BaseAdapter {

    private TORedeTimes rede;
    private Context context;

    public TimeAdapter(TORedeTimes rede, Context context) {
        this.rede = rede;
        this.context = context;
    }

    @Override
    public int getCount() {
        return rede.getLista().size();

    }

    @Override
    public Object getItem(int position) {
        return rede.getLista().get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        TOTime t = rede.getLista().get(position);

        LayoutInflater inflater = (LayoutInflater)
                context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

        View v = inflater.inflate(R.layout.item_times, null);

        TextView txtTimes = (TextView) v.findViewById(R.id.nome);
        txtTimes.setText(t.getNome());

        TextView txtPontos = (TextView) v.findViewById(R.id.pontos);
        txtPontos.setText(Integer.toString(t.getPontos()));

        TextView txtJogos = (TextView) v.findViewById(R.id.jogos);
        txtJogos.setText(Integer.toString(t.getJogos()));

        TextView txtVitorias = (TextView) v.findViewById(R.id.vitorias);
        txtVitorias.setText(Integer.toString(t.getVitorias()));

        TextView txtEmpates = (TextView) v.findViewById(R.id.empates);
        txtEmpates.setText(Integer.toString(t.getEmpates()));

        TextView txtDerrotas = (TextView) v.findViewById(R.id.derrotas);
        txtDerrotas.setText(Integer.toString(t.getDerrotas()));

        TextView txtGolsPro = (TextView) v.findViewById(R.id.golsPro);
        txtGolsPro.setText(Integer.toString(t.getGolsPro()));

        TextView txtGolsContra = (TextView) v.findViewById(R.id.golsContra);
        txtGolsContra.setText(Integer.toString(t.getGolsContra()));

        TextView txtSaldoGols  = (TextView) v.findViewById(R.id.saldoGols);
        txtSaldoGols.setText(Integer.toString(t.getSaldoGols()));




        final ImageView i = (ImageView) v.findViewById(R.id.imagem);

        DownloadEscudoTimeTask d = new DownloadEscudoTimeTask(){
            @Override
            protected  void onPostExecute(Bitmap bitmap)
            {
                i.setImageBitmap(bitmap);
            }
        };

        d.execute(t.getImagem());

        return v;
    }
}
