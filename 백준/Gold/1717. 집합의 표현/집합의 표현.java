import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[]parents ;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        parents = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parents[i] = i;
        }
        for (int i = 0; i < m; i++) {
            StringTokenizer sk = new StringTokenizer(br.readLine());
            int ask = Integer.parseInt(sk.nextToken());
            int a = Integer.parseInt(sk.nextToken());
            int b = Integer.parseInt(sk.nextToken());
            if (ask == 0) {
                unionParent(a,b);
            } else if (ask == 1) {
                if (findParent(a, b)) {
                    System.out.println("YES");
                }else System.out.println("NO");
            }
        }
    }
    public static void unionParent(int a,int b) {
        int a1 = getParent(a);
        int b1 = getParent(b);
        if (a1 > b1) {
            parents[a1] = b1;
        }else parents[b1] = a1;
    }

    public static int getParent(int k) {
        if (parents[k] ==k) {
            return k;
        }return parents[k] = getParent(parents[k]);
    }

    public static boolean findParent(int a, int b) {
        a = getParent(parents[a]);
        b = getParent(parents[b]);
        if (a == b) {
            return true;
        }else return false;
    }

}
