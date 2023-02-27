package 에프랩스터디.이코테;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ps0227_카드뭉치 {

    public static void main(String[] args) {

        Solution sol = new Solution();
        System.out.println(sol.solution(
            new String[]{"a", "b"},
            new String[]{"c", "d"},
            new String[]{"a", "b", "c", "d", "e"}
        ));

    }

    private static class Solution {

        public String solution(String[] cards1, String[] cards2, String[] goal) {
            String answer = "";

            Queue<String> q = new LinkedList<>(Arrays.asList(goal));

            int index1 = 0;
            int index2 = 0;

            for (int i = 0; i < goal.length; i++) {

                if (index1 < cards1.length && q.peek().equals(cards1[index1])) {
                    q.poll();
                    index1++;
                    continue;
                }

                if (index2 < cards2.length && q.peek().equals(cards2[index2])) {
                    q.poll();
                    index2++;
                    continue;
                }

                break;
            }

            if (q.isEmpty()) {
                answer = "Yes";
            } else {
                answer = "No";
            }

            return answer;
        }
    }
}

