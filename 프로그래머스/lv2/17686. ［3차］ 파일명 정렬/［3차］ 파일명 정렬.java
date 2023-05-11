import java.util.*;
class Solution {
    public static String[] solution(String[] files) {
        Arrays.sort(files, (o1, o2) -> {

            String[] part1 = modPart(o1);
            String[] part2 = modPart(o2);

            int headComparing = part1[0].compareTo(part2[0]);
            int numberComparing = Integer.parseInt(part1[1]) - Integer.parseInt(part2[1]);

            if (headComparing == 0) {
                if (numberComparing == 0) {
                    return 0;
                }
                return numberComparing;
            }
            return headComparing;
        });

        return files;
    }

    /**
     * head, number, tail을 나눔
     * @param s 나눌 문자열
     * @return String[0] = Head
     *         String[1] = Number
     *         String[2] = Tail
     * */
    private static String[] modPart(String s) {
        String[] part = new String[3];
        boolean state = false;
        int numberStartIdx = -1;

        for (int i = 0; i < s.length(); i++) {
            if (!state && isNumber(s.charAt(i))) {
                part[0] = s.substring(0, i).toLowerCase();
                numberStartIdx = i;
                state = true;
                if (i == s.length() - 1) {
                    part[1] = s.substring(numberStartIdx);
                }
            } else if (state && !isNumber(s.charAt(i))) {
                String number = s.substring(numberStartIdx, i);
                if (number.length() > 5) {
                    i = i - (number.length() - 5);
                }
                part[1] = s.substring(numberStartIdx, i);
                part[2] = s.substring(i);
                break;
            }
        }
        if (part[1] == null) {
            int i = s.length();
            String number = s.substring(numberStartIdx, i);
            if (number.length() > 5) {
                i = i - (number.length() - 5);
            }
            part[1] = s.substring(numberStartIdx, i);
            part[2] = s.substring(i);
        }

        return part;
    }

    private static boolean isNumber(char c) {
        return c >= '0' && c <= '9';
    }
}