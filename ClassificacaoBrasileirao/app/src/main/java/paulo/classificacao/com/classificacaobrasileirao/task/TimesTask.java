package paulo.classificacao.com.classificacaobrasileirao.task;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import paulo.classificacao.com.classificacaobrasileirao.fw.Constant;
import paulo.classificacao.com.classificacaobrasileirao.fw.Util;
import paulo.classificacao.com.classificacaobrasileirao.to.TORedeTimes;

/**
 * Created by Paulo on 17/06/2015.
 */
public class TimesTask extends AsyncTask<String,Void,TORedeTimes> {
    @Override
    protected TORedeTimes doInBackground(String... params) {

        TORedeTimes t = null;

        try {

            URL url = new URL(Constant.API.URL);
            HttpURLConnection http = (HttpURLConnection) url.openConnection();
            http.setRequestMethod("GET");
            http.setRequestProperty("Content-Type", "text/plain; charset=utf-8");

            InputStream i = new BufferedInputStream(http.getInputStream());
            String result = Util.readString(i);
            t = TORedeTimes.createByJson(result, TORedeTimes.class);

        } catch (Exception e) {
            t = null;
        }

        return t;
    }
}
