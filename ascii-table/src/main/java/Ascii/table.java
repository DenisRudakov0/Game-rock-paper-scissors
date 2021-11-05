package Ascii;

import de.vandermeer.asciitable.AsciiTable;

public class table {

    public static AsciiTable table(String[] s1, AsciiTable at) {
        for(int i = 0; i < s1.length; ++i) {
            String[] row = new String[s1.length + 1];
            row[0] = s1[i];
            for(int j = 0; j < s1.length; ++j) {
                if (j > i & j - i < s1.length / 2 + 1) {row[j+ 1] = "Win";}
                else if (j < i & j < i - s1.length / 2) {row[j+ 1] = "Win";}
                else if (i == j) {row[j + 1] = "Draw";}
                else{row[j + 1] = "Lose";}
            }
            at.addRow(row);
            at.addRule();
        }
        return at;
    }

    public static String add(String s) {
        String regex = " ";
        String[] s1 = s.split(regex);
        String ss = "USER/PC " + s;
        String[] s2 = ss.split(regex);
        AsciiTable at = new AsciiTable();
        at.addRule();
        at.addRow(s2);
        at.addRule();
        at = table(s1, at);
        String rend = at.render();
        return rend;
    }
}
