package 프로그래머스.연습문제;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ps0126_등수매기기 {

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.solution(new int[][]{{80, 70}, {90, 50}, {40, 70}, {50, 80}});
    }

    private static class Solution {

        public int[] solution(int[][] score) {
            List<Integer> scoreList = new ArrayList<>();

            for (int[] i : score) {
                scoreList.add(i[0] + i[1]);
            }
            scoreList.sort(Comparator.reverseOrder());

            int[] answer = new int[score.length];
            for (int i = 0; i < score.length; i++) {
                answer[i] = scoreList.indexOf(score[i][0] + score[i][1]) + 1;
            }

            return answer;
        }

    }
}
