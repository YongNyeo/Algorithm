
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;


public class Main {
    static int n,m;
    static String[][]map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][]j_visited;
    static boolean[][]f_visited;
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bf.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        Deque<Node> q = new ArrayDeque<>();
        map = new String[n][m];
        f_visited = new boolean[n][m];
        j_visited = new boolean[n][m];
        int [][]tmp = new int[1][2];
        for (int i = 0; i < n; i++) {
            String[] split = bf.readLine().split("");
            for (int j = 0; j < m; j++) {
                map[i][j] = split[j];
                if (split[j].equals("F")) {
                    q.add(new Node("F", i, j, 0));
                    f_visited[i][j] = true;
                }
                else if (split[j].equals("J")){
                    tmp[0][0] = i;
                    tmp[0][1] = j;
                }
            }
        }
        q.add(new Node("J",tmp[0][0],tmp[0][1],0));
        j_visited[tmp[0][0]][tmp[0][1]] = true;
        bfs(q);
    }

    public  static void bfs(Deque<Node> q) {
        j_visited = new boolean[n][m];
        f_visited = new boolean[n][m];

        //------여기까지 맵 초기화와 큐에 지훈이랑 불 넣음.
        while (!q.isEmpty()) {
            
            Node a = q.poll();
            int x = a.x;
            int y = a.y;
//            System.out.println("a.JF+\" \"+x+\" \"+y = " + a.JF+" "+x+" "+y);
            //불이라면
            if (a.JF.equals("F")) {
                for (int k = 0; k < 4; k++) {
                    int nx = x + dx[k];
                    int ny = y + dy[k];
                    if (nx >= 0 && nx < n && ny >= 0 && ny < m&&!map[nx][ny].equals("#")&&!f_visited[nx][ny]) {
                        if (map[nx][ny].equals(".")||map[nx][ny].equals("J")) {
                            map[nx][ny] = "F";
                            q.add(new Node("F",nx,ny,a.time+1));
                            f_visited[nx][ny] = true;
                        }
                    }
                }
            }
            else if (a.JF.equals("J")) {
                //범위에 나가는것==탈출헀다면
                if (x == n-1 || x == 0 || y == m-1 || y == 0){
                    System.out.println(a.time+1);
                    return;
                }
                //아직 탈출 아니라면,
                for (int k = 0; k < 4; k++) {
                    int nx = x + dx[k];
                    int ny = y + dy[k];
                    //방문X, 불X, 벽X
                    if (!j_visited[nx][ny] && !map[nx][ny].equals("F") && !map[nx][ny].equals("#")) {
                        j_visited[nx][ny] = true;
                        q.add(new Node("J", nx, ny, a.time+1));
                    }
                }
            }
        }
        System.out.println("IMPOSSIBLE");
        return;

    }
    public static class Node{
        private String JF;
        private int x,y;
        private int time ;
        public Node(String JF, int x, int y,int time) {
            this.JF = JF;
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }
}

