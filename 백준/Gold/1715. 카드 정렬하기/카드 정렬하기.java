
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int sum=0;
        if (n == 1) {
            System.out.println(sum);
            return;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }
        while (true) {
            int num1 = pq.poll();
            int num2 = pq.poll();
            int k =  (num1 + num2);
            sum+=k;
            if (pq.isEmpty()) {
                break;
            }
            pq.add(k);
        }
        System.out.println(sum);

    }
}
