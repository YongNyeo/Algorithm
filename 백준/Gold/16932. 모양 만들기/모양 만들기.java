
import java.io.*;
import java.util.*;

class Main {
    static boolean[][] visited;
    static int[][] map;
    static List<Integer> lst;
    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        map = new int[n][m];
        visited = new boolean[n][m];
        Deque<Node> Zero = new ArrayDeque<>();
        //map입력 받고 zero큐에 zero위치 저장해두기. 나중에 zero큐만 돌면서 Max result구할거임
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0) {
                    Zero.add(new Node(i, j));
                }
            }
        }
        int[][]arr = copy();
        lst = new ArrayList<>();
        lst.add(0); //lst는 각 그룹번호별 저장된 개수를 저장할것임. 그래서 0은 0이라는 임시값 추가
        //0을 기준으로 주변(상하좌우)에 1이 있으면, 그룹번호(++) 저장하기
        int idx = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    int size = bfs(i, j, idx,arr); //객체는 파라미터에 넘겨도 값이 변경된다.
                    idx++;
                    lst.add(size);
                }
            }
        }

        int mx = 0;
        while (!Zero.isEmpty()) {
            Node z = Zero.poll();
            int x = z.x;
            int y = z.y;
            int sum=mergeBfs(x, y, arr);
            mx = Math.max(mx,sum);
        }


        System.out.println(mx);




    }

    static int bfs(int x, int y, int idx,int[][] arr) {
        int size = 1;
        Deque<Node> q = new ArrayDeque<>();
        q.add(new Node(x, y));
        arr[x][y] = idx;
        visited[x][y] = true;
        while (!q.isEmpty()) {
            Node a = q.poll();
            int ax = a.x;
            int ay = a.y;
            for (int k = 0; k < 4; k++) {
                int nx = ax + dx[k];
                int ny = ay + dy[k];
                //범위
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny] && map[nx][ny] == 1) {
                    q.add(new Node(nx, ny));
                    arr[nx][ny] = idx;
                    visited[nx][ny] = true;
                    size++;
                }
            }
        }
        return size;
    }

    static int mergeBfs(int x, int y, int[][] arr) {
        Set<Integer> set = new HashSet<>();
        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            //범위
            if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                set.add(arr[nx][ny]);
            }
        }
        int s = 0;
        for (int t : set) {
            s+=lst.get(t);
        }
        return s+1;
    }
    static int[][] copy() {
        int [][]copyMap = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                copyMap[i][j] = map[i][j];
            }
        }
        return copyMap;
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
