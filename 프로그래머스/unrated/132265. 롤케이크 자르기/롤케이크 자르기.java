import java.util.*;
class Solution {
    public int solution(int[] topping) {
        int cnt=0;
        Map<Integer,Integer>map1 = new HashMap<>();
        Map<Integer,Integer>map2 = new HashMap<>();
        //전체 각 토핑별 갯수 구하기
        for (int i=0;i<topping.length;i++){
            if (map1.containsKey(topping[i])){
                map1.put(topping[i],map1.get(topping[i])+1);
            }else map1.put(topping[i],1);
        }
        //순서대로 돌면서 map1과 map2의 토핑 종류가 같은지 확인하기
        for (int i=0;i<topping.length;i++){
            if (map2.containsKey(topping[i])){
                map2.put(topping[i],map2.get(topping[i])+1);
            }else map2.put(topping[i],1);
            
            if (map1.get(topping[i])==1) map1.remove(topping[i]);
            else    map1.put(topping[i],map1.get(topping[i])-1);
            
            if((map1.keySet()).size()==(map2.keySet()).size()){
                cnt++;
            }
        }
        return cnt;
    }
}