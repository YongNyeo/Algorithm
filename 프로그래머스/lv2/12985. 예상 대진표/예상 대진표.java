import java.util.*;
class Solution
{
    public int solution(int n, int a, int b)
    {
        int x = n;
        int cnt = 0;
        while(true){
            if (x==1){
                break;
            }
            cnt+=1;
            x /=2;
        }
        //총 가능 라운드수
        // n/2 가 같다면 일단 같은쪽인거 확인. 그러면 %계산 1,3 하면 다른쪽인거 확인.
        a-=1;
        b-=1;
        while(cnt>1){
            n = n/2;
            if (a/n == b/n){
                cnt -=1;
            }
            else break;
        }
        return cnt;
    }
}