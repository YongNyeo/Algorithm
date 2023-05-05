import java.util.*;
class Solution {
    static int cnt = 0;
    public void dfs(int[] numbers,int target,int hap, int depth){
        if (depth==numbers.length){
            if(hap==target){
                cnt+=1;
            }
        }
        else{
        dfs(numbers,target,hap-numbers[depth],depth+1);
        dfs(numbers,target,hap+numbers[depth],depth+1);
        }
    }
    
    public int solution(int[] numbers, int target) {
        dfs(numbers,target,0,0);
        return cnt;
    }
}