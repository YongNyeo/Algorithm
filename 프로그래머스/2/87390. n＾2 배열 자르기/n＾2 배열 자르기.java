import java.lang.Math.*;
class Solution {
    public int[] solution(int n, long left, long right) {
        int k =(int)(right-left);
        int[] answer = new int[k+1];
        //n = 3일때
        
//         1행 1 2 3 4
//         2행 2 2 3 4
//         3행 3 3 3 4
//         4행 4 4 4 4 
            
        for (long i=left;i<=right;i++){
            // i값의 규칙을 찾아서 무슨값이 있었을지 예측하기
            long h = i/n ; //행
            long w = i%n ; //열
            answer[(int)(i-left)] = (int)(Math.max(h,w)+1);
        }
        return answer;
    }
}