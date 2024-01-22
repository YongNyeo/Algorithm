import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        Map<String,Integer>map = new HashMap<>();
        int count = 0;
        for (int i=0;i<want.length;i++){
            map.put(want[i],number[i]);
        }
        for (int i=0;i<discount.length;i++){
            if (map.containsKey(discount[i])){ //want 에 없는건 걍 패스
                map.put(discount[i],map.get(discount[i])-1); //뒤에거 추가하는 로직
            }
            //앞에꺼 빼주는 로직
            if (i>=9){ 
                  int a = 0;
                for (int k:map.values()){
                    a+=k;
                    if (k!=0) break;
                }
                if (a==0) count++;
                if (map.containsKey(discount[i-9])){
                    map.put(discount[i-9],map.get(discount[i-9])+1);
                }
                
              
            }
            
    
        }
        return count;
    }
}