package 프로그래머스.고득점킷;

import java.util.HashMap;
import java.util.Map;

public class ps1216_완주하지못한선수 {

    public static void main(String[] args) {
        Solution sol = new Solution();
        String result = sol.solution(new String[]{"leo", "kiki", "eden"},
            new String[]{"eden", "kiki"});

        System.out.println(result);
    }

    private static class Solution {
        public String solution(String[] participant, String[] completion) {
            String answer = "";

            Map<String, Integer> hm = new HashMap<>();

            for (String s : participant) {
                hm.put(s, hm.getOrDefault(s, 0) + 1);
            }

            for (String s : completion) {
                hm.put(s, hm.getOrDefault(s, 0) - 1);
            }

            for (String s : hm.keySet()) {
                if (hm.get(s) != 0) {
                    answer = s;
                }
            }

            return answer;
        }
    }

}
