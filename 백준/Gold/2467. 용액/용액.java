
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    /**
     * 5
     * -99 -2 -1 4 98
     */
    private static int n;

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        StringTokenizer s = new StringTokenizer(br.readLine());

        int[] num = new int[n];

        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(s.nextToken());
        }
        int left = 0;
        int right = n - 1;
        int min_left = 0;
        int min_right = 0;
        Long min = Long.MAX_VALUE;
        while (left < right) {
            long sum = num[left] + num[right];
            if (min > Math.abs(sum)) {
                min = Math.abs(sum);
                min_left = left;
                min_right = right;
            }
            if (sum > 0) {
                right--;
            } else left++;
        }
        System.out.println(num[min_left] + " " + num[min_right]);

    }

    private static boolean isNearZero(int a, int b) {
        if (Math.abs(0 + a) > Math.abs(0 + b)) {
            return true;
        }
        return false;
    }
}