import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        //순서 보장
        int time = 1;
        PriorityQueue<Truck>pq = new PriorityQueue<>();
        pq.add(new Truck(1,truck_weights[0]));
        int wait = 1;
        int sum = truck_weights[0];
        while(!pq.isEmpty()){
            time++;
            if (time-pq.peek().time==bridge_length){//맨 앞에 있는게 다리 다 건넜다면
                Truck poll = pq.poll();
                System.out.println(poll.time);
                sum-=poll.weight;
            }
            if (pq.size()>=bridge_length) continue; //다리 꽉 찼다면 패스
            if (wait<truck_weights.length){ // 대기 트럭 남아있다면
                if (sum+truck_weights[wait]<=weight) {//다리 무게 초과 안한다면
                    pq.add(new Truck(time,truck_weights[wait]));
                    // System.out.println(sum);
                    // System.out.println(truck_weights[wait]);
                    sum+=truck_weights[wait];
                    wait++;
                }
            }
        }        
        return time;
    }
}
class Truck implements Comparable<Truck>{
    int time;
    int weight;   
    public Truck(int time,int weight){
        this.time = time;
        this.weight = weight;
    }
    
    @Override
    public int compareTo(Truck truck){
        return this.time-truck.time;
    }
}