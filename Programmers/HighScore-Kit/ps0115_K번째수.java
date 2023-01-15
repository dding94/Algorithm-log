package 프로그래머스.고득점킷;

import java.util.Arrays;

public class ps0115_K번째수 {

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.solution(
            new int[]{1, 5, 2, 6, 3, 7, 4},
            new int[][]{
                {2, 5, 3},
                {4, 4, 1},
                {1, 7, 3}
            }
        );
    }

    private static class Solution {

        public int[] solution(int[] array, int[][] commands) {
            int n = commands.length;
            int[] answer = new int[n];

            for (int i = 0; i < n; i++) {
                int[] temp = Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]);
                Arrays.sort(temp);
                answer[i] = temp[commands[i][2] - 1];
            }

            return answer;
        }
    }
}
