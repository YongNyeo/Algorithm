import java.util.*;
class Solution {
    public int solution(int[] citations) {
        //정렬시키고 n번 배열 돌면 끝
        // 0,1,3,5,6
        int mx=0;
        Arrays.sort(citations);
        for (int i=0;i<citations.length;i++){

            if(citations[i]>=citations.length-i){
                mx = citations.length-i;
                break;
            }
        }
        return mx;
    }
}