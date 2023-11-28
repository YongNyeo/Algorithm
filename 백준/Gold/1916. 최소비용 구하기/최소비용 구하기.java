import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {

        /**
         * 5
         * 8
         * 1 2 2
         * 1 3 3
         * 1 4 1
         * 1 5 10
         * 2 4 2
         * 3 4 1
         * 3 5 1
         * 4 5 3
         * 1 5
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        ArrayList<Bus>[] graph = new ArrayList[n+1];
        boolean []visited = new boolean[n+1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a].add(new Bus(b, c));

        }
        StringTokenizer sk = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(sk.nextToken());
        int end = Integer.parseInt(sk.nextToken());

        Queue<Bus> pq = new PriorityQueue<>();
        pq.add(new Bus(start,0));


        int []dist = new int[n+1];
        Arrays.fill(dist,999999999);
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Bus poll = pq.poll();
            if (visited[poll.end]) continue;
             if (poll.end == end) {
                break;
            }
            visited[poll.end] = true;

            for (Bus node : graph[poll.end]) {
                if (!visited[node.end] && dist[node.end] > dist[poll.end] + node.dist) {
                    dist[node.end] = dist[poll.end] + node.dist;
                    pq.add(new Bus(node.end, dist[node.end]));
                }
            }
        }
        System.out.println(dist[end]);

    }
}

class Bus implements Comparable<Bus>{

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

