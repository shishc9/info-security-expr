import util.RSAUtil;

import java.util.HashMap;

/**
 * @author: ShiShc
 * @desc:
 */
public class RSAMain {
    public static void main(String[] args) throws Exception {
        System.out.println("----- RSA START -----");
        HashMap<String, String> dic = RSAUtil.genKeyDic();

        System.out.println("publicKey: " + dic.get("publicKey"));
        System.out.println("privateKey: " + dic.get("privateKey"));

        String pwd = "ShiShc0.0-test";
        String pwdEn = RSAUtil.encrypt(pwd, dic.get("publicKey"));
        System.out.println("encrypt: " + pwd + " => " + pwdEn);
        String pwdDe = RSAUtil.decrypt(pwdEn, dic.get("privateKey"));
        System.out.println("decrypt: " + pwdDe);

        System.out.println("----- RSA END -----");
    }
}
