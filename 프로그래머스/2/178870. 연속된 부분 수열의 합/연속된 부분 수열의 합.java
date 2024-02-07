class Solution {
    //합이 k고, 길이가 짧고 , 앞쪽인 경우
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int left=0;
        int right=0;
        int min_length = 1_000_001;
        int sum=sequence[right];
        while(left<=right){
            if (sum<k){
                right++;
                if (right==sequence.length) break; //sum도 부족한데 right가 끝이라면 끝내도 무관
                sum+= sequence[right];
            }
            else if (sum>k){
                sum-=sequence[left];
                left++;
            }
            else {
                if (right-left+1<min_length){
                    answer[0] = left;
                    answer[1] = right;
                    min_length = right-left+1;
                }
                right++;
                if (right==sequence.length) break; 
                sum += sequence[right];                
                    
            }
        }

        return answer;
    }
}