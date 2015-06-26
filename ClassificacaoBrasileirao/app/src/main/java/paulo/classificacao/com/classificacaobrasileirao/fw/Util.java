package paulo.classificacao.com.classificacaobrasileirao.fw;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Paulo on 17/06/2015.
 */
public class Util {

    public static String readString(InputStream i) throws IOException {
        byte[] bytes = readBytes(i);
        String texto = new String(bytes);
        return texto;
    }

    public static byte[] readBytes(InputStream i) throws IOException {
        ByteArrayOutputStream b = new ByteArrayOutputStream();
        try {

            byte[] buffer = new byte[1024];
            int len;
            while ((len = i.read(buffer)) > 0) {
                b.write(buffer, 0, len);
            }
            byte[] bytes = b.toByteArray();
            return bytes;

        } finally {
            b.close();
            i.close();
        }
    }

    public static String md5(String valor) {
        String sen = "";
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        BigInteger hash = new BigInteger(1, md.digest(valor.getBytes()));
        sen = hash.toString(16);
        return sen;
    }
}
