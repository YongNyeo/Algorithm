import java.io.*;
import java.util.*;
import java.lang.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (a==0&&b==0&&c==0) break;

            int max  = Math.max(a,b);
            max = Math.max(max,c);

            if ((Math.pow(a,2)+Math.pow(b,2)+Math.pow(c,2))/2== Math.pow(max,2)) 
                System.out.println("right");
            else 
                System.out.println("wrong");


        }

    }
}