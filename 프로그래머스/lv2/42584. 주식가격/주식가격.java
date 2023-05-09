import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        Stack<Integer>stack = new Stack<>();
        int[] answer = new int[prices.length];
        
        for (int i=0;i<prices.length;i++){
            while(!stack.isEmpty()){
                if (prices[stack.peek()]>prices[i]){
                    answer[stack.peek()] = i-stack.peek();
                    stack.pop();}
                else break;
            }
            stack.push(i);            
        }
        
        while(!stack.isEmpty()){
            answer[stack.peek()] = prices.length-stack.peek()-1;
            stack.pop();
        }
        
        return answer;
    }
}