package 에프랩스터디;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ps1223_메뉴리뉴얼 {

    public static void main(String[] args) {
        Solution sol = new Solution();

//        sol.solution(
//            new String[]{"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"},
//            new int[]{2, 3, 4}
//        );

        sol.solution(
            new String[]{"XYZ", "XWY", "WXA"},
            new int[]{2, 3, 4}
        );

    }

    private static class Solution {

        Map<String, Integer> hm = new HashMap<>();
        List<String> answerList = new ArrayList<>();

        public String[] solution(String[] orders, int[] course) {
            String[] answer = {};

            for (int i : course) {
                for (String order : orders) {
                    char[] chars = order.toCharArray();
                    Arrays.sort(chars);

                    dfs(0, i, "", chars);
                }

                int max = -1;
                for (Integer value : hm.values()) {
                    max = Math.max(max, value);
                }
                for (String key : hm.keySet()) {
                    Integer select = hm.get(key);

                    if (max >= 2 && max == select) {
                        answerList.add(key);
                    }
                }

                hm.clear();
            }

            Collections.sort(answerList);

            answer = new String[answerList.size()];

            for (int i = 0; i < answer.length; i++) {
                answer[i] = answerList.get(i);
            }

            return answer;
        }

        private void dfs(int depth, int end, String makeCourse, char[] chars) {
            if (makeCourse.length() == end) {
                hm.put(makeCourse, hm.getOrDefault(makeCourse, 0) + 1);
                return;
            }

            if (depth >= chars.length) {
                return;
            }

            dfs(depth + 1, end, makeCourse + chars[depth], chars);
            dfs(depth + 1, end, makeCourse, chars);
        }
    }

}
