package 프로그래머스.연습문제;

import java.util.Arrays;

public class ps0328_최댓닶과최솟값 {

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.solution("1 2 3 4");
    }

    private static class Solution {

        public String solution(String s) {
            String[] numbers = s.split(" ");

            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;

            for (String number : numbers) {
                int temp = Integer.parseInt(number);

                max = Math.max(max, temp);
                min = Math.min(min, temp);
            }


            return max + " " + min;
        }
    }
}
