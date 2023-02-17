package 에프랩스터디.이코테;

import java.util.*;

public class ps0217_가사검색 {

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.solution(
            new String[]{"frodo", "front", "frost", "frozen", "frame", "kakao"},
            new String[]{"fro??", "????o", "fr???", "fro???", "pro?"}
        );

    }

    private static class Solution {

        public int[] solution(String[] words, String[] queries) {
            int[] answer = new int[queries.length];

            Map<Integer, List<String>> frontMap = new HashMap<>();
            Map<Integer, List<String>> backMap = new HashMap<>();

            // words 리스트를 자료구조에 셋팅한다.
            for (String word : words) {
                int len = word.length();
                frontMap.computeIfAbsent(len, i -> new ArrayList<>()).add(word);
                backMap.computeIfAbsent(len, i -> new ArrayList<>()).add(reverse(word));
            }

            for (int key : frontMap.keySet()) {
                frontMap.get(key).sort(String::compareTo);
                backMap.get(key).sort(String::compareTo);
            }

            List<Integer> result = new ArrayList<>();

            for (String query : queries) {
                List<String> list;

                if (query.charAt(0) == '?') {
                    list = backMap.get(query.length());
                    query = reverse(query);
                } else {
                    list = frontMap.get(query.length());
                }

                if (list == null) {
                    result.add(0);
                } else {
                    result.add(lowerBound(list, query.replace('?', Character.MAX_VALUE))
                        - lowerBound(list, query.replace("?", "")));
                }
            }

            for (int i = 0; i < answer.length; i++) {
                answer[i] = result.get(i);
            }

            return answer;
        }

        private static int lowerBound(List<String> list, String str) {
            int left = 0;
            int right = list.size() - 1;

            while (left <= right) {
                int mid = (left + right) / 2;

                if (str.compareTo(list.get(mid)) <= 0) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            return left;
        }

        private static String reverse(String s) {
            return new StringBuilder(s).reverse().toString();
        }
    }
}
