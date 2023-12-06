import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    static int n, m, w;

    static List<Node>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int test = Integer.parseInt(st.nextToken());
        for (int t = 0; t < test; t++) {

            StringTokenizer sk = new StringTokenizer(bf.readLine());

            n = Integer.parseInt(sk.nextToken());
            m = Integer.parseInt(sk.nextToken());
            w = Integer.parseInt(sk.nextToken());

            graph = new ArrayList[n + 1];

            for (int i = 0; i <= n; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int i = 0; i < m + w; i++) {
                StringTokenizer s1 = new StringTokenizer(bf.readLine());
                int start = Integer.parseInt(s1.nextToken());
                int end = Integer.parseInt(s1.nextToken());
                int time = Integer.parseInt(s1.nextToken());
                if (i < m) {
                    graph[start].add(new Node(end, time));
                    graph[end].add(new Node(start, time));
                } else
                    graph[start].add(new Node(end, -1 * time));
            }
            System.out.println(bf() ? "YES" : "NO");

        }
    }

    static boolean bf() { //음의 사이클이 없으면 false
        boolean update = false;
        int[] dist = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            update = false;
            for (int j = 1; j <= n; j++) {
                for (Node node : graph[j]) {
                    if (dist[node.num] > dist[j] + node.dist) {
                        dist[node.num] = dist[j] + node.dist;

                        update= true; //음의 사이클 존재. (모두 0으로 시작해서 j==n 조건 필요 x)
                    }
                }
            }
            if (!update) {
                return update;
            }
        }
        return update;
    }
}

class Node {


    int num;
    int dist;

    public Node(int num, int dist) {
        this.num = num;
        this.dist = dist;
    }
}
