package HMAC;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class hmac {

    public static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder(bytes.length*2);
        for(byte b: bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    public static String[] add(String move) throws NoSuchAlgorithmException, InvalidKeyException, UnsupportedEncodingException {
        SecureRandom secureRandom = new SecureRandom();
        byte []bytes = new byte[16];
        secureRandom.nextBytes(bytes);
        Mac signer = Mac.getInstance("HmacSHA3-256");
        SecretKeySpec keySpec = new SecretKeySpec(bytes, "HmacSHA3-256");
        signer.init(keySpec);
        String messageStr = move;
        byte[] digest = signer.doFinal(messageStr.getBytes("utf-8"));
        String[] secret ={bytesToHex(bytes), bytesToHex(digest)};
        return secret;
    }
}
