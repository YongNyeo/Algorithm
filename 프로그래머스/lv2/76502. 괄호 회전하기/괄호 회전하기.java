import java.util.*;
class Solution {
    public int solution(String s) {
        int cnt=0;
        int len1 = s.length();
        for (int i=0;i<len1;i++){
            Stack<String>stack = new Stack<>();
            //i만큼 옮기기
            String tmp = s.substring(1);
            String tmp2 = s.substring(0,1);
            s = tmp+tmp2;
            // System.out.println(s);
        
            //문자열 돌기
            String[] arr=s.split("");
            boolean b = false;
            for (String k:arr){
                //비어있을땐 무조건 넣기
                if (stack.isEmpty()){
                    if (k.equals("(") || k.equals("{")||k.equals("[")){
                        stack.push(k);                        
                    }
                    else {
                        b=true;
                        break;
                         }
                }
                //들어있을때
                else{
                    //여는거라면 스택에 담기
                    if (k.equals("(") || k.equals("{") || k.equals("[")){
                        stack.push(k);
                        continue;
                    }
                    if (k.equals("]")){
                        if (stack.peek().equals("[")){
                            stack.pop();
                        }
                        else{
                        b=true;
                        break;}
                    }
                    if (k.equals(")")){
                        if (stack.peek().equals("(")){
                            stack.pop();
                        }
                        else{
                        b=true;
                        break;}
                    }
                    if (k.equals("}")){
                        if (stack.peek().equals("{")){
                            stack.pop();
                        }
                        else{
                        b=true;
                        break;}
                    }
                }
            }
            if (b==true){
                continue;
            }
            // System.out.println(stack+"@");
            
            //마지막에 비어있으면서 중도 멈춘게 아니어야함
            if (stack.isEmpty()==true){
                cnt+=1;
                }
            }
            
        return cnt;
        }
}