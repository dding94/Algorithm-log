package 에프랩스터디.이코테;

public class ps0216_징검다리건너기 {

    public static void main(String[] args) {
        Solution sol = new Solution();
        int solution = sol.solution(new int[]{2, 4, 5, 3, 2, 1, 4, 2, 5, 1}, 3);

        System.out.println(solution);
    }

    private static class Solution {

        public int solution(int[] stones, int k) {
            int answer = 0;

            int left = 0;
            int right = 200000001;

            while (left <= right) {
                int mid = (left + right) / 2;

                if (canJump(mid, stones, k)) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }

            }

            answer = left;
            return answer;
        }

        private static boolean canJump(int mid, int[] stones, int k) {
            int[] temp = stones.clone();

            for (int i = 0; i < temp.length; i++) {
                temp[i] -= mid;
                if (temp[i] < 0) {
                    temp[i] = 0;
                }
            }

            int now = -1;

            for (int i = 0; i < temp.length; i++) {
                if (temp[i] > 0) {
                    int jump = i - now;
                    if (jump > k) {
                        return false;
                    }
                    now = i;
                }
            }

            return temp.length - now <= k;
        }
    }

}
