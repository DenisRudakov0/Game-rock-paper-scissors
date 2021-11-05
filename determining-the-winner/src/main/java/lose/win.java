package lose;

public class win {

    public static String add(int us, int pc, String[] s){
        String result = " ";
        if (pc > us & pc - us < s.length / 2 + 1) {result = "Win!";}
        else if (pc < us & pc < us - s.length / 2) {result = "Win!";}
        else if (us == pc) {result = "Draw!";}
        else{result = "Lose!";}
        System.out.println("Enter your move: " + (us + 1) + "\n" + "Your move: " + s[us] + "\n" + "Computer move: " + s[pc]);
        return "You " + result;

    }
}
