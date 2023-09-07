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

    static int n,m,r;
    static final int INF = 200000000;
    
    static List<Node>[]graph;
    static int[]items;

    static Queue<Node>pq;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        graph = new ArrayList[n+1];
        items = new int[n+1];

        StringTokenizer sk = new StringTokenizer(bf.readLine());

        for (int i=1;i<=n;i++){
            graph[i] = new ArrayList<>();
            items[i] = Integer.parseInt(sk.nextToken());
        }

        for (int i = 0; i < r; i++) {
            StringTokenizer s1 = new StringTokenizer(bf.readLine());
            int start = Integer.parseInt(s1.nextToken());
            int end = Integer.parseInt(s1.nextToken());
            int k = Integer.parseInt(s1.nextToken());
            graph[start].add(new Node(end, k));
            graph[end].add(new Node(start, k));
        }
        int max = 0;
        for (int i = 1; i <= n; i++) {
            max = Math.max(dijkstra(i),max);
        }
        System.out.println(max);
    }
    static int dijkstra(int k){

        pq = new PriorityQueue<>();
        boolean[] visited = new boolean[n + 1];
        int[] dist = new int[n + 1];
        Arrays.fill(dist, 987654321);
        dist[k] = 0;

        pq.add(new Node(k, 0));
        int sum=0;


        while (!pq.isEmpty()) {
            Node poll = pq.poll();

            if (!visited[poll.num]) {
                visited[poll.num] = true;
                sum += items[poll.num];

                for (Node node : graph[poll.num]) {
                    if (!visited[node.num] && dist[node.num] > dist[poll.num] + node.dist) {
                        dist[node.num] = dist[poll.num] + node.dist;
                        if (dist[node.num] > m) { //수색 범위 벗어났다면 큐에 추가 X.방문할 필요 X
                            continue;
                        }
                        pq.add(new Node(node.num, dist[node.num]));
                    }
                }
            }
        }
        return sum;
    }
}
class Node implements Comparable<Node>{
    int num;
    int dist;

    public Node(int num, int dist) {
        this.num = num;
        this.dist = dist;
    }

    @Override
    public int compareTo(Node o) {
        return this.dist - o.dist;
    }
}
