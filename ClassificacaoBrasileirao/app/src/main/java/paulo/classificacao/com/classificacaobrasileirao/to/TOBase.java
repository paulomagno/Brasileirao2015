package paulo.classificacao.com.classificacaobrasileirao.to;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Created by Paulo on 17/06/2015.
 */
public class TOBase implements Cloneable {

    private transient Object tag;

    public TOBase() {
    }

    public TOBase(Object tag) {
        this.tag = tag;
    }

    public Object getTag() {
        return tag;
    }

    public void setTag(Object tag) {
        this.tag = tag;
    }

    private static Gson getGson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
        return gson;
    }

    public static <T extends TOBase> T createByJson(String json, Class<T> c) {
        try {
            Gson gson = getGson();
            return gson.fromJson(json, c);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String toString() {
        Gson gson = getGson();
        return gson.toJson(this, getClass());
    }


}