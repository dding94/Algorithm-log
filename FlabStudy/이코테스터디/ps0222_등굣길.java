package 에프랩스터디.이코테;

public class ps0222_등굣길 {

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.solution(4, 3, new int[][]{{2, 2}});
    }

    private static class Solution {

        public int solution(int m, int n, int[][] puddles) {
            int mod = 1000000007;

            int[][] d = new int[n + 1][m + 1];

            for (int[] puddle : puddles) {
                int x = puddle[1];
                int y = puddle[0];
                d[x][y] = -1;
            }

            d[1][1] = 1;

            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    if (d[i][j] == -1) {
                        continue;
                    }

                    if (d[i - 1][j] >= 0) {
                        d[i][j] += (d[i - 1][j] % mod);
                    }

                    if (d[i][j - 1] >= 0) {
                        d[i][j] += (d[i][j - 1] % mod);
                    }
                }
            }

            return d[n][m] % mod;
        }
    }
}
