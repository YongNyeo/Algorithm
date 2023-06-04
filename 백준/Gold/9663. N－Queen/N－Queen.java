
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

class Main {
    static int[]arr;
    static int n;
    static int cnt=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];


        dfs(1);
        System.out.println(cnt);
    }


    public static void dfs(int idx) {
        if (idx > n) {
            cnt++;
            return;
        }
        for (int i = 1; i <= n; i++) {
            // 검증 로직
            boolean challenge=true;
            int left_i = i;
            int right_i = i;
            //아래행부터 윗행으로 올라가기
            for (int j = idx-1; j > 0; j--) {
                left_i--;
                right_i++;
                // 같은 열에 수가 없는지
                if (arr[j] == i) {
                    challenge = false;
                    break;
                }
                // 대각선 라인에 수가 없는지 (좌,우따로)
                if (left_i > 0 && arr[j] == left_i) {
                    challenge=false;
                    break;
                }
                if (right_i <= n && arr[j] == right_i) {
                    challenge=false;
                    break;
                }

            }
            if (challenge) {
                arr[idx] = i;
                dfs(idx+1);
            }
        }
    }
}
