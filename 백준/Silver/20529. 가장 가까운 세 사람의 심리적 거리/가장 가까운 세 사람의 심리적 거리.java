
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
            StringTokenizer s2 = new StringTokenizer(br.readLine());
            String[] s = new String[n];
            for (int i = 0; i < n; i++) {
                s[i] = s2.nextToken();
            }
            if (n > 256) {
                System.out.println(0);
            } else {
                int min = Integer.MAX_VALUE;
                for (int i = 0; i < n; i++) { //숫자1
                    for (int j = i+1; j < n; j++) { //숫자2
                        for (int k = j + 1; k < n; k++) { //숫자3
                            int num=0;
                            for (int w = 0; w < 4; w++) { //4글자 체크
                                if (s[i].charAt(w) != s[j].charAt(w)) {
                                    num++;
                                }
                                if (s[i].charAt(w) != s[k].charAt(w)) {
                                    num++;
                                }if (s[j].charAt(w) != s[k].charAt(w)) {
                                    num++;
                                }
                            }
                            min = Math.min(min,num);
                        }
                    }
                }
                System.out.println(min);
            }
        }
    }
}
