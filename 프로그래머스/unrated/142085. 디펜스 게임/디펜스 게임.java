import java.util.*;
class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        PriorityQueue<Integer>pq = new PriorityQueue<>();
        int sum=0;
        for (int i=0;i<enemy.length;i++){
            pq.add(-enemy[i]);
            sum+=enemy[i];
            if (sum>n){
                if (k==0) break;
                k-=1;
                sum=sum-(-pq.poll());
            }
            answer++;
        }
        return answer;
    }
}