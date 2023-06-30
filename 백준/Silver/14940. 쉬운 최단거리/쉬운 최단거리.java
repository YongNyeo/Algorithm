
import java.io.*;

import java.util.*;

class Main {

    static int[] dice = new int[7];
    static int n, m, k;
    static int[][] map;
    static int[] dx = {1, -1, 0, 0}; //남북서동
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int s_x=0,s_y=0;
        map = new int[n][m];
        boolean[][]visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            StringTokenizer sk = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(sk.nextToken());
                if (map[i][j] == 2) {
                    s_x=i;
                    s_y=j;
                }
            }
        }
        Deque<Node> deque = new ArrayDeque<>();
        deque.add(new Node(s_x, s_y, 0));
        visited[s_x][s_y] = true;
        while (!deque.isEmpty()) {
            Node a = deque.poll();
            map[a.x][a.y] = a.value;
            for (int i = 0; i < 4; i++) {
                int nx = a.x + dx[i];
                int ny = a.y + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m||visited[nx][ny]||map[nx][ny]==0) {
                    continue;
                }
                deque.add(new Node(nx,ny,a.value+1));
                visited[nx][ny] = true;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] != 0 && !visited[i][j]) {
                    bw.write("-1 ");
                }
                else bw.write(map[i][j]+" ");
            }
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
    public static class Node{
        int x;
        int y;
        int value;

        public Node(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }
    }
}
