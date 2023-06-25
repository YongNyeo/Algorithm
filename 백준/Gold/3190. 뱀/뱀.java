import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;

class Main {
    static int n;
    static int[][] map;
    static int[] dx;
    static int[] dy;
    static int cnt = 0;
    static Map<Integer, String>hsh;
    static boolean[][]visited;
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer sk = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(sk.nextToken());

        dx = new int[]{ 0, 1, 0,-1}; //동남서북
        dy = new int[]{1, 0, -1,0};
        map = new int[n][n];
        visited = new boolean[n][n];
        StringTokenizer st1 = new StringTokenizer(bf.readLine());
        int ap = Integer.parseInt(st1.nextToken());
        for (int i = 0; i < ap; i++) {
            //사과를 map에서 1로
            StringTokenizer st2 = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st2.nextToken())-1;
            int y = Integer.parseInt(st2.nextToken())-1;
            map[x][y] = 1;

        }
        hsh = new HashMap<>();

        StringTokenizer st3 = new StringTokenizer(bf.readLine());
        int p = Integer.parseInt(st3.nextToken());
        for (int i = 0; i < p; i++) {
            //뱀의 방향전환횟수
            StringTokenizer st4 = new StringTokenizer(bf.readLine());
            int time = Integer.parseInt(st4.nextToken());
            String dir = st4.nextToken();
            hsh.put(time, dir);
        }



        int t = 0;
        Deque<Snake> lst = new ArrayDeque<>();
        lst.add(new Snake(0,0,0));
        visited[0][0] = true;
        while (true) {
            Snake peek = lst.peekLast();
            int dir = peek.dir;
            int nx = peek.x + dx[dir];
            int ny = peek.y + dy[dir];
            if (nx < 0 || nx >= n || ny < 0 || ny >= n||visited[nx][ny]) { //자기몸 닿거나 범위 벗어나면,
                break;
            }
            t++;
            //방향 틀어야되는 시간이면 틀기
            if (hsh.containsKey(t)) {
                String s = hsh.get(t);
                if (s.equals("L")) dir=(dir+3)%4;//왼쪽 90도
                else dir = (dir+1)%4;
            }
            //사과가 있으면, 뱀 머리만 추가하기
            if (map[nx][ny] == 1) {
                lst.addLast(new Snake(nx,ny,dir));
                visited[nx][ny] = true;
                map[nx][ny] = 0;

            }
            //사과없으면 꼬리는 짤라야됨
            else if(map[nx][ny] == 0){
                lst.addLast(new Snake(nx,ny,dir)); //머리 붙이기
                Snake snake = lst.removeFirst(); //꼬리짜르기
                visited[nx][ny] = true;
                visited[snake.x][snake.y] = false;
            }
        }
        System.out.println(t+1);

    }
    public static class Snake{
        int x;
        int y;
        int dir;

        public Snake(int x, int y, int dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }
    }
}
