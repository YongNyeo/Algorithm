import java.util.*;
class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        Map<Integer,Integer>map1 = new HashMap<>();
        Map<Integer,Integer>map2 = new HashMap<>();
        for (int i=0;i<topping.length;i++){
            map2.put(topping[i],map2.getOrDefault(topping[i],0)+1); 
        }
        
        for (int i=0;i<topping.length;i++){
            int k = topping[i];
            if (map2.get(k)==1){
                map2.remove(k);
            }else map2.put(k,map2.get(k)-1);
                map1.put(topping[i],map1.getOrDefault(topping[i],0)+1); 
            
            if (map1.keySet().size()==map2.keySet().size()){
              
                answer++;
            }
        }
        
        return answer;
    }
}