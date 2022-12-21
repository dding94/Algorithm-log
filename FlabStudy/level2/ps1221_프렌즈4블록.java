package 에프랩스터디;

import javax.management.MBeanRegistration;

public class ps1221_프렌즈4블록 {

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.solution(6, 6,
            new String[]{
                "TTTANT",
                "RRFACC",
                "RRRFCC",
                "TRRRAA",
                "TTMMMF",
                "TMMTTJ"
            }
        );

//        sol.solution(4, 5,
//            new String[]{
//                "CCBDE",
//                "AAADE",
//                "AAABF",
//                "CCBBF"
//            }
//        );
    }

    private static class Solution {

        public int solution(int m, int n, String[] board) {
            int answer = 0;
            char[][] block = new char[m][n];
            boolean[][] check;

            for (int i = 0; i < m; i++) {
                String s = board[i];
                for (int j = 0; j < n; j++) {
                    block[i][j] = s.charAt(j);
                }
            }
            boolean flag = true;

            while (flag) {
                check = new boolean[m][n];
                flag = false;

                //O(900)
                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < n; j++) {
                        if (i + 1 < m && j + 1 < n) {
                            if (block[i][j] != '0' &&
                                block[i][j] == block[i][j + 1] &&
                                block[i][j] == block[i + 1][j] &&
                                block[i][j] == block[i + 1][j + 1]
                            ) {
                                check[i][j] = true;
                                check[i + 1][j] = true;
                                check[i][j + 1] = true;
                                check[i + 1][j + 1] = true;
                                flag = true;
                            }
                        }
                    }
                }

                //O(900)
                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < n; j++) {
                        if (check[i][j] == true) {
                            answer++;
                            block[i][j] = '0';
                        }
                    }
                }

                //O(900)
                for (int j = 0; j < n; j++) {
                    for (int i = m - 1; i >= 0; i--) {
                        if (block[i][j] == '0') {
                            int temp = i - 1;
                            while (temp >= 0) {
                                if (block[temp][j] != '0') {
                                    char change = block[i][j];
                                    block[i][j] = block[temp][j];
                                    block[temp][j] = change;
                                    break;
                                }
                                temp--;
                            }
                        }
                    }
                }
            }

            return answer;
        }
    }
}
