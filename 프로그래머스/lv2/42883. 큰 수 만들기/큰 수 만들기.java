import java.util.*;
class Solution {
    public String solution(String number, int k) {
        Stack<Integer>stack = new Stack<>();
        
        for(int i=0;i<number.length();i++){
            while(true){
                //비어있으면 그냥 넣어주고 끝
                if (stack.isEmpty()){
                    stack.push(Integer.parseInt(number.substring(i,i+1)));
                    break;
                }
                //남은 문자를 다 추가해야되는 상황이면 넣어주고 끝
                if (stack.size()+(number.length()-i)==number.length()-k){
                    stack.push(Integer.parseInt(number.substring(i,i+1)));
                    break;
                }
                // 그게 아니라면 끝에거랑 비교. 인덱스값이크다면 빼고 넣어줘야함
                if (stack.peek()<Integer.parseInt(number.substring(i,i+1))){
                    stack.pop();
                }
                // 작다면
                else {
                    if (stack.size()<number.length()-k){
                        stack.push(Integer.parseInt(number.substring(i,i+1)));}
                    break;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}