package 에프랩스터디;

import java.util.HashSet;
import java.util.Set;

public class ps0112_후보키 {

    public static void main(String[] args) {

        Solution sol = new Solution();
        sol.solution(
            new String[][]{
                {"a","1","aaa","c","ng"},
                {"a","1","bbb","e","g"},
                {"c","1","aaa","d","ng"},
                {"d","2","bbb","d","ng"},
            }
        );

    }

    private static class Solution {

        static String[][] map;
        static int count = 0;
        static Set<String> candidateKey = new HashSet<>();

        public int solution(String[][] relation) {
            map = relation.clone();

            //선택 개수
            for (int k = 0; k < relation[0].length; k++) {
                dfs(k + 1, "", relation[0].length, 0);
            }

            return count;
        }

        private void dfs(int depth, String str, int number, int start) {
            if (str.length() == depth) {
                for (String s : candidateKey) {
                    int count = 0;
                    for (int i = 0; i < s.length(); i++) {
                        if (str.contains(String.valueOf(s.charAt(i)))) {
                            count++;
                        }
                    }
                    if (count == s.length()) {
                        return;
                    }
                }
                cal(str);
                return;
            }

            for (int i = start; i < number; i++) {
                dfs(depth, str + i, number, i + 1);
            }
        }

        private void cal(String selectNumber) {
            Set<String> hs = new HashSet<>();
            boolean flag = true;

            for (int i = 0; i < map.length; i++) {
                StringBuilder temp = new StringBuilder();

                for (int j = 0; j < selectNumber.length(); j++) {
                    temp.append(map[i][Integer.parseInt(String.valueOf(selectNumber.charAt(j)))]);
                }

                if (!hs.add(temp.toString())) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                count++;
                candidateKey.add(selectNumber);
            }
        }
    }

}
