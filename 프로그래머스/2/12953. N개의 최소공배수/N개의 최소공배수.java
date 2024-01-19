import java.util.*;
class Solution {
    public int solution(int[] arr) {
        Arrays.sort(arr);
        int before = arr[0];
        for (int i=1;i<arr.length;i++){
            int a = before;
            int b = arr[i];
            //최대 공약수 k  
            int k = 1;
            while(a!=0){
                k = b%a;
                b = a;
                a = k;
            }
            //최소 공배수 s 
            before = before*arr[i]/b;
            
        }
        
        return before;
    }
}