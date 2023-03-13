package 프로그래머스.연습문제;

public class ps0313_소수만들기 {

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.solution(new int[]{1, 2, 3, 4});
    }

    private static class Solution {

        int answer;
        int[] arr;

        public int solution(int[] nums) {
            answer = 0;
            arr = new int[3];
            dfs(nums, nums.length, 0, 0, 0);
            return answer;
        }

        private void dfs(int[] nums, int len, int cnt, int sum, int start) {
            if (cnt == 3) {
                if (isPrime(sum)) {
                    answer++;
                }
                return;
            }

            for (int i = start; i < len; i++) {
                arr[cnt] = nums[i];
                dfs(nums, len, cnt + 1, sum + nums[i], i + 1);
            }
        }

        private static boolean isPrime(int sum) {
            if (sum % 2 == 0) {
                return false;
            }

            for (int i = 2; i * i <= sum; i++) {
                if (sum % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }
}
