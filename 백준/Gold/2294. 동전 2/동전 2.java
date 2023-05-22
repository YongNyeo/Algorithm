
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] lst,dp;
    static int n,k;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bf.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        k = Integer.parseInt(s[1]);
        dp = new int[k+1];
        lst = new int[n+1];
        for (int i = 0; i <= k; i++) {
            dp[i] = 10001;
        }
        dp[0] = 0;
        for (int i = 1; i <=n ; i++) {
            lst[i] = Integer.parseInt(bf.readLine());
            for (int j = lst[i]; j <= k; j++) {
                dp[j]  = Math.min(dp[j],(dp[j-lst[i]])+1);
            }
        }
        if (dp[k] == 10001) {
            System.out.println(-1);
        }
        else System.out.println(dp[k]);
    }
}
