import java.io.*;

import java.util.*;

class Main {

    static int n, m, k;
    static String[][] map;
    static int[] dx = {1, -1, 0, 0}; //남북서동
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer s1 = new StringTokenizer(br.readLine());
        StringTokenizer s2 = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(s1.nextToken());
        int m = Integer.parseInt(s2.nextToken());
        boolean[] visited = new boolean[n + 1];
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        ArrayList<Node>[] graph = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            StringTokenizer s3 = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(s3.nextToken());
            int e = Integer.parseInt(s3.nextToken());
            int w = Integer.parseInt(s3.nextToken());
            graph[s].add(new Node(e, w));
        }
        StringTokenizer s4 = new StringTokenizer(br.readLine());
        int s_x = Integer.parseInt(s4.nextToken());
        int e_x = Integer.parseInt(s4.nextToken());

        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.w, o2.w));

        pq.add(new Node(s_x, 0));
        dist[s_x] = 0;
        while (!pq.isEmpty()) {
            Node a = pq.poll();
             if (visited[a.n]) {
                continue;
            }
            visited[a.n] = true;
            for (Node node : graph[a.n]) {
                if (!visited[node.n] && dist[node.n] > dist[a.n] + node.w) {
                    dist[node.n] = dist[a.n] + node.w;
                    pq.add(new Node(node.n, dist[node.n]));
                }
            }
        }
        System.out.println(dist[e_x]);

    }

    public static class Node {
        int n;
        int w;

        public Node(int n, int w) {
            this.n = n;
            this.w = w;
        }

    }
}
