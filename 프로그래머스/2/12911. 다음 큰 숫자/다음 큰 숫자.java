class Solution {
    public int solution(int n) {
        
        int sum =  Integer.bitCount(n);
        
        while(true){
            n+=1;
            int k = Integer.bitCount(n);
            if (k==sum) break;
        }
        return n;
           
    }
}