import Ascii.table;
import HMAC.hmac;
import input.validation;
import lose.win;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Scanner;

public class output {

    public static String[] HMAC_key(String[] s) throws UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeyException {
        String step_pc = "";
        SecureRandom secureRandom = new SecureRandom();
        int num = secureRandom.nextInt(s.length);
        step_pc = s[num];
        String s1 = String.join(" ", hmac.add(step_pc));
        s1 = s1 + " " + String.valueOf(num);
        String[] secret = s1.split(" ");
        return secret;
    }

    public static HashMap menu(String[] s) {
        HashMap user = new HashMap();
        for (int i = 0; i < s.length; ++i) {
            user.put(String.valueOf(i + 1), s[i]);
            System.out.println(i + 1 + " - " + s[i]);
        }
        user.put("0", "exit");
        String s1 = String.join(" ", s);
        user.put("?", table.add(s1));
        System.out.println("0 - exit" + "\n" + "? - help");
        return user;
    }

    public static void main(String[] args) throws UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeyException {
        boolean flag = false;
        String[] s1 = new String[0];
        while (flag == false) {
            Scanner in = new Scanner(System.in);
            String s = in.nextLine();
            s1 = s.split(" ");
            if (validation.add(s1) == false) {
                System.out.println("Error: Incorrect data entered");
            } else {
                flag = true;
            }
        }
        String[] secret = HMAC_key(s1);
        System.out.println(secret[1]);
        HashMap user = menu(s1);
        flag = false;
        String s_user = null;
        while (flag == false) {
            Scanner in = new Scanner(System.in);
            s_user = in.nextLine();
            if (user.containsKey(s_user)) {
                if (s_user.equals("?") == true) {
                    System.out.println(user.get("?"));
                    menu(s1);
                }
                else if (s_user.equals("0") == true) {System.exit(0);}
                else {flag = true;}
            } else {
                System.out.println("Error input");
            }
        }
        System.out.println(win.add(Integer.parseInt(s_user) - 1, Integer.parseInt(secret[2]), s1) + "\n" + "HMAC-key: " + secret[0]);
    }
}
