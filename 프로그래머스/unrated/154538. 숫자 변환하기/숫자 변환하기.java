import java.util.*;
class Solution {
    public int solution(int x, int y, int n) {
        int answer = 0;
        int [] visited =  new int[y+1];
        for (int i=0;i<y+1;i++){
            visited[i] = 1000000;
        }
        visited[x] = 0;
        for (int i=x;i<y+1;i++){
            if (i+n<=y){
                visited[i+n] = Math.min(visited[i]+1,visited[i+n]);                
            }
            if (i*2<=y){
                visited[i*2] = Math.min(visited[i]+1,visited[i*2]);            
            }
            if (i*3<=y){
                visited[i*3] = Math.min(visited[i]+1,visited[i*3]);                
            }
        }
        if (visited[y]==1000000) return -1;
        return visited[y];
    }
}