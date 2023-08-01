
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static List<Integer>[] graph;
    static int[] depth;
    static int[][] parent;
    static int sum, n;
    static boolean[] visited;
    static List<Integer> list;
    public static void main(String[] args) throws IOException {

        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        sum = 0;
        graph = new ArrayList[n + 1];
        depth = new int[n + 1];
        visited = new boolean[n + 1];
        parent = new int[n + 1][19];
        list = new ArrayList<>();

        StringTokenizer st;

        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }
        int m = Integer.parseInt(br.readLine());

        bfs(1, 0); //깊이 저장(depth), 부모 저장(parent)
        setParent();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            Lca(a, b);
        }

    }

    public static void bfs(int root, int dp) {
        Deque<Node> deque = new ArrayDeque<>();
        deque.add(new Node(root, dp));
        visited[root] = true;
        list.add(root);
        while (!deque.isEmpty()) {
            Node node = deque.poll();
            for (int k : graph[node.num]) {
                if (!visited[k]) { //방문 안한것만 넣기
                    list.add(k);
                    visited[k] = true;
                    depth[k] = node.depth + 1;
                    parent[k][0] = node.num;
                    deque.add(new Node(k, node.depth + 1));
                }
            }
        }

    }

    public static void setParent() {
        for (int i = 1; i <= 18; i++) {
            for (int j = 1; j <= n; j++) {
                parent[j][i] = parent[parent[j][i - 1]][i - 1];
            }
        }
    }

    public static void Lca(int a, int b) {
        // b를 a보다 확실히 더 아래로 만들기(깊게)
        if (depth[a] > depth[b]) {
            int tmp = a;
            a = b;
            b = tmp;
        }
        //먼저 조상이 같아지게 하기
        for (int i = 18; i>=0; i--) {
            int dist = depth[b] - depth[a];
            if (dist >= (1L << i)) { //2의 i제곱보다 거리가 크다면,
                b = parent[b][i]; //2의 i제곱 깊이만큼 위로 올려주기
            }
        }
        if (a == b) {
            System.out.println(a);
            return ;
        }

        // 이제 동시에 끌어올려서 같을때 까지 올리기
        for (int i = 18 ; i>=0; i--) {
            if (parent[a][i] != parent[b][i]) {
                a = parent[a][i];
                b = parent[b][i];
            }
        }
        System.out.println(parent[b][0]);
    }
}

class Node {
    int num;
    int depth;

    public Node(int num, int depth) {
        this.num = num;
        this.depth = depth;
    }
}
