import java.util.*;
import java.lang.Math.*;
class Solution {
    public int solution(int[] citations) {
        // 6,5,3,1,0
        // 6,5,5,5,5,1
        // 8,7,6,5,4,3,2,1
        // 1,0,0,0 = 1
        // 4,3,2,1 = 2
        Integer[]k = Arrays.stream(citations).boxed().toArray(Integer[]::new);
        Arrays.sort(k,Collections.reverseOrder());
        int sum = 0;
        int max = 0;
        for (int i=0;i<k.length;i++){
            if (i+1>=k[i]) {
                return Math.max(k[i],i);
            }
        }
        
        return k.length;
    }
}