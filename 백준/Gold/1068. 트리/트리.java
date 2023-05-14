import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static int cnt=0;
    public static int stop;
    public static void main(String[] args) throws IOException {
        List<Integer>[] tree = new ArrayList[51];
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        String[] st = bf.readLine().split(" ");
        for (int i = 0; i <51; ++i) {
            tree[i] = new ArrayList<Integer>();
        }

        stop = Integer.parseInt(bf.readLine());
        int i=-1;
        int parent =0 ;
        for (String s : st) {
            i++;
            if (s.equals("-1")) {
                parent=i;
                continue;}

            tree[Integer.parseInt(s)].add(i);
        }
        if (stop == parent) {
            System.out.println(cnt);
            return;
        }
        for(Integer t:tree[parent]){
            dfs(parent,t,tree);
        }

        System.out.println(cnt);
    }

    public static void dfs(int parent,int son,List<Integer>[] tree) throws IOException {
        if (son == stop) {
            if (tree[parent].size() <= 1) {
                cnt++;
                return;
            }
            else return;
        }
        if(!tree[son].isEmpty()){
            for (int t : tree[son]) {
                dfs(son,t, tree);
            }
        }
        else cnt++;
    }
}
