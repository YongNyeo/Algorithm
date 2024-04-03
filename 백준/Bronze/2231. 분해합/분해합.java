import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {
    // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // StringTokenizer st = new StringTokenizer(br.readLine());
    // System.out.println();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());

        for (int i=1;i<=k;i++){
            int origin = i;
            int sum = 0;
            while(origin>0){
                sum+=(origin%10);
                origin/=10;
            }
            if (sum+i==k) {
                System.out.println(i);
                return;
            }
        }
        System.out.println(0);
    }
   
}