import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[]{0,0};
        int len = words.length;
        Set<String>set = new HashSet<>();
        char last = words[0].charAt(0);
        for (int i=0;i<len;i++){
            if (set.contains(words[i])) {
                answer[0] = (i%n)+1; //자기 번호 == 최대n
                answer[1] = (i/n)+1; //자기 차례(턴)
                return answer;
            }
            if (last!=words[i].charAt(0)){
                answer[0] = (i%n)+1; //자기 번호 == 최대n
                answer[1] = (i/n)+1; //자기 차례(턴)
                return answer;
            }
            set.add(words[i]);
            last = words[i].charAt(words[i].length()-1);
        
        }
        
        return answer;
    }
}