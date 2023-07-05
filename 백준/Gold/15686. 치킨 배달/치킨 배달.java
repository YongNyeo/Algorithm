
import java.io.*;

import java.util.*;

class Main {

    static int[][] map;
    static int[] dx = {1, -1, 0, 0}; //남북서동
    static int[] dy = {0, 0, -1, 1};
    static ArrayList<int[]> h_lst ;
    static ArrayList<int[]> c_lst ;

    static int n,m,max;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer s = new StringTokenizer(br.readLine());
        n = Integer.parseInt(s.nextToken());
        m = Integer.parseInt(s.nextToken());
        max = 999999;
        c_lst = new ArrayList<>();
        h_lst = new ArrayList<>();
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    int[] t = {i, j};
                    h_lst.add(t);
                } else if (map[i][j] == 2) {
                    int[] t = {i, j};
                    c_lst.add(t);
                }
            }
        }
        int []distance = new int[h_lst.size()];
        Arrays.fill(distance,999999);
        dfs(0,0, distance);
        System.out.println(max);
    }
    public static void dfs(int depth,int idx,int[]distance) { //해당 치킨집을 했는지(depth)와 그로인한 cnt결과(현재까지의 최소치킨거리)
        if (depth == m) {
            //distance최솟값 구하기
            int sum=0;
            for (int i = 0; i < distance.length; i++) {
                sum += distance[i];
            }
            max = Math.min(max, sum);
            return;
        }
        if (idx == c_lst.size()) {
            return;
        }
        int[] new_dist = copy(distance);
        for (int i=0;i<distance.length;i++){
            int x = h_lst.get(i)[0];
            int y = h_lst.get(i)[1];
            int dist = Math.abs(c_lst.get(idx)[0] - x) + Math.abs(c_lst.get(idx)[1] - y);
            distance[i] = Math.min(distance[i], dist);
        }
        dfs(depth + 1,idx+1, distance);
        dfs(depth,idx+1 ,new_dist);

    }
    public static int[] copy(int []origin) {
        int[] copy = new int[origin.length];
        for (int i = 0; i < origin.length; i++) {
            copy[i] = origin[i];
        }
        return copy;
    }
}
