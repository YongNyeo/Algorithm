class Solution {
    static char[][]map;
    public int solution(String[] board) {
        map = new char[3][3];
        //게임상황이  error = 0 ,not error=1
        int answer1 = 0;
        int answer2 = 0;
        int cnt1 = 0;
        int cnt2 = 0;
        for(int i=0;i<3;i++){
            for (int j=0;j<3;j++){
                map[i][j] = board[i].charAt(j);
                if (map[i][j]=='O'){
                    cnt1++;
                }else if(map[i][j]=='X') cnt2++;
            }
        }
        
        //개수 짝이 안맞는경우
        if (cnt2>cnt1||cnt1-cnt2>1) return 0;
        
        //둘다 이긴경우
        if (win('O')>0&&win('X')>0) return 0;
        
        //이겼는데 개수가 같은경우 
        if (win('O')>0){
            if (cnt1==cnt2){
                return 0;
            }
        }
        
        if (win('X')>0){
            if (cnt1>cnt2) return 0;
        }
        
        return 1;
    }

  public int win(char c) {
        int game = 0;
        for(int i = 0; i < 3; i++)
        {
            if(map[i][0] == c && map[i][0] == map[i][1] && map[i][1] == map[i][2])
                game++;
            if(map[0][i] == c && map[0][i] == map[1][i] && map[1][i] == map[2][i])
                game++;
        }
        if(map[0][0] == c && map[0][0] == map[1][1] && map[1][1] == map[2][2])
            game++;
        if(map[0][2] == c && map[0][2] == map[1][1] && map[1][1] == map[2][0])
            game++;
        return game;
    }
}