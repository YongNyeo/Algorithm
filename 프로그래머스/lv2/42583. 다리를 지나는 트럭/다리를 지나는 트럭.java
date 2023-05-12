import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        // 1. 다리에 올라간 트럭무게합 WeightonBridge<= weight
        // 2. 다리에 올라간 트럭의 갯수 deque.size() <= bridge_length
        Deque<Integer>bridge = new ArrayDeque<>();
        int cnt = 0;
        int sumWeight =0;
        for (int w:truck_weights){
            while(true){
                if (bridge.isEmpty()){
                    bridge.offer(w);
                    sumWeight+=w;
                    cnt++;
                    break;
                }
                else if(bridge.size()==bridge_length){
                    sumWeight-=bridge.poll();
                }
                else{
                    //길이는 안찼지만, 무게가 가득참
                    if (sumWeight+w>weight){
                        bridge.offer(0);
                        cnt++;
                    }
                    else{
                        bridge.offer(w);
                        sumWeight+=w;
                        cnt++;
                        break;
                    }
                }
            }
        }
       
        return cnt+bridge_length;
        
    }
}