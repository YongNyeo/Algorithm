import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.ConcurrentLinkedDeque;


public class Main {
    static String[][] map;
    static int[] dx = new int[]{-1, -1, -1, 0, 0, 1, 1, 1, 0};
    static int[] dy = new int[]{-1, 1, 0, 1, -1, -1, 1, 0, 0};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        map = new String[8][8];
        for (int i = 0; i < 8; i++) {
            String[] s = bf.readLine().split("");
            map[i] = s;
        }
        System.out.println(bfs());


    }


    public static int bfs() {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(7, 0));
        while (!q.isEmpty()) {
            visited = new boolean[8][8];
            int size = q.size();
            //내거 움직이는 과정(bfs)
            for (int num = 0; num < size; num++) {
                Node a = q.poll();
                if (map[a.x][a.y].equals("#")) continue;
                if (a.x == 0 && a.y == 7) return 1;

                for (int k = 0; k < 9; k++) {
                    int nx = a.x + dx[k];
                    int ny = a.y + dy[k];
                    if (nx >= 0 && nx < 8 && ny >= 0 && ny < 8 && !map[nx][ny].equals("#") && !visited[nx][ny]) {
                        q.add(new Node(nx, ny));
                        visited[nx][ny] = true;
                    }
                }
            }
            //벽 내리기x`
            for (int i = 7; i >= 0; i--) {
                for (int j = 0; j < 8; j++) {
                    //위에는 벽이고 아래는 없을때
                    if (map[i][j].equals("#")) {
                        map[i][j] = ".";

                        if (i != 7) {
                            map[i + 1][j] = "#";
                        }
                    }

                }
            }
        }
        return 0;
    }

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
