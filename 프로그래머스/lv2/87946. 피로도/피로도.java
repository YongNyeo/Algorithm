import java.util.*;
class Solution {
    static int mx = 0;
    public void dfs(boolean[] visited, int[][] dungeons,int p,int cnt){
        for (int i=0;i<dungeons.length;i++){
            if (visited[i]==false && p>=dungeons[i][0]){
                visited[i]=true;
                cnt+=1;
                mx = Math.max(cnt,mx);
                p = p-dungeons[i][1];
                //재귀 순행
                dfs(visited,dungeons,p,cnt);
                //재귀 역행
                visited[i] = false;
                cnt-=1;
                p = p+dungeons[i][1];
            }
        }
    }
        
    public int solution(int k, int[][] dungeons) {
        //떠오르는건 dfs뿐...
        int a = dungeons.length;
        boolean[] visited = new boolean[a];
        dfs(visited,dungeons,k,0);
        return mx;
    }
    
}