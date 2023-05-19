import java.util.*;
class Solution {
    public long solution(int k, int d) {
        long cnt = 0;
        for (int i=0;i<=d;i+=k){
            int y = (int)Math.sqrt(Math.pow(d,2)-Math.pow(i,2));
            cnt += (long)y/k;
            cnt+=1; //y가 0인경우는 위에 더하기로 계산안되므로 1더 더해야함
        }
        return cnt;
        
    }
}
// (0,0)은 a=0, b=0.  Math.sqrt(x^2+y^2) <=d 인 경우만 cnt+=1
// 그냥 a==b에만 -1 해주고 나머지는 a,b 역의 경우 전부 더해주면 될듯