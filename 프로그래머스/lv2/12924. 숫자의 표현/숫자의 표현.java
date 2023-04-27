import java.util.*;
class Solution {
    public int solution(int n) {
       //투포인터 문제임. 오른쪽 포인터 목표 숫자보다 작으면 계속 이동, 같아지면 cnt+1 , 커지면 왼쪽 옮기기
        int left = 0;
        int right = 0;
        int cnt=1;
        int sum1 = 0;
        ArrayList<Integer>lst = new ArrayList<>();
        for (int i=1;i<=n;i++){
            lst.add(i);
        }
        while (left<=right && right<n){
            if (sum1<n){
                sum1+=lst.get(right);
                right+=1;

            }
            else if (sum1==n){
                cnt+=1;
                sum1+=lst.get(right);
                right+=1;
            }
            else{
                sum1-=lst.get(left);
                left+=1;
            }
        }
        return cnt;
    }
}