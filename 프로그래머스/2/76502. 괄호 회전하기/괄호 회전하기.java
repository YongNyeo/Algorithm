import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = -1;
        //올바른 문자열끼리 옆으로 붙여도 올바르고, 올바른 문자열 을 새로 감싸도 올바르다.
        
        //주어지는 s길이만큼 왼쪽으로 밀었을때 올바르게 만들어지는 문자열의 number가 필요하다
        //스택써서 다 해결되는지?
        //문자열이 올바른지 체크하는 메서드가 필요
        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        for (int i=0;i<s.length();i++){
            char first = sb.charAt(0);
            sb.deleteCharAt(0);
            sb.append(first);
            
            if (checkString(sb)) cnt++;
        }
        return cnt;
    }

    public boolean checkString(StringBuilder s){
        
        Stack<Character>stack = new Stack<>();
        for (int i=0;i<s.length();i++){
            if (stack.isEmpty())
                stack.push(s.charAt(i));
            else if (stack.peek()=='['&& s.charAt(i)==']')
                    stack.pop();
            else if (stack.peek()=='{'&& s.charAt(i)=='}')
                    stack.pop();
            else if (stack.peek()=='('&& s.charAt(i)==')')
                    stack.pop();
            else stack.push(s.charAt(i));
            }
        if (stack.isEmpty()) return true;
        return false;
    }
}