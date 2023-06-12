import java.util.*;
class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        int n = targets.length;
        boolean []visited = new boolean[n];
        Arrays.sort(targets,(o1,o2)->o1[1]-o2[1]);        

        for (int i=0;i<n;i++){
            if (!visited[i]){
                visited[i] = true;
                answer++;
                System.out.println(i);
                for(int j=i+1;j<n;j++){
                    if (targets[i][1]>targets[j][0]){
                        visited[j]=true;
                    }
                    else break;
                }
            }
        }
        return answer;
        
    }
}