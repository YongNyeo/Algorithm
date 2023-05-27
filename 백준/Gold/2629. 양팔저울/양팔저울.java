

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;


public class Main {
    static  int k;
    static int[]choo;
    static boolean[][]dp;
    //k번의 회전을 해야하는데, 회전을 어떤 순서대로 시키느냐에 따라 배열의 최대값이 바뀔수 있음
    //dfs로 회전을 하는게 맞을듯. 회전연산때문에 백트래킹은 어렵다.
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        int nC = Integer.parseInt(st.nextToken());
        choo = new int[nC+1];
        dp = new boolean[31][15001];
        StringTokenizer a = new StringTokenizer(bf.readLine());
        for (int i = 1; i<= nC; i++) {
            choo[i] = Integer.parseInt(a.nextToken());
        }
        goDp(0,0);

        StringTokenizer sk = new StringTokenizer(bf.readLine());
        int nG = Integer.parseInt(sk.nextToken());
        StringTokenizer b = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nG; i++) {
            int k = Integer.parseInt(b.nextToken());
            if (k > 15000) {
                sb.append("N ");
            }else sb.append(dp[nC][k]?"Y ":"N ");
        }
        System.out.println(sb);
    }

    public static void goDp(int idx, int weight) {
        if(dp[idx][weight]) return;
        dp[idx][weight]=true;
        if(idx+1== choo.length) return;
        goDp(idx+1, weight+choo[idx+1]);
        goDp(idx+1, weight);
        goDp(idx+1, Math.abs(weight-choo[idx+1]));
    }
}

