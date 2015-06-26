package paulo.classificacao.com.classificacaobrasileirao.task;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

import paulo.classificacao.com.classificacaobrasileirao.fw.Util;

/**
 * Created by Paulo on 20/06/2015.
 */
public class DownloadEscudoTimeTask extends AsyncTask<String,Void,Bitmap> {


    @Override
    protected Bitmap doInBackground(String... params) {
        Bitmap b = obterImagem(params[0]);
        if(b ==null) {
            try {
                InputStream in = new java.net.URL(params[0]).openStream();
                b = BitmapFactory.decodeStream(in);
                salvarBitMap(b,params[0]);
            } catch (Exception e) {
                b = null;
            }
        }

        return b;
    }

    private void salvarBitMap(Bitmap b,String url) throws Exception {
        String id = Util.md5(url);

        String filePath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/imagesBrasileirao/";

        File dir = new File(filePath);
        dir.mkdir();

        Log.i("Imagem", "Salvando Imagem :" + filePath + id + ".png");

        FileOutputStream out = new FileOutputStream(filePath + id + ".png");
        b.compress(Bitmap.CompressFormat.PNG,100,out);
        out.flush();
        out.close();
    }


    private Bitmap obterImagem(String url)
    {
        String id = Util.md5(url);
        String filePath = Environment.getExternalStorageDirectory().getAbsolutePath()+"/imagesBrasileirao/" + id + ".png";

        File f = new File(filePath);

        if(f.exists()){
            Log.i("imagem","Obtendo imagem" + filePath);
            Bitmap bitmap = BitmapFactory.decodeFile(filePath);
            return bitmap;
        }
        else {
            return null;
        }
    }
}
