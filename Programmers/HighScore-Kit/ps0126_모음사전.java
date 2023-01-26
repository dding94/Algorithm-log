package 프로그래머스.고득점킷;

public class ps0126_모음사전 {

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.solution("A");
    }

    private static class Solution {

        private static char[] words = new char[]{'A', 'E', 'I', 'O', 'U'};
        private static int count = 0;
        private static boolean flag = false;

        public int solution(String word) {

            dfs(0, word, "");
            System.out.println(count);
            return count;
        }


        private static void dfs(int depth, String word, String makeWord) {
            if (word.equals(makeWord)) {
                flag = true;
                return;
            }

            if (depth == 5) {
                return;
            }

            for (int i = 0; i < words.length; i++) {
                if (!flag) {
                    count++;
                    dfs(depth + 1, word, makeWord + words[i]);
                }
            }
        }
    }

}
