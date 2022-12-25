package 프로그래머스.고득점킷;

public class 동적계획법 {

    public static void main(String[] args) {

    }

    private static class Solution {

        public int solution(int[][] triangle) {
            int answer = 0;

            int n = triangle.length;
            int[][] d = new int[n + 1][n + 1];
            int[][] a = new int[n + 1][n + 1];

            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= i; j++) {
                    a[i][j] = triangle[i - 1][j - 1];
                }
            }

            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    d[i][j] = Math.max(d[i - 1][j - 1], d[i - 1][j]) + a[i][j];
                }
            }

            for (int i = 1; i <= n; i++) {
                answer = Math.max(answer, d[n][i]);
            }

            return answer;
        }
    }
}
