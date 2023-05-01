import java.util.*;
class Solution {
    public List<Long> solution(int n, long left, long right) {
        //n => 천만 => 사실상 모든 좌표 n^2을 돈다는것은 불가능.
        // right - left < 10^5임을 보았을때 모든 좌표 arr[left~rigth]를 loop
        
        List<Long> answer = new ArrayList<>();
        for (long i=left;i<=right;i++){
            answer.add(Math.max(i%n,i/n)+1);
        }
        
        return answer;
    }
}