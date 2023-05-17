import java.util.*;
class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        LinkedList<Integer>dq1 = new LinkedList<>();
        LinkedList<Integer>dq2 = new LinkedList<>();
        for (int i=0;i<queue1.length;i++){
            dq1.add(queue1[i]);
            dq2.add(queue2[i]);
        }
        long sum1 = Arrays.stream(queue1).sum();
        long sum2 = Arrays.stream(queue2).sum();
        while(true){
            if (answer>=(queue1.length+queue2.length)*2){
                answer = -1;
                break;
            }
            if (sum1<sum2){
                int p = dq2.poll();
                sum2-=p;
                dq1.add(p);
                sum1+=p;}
            else if(sum1>sum2){
                int k = dq1.poll();
                sum1-=k;
                dq2.add(k);
                sum2+=k;}
            else //같다면 pass
                break;
            answer++;
            }
        
        return answer;
        
        }
    }
