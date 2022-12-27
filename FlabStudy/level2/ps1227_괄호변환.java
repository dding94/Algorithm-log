package 에프랩스터디;

import java.util.Stack;

public class ps1227_괄호변환 {

    public static void main(String[] args) {
        Solution sol = new Solution();
        String result = sol.solution("()))((()");

        System.out.println(result);
    }

    private static class Solution {

        static int index;

        public String solution(String p) {

            // #1
            if (p.isEmpty()) {
                return p;
            }

            // #2
            boolean isBalance = balanceCheck(p);
            String u = p.substring(0, index);
            String v = p.substring(index);

            // #3
            if (isBalance) {
                return u + solution(v);
            }

            // #4
            // #4-1
            String answer = "(";

            // #4-2
            answer += solution(v);

            // #4-3
            answer += ")";

            // #4-4
            u = u.substring(1, u.length() - 1);
            for (int i = 0; i < u.length(); i++) {
                if (u.charAt(i) == '(') {
                    answer += ")";
                } else {
                    answer += "(";
                }
            }

            return answer;
        }

        private static boolean balanceCheck(String p) {
            Stack<Character> stack = new Stack<>();

            int left = 0;
            int right = 0;
            boolean isBalance = true;

            for (int i = 0; i < p.length(); i++) {
                if (p.charAt(i) == '(') {
                    left++;
                    stack.push(p.charAt(i));
                } else {
                    right++;
                    if (stack.isEmpty()) {
                        isBalance = false;
                    } else {
                        stack.pop();
                    }
                }

                if (left == right) {
                    //자르는 지점
                    index = i + 1;
                    return isBalance;
                }
            }

            if (!stack.isEmpty()) {
                isBalance = false;
            }



            return isBalance;
        }
    }
}
