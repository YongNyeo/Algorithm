import java.util.*;
class Solution {
    public ArrayList<Integer> solution(String s) {
        //s를 파싱하기.  1. 맨앞2개랑 ,맨뒤2개 지우고  2. split("},{")사용하기
        s = s.substring(2 , s.length()-2);
        String[] s_list = s.split("\\},\\{");
        int n = s_list.length;
        
        List<List<Integer>>arr = new ArrayList<>();;
        
        for (int i=0;i<n;i++){
            List<Integer> list = new ArrayList<>();
            String[]k = s_list[i].split(",");
            for (int j=0;j<k.length;j++){
                list.add(Integer.parseInt(k[j]));
            }
            arr.add(list);
        }
        Collections.sort(arr, Comparator.comparingInt(List::size));
        
        ArrayList<Integer>tt = new ArrayList<>();
        
        //여기까지 파싱
        for (List<Integer> list:arr){
            for (Integer k: list){
                if (tt.contains(k)) continue;
                tt.add(k);
            }
        }
        
        
        return tt;
    }
}