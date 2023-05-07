import java.util.*;
class Solution {
    public List<Integer>solution(int[] fees, String[] records) {
        
        //차량별 누적 시간을 Map에 저장하기.
        Map<String,Integer>map = new HashMap<>();
        //모든 차량의 입,출차 시간을 관리하는 map
        Map<String,Integer>time = new HashMap<>();
        for (String record : records){
            String [] s = record.split(" ");
            if (s[2].equals("IN")){
                
                //시간 변환해서 입차시간 저장해놓기
                time.put(s[1],timeChange(s[0]));
                
            }
            else if(s[2].equals("OUT")){
                //출차시간-입차시간(출차처리 하며 정산)
                int outt = timeChange(s[0]);
                int inn = time.get(s[1]);
                //map에 있다면,
                if (map.containsKey(s[1])){
                    map.put(s[1],map.get(s[1])+outt-inn);
                }else{
                    map.put(s[1],outt-inn);
                }
                time.remove(s[1]);
            }
        }
        //다 돌고 출차 안한 차량 처리하기
        for(String w : time.keySet()){
            int outt = timeChange("23:59");
            int inn = time.get(w);
            //map에 있다면,
            if (map.containsKey(w)){
                map.put(w,map.get(w)+outt-inn);
            }else{
                map.put(w,outt-inn);
            }
        }
        List<String>lst = new ArrayList<>(map.keySet());
        Collections.sort(lst);
        List<Integer>answer = new ArrayList<>();
        for(String l : lst){
            int myT = map.get(l);
            
            if (myT<=fees[0]){
                answer.add(fees[1]);
                continue;
            }
            int all = fees[1]+(int)(Math.ceil((myT-fees[0])/(double)fees[2]))*fees[3];
            answer.add(all);
        }
        
        
        return answer;
    }
    public int timeChange(String k){
        String []a = k.split(":");
        return (Integer.parseInt(a[0])*60)+(Integer.parseInt(a[1]));
    }
}