
import java.io.*;

import java.util.*;

class Main {

    static int n, m, k;
    static String[][] map;
    static int[] dx = {1, -1, 0, 0}; //남북서동
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int s_x=0,s_y=0;
        map = new String[n][m];
        boolean[][]visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                map[i][j] = split[j];
                if (map[i][j].equals("I")) {
                    s_x=i;
                    s_y=j;
                }
            }
        }
        int cnt=0;
        Deque<Node> deque = new ArrayDeque<>();
        deque.add(new Node(s_x, s_y));
        visited[s_x][s_y] = true;
        while (!deque.isEmpty()) {
            Node a = deque.poll();
            for (int i = 0; i < 4; i++) {
                int nx = a.x + dx[i];
                int ny = a.y + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m||visited[nx][ny]||map[nx][ny].equals("X")){
                    continue;
                }
                if (map[nx][ny].equals("P")) {
                    cnt++;
                }
                deque.add(new Node(nx,ny));
                visited[nx][ny] = true;
            }
        }
        if (cnt == 0) {
            System.out.println("TT");
        }else System.out.println(cnt);
    }
    public static class Node{
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
