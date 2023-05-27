
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;


public class Main {

    //k번의 회전을 해야하는데, 회전을 어떤 순서대로 시키느냐에 따라 배열의 최대값이 바뀔수 있음
    //dfs로 회전을 하는게 맞을듯. 회전연산때문에 백트래킹은 어렵다.
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int r1 = Integer.parseInt(st.nextToken());
        int c1 = Integer.parseInt(st.nextToken());
        int r2 = Integer.parseInt(st.nextToken());
        int c2 = Integer.parseInt(st.nextToken());
        int[][]map = new int[r2-r1+1][c2-c1+1];
        int[][] dir = new int[][]{{0,1},{-1,0},{0,-1},{1,0}};
        int wCnt = 0,x=0,y=0,cnt=0,dCnt=1,d=0,num=1;

        while(true){
            //배열 다채웠을때,
            if (wCnt>= ((r2 - r1 + 1) * (c2 - c1 + 1))) {
                break;
            }
            //내가 구하는 범위 안에 들어갈때는 값 넣어주기
            if (x <= r2 && x >= r1 && y <= c2 && y >= c1) {
                map[x-r1][y-c1] = num;
                wCnt++;
            }
            num++;
            cnt++;
            x = x + dir[d][0];
            y = y + dir[d][1];
            //해당 방향으로 채워야할 갯수 다 넣었을때는 방향 꺾기
            if (dCnt == cnt) {
                cnt=0;
                if (d == 1 || d == 3) {
                    dCnt++;
                }
                d = (d+1)%4;
            }
        }

        //출력하기
        //숫자마다 길이가 다른걸 고려해서, 제일 긴 숫자를 기준으로 공백 채우기
        int stand = (int)(Math.log10(num)+1);
        for (int i = 0; i < r2 - r1 + 1; i++) {
            for (int j = 0; j < c2 - c1 + 1; j++) {
                int k = (int)(Math.log10(map[i][j])+1);
                for (int q = 0; q < stand - k; q++) {
                    System.out.print(" ");
                }
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }

    }


}

