import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static int cnt = 0;
    static int[] dx =  {-1,1,0,0};
    static int [] dy = {0,0,-1,1};
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bf.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(map);
        System.out.println(cnt);
    }

    public static void dfs(int[][] map) {
        int[][] mp = new int[n][m];
        Queue<Node>q = new LinkedList<>();
        boolean[][]visited = new boolean[n][m];
        int c = 0;
        int bi  =0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j]<=0) bi++;
                //bfs돌기
                if (map[i][j]>0&&!visited[i][j]) {
                    c+=1;
                    q.offer(new Node(i, j));
                    visited[i][j] = true;
                    while (!q.isEmpty()) {
                        Node a = q.poll();
                        int x = a.getX();
                        int y = a.getY();
                        for (int f = 0;f<4;f++){
                            int fx = x+dx[f];
                            int fy = y+dy[f];
                            if (fx >= 0 && fx < n && fy >= 0 && fy < m && !visited[fx][fy] && map[fx][fy] >= 1) {
                                q.offer(new Node(fx,fy));
                                visited[fx][fy] = true;
                            }
                        }
                    }
                }
                if (bi==n*m) {
                    System.out.println(0);
                    System.exit(0);}
                if (c>=2){
                    System.out.println(cnt);
                    System.exit(0);
                }
              
                //새로운 맵에 0옆의 -1 처리해서 복사해놓기
                mp[i][j] = map[i][j];
                if (map[i][j] >0) {
                    for (int k = 0; k < 4; k++) {
                        int nx = i+dx[k];
                        int ny = j+dy[k];
                        if (nx>=0&&nx<n&&ny>=0&&ny<m&&map[nx][ny]<=0) {
                            mp[i][j] -= 1;
                        }
                    }
                }
            }
        }
      
        cnt++;
        dfs(mp);
    }
}

class Node {
    private int x;
    private int y;


    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
