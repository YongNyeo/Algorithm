import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        String[] lst = new String[numbers.length];
        
        for (int i=0;i<numbers.length;i++){
            lst[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(lst,(o1,o2)->(o2+o1).compareTo(o1+o2));
        
        if (lst[0].equals("0")) return "0";
        
        StringBuilder sb = new StringBuilder();
        for (String s : lst){
            sb.append(s);
        }
        return sb.toString();
    }
}