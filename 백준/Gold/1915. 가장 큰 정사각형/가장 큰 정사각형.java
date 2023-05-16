import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static String nev;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int ans = 0;
        int n =Integer.parseInt(st.nextToken());
        int m =Integer.parseInt(st.nextToken());
        int [][]map  = new int[n+1][m+1];
        if (n == 1 && m == 1) {
            System.out.println(1);
            return;
        }
        for (int i = 1; i <=n; i++) {
            String[] split = bf.readLine().split("");
            for (int j = 1; j <=m; j++) {
                int k  =Integer.parseInt(split[j-1]);
                if (i == 1 && j == 1) {
                    map[i][j] = k;
                }
                else {
                    if (k == 1) {
                        map[i][j] = Math.min(map[i-1][j],Math.min(map[i][j-1],map[i-1][j-1]))+1;
                        ans = Math.max(ans, map[i][j]);
                    }
                }
            }
        }
        System.out.println(ans*ans);

    }
}
