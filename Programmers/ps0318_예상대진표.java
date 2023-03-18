package 프로그래머스.연습문제;

public class ps0318_예상대진표 {

    public static void main(String[] args) {

        Solution sol = new Solution();
        sol.solution(8, 4, 7);
    }

    private static class Solution {

        public int solution(int n, int a, int b) {
            int answer = 0;

            do {
                a = a / 2 + a % 2;
                b = b / 2 + b % 2;
                answer++;

            } while (a != b);

            return answer;
        }
    }
}
