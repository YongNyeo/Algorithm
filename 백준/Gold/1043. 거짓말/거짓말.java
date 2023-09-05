import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    static int n, m;

    static int[]parents;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer sk = new StringTokenizer(bf.readLine());

        //사람수,파티 수
        n = Integer.parseInt(sk.nextToken());
        m = Integer.parseInt(sk.nextToken());

        parents = new int[n+1];

        for (int i=1;i<=n;i++){
            parents[i] = i;
        }


        StringTokenizer st = new StringTokenizer(bf.readLine());


        //진실을 알고있는 사람
        int true_num = Integer.parseInt(st.nextToken());
        boolean[]true_list = new boolean[51];
        
        for (int i=0; i< true_num;i++){
            int k = Integer.parseInt(st.nextToken());
            true_list[k] = true;
        }


        //파티별 사람 리스트
        List<Integer>[]list = new ArrayList[m];
        for (int i = 0; i < m; i++) {
            list[i] = new ArrayList<>();
        }
        int start=0;
        int post=0;
        for (int i=0;i<m;i++){
            StringTokenizer s = new StringTokenizer(bf.readLine());

            int num = Integer.parseInt(s.nextToken());
            if (num>0){
                start = Integer.parseInt(s.nextToken());
                list[i].add(start);
            }
            for (int j = 1; j < num; j++) {
                post = Integer.parseInt(s.nextToken());
                list[i].add(post);
                union(start, post);
                start = post;
            }
        }

        for (int i = 1; i < true_list.length; i++) {
            if (true_list[i]) {
                true_list[find(i)] = true;
            }
        }
        int parent;
        int cnt=0;
        for (int i = 0; i < m; i++) {
            if (list[i].size() > 0) {
                parent = find(list[i].get(0));

                if (!true_list[parent]) cnt++;
            }
        }
        System.out.println(cnt);
    }
    private static int find(int x) {
        if(parents[x] == x)
            return parents[x] = x;
        else  return find(parents[x]);

    }

    private static boolean union(int a, int b) {
        a = find(a);
        b = find(b);

        if(a!= b) {
            if(a>b) {
                parents[a] = b;
            } else {
                parents[b] = a;
            }
            return true;
        }
        return false;
    }
}
