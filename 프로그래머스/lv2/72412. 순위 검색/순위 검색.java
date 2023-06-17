import java.util.*;
class Solution {
    static Map<String,ArrayList<Integer>>map ;
    public int[] solution(String[] info, String[] query) {
        int []answer = new int[query.length];
        map  = new HashMap<>();
        //info 먼저 정리해서 map에 넣기
        for (String inf :info){
            StringBuilder sb = new StringBuilder();
            String[] s = inf.split(" ");
            dfs("",s,0);
        }
        //나중에 이분탐색 하려면 map의 int_valueList 정렬필요
        for (String ks:map.keySet()){
            Collections.sort(map.get(ks));
        }
        // 각 쿼리를 돌며 (이진)탐색 시작
        for (int j=0;j<query.length;j++){
            answer[j] = SQL(query[j]);
        }
        
        return answer;
    }
    
    public void dfs(String str,String[]split_info,int depth){
        if (depth==4){
            int k = Integer.parseInt(split_info[4]);
            if (map.containsKey(str)){
                map.get(str).add(k);
            }
            else {
                ArrayList<Integer>lst = new ArrayList<>();
                lst.add(k);
                map.put(str,lst);
            }
            return;
        }
        dfs(str+"-",split_info,depth+1);
        dfs(str+split_info[depth],split_info,depth+1);
    }
    public int SQL(String query){
        String []s = query.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<7;i++){
            if (s[i].equals("and")) continue;
            sb.append(s[i]);
        }
        int score = Integer.parseInt(s[7]);
        String a = sb.toString();
        if (map.containsKey(a)){
            ArrayList<Integer>list = map.get(a);
            int low = 0;
			int mid = 0;
			int high = list.size()-1;
			
			//이분탐색
			while(low <= high) {
				mid = (low+high)/2;
				
				if(list.get(mid) < score) {
					low = mid+1;
				}else {
					high = mid-1;
				}
			}
			//key값에 해당하는 전체 지원자 - 쿼리에서 요구하는 최소 점수의 인덱스
			//즉, 최소 점수가 해당하는 인덱스 위로는 전부
			//쿼리에서 요구하는 점수보다 큰 점수를 갖고있는 지원자들임.
			return list.size()-low;
		}
		//해당하는 지원자 없으면 0명 반환.
		return 0;
        }
}