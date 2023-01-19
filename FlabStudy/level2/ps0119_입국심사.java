package 에프랩스터디;

import java.util.Arrays;

public class ps0119_입국심사 {

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.solution(10, new int[]{6, 8, 10});
    }

    private static class Solution {
        public long solution(int n, int[] times) {
            long answer = 0;
            Arrays.sort(times);

            long left = 0;
            long right = (long) n * times[times.length - 1];


            while (left <= right) {
                long mid = (left + right) / 2;

                if (time(mid, times) >= n) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            answer = left;

            return answer;
        }

        private static long time(long mid, int[] times) {
            long time = 0L;

            for (int i = 0; i < times.length; i++) {
                time += (mid / times[i]);
            }

            return time;
        }
    }
}
