package 프로그래머스.연습문제;

public class ps0326_x만큼간격이있는n개의숫자 {

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.solution(-4, 2);

    }

    private static class Solution {

        public long[] solution(int x, int n) {
            long[] answer = new long[n];

            answer[0] = x;
            for (int i = 1; i < n; i++) {
                answer[i] = answer[i - 1] + x;
            }

            for (long l : answer) {
                System.out.println(l);
            }

            return answer;
        }
    }
}
