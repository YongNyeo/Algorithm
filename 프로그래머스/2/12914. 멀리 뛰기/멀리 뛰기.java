class Solution {
    public long solution(int n) {
        long []list = new long[n+1];
        list[1] = 1;
        if (n!=1) list[2] = 2;
        for (int i=3;i<=n;i++){
            list[i] = (list[i-1]+list[i-2])%1234567;
        }    
        return list[n];
    }
}