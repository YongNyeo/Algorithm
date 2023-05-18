class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[]{0,1000001};
        int start = 0;
        int end = 0;
        int sum = sequence[start];
        while(start<=end){
            //같다면 end무조건 올려줘야함
            if (sum<k){
                end+=1;
                if (end==sequence.length)break;
                sum+=sequence[end];
                
            }
            else if (sum>k){
                sum-=sequence[start];
                start+=1;
            }
            else{ //같으면
                if(answer[1]-answer[0]>end-start){
                    answer[0] = start;
                    answer[1] = end;
                    end+=1;
                    if (end==sequence.length)break;
                    sum+=sequence[end];
                }
                else {
                    end+=1; 
                    if (end==sequence.length)break;
                    sum+=sequence[end];}
            }
          
        }
        return answer;
    }
}