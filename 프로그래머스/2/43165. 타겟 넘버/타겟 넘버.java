import java.util.*;
class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        Deque<Node>deque = new ArrayDeque<>();
        deque.add(new Node(0,0));
        int cnt = 0;
        int n = numbers.length;
        while(!deque.isEmpty()){
            Node poll = deque.poll();
            if (poll.depth==n){
                if (poll.sum==target)
                    cnt++;
                continue;
            }
            deque.add(new Node(poll.depth+1,poll.sum+numbers[poll.depth]));
            deque.add(new Node(poll.depth+1,poll.sum-numbers[poll.depth]));
        }
    
        return cnt;
    }
}
class Node{
    int depth;
    int sum;
    public Node(int depth,int sum){
        this.depth = depth;
        this.sum = sum;
    }
}