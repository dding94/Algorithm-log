package 프로그래머스.고득점킷;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ps0113_가장큰수 {

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.solution(new int[]{0, 0, 0, 0, 9});
    }

    private static class Solution {
        public String solution(int[] numbers) {
            String answer = "";
            List<String> list = new ArrayList<>();

            for (int number : numbers) {
                if (number == 0) {

                }
                list.add(String.valueOf(number));
            }

            Collections.sort(list, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
            StringBuilder sb = new StringBuilder();

            for (String s : list) {
                sb.append(s);
            }

            if (sb.charAt(0) == '0') {
                return "0";
            }
            answer = sb.toString();
            return answer;
        }
    }
}
