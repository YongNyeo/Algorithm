

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};
    static int n,m;
    static int[][] map, dp;
    static boolean[][] visited;


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n+1][m+1];
        dp = new int[n+1][m+1];
        for (int i = 1; i < n+1; i++) {
            StringTokenizer sk = new StringTokenizer(bf.readLine());
            for (int j = 1; j < m+1; j++) {
                map[i][j] = Integer.parseInt(sk.nextToken());
            }
        }

        visited = new boolean[n+1][m+1];

        System.out.println(dfs(1, 1));
    }

    public static int dfs(int x, int y) {
        if (x == n && y == m ) {
            return 1 ;
        }
        if (visited[x][y]) {
            return dp[x][y];
        }
        visited[x][y] = true;
        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            if (nx < 1 || nx > n || ny < 1 || ny > m) {
                continue;
            }
            if (map[x][y] > map[nx][ny]) {
                dp[x][y] += dfs(nx, ny);
            }
        }
        return dp[x][y];
    }
}
