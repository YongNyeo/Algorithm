
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    private static int n;
    private static int k;



    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        int[][] dp = new int[n + 1][k + 1];

        int[] v = new int[n + 1];
        int[] w = new int[n + 1];

        for (int i = 1; i <= n; i++) {

            StringTokenizer sk = new StringTokenizer(br.readLine());
            v[i] = Integer.parseInt(sk.nextToken());
            w[i] = Integer.parseInt(sk.nextToken());

        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                dp[i][j] = dp[i-1][j];

                if (j -v[i]>=0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-v[i]]+w[i]);
                }
            }
        }
        System.out.println(dp[n][k]);

    }
}

