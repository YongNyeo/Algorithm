import java.util.*;
class Solution {
    public List<Integer> solution(int rows, int columns, int[][] queries) {
        List<Integer>lst = new ArrayList<>();
        int idx=1;
        int [][]map = new int[rows][columns];
        for (int i=0;i<rows;i++){
            for (int j=0;j<columns;j++){
                map[i][j]= idx++;
            }
        }
        
        for (int[] q:queries){
        //각 쿼리별로 사각형 네 변을 도는 연산을 할것임
            int sx = q[0]-1 ; int sy = q[1]-1;
            int ex = q[2]-1 ; int ey = q[3]-1;
            int start = map[sx][ey]; //맨오른쪽 맨위는 저장해주기
            int min = start;
            for (int i= ey;i>sy;i--){
                map[sx][i] = map[sx][i-1]; 
                min = Math.min(min,map[sx][i]);
                
            }
            for(int i=sx;i<ex;i++){
                map[i][sy] = map[i+1][sy];
                min = Math.min(min,map[i][sy]);
            }
            for (int i= sy;i<ey;i++){
                map[ex][i] = map[ex][i+1];
                min = Math.min(min,map[ex][i] );
                
            }
            for (int i=ex;i>sx;i--){
                map[i][ey] = map[i-1][ey];
                min = Math.min(min,map[i][ey]);
            }
            map[sx+1][ey] = start;
            
            lst.add(min);
        }
        return lst;
    }
}