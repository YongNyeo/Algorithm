
import java.io.*;

import java.util.*;

class Main {

    static int n, m, k;
    static String[][] map;
    static int[] dx = {1, -1, 0, 0}; //남북서동
    static int[] dy = {0, 0, -1, 1};

    static int[] tree = new int[10000];
    static void postOrder(int start, int end) {
        int i;
        if (start >= end) {
            return;
        }
        for (i = start+1; i < end; i++) {
            if(tree[start] < tree[i] )break;
        }
        postOrder(start+1, i);
        postOrder(i, end);
        System.out.println(tree[start]);
        return ;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int i = 0;
        String input;
        // 입력받기
        while((input = br.readLine()) != null)
            tree[i++] = Integer.parseInt(input);

        // 후위순회 호출
        postOrder(0, i);
    }

}
