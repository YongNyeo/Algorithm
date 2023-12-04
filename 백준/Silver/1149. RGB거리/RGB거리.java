import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    private static int n;
    private static int k;



    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        int [][]arr = new int[n+1][3];

        for (int i = 1; i <= n; i++) {

            StringTokenizer sk = new StringTokenizer(br.readLine());

            int n0 = Integer.parseInt(sk.nextToken());
            int n1 = Integer.parseInt(sk.nextToken());
            int n2 = Integer.parseInt(sk.nextToken());

            arr[i][0] = Math.min(arr[i-1][1],arr[i-1][2])+n0;
            arr[i][1] = Math.min(arr[i-1][0],arr[i-1][2])+n1;
            arr[i][2] = Math.min(arr[i-1][0],arr[i-1][1])+n2;

        }

        System.out.println(Math.min(arr[n][0],Math.min(arr[n][1],arr[n][2])));
    }


}