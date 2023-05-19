import java.util.*;
class Solution {
    public int solution(String[][] book_time) {
        int cnt=0;
        PriorityQueue<Integer>room = new PriorityQueue<>();
        List<List<Integer>>wait = new ArrayList<>();
        
        for (String[] book:book_time){
            wait.add(time_change(book));
        }
        Collections.sort(wait,(w1,w2)->{
            if (w1.get(0)>w2.get(0)) return 1;
            else if (w1.get(0)<w2.get(0)) return -1;
            else {
                if (w1.get(1)>w2.get(1)) 
                    return 1;
                else return -1;}       
        });
        for (int i=0;i<wait.size();i++){
            if (room.isEmpty()){
                room.add(wait.get(i).get(1));
                cnt+=1;
                continue;
            }
            if (room.peek()+10<=wait.get(i).get(0)){
                room.poll();
                room.add(wait.get(i).get(1));
            }
            else {
                room.add(wait.get(i).get(1));
                cnt+=1;
            }
        }
        
        return cnt;
    }
    
    
    public List<Integer> time_change(String[] time){
        String[]t1 =time[0].split(":");
        int a1 = Integer.parseInt(t1[0])*60+Integer.parseInt(t1[1]);
        String[]t2 =time[1].split(":");
        int a2 = Integer.parseInt(t2[0])*60+Integer.parseInt(t2[1]);
        List<Integer>answer = new ArrayList<>();
        answer.add(a1);
        answer.add(a2);
        return answer;
    }
}