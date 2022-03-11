package 프로그래머스;

import java.io.*;
import java.util.*;

public class Kakao_2019_Crane {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] board = {{0, 0, 0, 0, 0}, {0, 0, 1, 0, 3}, {0, 2, 5, 0, 1}, {4, 2, 4, 4, 2}, {3, 5, 1, 3, 1}};
        int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};
        sol.solution(board, moves);
    }


    static class Solution {
        static Stack<Integer> stack = new Stack<>();
        static int ans = 0;
        public int solution(int[][] board, int[] moves) {

            int answer = 0;
            stack.push(-1);
            for (int move : moves) {
                moveCrane(move, board);
            }

            return ans*2;
        }

        static void moveCrane(int move, int[][] board) {
            for (int i = 0; i < board.length; i++) {
                if (board[i][move - 1] != 0) {
                    if (stack.peek() == board[i][move - 1]) {
                        stack.pop();
                        ans++;
                    }else{
                        stack.push(board[i][move - 1]);
                    }
                    board[i][move - 1] = 0;
                    break;
                }
            }
        }
    }
}
