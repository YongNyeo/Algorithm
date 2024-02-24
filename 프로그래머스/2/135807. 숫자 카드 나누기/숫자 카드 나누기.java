import java.util.*;
import java.lang.Math;
class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);
        
        int x1 = find(arrayA,arrayB);
        int x2 = find(arrayB,arrayA);
        
        
        return Math.max(x1,x2);
    }
    private int find(int[] A, int[] B){
        int min = A[0];
        List<Integer>list = findList(min);
        //제일 작은수의 모든 약수를 구하고, 그에 대해 A는 맞아 떨어지는지, B는 안맞아 떨어지는지 체크
        int result = 0;
        for (int k:list){
            for (int i=0;i<A.length;i++){
                if (A[i]%k!=0) 
                    break; //안맞아떨어지면 그 k는 바로 pass
                if (B[i]%k==0) 
                    break; // B가 맞아떨어지면 그 k는 바로 pass
                if (i==A.length-1)
                    result = Math.max(result,k);
            }
        }
        return result;
        
    }
    private List<Integer> findList(int k){
        List<Integer>list = new ArrayList<>();
        for (int i=1;i<Math.sqrt(k)+1;i++){
            if ((k%i)==0)
            {    
                list.add(i);
                list.add(k/i);
            }
            
        }
        return list;
    }
}