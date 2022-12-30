package 에프랩스터디;

import static java.util.Arrays.*;

import java.util.ArrayList;
import java.util.List;

public class ps1230_두큐합같게만들기 {

    public static void main(String[] args) {
        Solution sol = new Solution();
        int result = sol.solution(
            new int[]{3, 2, 7, 2},
            new int[]{4, 6, 5, 1}
        );


        int solution = sol.solution(
            new int[]{1, 2, 1, 2},
            new int[]{1, 10, 1, 2}
        );

        System.out.println(solution);
    }

    private static class Solution {

        public int solution(int[] queue1, int[] queue2) {

            List<Integer> number = new ArrayList<>();
            long goal = 0L;
            long sum = 0L;

            for (int i = 0; i < queue1.length; i++) {
                number.add(queue1[i]);
                sum += queue1[i];
                goal += queue1[i];
            }
            for (int i = 0; i < queue2.length; i++) {
                number.add(queue2[i]);
                goal += queue2[i];
            }

            int left = 0;
            int right = queue1.length - 1;
            goal = goal / 2;
            int count = 0;

            while (left <= right && right < number.size()) {
                if (sum == goal) {
                    return count;
                } else if (sum < goal && right < number.size() - 1) {
                    right++;
                    sum += number.get(right);
                } else {
                    sum -= number.get(left);
                    left++;
                }
                count++;
            }

            return -1;
        }

    }

}
