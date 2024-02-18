import java.util.*;
class Solution {
    private int n;
    private int m;
    boolean[][] visited;
    int[]dx = new int[]{-1,1,0,0};
    int[]dy = new int[]{0,0,-1,1};
    
    public List<Integer> solution(String[] maps) {
        n = maps.length;
        m = maps[0].length();
        int[][]map = new int[n][m];
        for(int i=0;i<n;i++){
            String[]s=maps[i].split("");
            for (int j=0;j<m;j++){
                if (s[j].equals("X")) 
                    map[i][j] = 0;
                else 
                    map[i][j] = Integer.parseInt(s[j]);
            }
        }
    
        visited = new boolean[n][m];
        List<Integer>list = new ArrayList<>();
        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                if (!visited[i][j]&&map[i][j]>0){
                    list.add(bfs(map,i,j));
                }
            }
        }
        if (list.size()==0) list.add(-1);
        Collections.sort(list);
        return list;
    
    }
    public int bfs(int[][]map,int i,int j){
        
        Deque<Node> dq = new ArrayDeque<>();
        dq.add(new Node(i,j));
        int count = 0;
        while(!dq.isEmpty()){
            Node poll = dq.poll();
            if (visited[poll.x][poll.y])
                continue;
            
            visited[poll.x][poll.y] = true;
            count+=map[poll.x][poll.y];
            
            for (int k=0;k<4;k++){
                int x = dx[k]+poll.x;
                int y = dy[k]+poll.y;
                if (x>=0&&x<n&&y>=0&&y<m&&!visited[x][y]&&map[x][y]>0)
                    dq.add(new Node(x,y));
            }
        }
        return count;
        
        
    }
}
class Node{
    int x;
    int y;
    public Node(int x,int y){
        this.x = x;
        this.y = y;
    }
}