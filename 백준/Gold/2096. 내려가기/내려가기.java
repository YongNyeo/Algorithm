
import java.io.*;

import java.util.*;

class Main {

    static int n, m, k;
    static String[][] map;
    static int[] dx = {1, -1, 0, 0}; //남북서동
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer s1 = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(s1.nextToken());

        int[][][]arr = new int[n][3][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer s = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j][0] = Integer.parseInt(s.nextToken());
                arr[i][j][1] = arr[i][j][0];
            }
        }
        for (int i = 1; i < n; i++) {
            // 1번
            arr[i][0][0] += Math.min(arr[i-1][0][0],arr[i-1][1][0]);
            arr[i][0][1] += Math.max(arr[i-1][0][1],arr[i-1][1][1]);

            // 2번
            int mn = Math.min(arr[i-1][0][0],arr[i-1][1][0]);
            mn = Math.min(mn,arr[i-1][2][0]);
            arr[i][1][0] += mn;

            int mx = Math.max(arr[i-1][0][1],arr[i-1][1][1]);
            mx = Math.max(mx, arr[i - 1][2][1]);
            arr[i][1][1] += mx;

            // 3번
            arr[i][2][0] += Math.min(arr[i-1][1][0],arr[i-1][2][0]);
            arr[i][2][1] += Math.max(arr[i-1][1][1],arr[i-1][2][1]);

        }
        int max = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            min = Math.min(arr[n - 1][i][0], min);
            max = Math.max(arr[n - 1][i][1], max);
        }
        System.out.println(max+" "+min);
    }
}
