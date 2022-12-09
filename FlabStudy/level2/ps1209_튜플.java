package 에프랩스터디;


import java.util.*;

public class ps1209_튜플 {

    public static void main(String[] args) {

        Solution sol = new Solution();
        int[] result = sol.solution("{{2,1},{2},{2,1,3},{2,1,3,4}}");


    }

    private static class Solution {

        public int[] solution(String s) {
            int[] answer = {};

            String[] split = s.split("},");

            List<String> list = new ArrayList<>();

            //O(500) return 500 이하이기 때문
            for (String str : split) {
                String temp = str.replaceAll("\\{", "").replaceAll("}", "");
                list.add(temp);
            }

            //O(500log500)
            Collections.sort(list, (o1, o2) -> o1.length() - o2.length());
            Set<Integer> lhs = new LinkedHashSet<>();

            //O(500)
            for (String str : list) {
                String[] strSplit = str.split(",");

                //(500)
                for (String tuple : strSplit) {
                    lhs.add(Integer.parseInt(tuple));
                }
            }

            answer = new int[lhs.size()];
            int point = 0;

            //O(500)
            for (Integer i : lhs) {
                answer[point] = i;
                point++;
            }

            return answer;
        }
    }

}
