import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String,Integer>dict = new HashMap<>();
        for (String[] cloth : clothes){
            if (dict.containsKey(cloth[1])==true){
                dict.put(cloth[1],dict.get(cloth[1])+1);
            }
            else{
                dict.put(cloth[1],1);
            }
        }
        for (int k:dict.values()){
            answer*=(k+1);   
        }
        return answer-1;
    }
}