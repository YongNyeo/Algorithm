import java.util.*;
class Solution
{
    public int solution(String s)
    {
        Stack<Character> stack = new Stack<>();
        char[] list = s.toCharArray();
        for (char c : list){
            
            if (!stack.isEmpty()&& stack.peek() == c)
                stack.pop();
            else stack.push(c);
        }
        return !stack.isEmpty()?0:1;
    }
}