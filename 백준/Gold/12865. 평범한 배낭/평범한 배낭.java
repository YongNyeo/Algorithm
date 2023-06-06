
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Main {
    static int[] arr;
    static int n;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int k = Integer.parseInt(split[1]);
        int max = 0;
        int[][] arr = new int[n+1][2];
        // 무게 기준으로 정렬. 후 value 보고 Dp풀어내는 방식
        for (int i = 1; i <= n; i++) {
            String[] s = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(s[0]);
            arr[i][1] = Integer.parseInt(s[1]);
        }

        int[][]dp = new int[n+1][k+1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <=k; j++) {
                dp[i][j] = dp[i-1][j];
                if (j - arr[i][0]>=0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - arr[i][0]]+arr[i][1]);
                }
            }
        }


        System.out.println(dp[n][k]);

    }

}
