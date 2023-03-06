package 에프랩스터디.이코테;

import java.util.Stack;

public class PS0306_짝지어제거하기 {

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution("cc"));
    }

    private static class Solution {

        public int solution(String s) {
            Stack<Character> stack = new Stack<>();

            for (int i = 0; i < s.length(); i++) {

                if (!stack.isEmpty() && stack.peek() == s.charAt(i)) {
                    stack.pop();
                } else {
                    stack.push(s.charAt(i));
                }
            }

            return stack.isEmpty() ? 1 : 0;
        }
    }
}
