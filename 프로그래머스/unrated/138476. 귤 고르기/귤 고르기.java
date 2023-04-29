import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        //중복이 많이 되는 순서대로 뽑으면 됨.
        // nLog(n)이나 n 번 안에 해야함
        Map<Integer,Integer>map = new HashMap<>();
        for (int t : tangerine){
            if (map.containsKey(t)==false){
                map.put(t,1);
            }
            else{
                map.put(t,map.get(t)+1);
            }
        }
        List<Integer> keySetList = new ArrayList<>(map .values());
        Collections.sort(keySetList,Collections.reverseOrder());
        Integer sum1 = 0;
        int cnt=0;
        System.out.print(keySetList.get(0));
        for (Integer e : keySetList){
            if (k>sum1){
                sum1+=e;
                cnt+=1;
            }
            else break;
        }


        return cnt;
    }
}