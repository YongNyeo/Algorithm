import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException {
        String[] numList = new String[]{"2", "3", "5", "7"};
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int depth = Integer.parseInt(input);
        for (String num : numList) {
            backT(num, depth);
        }
    }

    public static void backT(String k, int depth) {
        if (k.length() == depth) {
            if (sosu(k)) {
                System.out.println(k);
            }
        }
        for (int i = 1; i <= 9; i++) {

            if (sosu(k)) {
                backT(k+Integer.toString(i), depth);}
            else {
                return;
            }
        }
    }

    public static boolean sosu(String s) {
        int k = Integer.parseInt(s);
        for (int i = 2; i <= Math.sqrt(k) ; i++) {
            if (k % i == 0) {
                return false;
            }
        }
        return true;
    }
}
