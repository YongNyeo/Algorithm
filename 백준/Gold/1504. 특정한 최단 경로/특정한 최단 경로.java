import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    /**
     * 4 6
     * 1 2 3
     * 2 3 3
     * 3 4 1
     * 1 3 5
     * 2 4 5
     * 1 4 4
     * 2 3
     *
     * 다익스트라로 접근하는것이 나을듯
     */

    static int n,m;
    static final int INF = 200000000;
    
    static List<Node>[]graph;

    static Queue<Node>pq;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new ArrayList[n+1];
        for (int i=0;i<=n;i++){
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            StringTokenizer s1 = new StringTokenizer(bf.readLine());
            int start = Integer.parseInt(s1.nextToken());
            int end = Integer.parseInt(s1.nextToken());
            int k = Integer.parseInt(s1.nextToken());
            graph[start].add(new Node(end, k));
            graph[end].add(new Node(start, k));

        }
        StringTokenizer s2 = new StringTokenizer(bf.readLine());
        int a = Integer.parseInt(s2.nextToken());
        int b = Integer.parseInt(s2.nextToken());

        int result1 = 0;
        int result2 = 0;

        // 1.1에서 a먼저 가는경우

        result1+=dijkstra(1,a);
        result1+=dijkstra(a,b);
        result1+=dijkstra(b,n);

        // 2.1에서 b먼저 가는경우

        result2+=dijkstra(1,b);
        result2+=dijkstra(b,a);
        result2+=dijkstra(a,n);

        System.out.println((result1 >= INF && result2 >= INF) ? -1 : Math.min(result1, result2));

    }
    static int dijkstra(int a,int b){


        pq = new PriorityQueue<>();
        boolean[] visited = new boolean[n+1];
        int[]dist = new int[n+1];

        Arrays.fill(dist,INF);
        dist[a] = 0;
        pq.add(new Node(a, 0));

        while (!pq.isEmpty()) {
            Node poll = pq.poll();

            if (!visited[poll.end]) {
                visited[poll.end] = true;

                for (Node node : graph[poll.end]) {
                    if (!visited[node.end] && dist[node.end] > dist[poll.end] + node.dist) {
                        dist[node.end] = dist[poll.end] + node.dist;
                        pq.add(new Node(node.end, dist[node.end]));
                    }
                }
            }
        }
        return dist[b];
    }
}
class Node implements Comparable<Node>{
    int end;
    int dist;

    public Node(int end, int dist) {
        this.end = end;
        this.dist = dist;
    }

    @Override
    public int compareTo(Node o) {
        return this.dist - o.dist;
    }
}
