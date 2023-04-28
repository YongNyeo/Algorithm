import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        int cnt=0;
        int start=0;
        for (int i=people.length-1;i>=start;i--){
            if (people[start]+people[i]<=limit){
                cnt+=1;
                start+=1;
            }
            else{
                cnt+=1;
            }
        }
        return cnt;
        
    }
    
}