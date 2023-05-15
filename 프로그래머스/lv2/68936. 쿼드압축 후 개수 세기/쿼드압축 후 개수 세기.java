class Solution {
    static int one_cnt=0;
    static int zero_cnt=0;
    
    public int[] solution(int[][] arr) {
        dfs(arr,0,0,arr.length);
        int[] answer = new int[]{zero_cnt,one_cnt};
        return answer;
    }
    public void dfs(int[][]arr,int x,int y,int n){
        int sum=0;
        for(int i=x;i<x+n;i++){
            for (int j=y;j<y+n;j++){
                sum+=arr[i][j];
            }
        }
        if (sum==n*n){
            one_cnt+=1;
            return;
        }
        else if(sum==0){ 
            zero_cnt+=1;
            return;
        }
        else{
            dfs(arr,x,y,n/2);
            dfs(arr,x+(n/2),y,n/2); 
            dfs(arr,x,y+(n/2),n/2);
            dfs(arr,x+(n/2),y+(n/2),n/2);
        }
    }
}