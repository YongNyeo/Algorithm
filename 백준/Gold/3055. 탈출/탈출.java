import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        int k = bfs();
        if (k==-1){
            System.out.println("KAKTUS");
        }
        else System.out.println(k);
    }
    public static int bfs() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        boolean[][]w_visited = new boolean[n][m];
        boolean[][]s_visited = new boolean[n][m];
        String[][] map = new String[n][m];
        for (int i = 0; i < n; i++) {
            String[] split = bf.readLine().split("");
            int j = 0;
            for (String s:split){
                map[i][j] = s;
                j++;
            }
        }
        int[] dx = new int[]{-1,1,0,0};
        int[] dy = new int[]{0,0,-1,1};
        //bfs기반 문제
        //물 확장 한번, 고슴도치 확장 한번. 도착시간 구하기. 물한테 모두 막히면 KATCCAYS 출력
        //한턴에 물 확장, 고슴도치 이동 한번
        Queue<X> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j].equals("*")) {
                    q.offer(new X(i, j, "*",0));
                    w_visited[i][j] = true;
                }
            }
        }
        //고슴도치 넣어주기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j].equals("S")) {
                    q.offer(new X(i, j, "S",0));
                    s_visited[i][j] = true;
                    break;
                }
            }
        }
        while(!q.isEmpty()){
            X a = q.poll();

            //물이라면 물로 바꿔주기
            if (a.getwOrd().equals("*")){
                for (int k=0;k<4;k++){
                    int nx = a.getN()+dx[k];
                    int ny = a.getM()+dy[k];
                    if ((nx>=0&&nx<n)&&(ny >= 0 && ny < m)&&!map[nx][ny].equals("X")&&!w_visited[nx][ny]&&!map[nx][ny].equals("D")){
                        map[nx][ny] = "*";
                        w_visited[nx][ny] = true;
                        q.offer(new X(nx,ny,"*",a.getTime()+1));
                    }
                }
            }
            else if (a.getwOrd().equals("S")){
                for (int k=0;k<4;k++){
                    int nx = a.getN()+dx[k];
                    int ny = a.getM()+dy[k];
                    if ((nx>=0&&nx<n)&&(ny >= 0 && ny < m)&&!map[nx][ny].equals("X")&&!map[nx][ny].equals("*")&&!s_visited[nx][ny]){
                        if (map[nx][ny].equals("D")){
                            return a.getTime()+1;
                        }
                        map[nx][ny] = "S";
                        s_visited[nx][ny] = true;
                        q.offer(new X(nx,ny,"S",a.getTime()+1));
                    }
                }
            }
        }
        return -1;
    }
}

    class X{
        private  int n;
        private  int m;
        private String wOrd;
        private int time;
        public X(int n, int m, String wOrd,int time) {
            this.n = n;
            this.m = m;
            this.wOrd = wOrd;
            this.time = time;
        }

        public int getN() {
            return n;
        }

        public int getM() {
            return m;
        }

        public String getwOrd() {
            return wOrd;
        }

        public int getTime() {
            return time;
        }
    }
