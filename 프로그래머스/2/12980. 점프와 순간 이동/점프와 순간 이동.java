import java.util.*;

public class Solution {
    public int solution(int n) {
        int ans = 0;
        
        //n(큰수)에서 1을 만드는게 목표 
        while(n!=1){
            if (n%2==0){ //짝수면
                n/=2;
            }else {
                n-=1;
                ans+=1;
            }
        }

        return ans+1;
    }
}