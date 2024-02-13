class Solution {
    private static int min = 100_000_001;
    public int solution(int storey) {
        int sum = 0;
        while(storey>0){
            int k = storey%10;
            storey/=10;
            
            if (k==5){
                if (storey%10>=5){ //반올림될 수 생각하기
                    sum+=(10-k);
                    storey++;
                }
                else sum+=k;
            }
            else if (k>5){
                sum+=(10-k);
                storey++;
            }else sum+=k;
        }
        return sum;

    }
}