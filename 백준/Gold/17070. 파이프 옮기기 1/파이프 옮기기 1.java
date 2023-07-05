
import java.io.*;

import java.util.*;

class Main {

    static int[][] map;
    static int[] dx = {1, -1, 0, 0}; //남북서동
    static int[] dy = {0, 0, -1, 1};

    static int n;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer s = new StringTokenizer(br.readLine());
        n = Integer.parseInt(s.nextToken());


        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        Deque<Node> deque = new ArrayDeque<>();
        deque.add(new Node(0, 0, 0, 1,0));
        int cnt=0;
        while (!deque.isEmpty()) {
            Node poll = deque.poll();
            if (poll.tail_x == n - 1 && poll.tail_y == n - 1) {
                cnt++;
                continue;
            }
            if (poll.dir == 0) { //가로라면
                if (poll.tail_y + 1 < n && map[poll.tail_x][poll.tail_y + 1] != 1) { //가로 이동할떄 벽이 아니고, 범위초과X일때
                    deque.add(new Node(poll.tail_x, poll.tail_y, poll.tail_x, poll.tail_y + 1, 0));
                }
                if (poll.tail_y + 1 < n && poll.tail_x + 1 < n && //대각선으로 이동할때 벽 아니고, 범위초과X
                        map[poll.tail_x][poll.tail_y + 1] != 1 && map[poll.tail_x + 1][poll.tail_y] != 1 && map[poll.tail_x + 1][poll.tail_y + 1] != 1) {
                    deque.add(new Node(poll.tail_x, poll.tail_y, poll.tail_x + 1, poll.tail_y + 1, 2));
                }
            } else if (poll.dir == 1) {//세로라면
                if (poll.tail_x + 1 < n && map[poll.tail_x + 1][poll.tail_y] != 1) {//세로 이동할떄 벽이 아니고, 범위초과X일때
                    deque.add(new Node(poll.tail_x, poll.tail_y, poll.tail_x + 1, poll.tail_y, 1));
                }
                if (poll.tail_y + 1 < n && poll.tail_x + 1 < n && //대각선으로 이동할때 벽 아니고, 범위초과X
                        map[poll.tail_x][poll.tail_y + 1] != 1 && map[poll.tail_x + 1][poll.tail_y] != 1 && map[poll.tail_x + 1][poll.tail_y + 1] != 1) {
                    deque.add(new Node(poll.tail_x, poll.tail_y, poll.tail_x + 1, poll.tail_y + 1, 2));
                }
            } else { //대각선이라면
                if (poll.tail_y + 1 < n && map[poll.tail_x][poll.tail_y + 1] != 1) { //가로 이동할떄 벽이 아니고, 범위초과X일때
                    deque.add(new Node(poll.tail_x, poll.tail_y, poll.tail_x, poll.tail_y + 1, 0));
                }
                if (poll.tail_x + 1 < n && map[poll.tail_x + 1][poll.tail_y] != 1) {//세로 이동할떄 벽이 아니고, 범위초과X일때
                    deque.add(new Node(poll.tail_x, poll.tail_y, poll.tail_x + 1, poll.tail_y, 1));
                }
                if (poll.tail_y + 1 < n && poll.tail_x + 1 < n && //대각선으로 이동할때 벽 아니고, 범위초과X
                        map[poll.tail_x][poll.tail_y + 1] != 1 && map[poll.tail_x + 1][poll.tail_y] != 1 && map[poll.tail_x + 1][poll.tail_y + 1] != 1) {
                    deque.add(new Node(poll.tail_x, poll.tail_y, poll.tail_x + 1, poll.tail_y + 1, 2));
                }
            }
        }
        System.out.println(cnt);
    }

    public static class Node {
        private int head_x;
        private int head_y;
        private int tail_x;
        private int tail_y;
        private int dir; // 0=가로(0또는2만가능), 1=세로(1또는 2만가능), 2=대각선(0,1,2모두가능) 아래,오른쪽 ,아래오른쪽
        //단 대각선으로 갈때 오른쪽,왼쪽에 벽있으면 안됨.


        public Node(int head_x, int head_y, int tail_x, int tail_y, int dir) {
            this.head_x = head_x;
            this.head_y = head_y;
            this.tail_x = tail_x;
            this.tail_y = tail_y;
            this.dir = dir;
        }
    }
}
