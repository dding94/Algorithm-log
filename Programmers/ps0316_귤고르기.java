package 프로그래머스.연습문제;

import java.util.*;

public class ps0316_귤고르기 {

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.solution(4, new int[]{1, 3, 2, 5, 4, 5, 2, 3});
    }

    private static class Solution {

        public int solution(int k, int[] tangerine) {
            int answer = 0;

            Map<Integer, Integer> hm = new HashMap<>();

            for (int i : tangerine) {
                hm.put(i, hm.getOrDefault(i, 0) + 1);
            }

            ArrayList<Integer> list = new ArrayList<>(hm.keySet());
            list.sort((o1, o2) -> hm.get(o2) - hm.get(o1));

            for (int i = 0; i < list.size(); i++) {
                if (k <= 0) {
                    break;
                }
                k -= hm.get(list.get(i));
                answer++;
            }

            return answer;
        }
    }
}
