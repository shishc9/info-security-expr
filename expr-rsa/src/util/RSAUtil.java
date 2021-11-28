package util;

import javax.crypto.Cipher;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.HashMap;

/**
 * @author: ShiShc
 * @desc:
 */
public class RSAUtil {
    /**
     * generate key pair
     * @return {"publicKey": "*", "privateKey": "*"}
     * @throws Exception
     */
    public static HashMap<String, String> genKeyDic() throws Exception {
        KeyPair keyPair = genKeyPair();
        HashMap<String, String> keyDic = new HashMap<>();
        keyDic.put("publicKey", getPublicKey(keyPair));
        keyDic.put("privateKey", getPrivateKey(keyPair));
        return keyDic;
    }

    /**
     * encrypt pwd use publicKey
     * @param pwd origin password
     * @param publicKey publicKey
     * @return password after encrypt
     * @throws Exception
     */
    public static String encrypt(String pwd, String publicKey) throws Exception {
        // publicKey decoder2 byte[]
        byte[] bytesPublicKey = Base64.getDecoder().decode(publicKey);
        // Generates a public key object from the provided X509EncodedKeySpec
        RSAPublicKey pubKey = (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(bytesPublicKey));
        Cipher cipher = Cipher.getInstance("RSA");
        // use pubKey to encrypt
        cipher.init(Cipher.ENCRYPT_MODE, pubKey);
        String outstr = Base64.getEncoder().encodeToString(cipher.doFinal(pwd.getBytes(StandardCharsets.UTF_8)));
        // encrypt finish.
        return outstr;
    }

    public static String decrypt(String pwd, String privateKey) throws Exception {
        byte[] bytesPrivateKey = Base64.getDecoder().decode(pwd.getBytes(StandardCharsets.UTF_8));
        byte[] decoded = Base64.getDecoder().decode(privateKey);
        PrivateKey priKey = KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(decoded));
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, priKey);
        String outstr = new String(cipher.doFinal(bytesPrivateKey));
        return outstr;
    }

    private static KeyPair genKeyPair() throws Exception {
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
        keyPairGen.initialize(1024, new SecureRandom());
        KeyPair keyPair = keyPairGen.generateKeyPair();
        return keyPair;
    }

    private static String getPublicKey(KeyPair keyPair) {
        return Base64.getEncoder().encodeToString(keyPair.getPublic().getEncoded());
    }

    private static String getPrivateKey(KeyPair keyPair) {
        return Base64.getEncoder().encodeToString(keyPair.getPrivate().getEncoded());
    }
}
