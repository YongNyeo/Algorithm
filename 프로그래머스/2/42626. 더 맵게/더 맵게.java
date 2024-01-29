import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer>pq= new PriorityQueue<>();
        for (int s:scoville){
            pq.add(s);
        }
        int cnt = 0;
        while(!pq.isEmpty()){
            int poll1 = pq.poll();
            if (poll1>=K)
                break;
            if(pq.size()==0) return -1;
            int poll2 = pq.poll();
            pq.add(poll1+(poll2*2));
            cnt++;
        }
        return cnt;
    }
}