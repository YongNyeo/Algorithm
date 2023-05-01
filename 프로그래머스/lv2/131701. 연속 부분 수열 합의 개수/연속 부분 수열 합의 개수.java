import java.util.*;
class Solution {
    public int solution(int[] elements) {
        Set<Integer>lst = new HashSet<>();
        for (int i=0;i<elements.length;i++){
            // 길이가 i인 부분수열의 합을 구하려고함.
            for (int k=0;k<elements.length;k++){
                //sum이용하기 애매해서 각 부분수열의 합을 *계산*하는 for문
                int hap=0;
                for (int q=k;q<k+i+1;q++){
                    hap +=elements[q%elements.length];
                }
                lst.add(hap);
            }
        }
        return lst.size();
    }
}