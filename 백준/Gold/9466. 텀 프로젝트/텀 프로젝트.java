
import java.io.*;
import java.util.*;

class Main {

    static boolean[] cycle;
    static boolean[] visited; //방문처리
    static int n;
    static int all ;
    static  int[] lst; //각 노드의 값
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int test = 0; test < t; test++) {
            all=0;
            n = Integer.parseInt(br.readLine());
            visited = new boolean[n+1];
            cycle = new boolean[n+1];
            lst = new int[n + 1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                lst[i] = Integer.parseInt(st.nextToken());

            }
            for (int i = 1; i <= n; i++) {
                dfs(i);
            }
            System.out.println(n-all);

        }
    }

    static void dfs(int idx) {
        if (cycle[idx]) { // 사이클 정리 끝났으니 들어갈볼필요 아예 X
            return;
        }
        if (visited[idx]) { //사이클이라는 의미
            cycle[idx] = true;
            all++;
        }
        visited[idx] = true;
        dfs(lst[idx]);
        cycle[idx] = true; //해당 idx 탐색 다 끝나서 더이상 볼필요 없어서 cycle로 바꿔놓음
        visited[idx] = false;
    }
}
