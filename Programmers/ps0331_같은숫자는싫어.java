package 프로그래머스.연습문제;

import java.util.Stack;

public class ps0331_같은숫자는싫어 {

    public static void main(String[] args) {
        Solution sol = new Solution();
//        sol.solution(new int[]{1, 1, 3, 3, 0, 1, 1});
        sol.solution(new int[]{4, 4, 4, 3, 3});
    }

    private static class Solution {

        public int[] solution(int[] arr) {
            int[] answer = {};
            Stack<Integer> stack = new Stack<>();

            for (int num : arr) {
                if (!stack.isEmpty()) {
                    if (stack.peek() != num) {
                        stack.add(num);
                    }
                } else {
                    stack.add(num);
                }
            }

            answer = new int[stack.size()];

            for (int i = 0; i < stack.size(); i++) {
                answer[i] = stack.get(i);
            }

            return answer;
        }
    }
}
