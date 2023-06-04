import java.util.*;
class Solution {
    public List<String>solution(String[][] plans) {
        // stack 활용하기(stack에는 과목명 넣기)
        // map에 과목명:시간 넣어서 남은시간은 수시로 변경
        //우선 시간별로 정렬시켜야한다.
        Stack<Node>stack = new Stack<>();
        //진행방식은 다음 과목이 시작하기 전까지 현재과목의 시간을 감소시켜야함. 시간이 남는경우도!
        List<String>answer = new ArrayList<>();
        
        Arrays.sort(plans,new Comparator<String[]>(){
            @Override
            public int compare(String[] o1, String[] o2) {
                String[] t1 = o1[1].split(":");
                String[] t2 = o2[1].split(":");
                String a = t1[0]+t1[1];
                String b = t2[0]+t2[1];
                if (Integer.parseInt(a)>Integer.parseInt(b)){
                    return 1;
                }
                else return -1;
            }
        });
       //정렬 끝
        for (int i=0;i<plans.length-1;i++){
            int t1 = TC(plans[i][1]);
            int t2 = TC(plans[i+1][1]);
            int plus = Integer.parseInt(plans[i][2]);
           
            // 다음것까지 시간이 부족할때는 현재거 시간 차감해서 넣어주기
            if (t1+plus>t2){
                stack.push(new Node(plans[i][0],plus-(t2-t1)));
                System.out.println(plans[i][0]);
                continue;
            }
            //현재작업을 다음 작업시간내에 할수있으면 다음차례로가기!
            else if(t1+plus==t2){
                answer.add(plans[i][0]);}
            //만약 작업 끝내고 시간이 남는다면.
            else {
                int k = t1+plus; //현재 시간 바꾸기
                answer.add(plans[i][0]);
                while(true){
                    if (stack.isEmpty()) break;
                    Node a = stack.pop();
                    //시간초과
                    if (k+a.time>t2){
                        //뺏던거 다시 넣어야됨
                        stack.push(new Node(a.name,a.time-(t2-k)));
                        break;
                    }
                    //이번작업만 딱 끝낼수있음
                    else if (k+a.time==t2){    
                        answer.add(a.name);
                        break;
                    }
                    //작업끝내고 시간남음
                    else {
                        k = k+a.time;
                        answer.add(a.name);
                         }
                }
            }
        }
        int n = plans.length;
        stack.push(new Node(plans[n-1][0],Integer.parseInt(plans[n-1][2])));
        while(!stack.isEmpty()){
            Node as = stack.pop();
            answer.add(as.name);
        }
        
        return answer;
    }
    public int TC(String t){
        String[] s = t.split(":");
        return (Integer.parseInt(s[0])*60)+(Integer.parseInt(s[1]));
    }

    public class Node{
        private String name;
        private int time;
        
        public Node(String name,int time){
            this.name =name;
            this.time = time;
        }
    }
}