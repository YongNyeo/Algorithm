class Solution {
    // 방문했던 길을 어떻게 판단할 것이냐? 각 좌표별로 상하좌우 나눠서 ㄱ
    private static boolean[][][]visited ;
    public int solution(String dirs) {
        int answer = 0;
        String[]list = dirs.split("");
        int n = list.length;
        visited = new boolean[11][11][4]; // 0(U) , 1(R),2(D),3(L)
        int x = 5;
        int y = 5;
        int sum = 0;
        for (int i=0;i<n;i++){
            String s = list[i];
            
            if (s.equals("U")){ 
                if (x+1<=10){
                    x+=1;
                    if (!visited[x-1][y][0]){
                        sum++;
                        visited[x-1][y][0] = true;
                        visited[x][y][2] = true;
                    }
                }
            }
            else if (s.equals("R")){
                   if (y+1<=10){
                    y+=1;
                    if (!visited[x][y-1][1]){
                        sum++;
                        visited[x][y-1][1] = true;
                        visited[x][y][3] = true;
                    }
                }
            }
            else if (s.equals("D")){
                  if (x-1>=0){
                    x-=1;
                    if (!visited[x+1][y][2]){
                        sum++;
                        visited[x][y][0] = true;
                        visited[x+1][y][2] = true;
                    }
                }
            }
            else 
            {
                if (y-1>=0){
                    y-=1;
                    if (!visited[x][y+1][3]){
                        sum++;
                        visited[x][y+1][3] = true;
                        visited[x][y][1] = true;
                        
                    }
                }
            }
        }
        return sum;
    }
}