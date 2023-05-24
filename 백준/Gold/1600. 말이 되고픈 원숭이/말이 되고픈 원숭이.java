
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;


public class Main {
    static int n, m;
    static boolean horse;
    static int min = Integer.MAX_VALUE;
    static int[][] map;
    static int w;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[] hx = {-2, -2, 2, 2, -1, -1, 1, 1};
    static int[] hy = {-1, 1, -1, 1, -2, 2, -2, 2};
    static boolean[][][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        w = Integer.parseInt(bf.readLine());
        String[] s = bf.readLine().split(" ");
        m = Integer.parseInt(s[0]);
        n = Integer.parseInt(s[1]);
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] sk = bf.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(sk[j]);
            }
        }
        visited = new boolean[n][m][w+1];
        visited[0][0][w] = true;
        Deque<Node> q = new ArrayDeque<>();

        q.add(new Node(0, 0, w,0));



        bfs(q);
        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    }

    static void bfs(Deque <Node>q){

        while (!q.isEmpty()) {
            Node a = q.poll();
            if (a.x == n - 1 && a.y == m - 1) {
                min = Math.min(min, a.time);
            }
            if (a.horse >0) {
                for (int k = 0; k < 8; k++) {
                    int nx = a.x + hx[k];
                    int ny = a.y + hy[k];
                    if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny][a.horse-1] && map[nx][ny] != 1) {
                        visited[nx][ny][a.horse-1] = true;
                        q.add(new Node(nx,ny,a.horse-1,a.time+1));
                    }
                }
            }
            for (int k = 0; k < 4; k++) {
                int nx = a.x + dx[k];
                int ny = a.y + dy[k];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny][a.horse] && map[nx][ny] != 1) {
                    visited[nx][ny][a.horse]= true;
                    q.add(new Node(nx,ny,a.horse,a.time+1));
                }
            }
        }
    }

    static class Node{
        int x;
        int y;
        int horse;
        int time;

        public Node(int x, int y, int horse,int time) {
            this.x = x;
            this.y = y;
            this.horse = horse;
            this.time = time;

        }
    }

}

