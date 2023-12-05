
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    private static int n;
    private static int m;
    private static int k;
    private static List<Node>[] graph;
    private static int[] dist;

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        StringTokenizer s = new StringTokenizer(br.readLine());

        k = Integer.parseInt(s.nextToken());

        graph = new ArrayList[n + 1];
        dist = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {

            StringTokenizer sk = new StringTokenizer(br.readLine());

            int n0 = Integer.parseInt(sk.nextToken());
            int n1 = Integer.parseInt(sk.nextToken());
            int n2 = Integer.parseInt(sk.nextToken());

            graph[n0].add(new Node(n1, n2));
        }

        Arrays.fill(dist,987654321);
        dist[k] = 0;
        dijkstra();

        for (int i = 1; i <= n; i++) {
            if (dist[i] == 987654321) {
                System.out.println("INF");
            }else System.out.println(dist[i]);
        }
    }

    private static void dijkstra() {

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(k, 0));
        boolean[] visited = new boolean[n + 1];

        while (!pq.isEmpty()) {

            Node poll = pq.poll();
            if (visited[poll.num]) {
                continue;
            }
            dist[poll.num] = poll.dist;
            visited[poll.num] = true;

            for (Node node : graph[poll.num]) {
                if (!visited[node.num] && dist[node.num] > dist[poll.num] + node.dist) {
                    pq.add(new Node(node.num, dist[poll.num] + node.dist));
                }
            }

        }

    }



}


class Node implements Comparable<Node> {

    public int num;
    public int dist;

    public Node(int num, int dist) {
        this.num = num;
        this.dist = dist;
    }

    @Override
    public int compareTo(Node o) {
        return this.dist - o.dist;
    }
}

