
import java.io.*;

import java.util.*;

class Main {

    static int n, m, k;
    static String[][] map;
    static int[] dx = {1, -1, 0, 0}; //남북서동
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        StringTokenizer st = new StringTokenizer(br.readLine());
        int test = Integer.parseInt(st.nextToken());
        for (int t = 0; t < test; t++) {
            StringTokenizer s1 = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(s1.nextToken());
            TreeMap<Integer,Integer>treeMap = new TreeMap<>();
            for (int i = 0; i < n; i++) {
                StringTokenizer s = new StringTokenizer(br.readLine());
                String dir = s.nextToken();
                int k = Integer.parseInt(s.nextToken());
                if (dir.equals("I")) {
                    treeMap.put(k,treeMap.getOrDefault(k,0)+1);
                } else {
                    if (k == 1) { //최대값
                        if (treeMap.isEmpty()) {
                            continue;
                        }
                        int last = treeMap.lastKey();
                        if (treeMap.get(last) == 1) {
                            treeMap.remove(last);
                        }else treeMap.put(last,treeMap.get(last)-1);
                    } else { //최소값
                        if (treeMap.isEmpty()) {
                            continue;
                        }
                        int first = treeMap.firstKey();
                        if (treeMap.get(first) == 1) {
                            treeMap.remove(first);
                        } else {
                            treeMap.put(first, treeMap.get(first)-1);
                        }
                    }
                }
            }
            if (treeMap.isEmpty()) {
                bw.write("EMPTY");
                bw.newLine();
            } else {
                bw.write(treeMap.lastKey() + " " + treeMap.firstKey());
                bw.newLine();
            }
        }
        bw.flush();
        bw.close();
        //pq는 기본적으로 작은수(우선순위가 높음)먼저 뽑는다. 따라서 큰 숫자를 뽑을수있는(-를 붙인)pq를 만든다.
        //1이 나오면 가짜 pq에서 가장 낮은것*-1 을뽑기. 후 진짜pq에서 해당 숫자 삭제하기
    }
}
