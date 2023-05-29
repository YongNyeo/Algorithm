
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    //각 좌표마다 방향 정해서 visited해놔야 재방문했을때 다시 그런짓 안함. 3차원배열 생성 bfs
    //최소 움직임이기때문에 bfs .
    static boolean[][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer sk = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(sk.nextToken());
        int k = Integer.parseInt(sk.nextToken());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        String s = st.nextToken();
        int[] lst = new int[s.length()];
        int cnt=0;

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            lst[i] = Integer.parseInt(s.substring(i, i + 1));
            while (!stack.isEmpty()&&cnt!=k) {
                if (stack.peek()<lst[i]){
                    stack.pop();
                    cnt++;
                }
                else break;
            }
            stack.push(lst[i]);
        }
        StringBuilder sb = new StringBuilder();
        //다 지우지못함.
        if (k>cnt) {
            for (int i = 0; i < stack.size() - (k-cnt); i++) {
                sb.append(stack.get(i));
            }
        }else{
            for (int i = 0; i < stack.size(); i++) {
                sb.append(stack.get(i));
            }
        }
        System.out.println( sb.toString());
    }
}
