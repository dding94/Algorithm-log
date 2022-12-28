package 에프랩스터디;

import java.util.ArrayList;

public class ps1228_수식최대화 {

    public static void main(String[] args) {

        Solution sol = new Solution();
//        sol.solution("100-200*300-500+20");
        sol.solution("50*6-3*2");

    }


    private static class Solution {

        static boolean[] check = new boolean[3];
        static long answer = -1;
        static ArrayList<Long> numbers = new ArrayList<>();
        static ArrayList<Character> operation = new ArrayList<>();

        public long solution(String expression) {
            char[] op = {'*', '+', '-'};

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < expression.length(); i++) {
                char word = expression.charAt(i);

                if (Character.isDigit(word)) {
                    sb.append(word);
                } else {
                    operation.add(word);
                    numbers.add(Long.parseLong(sb.toString()));
                    sb.setLength(0);
                }
            }
            numbers.add(Long.parseLong(sb.toString()));

            dfs(0, op, "");

            return answer;
        }



        private void dfs(int depth, char[] op, String makeOperation) {
            if (depth == 3) {
                calculation(makeOperation);
                return;
            }

            for (int i = 0; i < op.length; i++) {
                if (!check[i]) {
                    check[i] = true;
                    dfs(depth + 1, op, makeOperation + op[i]);
                    check[i] = false;
                }
            }
        }


        private void calculation(String makeOperation) {
            ArrayList<Long> copyNumbers = (ArrayList<Long>) numbers.clone();
            ArrayList<Character> copyOperation = (ArrayList<Character>) operation.clone();

            for (int k = 0; k < makeOperation.length(); k++) {
                for (int i = 0; i < copyOperation.size(); i++) {
                    long result = 0;

                    if (makeOperation.charAt(k) == copyOperation.get(i)) {
                        if (copyOperation.get(i) == '+') {
                            result = copyNumbers.get(i) + copyNumbers.get(i + 1);
                        }
                        if (copyOperation.get(i) == '*') {
                            result = copyNumbers.get(i) * copyNumbers.get(i + 1);
                        }
                        if (copyOperation.get(i) == '-') {
                            result = copyNumbers.get(i) - copyNumbers.get(i + 1);
                        }

                        copyNumbers.remove(i + 1);
                        copyNumbers.remove(i);
                        copyNumbers.add(i, result);
                        copyOperation.remove(i);

                        i--;
                    }

                }
            }

            answer = Math.max(answer, Math.abs(copyNumbers.get(0)));
        }
    }

}
