import java.util.*;
class Solution {
    public List<Integer>solution(int[] progresses, int[] speeds) {
        List<Integer>lst = new ArrayList<>();
        int mn = (int)Math.ceil((double)(100-progresses[0])/speeds[0]);
        int n = progresses.length;
        // 5 , 10 , 1(10일),1(10일),20,1(20일)
        int cnt=1;
        for (int i=1;i<n;i++){
            //뒤가 더크면 배포
            if ((int)Math.ceil((double)(100-progresses[i])/speeds[i])>mn){
                lst.add(cnt);
                cnt=1;
                mn = (int)Math.ceil((double)(100-progresses[i])/speeds[i]);
            }
            //작으면 앞에것과 같이 감
            else{
                cnt+=1;
            }
        }
        lst.add(cnt);
        return lst;
    }
}
//progresses = [1, 1, 1, 1]
//speeds = [100, 50, 99, 100]

