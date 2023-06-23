
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        for (int i = 0; i < n; i++) {
            boolean[] visited = new boolean[10000];
            String[] s = bf.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            //a->b가 되는 최소의경우 -->bfs ?

            Deque<Node> deque = new ArrayDeque<>();
            deque.add(new Node(a,new StringBuilder()));
            visited[a] = true;
            while (!deque.isEmpty()) {
                Node p = deque.poll();
                int number = p.num;
                if (number == b) {
                    System.out.println(p.depth.toString());
                    break;
                }

                int num1 = (2*number)%10000;
                if (!visited[num1]) {
                    visited[num1] = true;
                    deque.add(new Node(num1, new StringBuilder(p.depth+"D")));
                }

                int num2 = (number == 0) ? 9999 : number - 1;
                if (!visited[num2]) {
                    visited[num2] = true;

                    deque.add(new Node(num2, new StringBuilder(p.depth+"S")));
                }

                int num3 = (number%1000)*10 + number/1000;
                if (!visited[num3]) {
                    visited[num3] = true;

                    deque.add(new Node(num3,new StringBuilder(p.depth+"L")));
                }

                int num4 = (number % 10 * 1000) + number / 10;
                if (!visited[num4]) {
                    visited[num4] = true;

                    deque.add(new Node(num4,new StringBuilder(p.depth+"R")));
                }

            }

        }

    }
    public static class Node{
        int num;
        StringBuilder depth;

        public Node(int num, StringBuilder depth) {
            this.num = num;
            this.depth = depth;
        }
    }


}
