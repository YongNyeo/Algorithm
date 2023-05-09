import java.util.*;
class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        Map<String,String>map = new HashMap<>();
        for(int i = 1;i<skill.length();i++){
            map.put(skill.substring(i,i+1),skill.substring(i-1,i));
        }
        for (String sk : skill_trees) {
            List<String>lst = new ArrayList<>();
            for (int i=0;i<sk.length();i++){
                //선행키 있다면
                if (map.containsKey(sk.substring(i,i+1))){
                    //선행안했다면
                    if (!lst.contains(map.get(sk.substring(i,i+1)))){
                        answer-=1; 
                        break;
                    }
                    //선행했다면,
                    lst.add(sk.substring(i,i+1));
                }
                else lst.add(sk.substring(i,i+1));
            }
            answer+=1;
        }
        return answer;
    }
}