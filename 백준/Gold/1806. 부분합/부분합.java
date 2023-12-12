
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    private static int n, m;

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        StringTokenizer s = new StringTokenizer(br.readLine());

        int[] num = new int[n+1];

        for (int i = 1; i <= n; i++) {
            num[i] = Integer.parseInt(s.nextToken());
        }
        int left=0,right=0;

        int sum = 0;
        int min = 100_000_000;
        int cnt = 0;
        while (left<=right) {
            if (sum < m) {
                if (right!=n){ //right는 오른쪽 끝에 가면 더이상 오르면 안됨. 값이 부족한데 오른쪽 끝에 도착하면 걍 끝내도 되는거아님?
                    right++;
                    sum += num[right];
                    cnt++;
                }else break;

            } else { //값이 넘치는 상황
                min = Math.min(min,cnt);
                cnt -=1;
                left++;
                sum -= num[left];
            }
        }

        if (min == 100_000_000) {
            System.out.println(0);
        } else System.out.println(min);

    }

}
