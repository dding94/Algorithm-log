package 에프랩스터디;

import java.util.*;

public class ps1212_뉴스클러스터링 {

    public static void main(String[] args) {
        Solution sol = new Solution();
//        int result = sol.solution("handshake", "shake hands");
        int result = sol.solution("aa1+aa2", "AAAA12");
//        int result = sol.solution("FRANCE", "french");

        System.out.println(result);
    }

    private static class Solution {

        public int solution(String str1, String str2) {

            List<String> split1 = new ArrayList<>();
            List<String> split2 = new ArrayList<>();

            //1000
            for (int i = 0; i < str1.length() - 1; i++) {
                split1.add(str1.substring(i, i + 2).toLowerCase().replaceAll("[^a-zA-Z]", " "));
            }

            //1000
            for (int i = 0; i < str2.length() - 1; i++) {
                split2.add(str2.substring(i, i + 2).toLowerCase().replaceAll("[^a-zA-Z]", " "));
            }

            Map<String, Integer> word1 = new HashMap<>();
            Map<String, Integer> word2 = new HashMap<>();

            //2000
            for (String s : split1) {
                if (s.length() != 2 || s.contains(" ")) {
                    continue;
                }

                word1.put(s, word1.getOrDefault(s, 0) + 1);
            }

            //2000
            for (String s : split2) {
                if (s.length() != 2 || s.contains(" ")) {
                    continue;
                }

                word2.put(s, word2.getOrDefault(s, 0) + 1);
            }


            double intersection = 0;
            double union = 0;

            //1000
            for (String s : word1.keySet()) {
                //공집합
                if (word2.containsKey(s)) {
                    intersection += Math.min(word1.get(s), word2.get(s));
                }

                //합집합
                if (word2.get(s) == null) {
                    union += word1.get(s);
                } else {
                    union += Math.max(word1.get(s), word2.get(s));
                    word2.remove(s);
                }
            }

            //1000
            for (String s : word2.keySet()) {
                union += word2.get(s);
            }

            if (intersection == 0 || union == 0) {
                return 65536;
            }

            double temp = intersection / union;

            return (int) (temp * 65536);
        }
    }

}
