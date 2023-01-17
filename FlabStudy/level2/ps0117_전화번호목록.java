package 프로그래머스.고득점킷;

import java.util.HashMap;
import java.util.Map;

public class ps0117_전화번호목록 {

    public static void main(String[] args) {
        Solution sol = new Solution();
        boolean solution = sol.solution(new String[]{"999", "998", "97"});

        System.out.println(solution);
    }

    private static class Solution {

        public boolean solution(String[] phone_book) {
            Map<String, Integer> hm = new HashMap<>();

            for (String s : phone_book) {
                hm.put(s, 1);
            }

            //O(100만)
            for (String s : hm.keySet()) {
                //O(20)
                for (int i = 1; i < s.length(); i++) {
                    if (hm.containsKey(s.substring(0, i))) {
                        return false;
                    }
                }
            }

            return true;
        }
    }

}
