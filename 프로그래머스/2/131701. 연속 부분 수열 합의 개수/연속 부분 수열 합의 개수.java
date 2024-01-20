import java.util.*;
class Solution {
    public int solution(int[] elements) {
        Set<Integer>set = new HashSet<>();
        int answer = 0;
        int n = elements.length;
        //맨 마지막 케이스는 따로하기
        for(int i=0;i<n;i++){
            int sum = elements[i];
            set.add(sum);
            for (int j=i+1;j<i+n;j++){
                int k = j;
                if (j>=n) 
                    k = j%n;
                sum+=elements[k];
                set.add(sum);
            }
        }
        
        return set.size();
    }
}
