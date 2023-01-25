package 프로그래머스.고득점킷;

public class ps0125_피로도 {

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.solution(80,
            new int[][]{
                {80, 20},
                {50, 40},
                {30, 10}
            }
        );
    }

    private static class Solution {

        private static boolean[] check;
        private static int[][] map;
        private static int temp;
        private static int max = -1;

        public int solution(int k, int[][] dungeons) {
            int depth = dungeons.length;
            map = dungeons;
            temp = k;
            check = new boolean[depth];

            dfs(depth, 0, "");

            return max;
        }

        private static void dfs(int depth, int now, String search) {
            if (now == depth) {
                adventure(search);
                return;
            }

            for (int i = 0; i < depth; i++) {
                if (!check[i]) {
                    check[i] = true;
                    dfs(depth, now + 1, search + i);
                    check[i] = false;
                }
            }
        }

        private static void adventure(String search) {
            int count = 0;
            int k = temp;

            for (int i = 0; i < search.length(); i++) {
                int now = search.charAt(i) - '0';
                if (k >= map[now][0]) {
                    k -= map[now][1];
                    count++;
                }
            }

            max = Math.max(count, max);
        }
    }

}
