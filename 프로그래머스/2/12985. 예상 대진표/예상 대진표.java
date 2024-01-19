import java.util.*;
class Solution
{
    public int solution(int n, int a, int b)
    {
        //들어오는 n만큼의 대진을 만들어야함
        //n은 항상 2의 제곱으로 부전승X
        //계속 나눠서(i+=1) 1이 되는 순간의 i값
        int cnt = 0;
        while(a!=b){
            a = (a+1)/2;
            b = (b+1)/2;
            cnt+=1;
        }
        
        return cnt;
    }
}