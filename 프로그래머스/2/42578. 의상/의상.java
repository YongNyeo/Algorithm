import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        //조합 문제?
        Map<String,Integer>map = new HashMap<>();
        for (int i=0;i<clothes.length;i++){
            map.put(clothes[i][1],map.getOrDefault(clothes[i][1],0)+1);
        }
        
        int multiSum = 1;
        
        for (Integer k:map.values()){
            multiSum*=(k+1);
        }
        return multiSum-1;
        
    }
}