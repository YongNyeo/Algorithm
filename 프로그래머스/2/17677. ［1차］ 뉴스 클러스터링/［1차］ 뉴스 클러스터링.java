import java.util.*;
class Solution {
    /**
    자카드 유사도 J(A,B) 두 집합(각A,B)의 교집합의 크기를 두 집합의 합집합의 크기로 나눈 값
    
    각 집합은 중복 원소를 허용한다. -> 자카드에도 적용시킴
    
    문자열을 두글자씩 끊어서 다중집합의 원소로 만든다. 오직 
    **/

    public int solution(String str1, String str2) {
        int answer = 0;
        str1 = str1.toUpperCase(); // 모두 대문자로 
		str2 = str2.toUpperCase();
		
        List<String>list1 = new ArrayList<>();
        List<String>list2 = new ArrayList<>();
        for (int i=0;i<str1.length()-1;i++){
            char s1 = str1.charAt(i);
            char s2 = str1.charAt(i+1);
            if (((s1>='A'&&s1<='Z')||
                (s1>='a'&&s1<='z'))&&
                ((s2>='A'&&s2<='Z')||
                (s2>='a'&&s2<='z'))){
                list1.add(Character.toString(s1)+Character.toString(s2));
            }
        }
        
        for (int i=0;i<str2.length()-1;i++){
            char s3 = str2.charAt(i);
            char s4 = str2.charAt(i+1);
             if (((s3>='A'&&s3<='Z')||
                (s3>='a'&&s3<='z'))&&
                ((s4>='A'&&s4<='Z')||
                (s4>='a'&&s4<='z'))){
                list2.add(Character.toString(s3)+Character.toString(s4));
            }
        }
        Collections.sort(list1);
		Collections.sort(list2);
		
        List<String>intersection = new ArrayList<>();
        List<String>union = new ArrayList<>();
            
        //교집합 구하기
        for (String s:list1){
            if (list2.remove(s))
                intersection.add(s);
            union.add(s);
        }
        //합집합 구하기
        for (String s:list2){
            union.add(s);
        }
        
        double q = intersection.size();
        double p = union.size();
        if (union.size()==0) return 65536;
        System.out.println(q+" "+p);
        double nn = (q/p)*65536;
        return (int)nn;
    
    }
}