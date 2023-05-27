import java.util.*;
class Solution {
    public double[] solution(int k, int[][] ranges) {
        //k를 이용해서 도착 x값 구하기
        double[] answer = new double[ranges.length];
        //10억이라는 숫자 1로 만드는데 200이상 안넘는다?
        int tmp = k;
        int cnt=0;
        List<Integer>lst = new ArrayList<>();
        lst.add(k);
        //x좌표별 y값저장
        while(tmp!=1){
            if(tmp%2==0) tmp/=2;
            else tmp = tmp*3+1;
            cnt++;
            lst.add(tmp);
        }
        //x좌표별 1칸마다의 정적분값
        double []dp = new double[lst.size()];
        for (int i=1;i<=cnt;i++){
            dp[i] = ((double)(lst.get(i)+lst.get(i-1))/2);
        }        
        
        //정적분 결과
        int w=0;
        for (int[] range: ranges){
            int a = range[0];
            int b = cnt+range[1];
            if (a>b) answer[w] = -1.0;
            else if (a==b) answer[w] =  0.0;
            else{
                double sum=0;
                for (int c = b;c>a;c--){
                    sum+=dp[c];
                }
                answer[w] = sum;
            }
            w++;
        }
        
        
        
        
        
        return answer;
        
        
        
    }
}