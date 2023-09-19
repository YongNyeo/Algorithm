
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    static int[][] arr;
    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};
    static List<Node> cheezeList;
    static int n, m, sum;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        cheezeList = new ArrayList<>();
        sum = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer sk = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(sk.nextToken());
                if (arr[i][j] == 1) {
                    cheezeList.add(new Node(i, j));
                    sum += 1;
                }
            }
        }

        /**
         *        문제 솔루션
         *
         *        1. 외부공기와 내부공기(치즈로 둘러싸인) 나누기
         *        2. 치즈 녹이기(외부공기 2개이상)
         *        3. 치즈 다 없어졌나 check
         *        1~3반복
         */

        int c = 0;
        while (sum > 0) {
            c++;
            checkOuterOrInner();
            meltCheeze();
        }
        System.out.println(c);

    }

    private static void meltCheeze() {
        for (int i = 0; i < cheezeList.size(); i++) {
            int cnt = 0;
            Node cheeze = cheezeList.get(i);
            for (int j = 0; j < 4; j++) {
                int nx = cheeze.x + dx[j];
                int ny = cheeze.y + dy[j];

                if (arr[nx][ny] == 2) {
                    cnt++;
                }
            }
            if (cnt >= 2) {arr[cheeze.x][cheeze.y] = 0;
                sum--;
                cheezeList.remove(i);
                i--;
            }
        }
    }

    private static void checkOuterOrInner() { //bfs로 외부공기는 2로
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(new Node(0, 0));
        boolean[][] visited = new boolean[n][m];
        visited[0][0] = true;
        arr[0][0] = 2;

        while (!queue.isEmpty()) {

            Node poll = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = poll.x + dx[i];
                int ny = poll.y + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny] && arr[nx][ny] != 1) {
                    arr[nx][ny] = 2;
                    visited[nx][ny] = true;
                    queue.add(new Node(nx, ny));
                }
            }
        }

    }


}

class Node {
    int x;
    int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

