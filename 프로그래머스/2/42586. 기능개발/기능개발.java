import java.util.*;
class Solution {
    public List<Integer>solution(int[] progresses, int[] speeds) {
        // int[] answer = {}; 
        //자정에 배포마다 **몇개씩** 배포가 되는지!
        //순서 매우중요! 앞 순서가 안끝나면 먼저 끝난(후순서)도 배포 못함
        List<Integer>answer = new ArrayList<>();
        PriorityQueue<Node>pq = new PriorityQueue<>();
        int n = progresses.length;
        for (int i=0;i<n;i++){
            pq.add(new Node(progresses[i],i));
        }
        //순서대로 빼면서, 
        //1.초과하면 뒤에거는 새로 또 다시 계산해야됨
        //2. 초과 안하면 뒤에거는 계산 없이 바로 speeds만 추가하고 다시 추가
        int sum=0;
   
        
        
        while(sum!=n){
            int k = 0;
            List<Node>list = new ArrayList<>();
            Node peek = pq.peek();
            boolean exceed = true;
            
            while(!pq.isEmpty()){
                Node poll = pq.poll();
                poll.progress +=speeds[poll.number]; //일단 계산해주고
                if (exceed){ //이전거 초과한 상태면,
                    if (poll.progress>=100){ //이번것 초과하면 
                        k+=1;
                        
                    }else { //이번거 초과 못했으면 
                        exceed = false;
                        list.add(poll);
                    }
                }else { //이전거 초과 안했으면
                    list.add(poll);
                    }
            }
            sum+=k;
            if (k!=0) answer.add(k);
            list.forEach(lst-> pq.add(lst));
        }
        
        return answer;
    }
}
class Node implements Comparable<Node>{
    int progress;
    int number;
    public Node(int progress,int number){
        this.progress = progress;
        this.number = number;
    }
    @Override
    public int compareTo(Node node){
        return this.number-node.number;
    }
}