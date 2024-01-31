import java.util.*;
class Solution {
    private static int answer;
    private static Map<Character,Character>map;
    private static boolean[]visited;
    public int solution(String skill, String[] skill_trees) {
         answer = skill_trees.length;
        //선행 스킬 등록
        map = new HashMap<>(); //<스킬,선행스킬>
        Character first = skill.charAt(0);
        for (int i=1;i<skill.length();i++){
            map.put(skill.charAt(i),skill.charAt(i-1));
        }
        
        for (int i=0;i<skill_trees.length;i++){
            visited = new boolean[26];
            String s = skill_trees[i];
            for (int k=0;k<s.length();k++){ //하나의 문자열 내 하나의 글자
                Character c = s.charAt(k);
                if (c==first){ //첫 문자면 바로 방문처리 ok
                    visited[first-65]=true;
                    continue;
                }
                //선행 스킬이 필요한 문자일때, 
                if (map.containsKey(c)){
                    //선행스킬 이행 했는지 확인하기
                    Character c2 = map.get(c);
                    int num = c2-65;
                    if (!visited[num]){
                        answer--;
                        break;
                    }
                    visited[c-65] = true;
                }    
            }
        }
        
        return answer;
    }
 
}