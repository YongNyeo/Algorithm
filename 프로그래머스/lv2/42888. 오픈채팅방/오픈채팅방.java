import java.util.*;
class Solution {
    public String[] solution(String[] record) {
        //채팅방 닉네임 중복 허용,길이 10만, 
        //uid 고유값
      
        Map<String,String>nickName = new HashMap<>();
        for (String r:record){
            String[] s = r.split(" ");
            if (s[0].equals("Enter")){
                //이미 있을때는 바꾸기
                if (nickName.containsKey(s[1])){
                    nickName.replace(s[1],s[2]);
                }
                //없을때는 새로 넣어주기
                else nickName.put(s[1],s[2]);
            }
            else if(s[0].equals("Change")){
                //당연히 기존에 uid가 존재해야함.
                nickName.replace(s[1],s[2]);
            }
        }
        List<String>lst = new ArrayList<>();
        for (String r:record){
            String s[] = r.split(" ");
            StringBuilder sb = new StringBuilder();
            if (s[0].equals("Change")) continue;
            
            sb.append(nickName.get(s[1]));
            if (s[0].equals("Enter")){
            sb.append("님이 들어왔습니다.");}
            else if(s[0].equals("Leave")){
                sb.append("님이 나갔습니다.");}
            lst.add(sb.toString());
        }
        String[] answer = new String[lst.size()];
        for (int i=0;i<answer.length;i++){
            answer[i] = lst.get(i);
        }
        return answer;
        
    }
}