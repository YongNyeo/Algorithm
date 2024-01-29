import java.util.*;
class Solution {
    private static int[] dx;
    private static int[] dy;
    public int solution(int[][] maps) {
        dx = new int[]{-1,1,0,0};
        dy = new int[]{0,0,-1,1};
        int n = maps.length;
        int m = maps[0].length;
        Deque<Node>dq = new ArrayDeque<>();
        dq.add(new Node(0,0,1));
        boolean[][]visited = new boolean[n][m];
        
        while(!dq.isEmpty()){
            Node poll = dq.poll();
            if (poll.x==n-1&&poll.y==m-1)
                return poll.dist;
            
            if (visited[poll.x][poll.y])
                continue;
            
            visited[poll.x][poll.y] = true;
            
            for (int i=0;i<4;i++){
                int nx = poll.x+dx[i];
                int ny = poll.y+dy[i];
                
                if (nx>=0&&nx<n&&ny>=0&&ny<m&&!visited[nx][ny]&&maps[nx][ny]!=0)
                    dq.add(new Node(nx,ny,poll.dist+1));
            }
        }
        return -1;
    
    }
    
}
class Node{
    int x;
    int y;
    int dist;
    public Node(int x,int y,int dist){
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
}