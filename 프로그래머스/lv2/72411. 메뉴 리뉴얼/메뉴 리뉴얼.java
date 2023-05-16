import java.util.*;
import java.util.Map.Entry;

class Solution {
    static Map<String,Integer>map = new HashMap<>();
    public List<String> solution(String[] orders, int[] course) {
        //부분집합 문제. 가장 많이 호출된 부분집합 순서대로 
        for (String order:orders){
             // 1. 각 문자열을 오름차순 정렬.
            char[] charArr = order.toCharArray();
            // 3. 해당 문자형 배열을 정렬.
            Arrays.sort(charArr);
            // 4. 정렬된 문자형 배열을 문자열로 변환해 저장.
            order = String.valueOf(charArr);
        
        
            for(int c:course){
                boolean[] visited = new boolean[order.length()];
                dfs(order,c,visited,0);
            }
        }
        List<String>answer = new ArrayList<>();
        for (int c:course){
            int max = 0;
            for(Entry<String,Integer> entry : map.entrySet()){
                if (entry.getKey().length()==c){
                    max = Math.max(max,entry.getValue());
                }
            }
            for(Entry<String,Integer> entry : map.entrySet()){
                if (entry.getKey().length()==c){
                    if(max >=2 && entry.getValue() == max)
                        answer.add(entry.getKey());
                    }
                }
            }
        Collections.sort(answer);
        return answer;
        
    }
    public void dfs(String order,int c,boolean[]visited,int depth){
        //개수만큼 다 뽑음
        if (c==0){
            Mapping(order,visited);

            return;
        }
        // dpeth 끝까지 들어간상태.
        if (depth==order.length()){
            return;
        }
        visited[depth] = true;
        dfs(order,c-1,visited,depth+1);
        visited[depth]  = false;
        dfs(order,c,visited,depth+1);
        
    }
    public void Mapping(String order,boolean[]visited){
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<visited.length;i++){
            if (visited[i]){
                sb.append(order.charAt(i));
            }
        }
        String k = sb.toString();
        if (map.containsKey(k)){
            map.put(k,map.get(k)+1);
        }
        else map.put(k,1);
    }
}