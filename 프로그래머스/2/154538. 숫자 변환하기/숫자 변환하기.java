import java.util.*;
import java.lang.Math.*;
class Solution {
    public int solution(int x, int y, int n) {
        int answer = -1;
        int []dp = new int[y+1];
        Arrays.fill(dp,1000001);
        dp[x] = 0;
        for (int i=x;i<=y-n;i++){
            if (i+n<=y){
                dp[i+n] = Math.min(dp[i+n],dp[i]+1);
            }
            if (i*2<=y){
                dp[i*2] = Math.min(dp[i*2],dp[i]+1);
            }
            if (i*3<=y){
                dp[i*3] = Math.min(dp[i*3],dp[i]+1);
            }
        }
      
        
        if (dp[y]==1000001) return -1;
        return dp[y];
    }
}
