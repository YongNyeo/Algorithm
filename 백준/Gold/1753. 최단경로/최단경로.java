import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int INF = Integer.MAX_VALUE;
        String[] s = bf.readLine().split(" ");
        int v = Integer.parseInt(s[0]);
        int e = Integer.parseInt(s[1]);
        int[] distance = new int[v + 1];
        Arrays.fill(distance, INF);
        ArrayList<Node>[] graph = new ArrayList[v + 1];
        for (int i = 0; i < graph.length; i++) graph[i] = new ArrayList<>();
        String s1 = bf.readLine();
        int start = Integer.parseInt(s1);
        for (int i = 0; i < e; i++) {
            String[] s2 = bf.readLine().split(" ");
            int a = Integer.parseInt(s2[0]);
            int b = Integer.parseInt(s2[1]);
            int w = Integer.parseInt(s2[2]);
            graph[a].add(new Node(b, w));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.weight, o2.weight));
        pq.add(new Node(start, 0));
        distance[start] = 0;
        while (!pq.isEmpty()) {
            Node x = pq.poll();
            if (distance[x.num]<x.weight) continue;

            for (Node k : graph[x.num]) {
                if (distance[k.num] > distance[x.num] + k.weight) {
                    distance[k.num] = distance[x.num] + k.weight;
                    pq.offer(new Node(k.num, distance[k.num]));
                }
            }
        }
        for (int i = 1; i <= v; i++) {
            if (distance[i] == INF) {
                System.out.println("INF");
            } else System.out.println(distance[i]);
        }

    }

    public static class Node {
        private int num;
        private int weight;

        public Node(int num, int weight) {
            this.num = num;
            this.weight = weight;
        }
    }
}
