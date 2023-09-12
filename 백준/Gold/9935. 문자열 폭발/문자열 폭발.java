import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
        String all = br.readLine();
        String find = br.readLine();


        /**
         * mirkovC4nizCC44
         * C4
         */

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < all.length(); i++) {
            stack.push(all.charAt(i));
            boolean success = true;
            if (stack.size() >= find.length()) { //스택의 크기와 찾는 문자열의 크기가 같다면

                //스택 위에서부터 내가 찾는 글자와 같은지 확인하기
                for (int k = 1;k<=find.length();k++) {
                    if (find.charAt(find.length()-k) != stack.get(stack.size() - k)) {

                        success = false;
                        break;
                    }
                }

                if (success) { //성공시엔 글자가 모두 같은것=> 스택에 글자 모두 빼주기
                    for (int j = 0; j < find.length(); j++) {
                        stack.pop();
                    }
                } //실패시엔 그대로 둬야함
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < stack.size(); i++) {
            sb.append(stack.get(i));
        }

        System.out.println(stack.isEmpty()?"FRULA":sb);
    }


}
