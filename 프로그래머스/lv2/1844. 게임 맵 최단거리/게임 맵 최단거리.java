import java.util.*;
class Solution {
    public int solution(int[][] maps) {
        return bfs(maps);
        }
    public int bfs(int[][]maps){
        int n = maps.length;
        int m = maps[0].length;
        boolean [][]visited = new boolean[n][m];
        // System.out.println(visited[0][0]);
        int []x = new int[] {-1,1,0,0};
        int []y = new int[] {0,0,-1,1};
        Deque<Node>queue = new ArrayDeque<>();
        queue.add(new Node(0,0,1));
        visited[0][0] = true;
        while (!queue.isEmpty()){
            Node node = queue.poll();
            int a = node.getX();
            int b = node.getY();
            int idx = node.getIdx();
            if (a==n-1&&b==m-1) return idx;
            for (int i=0;i<4;i++){
                int nx = a+x[i];
                int ny = b+y[i];
                if (nx>=0&&nx<n&&ny>=0&&ny<m&& visited[nx][ny]==false&& maps[nx][ny]==1){
                    visited[nx][ny] = true;
                    queue.add(new Node(nx,ny,idx+1));
                }
            }
        }
        return -1;
    }
    class Node{
        public int x;
        public int y;
        public int idx;
        
        public  Node(int x,int y,int idx){
            this.x = x;
            this.y = y;
            this.idx = idx;
        }
        int getX(){
            return this.x;
        }
        int getY(){
            return this.y;
        }
        int getIdx(){
            return this.idx;
        }
    }
}