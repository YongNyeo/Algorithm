import java.util.*;
class Solution {
    public long solution(int[] weights) {
        Arrays.sort(weights);
        long tmp =0;
        long sum=0;
        for (int i=0;i<weights.length;i++){
            if(i!=0){
                if (weights[i]==weights[i-1]){
                    tmp--;
                    sum+=tmp;
                    continue;
                }
            }
            tmp = 0;
            for (int j=i+1;j<weights.length;j++){
                if(weights[i]==weights[j]||
                   weights[i]*3==weights[j]*2||
                  weights[i]*4==weights[j]*2||
                   weights[i]*4==weights[j]*3){
                    tmp++;
                }
            }
            sum+=tmp;
            
        }
        return sum;
    }
}