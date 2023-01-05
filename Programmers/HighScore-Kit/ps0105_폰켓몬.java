package 프로그래머스.고득점킷;

import java.util.HashSet;
import java.util.Set;

public class ps0105_폰켓몬 {

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.solution(new int[]{3, 1, 2, 3});
    }

    private static class Solution {
        public int solution(int[] nums) {
            Set<Integer> hs = new HashSet<>();

            for (int num : nums) {
                hs.add(num);
            }

            return hs.size() / 2;
        }
    }
}
