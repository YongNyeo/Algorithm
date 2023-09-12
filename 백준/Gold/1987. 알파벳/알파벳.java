
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    static char[][] map;
    static int R, C;
    static int max = 0;
    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        boolean[] visited = new boolean[100];
        int a = (int)map[0][0];
        visited[a] = true;
        dfs(0, 0, 1, visited);
        System.out.println(max);
    }

    public static void dfs(int x, int y, int cnt, boolean[] visited) {

        if (cnt > max) {
            max = cnt;
        }

        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            if (nx >= 0 && nx < R && ny >= 0 && ny < C&&!visited[(int)map[nx][ny]]) {
                boolean[] list1 = new boolean[visited.length];
                list1 = Arrays.copyOf(visited, visited.length);
                list1[(int)map[nx][ny]] = true;
                dfs(nx, ny, cnt + 1, list1);
            }
        }
    }


}

