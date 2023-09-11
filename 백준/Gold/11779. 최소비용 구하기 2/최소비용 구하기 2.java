import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

class Main {

    /**
     *
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
     *
     */

    static int n,m;

    static List<Obj>[]graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        StringTokenizer sk = new StringTokenizer(br.readLine());
        m = Integer.parseInt(sk.nextToken());
        graph = new ArrayList[n+1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer s = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(s.nextToken());
            int end = Integer.parseInt(s.nextToken());
            int cost = Integer.parseInt(s.nextToken());
            graph[start].add(new Obj(end,cost));
        }

        StringTokenizer s2 = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(s2.nextToken());
        int end = Integer.parseInt(s2.nextToken());

        if (start == end) {
            for (Obj ob : graph[start]) {
                if (ob.num == start) {
                    System.out.println(ob.dist);
                    System.out.println(1);
                    System.out.println(ob.num);
                    return;
                }
            }
        }


        dijkstra(start, end);

    }


    static void dijkstra(int start, int end) {

        boolean[] visited = new boolean[n + 1];
        Queue<Node> queue = new PriorityQueue<>();

        int []dist = new int[n+1];

        Arrays.fill(dist,1_000_000_000);

        dist[start] = 0;
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(start);
        queue.add(new Node(start, 0, 1, list1));

        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            if (!visited[poll.num]) {
                visited[poll.num] = true;

                if (poll.num == end) {
                    System.out.println(dist[poll.num]);
                    System.out.println(poll.cnt);
                    StringBuilder sb = new StringBuilder();
                    for (Integer integer : poll.list) {
                        sb.append(integer + " ");
                    }
                    System.out.println(sb);
                    break;
                }

                for (Obj objs : graph[poll.num]) {
                    if (!visited[objs.num] && dist[objs.num] > dist[poll.num] + objs.dist) {
                        dist[objs.num] = dist[poll.num] + objs.dist;
                        ArrayList<Integer> ne = new ArrayList<>(poll.list);
                        ne.add(objs.num);

                        queue.add(new Node(objs.num, dist[objs.num], poll.cnt + 1, ne));
                    }
                }
            }
        }
    }
}

class Obj {
    int num;
    int dist;

    public Obj(int num, int dist) {
        this.num = num;
        this.dist = dist;
    }
}


class Node implements Comparable<Node> {
    int num;

    int dist;

    int cnt;

    ArrayList<Integer> list;

    public Node(int num, int dist, int cnt, ArrayList<Integer> list) {
        this.num = num;
        this.dist = dist;
        this.cnt = cnt;
        this.list = list;
    }

    @Override
    public int compareTo(Node o) {
        return this.dist - o.dist;
    }
}
