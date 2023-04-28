class Solution {
    //카펫 가로>=세로
    // 브라운 = 2x+2y , 옐로 = (x-2)*y == xy-2y 
    // x+y = 24.  (12-x)*(x-2)=yellow
    int a= 0;
    public int[] solution(int brown, int yellow) {
        for (int x=1;x<2500;x++){
            if (((brown/2)-x)*(x-2)==yellow){
                a = x;
                break;
            }        
        }
        int b = (brown/2)-a;
        
        int[] answer = {b+2,a};
        
        return answer;
    }
}