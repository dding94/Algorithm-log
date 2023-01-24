package 프로그래머스.연습문제;

public class ps0124_ox퀴즈 {

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.solution(new String[]{"19 - 6 = 13", "5 + 66 = 71", "5 - 15 = 63", "3 - 1 = 2"});
    }
    private static class Solution {
        public String[] solution(String[] quiz) {
            String[] answer = new String[quiz.length];

            int i = 0;
            for (String s : quiz) {
                String[] split = s.split(" ");
                int first = Integer.parseInt(split[0]);
                int second = Integer.parseInt(split[2]);
                int result = Integer.parseInt(split[4]);
                String op = split[1];

                if (op.equals("+")) {
                    if (first + second == result) {
                        answer[i] = "O";
                    } else {
                        answer[i] = "X";
                    }
                }

                if (op.equals("-")) {
                    if (first - second == result) {
                        answer[i] = "O";
                    } else {
                        answer[i] = "X";
                    }
                }
                i++;
            }

            return answer;
        }
    }

}
