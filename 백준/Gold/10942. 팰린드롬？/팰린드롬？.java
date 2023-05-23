
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;


public class Main {
    static int n;
    static boolean[][] dp;
    static int[] lst;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(bf.readLine());
        lst = new int[n];

        String[] s = bf.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            lst[i] = Integer.parseInt(s[i]);
        }
        dp = new boolean[n][n];

        palindrom();
        int k = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < k; i++) {
            String[] a = bf.readLine().split(" ");
            int x = Integer.parseInt(a[0]);
            int y = Integer.parseInt(a[1]);
            if(dp[x-1][y-1]) {
                sb.append(1+"\n");
            }
            else {
                sb.append(0+"\n");
            }
        }
        System.out.println(sb);
    }


    static void palindrom() {
        //길이 1(==0)
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        //길이 2(==[1])
        for (int i = 0; i < n - 1; i++) {
            if (lst[i] == lst[i + 1]) {
                dp[i][i + 1] = true;
            }
        }

        //길이 3 이상
        for (int i = 2; i < n ; i++) { //길이 2~n-1까지
            for (int j = 0; j < n-i; j++) { // 찾을 인덱스.
                if (lst[j] == lst[j + i] && dp[j + 1][j + i - 1]) {
                    dp[j][j + i] = true;
                }
            }
        }
    }
}

