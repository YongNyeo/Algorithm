import java.util.*;
class Solution {
    public int[] solution(String s) {
        int cnt = 0;
        int sum_mn = 0;
        while (s.equals("1")==false){
            char[]lst = s.toCharArray();
            cnt += 1;
            int mn = 0;
            for (char k : lst){
                if (k=='0'){
                   mn+=1; 
                }
            }
            sum_mn += mn;
            Integer n = s.length()-mn;
            s = Integer.toBinaryString(n);
            if (s.length()==1)
                break;
        }
        int [] answer = new int[2];
        answer[0] = cnt;
        answer[1] = sum_mn;
        return answer;
    }
}