import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int solution(int[] scoville, int K) {
        List<Integer> lst = Arrays.stream(scoville)
            .boxed()
            .collect(Collectors.toList());
        PriorityQueue<Integer>pq = new PriorityQueue<Integer>(lst);
        int cnt=0;
        while(true){
            int num1 = pq.poll();
            // 최솟값이 K보다 크다면 끝내기
            if (num1>=K) break;
            // 비어있지 않으면 또 진행 
            if (!pq.isEmpty()){
                int num2 = pq.poll();
                int s = num1+(num2*2);
                cnt+=1;
                pq.add(s);
            } //비어있다면 못만드는경우라서 -1
            else return -1;
            
        }
        return cnt;
    }
}