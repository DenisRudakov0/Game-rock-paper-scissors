package input;

public class validation {

    public static boolean add(String[] s) {
        boolean flag = true;
        for (int i = 0; i < s.length; i++) {for (int j = 0; j < s.length; j++) {
            if (s[i].equals(s[j]) == true & i != j) {flag = false;}
            }
        }
        if (s.length % 2 == 0 | s.length < 3) {flag = false;}
        return flag;
    }
}
