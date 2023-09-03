import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    /**
     * 트리간의 지름 구하기
     * 5
     * 1 3 2 -1
     * 2 4 4 -1
     * 3 1 2 4 3 -1
     * 4 2 4 3 3 5 6 -1
     * 5 4 6 -1
     * <p>
     * <p>
     * 지름을 구하라 --> 끝에서 끝을 구하라 (어느 한 정점에서 가장 먼 한 정점까지의 거리)
     * <p>
     * 1. 1번에서 bfs로 출발해서 가장 먼곳으로 도착.
     * 2. 이후 도착점(1번에서 실행한)에서 또 bfs로 가장 먼곳 도착
     * <p>
     * 1번에서 2번으로 갈때 거리를 구하면 될듯?
     * <p>
     * n=10
     */


    static int n, result1,max;
    static List<Node>[] graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
       
            StringTokenizer sk = new StringTokenizer(bf.readLine());
            int parseInt = Integer.parseInt(sk.nextToken());
            graph[parseInt] = new ArrayList<>();
            while (true) {
                int num1 = Integer.parseInt(sk.nextToken());
                if (num1 == -1) {
                    break;
                }
                int num2 = Integer.parseInt(sk.nextToken());
                graph[parseInt].add(new Node(num1, num2));
            }
        }
        visited = new boolean[n+1];
        dfs(1, 0);
        visited = new boolean[n+1];
        dfs(result1, 0);
        System.out.println(max);

    }

    static void dfs(int k,int depth) {

        if (depth>max){
            max = depth;
            result1 = k;
        }
        visited[k] = true;

        for (int i=0;i<graph[k].size();i++){
            Node n = graph[k].get(i);
            if(visited[n.num] == false) {
                dfs(n.num, n.dist + depth);
                visited[n.num] = true;
            }
        }
    }
}

class Node  {
    int num;
    int dist;

    public Node(int num, int dist) {
        this.num = num;
        this.dist = dist;
    }

}
