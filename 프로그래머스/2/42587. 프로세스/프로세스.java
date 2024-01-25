import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
    List<Integer> priorityList = new ArrayList<>();
        for (int i=0;i<priorities.length;i++){
            priorityList.add(priorities[i]);
        }
        
        PriorityQueue<Node>pq = new PriorityQueue<>();
        for (int i=0;i<priorities.length;i++){
            pq.add(new Node(i,priorities[i]));
        }
        
        int cnt = 1;        
        Node poll0 = pq.poll();
        Integer idx = priorityList.indexOf(poll0.pri);
        //맨처음건 뽑아도 걍 맨앞에거 빼면 되는데, 
        //그 다음부턴 이전에 뽑았던거에서 제일 가까워야함 indexOf 사용하면 안됨.
    
        while(true){    
            if (idx==location) break; //내가 찾는 위치의 것이라면,
            else {
                Node poll = pq.poll();
                while(true){
                    idx++;
                    if (idx==priorities.length)
                        idx%=priorities.length;
                    if (priorities[idx]==poll.pri){
                        break;
                    }
                }
            }
            cnt++;
        }
        
        return cnt;
    }
}
class Node implements Comparable<Node>{
    int inedx; //인덱스
    int pri; //우선순위
    public Node(int index,int pri){
        this.inedx = index;
        this.pri = pri;
    }
    @Override
    public int compareTo(Node node){
        return node.pri-this.pri;
    }
}