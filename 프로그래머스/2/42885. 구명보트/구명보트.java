import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        
        // 3,5,5,7 -> 이 경우에 젤 작은거랑 젤 큰거랑 해결 안되면, 젤 큰거는 가망 없는 케이스임.
        Arrays.sort(people);
        int left = 0;
        int right = people.length-1;
        int sum =0;
        while(left<=right){
            
            if (people[left]+people[right]<=limit){
                left++;
                right--;
                sum+=1;
            }else {
                right--;
                sum+=1;
            }
        }
        return sum;
    }
}