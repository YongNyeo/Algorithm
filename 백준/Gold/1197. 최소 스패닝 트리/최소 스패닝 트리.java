
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    /**
     * 5
     * -99 -2 -1 4 98
     */
    private static int n, m;

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());


        List<Node>[] graph = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer s = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(s.nextToken());
            int b = Integer.parseInt(s.nextToken());
            int c = Integer.parseInt(s.nextToken());
            graph[a].add(new Node(b, c));
            graph[b].add(new Node(a, c));
        }

        boolean[] visited = new boolean[n + 1];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(1, 0));

        int sum = 0;

        while (!pq.isEmpty()) {
            Node poll = pq.poll();
            if (visited[poll.num]) {
                continue;
            }

            visited[poll.num] = true;
            sum += poll.dist;

            for (Node node : graph[poll.num]) {
                if (!visited[node.num]) {
                    pq.add(node);
                }
            }


        }
        System.out.println(sum);
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

