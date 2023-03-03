package 에프랩스터디.이코테;

import java.util.Stack;

public class ps0303_햄버거만들기 {

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.solution(new int[]{2, 1, 1, 2, 3, 1, 2, 3, 1});

    }

    private static class Solution {

        public int solution(int[] ingredient) {
            int answer = 0;
            Stack<Integer> stack = new Stack<>();

            for (int i : ingredient) {
                stack.push(i);

                if (stack.size() >= 4) {
                    if (stack.get(stack.size() - 4) == 1 &&
                        stack.get(stack.size() - 3) == 2 &&
                        stack.get(stack.size() - 2) == 3 &&
                        stack.get(stack.size() - 1) == 1
                    ) {
                        answer++;
                        for (int k = 0; k < 4; k++) {
                            stack.pop();
                        }
                    }
                }
            }

            return answer;
        }
    }
}
