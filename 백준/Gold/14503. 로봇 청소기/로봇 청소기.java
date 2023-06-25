
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;

class Main {
    static int n, m;
    static int[][] map;
    static int[] dx;
    static int[] dy;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer sk = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(sk.nextToken());
        m = Integer.parseInt(sk.nextToken());

        dx = new int[]{-1, 0, 1, 0};
        dy = new int[]{0, 1, 0, -1};
        map = new int[n][m];

        StringTokenizer st = new StringTokenizer(bf.readLine());
        int s_x = Integer.parseInt(st.nextToken());
        int s_y = Integer.parseInt(st.nextToken());
        int s_d = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            StringTokenizer s1 = new StringTokenizer(bf.readLine(), " ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(s1.nextToken());
            }
        }
        dfs(s_x, s_y, s_d);
        System.out.println(cnt);
    }

    public static void dfs(int x, int y, int dir) {
        if (map[x][y] == 0) {
            cnt++;
            map[x][y] = -1;
        }
        for (int i = 0; i < 4; i++) {
            dir = (dir + 3) % 4;
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if (nx >= 0 && ny >= 0 && nx < n && ny < m && map[nx][ny] == 0) {
                dfs(nx, ny, dir);
                return;
            }
        }
        int d = (dir + 2) % 4; //반대 방향으로 후진
        int bx = x + dx[d];
        int by = y + dy[d];
        if (bx >= 0 && by >= 0 && bx < n && by < m && map[bx][by] != 1) {
            dfs(bx, by, dir); //후진이니까 바라보는 방향은 유지
        }
    }
}
