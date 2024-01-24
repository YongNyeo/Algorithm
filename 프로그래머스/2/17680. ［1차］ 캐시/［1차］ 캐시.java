
import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        int time = 0;
        List<String>cache = new LinkedList<>();
        if (cacheSize==0) return cities.length*5;
        for (int i=0;i<cities.length;i++){
            String s = cities[i].toUpperCase();
            if (cache.remove(s)){
                time+=1;
                cache.add(s);
            }else {
                time+=5;
                if (cacheSize<=cache.size())
                    cache.remove(0);
                cache.add(s);
            }
        }
  
        return time;
    }
}