import java.util.*;
class Solution {
    public List<Integer> solution(String s) {
        // 각 튜플의 길이순으로 정렬 후, 이미 있는 숫자면 pass,없으면 lst에 담기
        List<Integer>lst = new ArrayList<>();
        
        int n = s.length();
        s= s.substring(2,n-2);
        String[] a = s.split("\\}\\,\\{");
        Arrays.sort(a,new Comparator<String>(){
            public int compare(String a, String b){
                return Integer.compare(a.length(),b.length());
            }
        });
        
        for(String k:a){
            String[] w = k.split(",");
            for (String q : w){
                Integer h = Integer.parseInt(q);
                if (!lst.contains(h)){
                    lst.add(h);
                }
            }
        }
        return lst;
        
    }
}