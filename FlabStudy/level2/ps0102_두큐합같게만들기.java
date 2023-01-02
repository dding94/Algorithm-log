package 에프랩스터디;

import java.util.ArrayList;
import java.util.List;

public class ps0102_두큐합같게만들기 {

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
            int answer = 0;

            List<Integer> totalQ = new ArrayList<>();
            long target = 0;
            long sum = 0;

            //O(30만)
            for (int i : queue1) {
                totalQ.add(i);
                target += i;
                sum += i;
            }

            //O(30만)
            for (int i : queue2) {
                totalQ.add(i);
                target += i;
            }
            target /= 2;

            int left = 0;
            int right = queue1.length - 1;

            //O(60만)
            while (left <= right && right < totalQ.size() - 1) {

                if (sum == target) {
                    return answer;
                } else if (sum > target) {
                    sum -= totalQ.get(left);
                    left++;
                } else {
                    right++;
                    sum += totalQ.get(right);
                }

                answer++;
            }

            return -1;
        }
    }

}
