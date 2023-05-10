import java.util.*;
class Solution {
    final String[] s = {"A","E","I","O","U"};
    public int solution(String word) {
        int answer =0;
        List<String> lst = new ArrayList<>();
        for (String k : s){
            dfs(k,lst);
        }
        for (int i=0;i<lst.size();i++){
            if (lst.get(i).equals(word)) answer = i+1;
        }
        return answer;
    }
    public void dfs(String k,List<String>lst){
        if (k.length()>s.length){
            return;}
        if (!lst.contains(k)){
            lst.add(k);
        }
        for (int i=0;i<s.length;i++){
            dfs(k+s[i],lst);
        }
    }
    
}