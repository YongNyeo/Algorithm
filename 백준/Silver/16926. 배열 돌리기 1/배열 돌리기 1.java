import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;

class Main {

    static int[] dice = new int[7];
    static int n, m, k;
    static int[][] map;
    static int[] dx = {1, -1, 0, 0}; //남북서동
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());//n,m중 작은것은 무조건 짝수.
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            StringTokenizer sk = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(sk.nextToken());
            }
        }
        int w = Math.min(n, m) / 2;
        for (int i = 0; i < w; i++) {
            for (int a = 0; a < k; a++) {
                int tmp = map[i][i];
                //4방면 나눠서 배열값 옮기기
                for (int j = i + 1; j < m - i; j++) {
                    map[i][j - 1] = map[i][j];
                }
                for (int j = i + 1; j < n - i; j++) {
                    map[j - 1][m - 1 - i] = map[j][m - 1 - i];
                }
                for (int j = m - 2 - i; j >= i; j--)
                    map[n - 1 -i][j + 1] = map[n - 1 - i][j];

                for (int j = n - 2 - i; j >= i; j--)
                    map[j + 1][i] = map[j][i];
                map[i+1][i] = tmp;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }
}
