import java.util.*;
class Solution {
    public long solution(int r1, int r2) {
        //규칙성 찾기    x^2+y^2= k^2 
        // y = Math.sqrt(k^2-x^2)
        long sum1 = 0;
        long sum2 = 0;
        long answer = 0;
        long tmp=0;
        for (int i=0;i<=r2;i++){
            sum1 += (long)Math.sqrt(Math.pow(r2,2)-Math.pow(i,2))-(long)Math.sqrt(Math.pow(r1,2)-Math.pow(i,2));
            
            if (Math.sqrt(Math.pow(r1,2)-Math.pow(i,2))%1==0){
                tmp++;
            }
        }
        sum1*=4;
        sum1+=(tmp*4-4);
        
        return sum1;
    }
}