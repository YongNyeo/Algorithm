import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int k = Integer.parseInt(bf.readLine());
        int[][] floyd = new int[n][n];

        //플로이드 초기화
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    floyd[i][j] = 1_000_000_000;
                }
                else floyd[i][j] = 0;
            }
        }
        //플로이드 값 입력
        for (int i = 0; i < k; i++) {
            String[] s = bf.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            int c = Integer.parseInt(s[2]);
            if (floyd[a - 1][b - 1] > c) {
                floyd[a-1][b-1] = c;
            }
        }

        //플로이드 구현
        for (int w = 0; w < n; w++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (floyd[i][j] > floyd[i][w] + floyd[w][j]) {
                        floyd[i][j] = floyd[i][w] + floyd[w][j];
                    }
                }
            }
        }
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if (floyd[i][j]==1000000000) {
                    System.out.print(0+" ");
                    continue;
                }
                System.out.print(floyd[i][j]+ " ");
            }
            System.out.println();
        }
    }

}
