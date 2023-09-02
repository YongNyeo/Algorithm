
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main
{

    static boolean[]visited;
    static List<Node>[]map;
    static int n,destination;
    static List<Node>[]reverse_map;
    public static void main(String[] args) throws IOException {

        /**
         *
         * 4개의 마을, 2번 마을까지 간뒤 자신의 집으로 돌아와야함. (n-1) 학생들이 모두 특정(2번)까지 도달후, 돌아오기.
         * 단방향이라 왔던길로는 못간다. 다익스트라를 역으로 생각해서 풀기.
         *
         *
         */
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());

        n = Integer.parseInt(st.nextToken());

        int m =  Integer.parseInt(st.nextToken());

         destination  =  Integer.parseInt(st.nextToken());


        map = new ArrayList[n+1];  // 각 마을에서 갈수있는 Node(갈수있는 마을,거리) 저장리스트
        reverse_map = new ArrayList[n+1];
        for (int i=0;i<=n;i++){
            map[i] = new ArrayList<>();
            reverse_map[i] = new ArrayList<>();
        }

        for (int i=0;i<m;i++){
            StringTokenizer sk = new StringTokenizer(bf.readLine());

            int start = Integer.parseInt(sk.nextToken());

            int end =  Integer.parseInt(sk.nextToken());

            int dist  =  Integer.parseInt(sk.nextToken());

            map[start].add(new Node(end, dist));
            reverse_map[end].add(new Node(start, dist));
        }
        int[] list1 = dikjstra(reverse_map);
        int[] list2 = dikjstra(map);
        int max = 0;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max,(list1[i]+list2[i]));
        }
        System.out.println(max);
    }

    static int[] dikjstra(List<Node>[]graph) {  //X에서 최단거리를 return 해주는 리스트
        int []list = new int[n+1];
        Arrays.fill(list, 987654321);

        visited = new boolean[n + 1];

        Queue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(destination, 0));

        list[destination] = 0;

        while (!pq.isEmpty()) {
            Node poll = pq.poll();
            if (!visited[poll.num]) {
                visited[poll.num] = true;

                for (Node node : graph[poll.num]) {
                    if (list[node.num] > list[poll.num] + node.dist) { //방문하지 않은것만 pq에 다시 넣기
                        pq.add(new Node(node.num, list[poll.num] + node.dist));
                        list[node.num] = list[poll.num] + node.dist;

                    }
                }
            }
        }
        return list;
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
        return this.dist-o.dist;
    }
}
