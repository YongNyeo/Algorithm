class Solution {
    static int cnt=0;
    static int n ;
    static int[]arr;
    public int solution(int fin) {
       
        n = fin;
        arr = new int[n];
        
        dfs(0);
        return cnt;
    }
    public void dfs(int x){
        if (x==n){
            cnt++;
            return;
        }
        for (int i=0;i<n;i++){
            arr[x] = i;
            boolean a = true;
            for (int j=0;j<x;j++){
                
                //같은 열에 있는 경우
                if (arr[j]==arr[x]){
                    a = false;
                    break;
                }
                //대각선에 있는 경우
                if (Math.abs(arr[x]-arr[j])==(Math.abs(x-j))){
                    a = false;
                    break;
                }
            }
            if (a) dfs(x+1);
            
        }
    }
}








