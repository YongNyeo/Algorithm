import java.util.*;
class Solution {
    private static boolean[]visited;
    private static int[][] list;
    private static int n;
    private static int max;
    public int solution(int k, int[][] dungeons) {
        n = dungeons.length;
        max = 0;
        visited = new boolean[n];
        list = dungeons;
        dfs(k,0,0);
        
        return max;
        
    }
    
    public void dfs(int hp,int depth,int cnt){
        if (depth==n){
            if (cnt>max) max = cnt;
            return;            
        }
        
        for (int i=0;i<n;i++){
            if (!visited[i]){ //방문하지 않은 던전 중
                if (hp>=list[i][0]){//최소 필요 피로도 충족
                    visited[i] = true;
                    dfs(hp-list[i][1],depth+1,cnt+1);
                    visited[i] = false;
                }
                visited[i] = true;
                dfs(hp-list[i][1],depth+1,cnt);
                visited[i] = false;
            }
        }
    }
        
}