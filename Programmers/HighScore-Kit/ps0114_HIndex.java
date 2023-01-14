package 프로그래머스.고득점킷;

import java.util.Arrays;

public class ps0114_HIndex {

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.solution(new int[]{3, 0, 6, 1, 5});
    }

    private static class Solution {
        public int solution(int[] citations) {
            int answer = 0;
            Arrays.sort(citations);

            for (int i = 0; i < citations.length; i++) {
                int index = citations.length - i;

                if (citations[i] >= index) {
                    answer = index;
                    break;
                }
            }

            return answer;
        }
    }
}
