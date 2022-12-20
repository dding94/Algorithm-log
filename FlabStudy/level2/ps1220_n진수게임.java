package 에프랩스터디;

public class ps1220_n진수게임 {

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.solution(2, 4, 2, 1);
//        sol.solution(16, 16, 2, 1);
//        sol.solution(16, 16, 2, 2);
//        sol.solution(16, 1000, 100, 2);
    }

    private static class Solution {
        public String solution(int n, int t, int m, int p) {
            String answer = "";

            StringBuilder sb = new StringBuilder();
            int index = 0;

            //O(1000 * 100) 도 안나올듯 합니다.
            while (sb.length() <= t * m) {
                sb.append(Integer.toString(index, n));
                index++;
            }

            String word = sb.toString().toUpperCase();
            sb.setLength(0);

            //O(1000 * 100)
            for (int i = 0; i < word.length(); i++) {
                if (i % m == p - 1) {
                    sb.append(word.charAt(i));
                }
            }

            sb.setLength(t);
            answer = sb.toString();
            return answer;
        }
    }
}
