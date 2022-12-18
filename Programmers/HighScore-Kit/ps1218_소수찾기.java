package 프로그래머스.고득점킷;

import java.util.HashSet;
import java.util.Set;

public class 소수찾기 {

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.solution("17");

    }

    private static class Solution {

        static Set<Integer> hs = new HashSet<>();
        static boolean[] check = new boolean[7];

        public int solution(String numbers) {
            int answer = 0;

            for (int i = 0; i < numbers.length(); i++) {
                dfs("", i + 1, numbers);
            }

            for (Integer i : hs) {
                if (isPrime(i)) {
                    answer++;
                }
            }

            return answer;
        }

        private static void dfs(String temp, int end, String word) {
            if (temp.length() == end) {
                int num = Integer.parseInt(temp);
                hs.add(num);
                return;
            }

            for (int i = 0; i < word.length(); i++) {
                if (!check[i]) {
                    check[i] = true;
                    temp += word.charAt(i);
                    dfs(temp, end, word);
                    check[i] = false;
                    temp = temp.substring(0, temp.length() - 1);
                }
            }
        }


        private static boolean isPrime(int n) {
            if (n < 2) {
                return false;
            }

            for (int i = 2; i * i <= n; i++) {
                if (n % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }
}
