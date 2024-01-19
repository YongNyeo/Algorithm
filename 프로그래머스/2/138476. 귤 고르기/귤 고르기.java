import java.util.*;
class Solution {
    // 1 2 2 3 3 4 5 5
    public int solution(int k, int[] tangerine) {
        //최대한 종류가 적어야한다. 개수 10만  n또는 n로그n
        PriorityQueue<G>pq = new PriorityQueue<>();
        
        int min = 987654321;
        Map<Integer,Integer>map = new HashMap<>();
        for (int i=0;i<tangerine.length;i++){
            if (map.containsKey(tangerine[i])){
                map.put(tangerine[i],map.get(tangerine[i])+1);
            }else map.put(tangerine[i],1);
        }
        for (Integer a : map.keySet()){
            pq.add(new G(a,map.get(a)));
        }
        int sum = 0;
        int cc = 0;
        while(!pq.isEmpty()){
            G g = pq.poll();
            sum+=g.cnt;
            cc++;
        
            if (sum>=k) break;
        }
        
        return cc;
   }
}
class G implements Comparable<G>{
    int num;
    int cnt;
    @Override
    public int compareTo(G g){
        return g.cnt-this.cnt;
    }
    public G(int n,int c){
        this.num = n;
        this.cnt = c;
    }
}