package 프로그래머스.연습문제;

import java.util.HashSet;
import java.util.Set;

public class ps0401_두개뽑아서더하기 {

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.solution(new int[]{5, 0, 2, 7});
    }


    private static class Solution {

        private static Set<Integer> hs = new HashSet<>();
        private static boolean[] visit;

        public int[] solution(int[] numbers) {
            visit = new boolean[numbers.length];
            dfs(0, 0, numbers);
            int[] answer = new int[hs.size()];

            int idx = 0;
            for (Integer h : hs) {
                answer[idx] = h;
                idx++;
            }
            return answer;
        }

        private static void dfs(int depth, int sum, int[] numbers) {

            if (depth == 2) {
                hs.add(sum);
                return;
            }

            for (int i = 0; i < numbers.length; i++) {
                if (!visit[i]) {
                    visit[i] = true;
                    dfs(depth + 1, sum + numbers[i], numbers);
                    visit[i] = false;
                }
            }
        }
    }
}
