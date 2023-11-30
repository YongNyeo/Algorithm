import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    private static int n;

    private static char [][]map;


    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        map = new char[n][2*n-1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2 * n - 1; j++) {
                map[i][j] = ' ';
            }
        }

        dfs(0,n-1,n);



        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2 * n - 1; j++) {
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);

    }

    public static void dfs(int x, int y, int k) {

        if (k == 3) {
            map[x][y] = '*';
            map[x + 1][y - 1] = map[x + 1][y + 1] = '*';
            map[x + 2][y - 2] = map[x + 2][y - 1] = map[x + 2][y] = map[x + 2][y + 1] = map[x + 2][y + 2] = '*';
            return;
        }
        dfs(x, y , k / 2);
        dfs(x+k/2,y-k/2,k/2);
        dfs(x+k/2,y+k/2,k/2);


    }
}

class Bus implements Comparable<Bus> {

    public int end;
    public int dist;

    public Bus(int end, int dist) {
        this.end = end;
        this.dist = dist;
    }

    @Override
    public int compareTo(Bus o) {
        return this.dist - o.dist;
    }
}

