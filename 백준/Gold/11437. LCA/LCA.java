
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Main {
    static List<Integer>[] graph;
    static int[]depth;
    static int[]parent;
    static boolean[]visited;
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        graph = new ArrayList[n+1];
        depth = new int[n + 1];
        visited = new boolean[n + 1];
        parent = new int[n+1];
        StringTokenizer st;
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }
        dfs(1, 0); //깊이 저장(depth), 부모 저장(parent)
        int m = Integer.parseInt(br.readLine());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            Lca(a, b);
        }
    }

    public static void dfs(int root, int dp) {
        depth[root] = dp;
        visited[root] = true;
        for (int k : graph[root]) {
            if (!visited[k]) { // 값이 0이어야 방문 안한 노드
                parent[k] = root;
                dfs(k, dp + 1);
            }
        }
    }
    public static void Lca(int a,int b) {
        //먼저 조상이 같아지게 하기
        while (depth[a] != depth[b]) {
            if (depth[a] > depth[b]) {
                a = parent[a];
            } else b = parent[b];
        }
        // 이제 동시에 끌어올려서 같을때 까지 올리기
        while (a != b) {
            a = parent[a];
            b = parent[b];
        }
        System.out.println(a);
    }
}
