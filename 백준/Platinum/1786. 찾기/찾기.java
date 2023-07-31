
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        String s1 = br.readLine();

        String s2 = br.readLine();

        int[] pi = new int[s2.length()];
        int j = 0;
        for (int i = 1; i < s2.length(); i++) {
            while (j > 0 && s2.charAt(i) != s2.charAt(j)) {
                j = pi[j - 1];
            }
            if (s2.charAt(i) == s2.charAt(j)) {
                j++;
                pi[i] = j;
            }
        }
        j = 0;
        int cnt = 0;
        for (int i = 0; i < s1.length(); i++) {
            while (j > 0 && s1.charAt(i) != s2.charAt(j)) {
                j = pi[j - 1];
            }
            if (s1.charAt(i) == s2.charAt(j)) {
                if (j == s2.length() - 1) {
                    cnt++;
                    j = pi[j];
                    sb2.append((i + 2 - s2.length()) + " ");
                } else j++;
            }
        }
        System.out.println(cnt);
        System.out.println(sb2.toString());

    }

}
