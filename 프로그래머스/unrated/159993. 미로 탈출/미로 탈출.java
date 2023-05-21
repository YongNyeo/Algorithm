import java.util.*;
class Solution {
    static boolean[][]visited;
    static int[] dx = new int[]{-1,1,0,0};
    static int[] dy = new int[]{0,0,-1,1};
    static int cnt = 0;
    static Deque<Node>q;
    public int solution(String[] map) {
        int answer = 0;
        int n = map.length;
        int m = map[0].length();
        String[][]maps = new String[n][m];
        
        visited = new boolean[n][m];
        int start_x=0;
        int start_y=0;
        int L_x=0;
        int L_y=0;
        int E_x=0;
        int E_y=0;
        for(int i=0;i<n;i++){
            maps[i] = map[i].split("");
            for (int j=0;j<m;j++){
                if (maps[i][j].equals("S")){
                    start_x = i;
                    start_y = j;
                }
                else if(maps[i][j].equals("L")){
                    L_x = i;
                    L_y = j;
                }
                else if(maps[i][j].equals("E")){
                    E_x = i;
                    E_y = j;
                }
            }
        }
        
        
        //레버까지 가기
        q = new ArrayDeque<>();
        q.offer(new Node(start_x,start_y,0));
        visited[start_x][start_y] = true;
        while(!q.isEmpty()){
            Node a = q.poll();
            int x = a.x;
            int y = a.y;
            int d = a.deep;
            if (x==L_x&&y==L_y){
                cnt = d;
                break;
            }
            for (int k=0;k<4;k++){
                int nx = x+dx[k];
                int ny = y+dy[k];
                //범위 초과X, 방문X, 벽X
                if (nx>=0&&nx<n&&ny>=0&&ny<m&&!maps[nx][ny].equals("X")&&!visited[nx][ny]){
                    q.offer(new Node(nx,ny,d+1));
                    visited[nx][ny] = true;
                }
            }
        }
        //레버 못찾음
        if (cnt==0) return -1;
        //레버에서 도착점 가기. 방문처리 초기화. cnt에 deep도 누적된상태
        q = new ArrayDeque<>();
        visited = new boolean[n][m];
        q.offer(new Node(L_x,L_y,cnt));
        int sum = 0;
        while(!q.isEmpty()){
            Node a = q.poll();
            int x = a.x;
            int y = a.y;
            int d = a.deep;
            if (x==E_x&&y==E_y){
                sum = d;
                break;
            }
            for (int k=0;k<4;k++){
                int nx = x+dx[k];
                int ny = y+dy[k];
                //범위 초과X, 방문X, 벽X
                if (nx>=0&&nx<n&&ny>=0&&ny<m&&!maps[nx][ny].equals("X")&&!visited[nx][ny]){
                    q.offer(new Node(nx,ny,d+1));
                    visited[nx][ny] = true;
                }
            }
        }
        if (sum==0) return -1;
        return sum;
       
    }
    class Node{
        int x;
        int y;
        int deep;
        Node(int x,int y,int deep){
            this.x = x;
            this.y = y;
            this.deep = deep;
        }
    }
    
}