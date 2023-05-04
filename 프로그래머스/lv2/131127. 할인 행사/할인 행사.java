import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        Map<String,Integer>map = new LinkedHashMap<>();
        Collection<Integer>lst = new ArrayList<>();
        int cnt =0;
        for (String w:want){
            map.put(w,0);
        }
        for (int i=0;i<number.length;i++){
            lst.add(number[i]);
        }
        
        for(int i=0;i<discount.length;i++){
            //i가 0~9까지는 미리 넣어놓기
            if (i>=0 && i<=9){
                //원하는 것일때만 +1
                if (map.containsKey(discount[i])==true){
                    map.put(discount[i],map.get(discount[i])+1);
                }
                continue;
            }
            List<Integer> list = new ArrayList<Integer>(map.values());
            List<Integer> st = Arrays.stream(number)        // IntStream
                .boxed()          // Stream<Integer>
                .collect(Collectors.toList());
            
            if (list.equals(st)) cnt+=1;
           
            //앞에꺼 하나 빼주고, 뒤에꺼 하나더해주기
            if (map.containsKey(discount[i-10])==true){
                    map.put(discount[i-10],map.get(discount[i-10])-1);
                }
            if (map.containsKey(discount[i])==true){
                    map.put(discount[i],map.get(discount[i])+1);
                }
            
        }
            List<Integer> list = new ArrayList<Integer>(map.values());
            List<Integer> st = Arrays.stream(number)      
                .boxed()        
                .collect(Collectors.toList());
            
            if (list.equals(st)) cnt+=1;
        return cnt;
 
    }
}