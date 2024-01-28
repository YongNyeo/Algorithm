import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Map<String,Boolean>map = new HashMap<>();
        Arrays.sort(phone_book);
        for (int i=0;i<phone_book.length;i++){
            StringBuilder sb = new StringBuilder();
            for (int j=0;j<phone_book[i].length();j++){
                sb.append(phone_book[i].charAt(j));
                if (map.containsKey(sb.toString())){
                    return false;
                }
                if (j==phone_book[i].length()-1) map.put(sb.toString(),true);
            }
        }
        
        return answer;
    }
}