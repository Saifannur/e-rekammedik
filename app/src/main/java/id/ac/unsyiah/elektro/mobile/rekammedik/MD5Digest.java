package id.ac.unsyiah.elektro.mobile.rekammedik;

/**
 * Created by xhaa on 19/06/15.
 */
import java.security.MessageDigest;

public class MD5Digest {

    public static String doHash(String args) throws Exception {

        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(args.getBytes());
        byte[] digest = md.digest();
        StringBuffer sb = new StringBuffer();
        for (byte b : digest) {
            sb.append(String.format("%02x", b & 0xff));
        }
        return sb.toString();
    }

}
