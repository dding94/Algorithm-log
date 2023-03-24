package 프로그래머스.연습문제;

public class ps0324_숫자의표현 {

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(15));

    }

    private static class Solution {

        public int solution(int n) {
            int answer = 0;
            int start = 1;
            int end = 1;
            int sum = 0;
            while (start <= n) {
                if (sum < n) {
                    sum += end;
                    end++;
                } else if (sum == n) {
                    answer++;
                    sum -= start;
                    start++;
                } else {
                    sum -= start;
                    start++;
                }
            }
            return answer;
        }
    }
}
