package 프로그래머스.연습문제;

import java.util.*;

public class ps0311_영어끝말잇기 {

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.solution(2, new String[]{"hello", "one", "even", "never", "now", "world", "draw"});
    }


    private static class Solution {

        public int[] solution(int n, String[] words) {
            int[] answer = {0, 0};

            Map<String, Integer> map = new HashMap<>();
            map.put(words[0], 1);

            for (int i = 1; i < words.length; i++) {
                String s1 = words[i - 1];
                String s2 = words[i];

                char last = s1.charAt(s1.length() - 1);
                char first = s2.charAt(0);

                if (map.containsKey(s2) || last != first) {
                    answer[0] = (i % n) + 1;
                    answer[1] = (i / n) + 1;

                    return answer;
                }

                map.put(words[i], 1); // 사용한 단어 맵에 저장
            }

            return answer;
        }
    }
}

