import java.util.*;
class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        int n = targets.length;
        Arrays.sort(targets,(o1,o2)->o1[1]-o2[1]);        

        int end =0;
        for (int i=0;i<n;i++){
            if (end>targets[i][0]){
                continue;
            }
            else{
                end = targets[i][1];
                answer++;
            
            }                
        }    
        return answer;
        
    }
}