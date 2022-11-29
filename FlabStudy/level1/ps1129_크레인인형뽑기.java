package 에프랩스터디;

import java.util.Stack;

public class ps1129_크레인인형뽑기 {

    public static void main(String[] args) {
//        Solution sol = new Solution();
//        int result = sol.solution(
//            new int[][]{
//                {0, 0, 0, 0, 0},
//                {0, 0, 1, 0, 3},
//                {0, 2, 5, 0, 1},
//                {4, 2, 4, 4, 2},
//                {3, 5, 1, 3, 1}
//            }, new int[]{1, 5, 3, 5, 1, 2, 1, 4}
//        );

        long maxValue = Integer.MAX_VALUE;


        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < maxValue + 1; i++) {
            stack.push(i);
        }
        boolean add = stack.add(1);
        System.out.println(stack.size());

    }

    private static class Solution {

        public int solution(int[][] board, int[] moves) {
            int answer = 0;
            int n = board.length;

            Stack<Integer> stack = new Stack<>();

            //시간복잡도 1000 * 30 = O(30000) , O(NM)
            for (int k = 0; k < moves.length; k++) {
                for (int i = 0; i < n; i++) {
                    int x = i;
                    int y = moves[k] - 1;

                    if (board[x][y] != 0) {
                        if (!stack.isEmpty()) {
                            if (stack.peek() == board[x][y]) {
                                stack.pop();
                                answer += 2;
                            } else {
                                stack.push(board[x][y]);
                            }
                        } else {
                            stack.push(board[x][y]);
                        }

                        board[x][y] = 0;
                        break;
                    }

                }
            }

            return answer;
        }
    }

}
