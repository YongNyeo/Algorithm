import java.util.*;
import java.lang.Math;
class Solution {
     Set<Integer>set ;
    ArrayList<Integer>[]list ;
    int sum;
    
    public int solution(int n, int[][] wires) {
        sum = 0;
        set = new HashSet<>();
        list = new ArrayList[n+1];
        for (int i=1;i<=n;i++){
            list[i] = new ArrayList<Integer>();
        }
        for(int i=0;i<wires.length;i++){
            int a = wires[i][0];
            int b = wires[i][1];
            list[a].add(b);
            list[b].add(a);
            set.add(a);
            set.add(b);
        }
        for (int k:set){
            sum+=k;
        }
        int min = 1_000_000_000;
        for (int i=0;i<wires.length;i++){
            int x1 = bfs(wires[i][0],wires[i][1],n);
            int x2 = bfs(wires[i][1],wires[i][0],n);
            
            min = Math.min(min,Math.abs(x1-x2));
            
        }
        

        return min;
    }
    public int bfs(int a, int b,int n){
        Deque<Integer>dq = new ArrayDeque<>();
        dq.add(a);
        boolean[]visited = new boolean[n+1];
        int count = 0;
        while(!dq.isEmpty()){
            int poll = dq.poll();
            if (visited[poll])
                continue;
            
            
            visited[poll] = true;
            count++;
            
            for (int k:list[poll]){
                if (!visited[k]&&k!=b){
                    dq.add(k);     
                }
            }
        }
        return count;
    }
}
